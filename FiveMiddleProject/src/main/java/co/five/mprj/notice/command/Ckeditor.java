package co.five.mprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;

public class Ckeditor implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "notice/ckEditor.tiles";
	
	}

}
