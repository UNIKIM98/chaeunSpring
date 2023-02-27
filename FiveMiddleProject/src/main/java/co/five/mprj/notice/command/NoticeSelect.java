package co.five.mprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 상세보기
		
		System.out.println("공지 상세페이지 도착============");
		
		NoticeService service = new NoticeServiceImpl();
		
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeNum(Integer.parseInt(request.getParameter("noticeNum")));
		vo = service.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeSelect.tiles";
	}

}
