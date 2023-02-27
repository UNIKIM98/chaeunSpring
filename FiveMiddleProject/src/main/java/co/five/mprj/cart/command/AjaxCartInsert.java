package co.five.mprj.cart.command;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.cart.service.CartService;
import co.five.mprj.cart.service.CartVO;
import co.five.mprj.cart.serviceImpl.CartServiceImpl;
import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;

public class AjaxCartInsert implements Command {

	// ▼ 장바구니 담기
	// 정은 온니 굿몰닝야!!! 상품 상세 페이지에서 '장바구니'버튼 누르면 > JS파일에서 강좌 정보 담아서(fetch문으로)
	// cartInsert.do로 보내주면 돼!!
	// 아마 될 거야ㅎ,, 안 되면 말해줘♥♡♥♡♥♡ 메리크리스마스~!~!
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService service = new CartServiceImpl();
		CartVO vo = new CartVO();

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		

		System.out.println("카트보 ▶" + vo);
		
	
		// 장바구니 상품 중복 검사
		int prodNum = Integer.parseInt(request.getParameter("productNum"));

		List<CartVO> list = service.cartSelectList(memberId);

		CartVO goods = new CartVO();
		
		goods.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		
		System.out.println("중복검사용 ▶" + goods);
		
		for (int i = 0; i < list.size(); i++) {
			// 요청 파라미터 아이디의 상품이 존재하는지 검사
			goods = list.get(i);
			int num = goods.getProductNum();

			// 상품이 이미 장바구니에 담겨있다면 alert 띄우고 장바구니로 이동
			if (num == prodNum) {

				try {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();

					out.println("<script language='javascript'>");
					out.println("alert('장바구니에 동일한 상품이 있습니다. 장바구니로 이동합니다.');location.href='cartMain.do';");
					out.println("</script>");

					out.flush();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return "cart/cartMain.tiles";
			}
		}

		
		
		
		// 장바구니에 없는 상품이라면 계속 진행
		if (memberId == null) {
			// ▷ 로그인X : 로그인폼으로 이동
			return "member/memberLoginForm.tiles";
		}

		// ▷ 로그인O : 장바구니에 담기
		vo.setMemberId(memberId);
		vo.setProductName(request.getParameter("productName"));
//		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));

		System.out.println("(CartInsert) 장바구니에 담을 VO ▶ " + vo);
		int n = service.cartInsert(vo);

		try {
			if (n != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('상품을 장바구니에 담았습니다. 장바구니로 이동합니다.');location.href='cartMain.do';");
				out.println("</script>");

				out.flush();
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('상품이 장바구니에 담기지 않았습니다.');location.href='cartMain.do';");
				out.println("</script>");

				out.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "cart/cartMain.tiles";

	}

}