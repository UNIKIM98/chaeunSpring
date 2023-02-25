package co.five.mprj.cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.cart.service.CartService;
import co.five.mprj.cart.service.CartVO;
import co.five.mprj.cart.serviceImpl.CartServiceImpl;
import co.five.mprj.common.Command;

public class AjaxCartDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService service = new CartServiceImpl();
		CartVO vo = new CartVO();

		String cartNum = request.getParameter("cartNum");
		System.out.println("(AjaxCartDelete)삭제할 장바구니번호 ▶ " + cartNum);

		vo.setCartNum(Integer.parseInt(cartNum));
		int delCnt = service.cartDelete(vo);
		System.out.println(delCnt);
		String json = null;

		if (delCnt > 0) {
			json = "{\"retCode\":\"Success\",\"cartNum\":\"" + cartNum + "\"}";
			System.out.println(json);
		} else {
			json = "{\"retCode\":\"Fail\",\"cartNum\":\"" + cartNum + "\"}";
		}

		return "Ajax:" + json;
	}

}
