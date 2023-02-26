package co.micol.prj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class NoticePaging implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//통로
		return "jquery/noticePagingForm.tiles";
	}

}