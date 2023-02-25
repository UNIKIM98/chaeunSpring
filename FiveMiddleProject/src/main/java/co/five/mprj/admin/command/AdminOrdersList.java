package co.five.mprj.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.orders.service.OrdersService;
import co.five.mprj.orders.service.OrdersVO;
import co.five.mprj.orders.serviceImpl.OrdersServiceImpl;

public class AdminOrdersList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//★ 221226 진행 예정
		OrdersService service = new OrdersServiceImpl();
		OrdersVO vo = new OrdersVO();
		
		String memberId = request.getParameter("memberId");
		
		return null;
	}

}
