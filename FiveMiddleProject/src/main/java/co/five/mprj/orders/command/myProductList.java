package co.five.mprj.orders.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.five.mprj.common.Command;
import co.five.mprj.orders.service.OrdersService;
import co.five.mprj.orders.service.OrdersVO;
import co.five.mprj.orders.serviceImpl.OrdersServiceImpl;

public class myProductList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 내 강의실 -> 수강중인 강의 출력

		HttpSession session = request.getSession();
		OrdersService dao = new OrdersServiceImpl();

		String memberId = (String) session.getAttribute("memberId");

		List<OrdersVO> list = new ArrayList<OrdersVO>();
		
		dao.ordersSelectProduct(memberId);
		
		list = dao.ordersSelectProduct(memberId);
		
		request.setAttribute("list", list);
		

		return "orders/myProductList.tiles";
	}

}
