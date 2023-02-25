package co.five.mprj.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.five.mprj.common.Command;

public class AdminMemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		return "admin/adminMemberList.tiles";
	}
 
}
