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

public class OrdersHistory implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 내 강의실 -> 수강중인 강의 출력
				System.out.println("myProductList 호출되니");// 호출됨

				HttpSession session = request.getSession();
				OrdersService dao = new OrdersServiceImpl();

				String memberId = (String) session.getAttribute("memberId");
				System.out.println("세션에 담겨있는 Id : "+ memberId);

				List<OrdersVO> lists = new ArrayList<OrdersVO>();
				
				dao.ordersListProduct(memberId);
//				System.out.println("dao에서호출"+dao.ordersSelectProduct(memberId));
				
				lists = dao.ordersListProduct(memberId);
				
				request.setAttribute("lists", lists);
				
				System.out.println("lists"+lists);

		
		return "orders/ordersHistory.tiles";
	}

}
