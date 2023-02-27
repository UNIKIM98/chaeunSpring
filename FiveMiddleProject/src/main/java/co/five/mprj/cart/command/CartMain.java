package co.five.mprj.cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;

public class CartMain implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "cart/cartMain.tiles";
	}

}
