package co.five.mprj.orders.command;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.cart.service.CartService;
import co.five.mprj.cart.service.CartVO;
import co.five.mprj.cart.serviceImpl.CartServiceImpl;
import co.five.mprj.common.Command;

import co.five.mprj.orders.service.OrdersService;
import co.five.mprj.orders.service.OrdersVO;
import co.five.mprj.orders.serviceImpl.OrdersServiceImpl;

public class OrderListInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OrderListInsert=======================");
		OrdersService service = new OrdersServiceImpl();
		CartService cService = new CartServiceImpl();

		List<OrdersVO> list = new ArrayList<OrdersVO>();

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");

		String[] productNums = request.getParameterValues("productNum");
		String[] cartNums = request.getParameterValues("cartNum");
		for (String productNum : productNums) {
			OrdersVO vo = new OrdersVO();

			vo.setProductNum(Integer.parseInt(productNum));
			vo.setMemberId(memberId);

			list.add(vo);
		}

		for (int i = 0; i < list.size(); i++) {
			int n = service.ordersInsert(list.get(i));
			if (n != 0) {
				System.out.println(n + "주문성공");

				for (String cartNum : cartNums) {
					System.out.println("for문 안에 들어옴");
					CartVO cVo = new CartVO();
					cVo.setCartNum(Integer.parseInt(cartNum));
					int cn = cService.cartDelete(cVo);
					if (cn > 0) {
						System.out.println("장바구니 삭제 완(장바구니번호 : " + cartNum + ")");
					}
				}
				try {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();

					out.println("<script language='javascript'>");
					out.println("alert('주문이 완료되었습니다.');location.href='main.do';");
					out.println("</script>");

					out.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				System.out.println(n + "주문실패");
			}

		}

		return "main/main.tiles";
	}

}
