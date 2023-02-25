package co.five.mprj.orders.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.orders.service.OrdersService;
import co.five.mprj.orders.serviceImpl.OrdersServiceImpl;

public class Kakaopay implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "orders/kakaopay.tiles";
	}

}
