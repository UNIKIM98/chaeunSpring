package co.five.mprj.cart.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.cart.service.CartService;
import co.five.mprj.cart.service.CartVO;
import co.five.mprj.cart.serviceImpl.CartServiceImpl;
import co.five.mprj.common.Command;

public class CartToOrder implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("왔슈.");

		CartService service = new CartServiceImpl();
		List<CartVO> list = new ArrayList<CartVO>();
		CartVO vo = new CartVO();

		String[] cartNums = request.getParameterValues("cartNum");
		System.out.println(cartNums[0]);
		for (int i = 0; i < cartNums.length; i++) {
			System.out.println("체크된 장바구니 번호 ▶" + cartNums[i]);
			vo = service.cartToOrder(Integer.parseInt(cartNums[i]));
			list.add(vo);
		}

		request.setAttribute("CartList", list);
		System.out.println(list);

		return "orders/orderList.tiles";
	}

}
