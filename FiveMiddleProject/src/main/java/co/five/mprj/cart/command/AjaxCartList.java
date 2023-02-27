package co.five.mprj.cart.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.cart.service.CartService;
import co.five.mprj.cart.service.CartVO;
import co.five.mprj.cart.serviceImpl.CartServiceImpl;
import co.five.mprj.common.Command;

public class AjaxCartList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService service = new CartServiceImpl();
		HttpSession session = request.getSession();
		ObjectMapper mapper = new ObjectMapper();

		// session에서 id가져오기
		String memberId = (String) session.getAttribute("memberId");

		List<CartVO> list = service.cartSelectList(memberId);
		System.out.println("(AjaxCartList)" + memberId + "회원 장바구니 목록 ▶ " + list);

		String json = null;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}

}
