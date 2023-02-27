package co.five.mprj.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class Notice implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService service = new NoticeServiceImpl();
		
		List<NoticeVO> notice = new ArrayList<NoticeVO>();
		
		notice = service.noticeSelectList();
		request.setAttribute("notice", notice);
		
		return "notice/noticeList2.tiles";
	}

}
