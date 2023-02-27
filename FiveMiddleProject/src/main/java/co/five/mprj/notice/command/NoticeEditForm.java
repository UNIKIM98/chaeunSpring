package co.five.mprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeEditForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정을 위한 데이터 호출 후 수정폼에 전달
		NoticeService service = new NoticeServiceImpl();
		
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeNum(Integer.parseInt(request.getParameter("noticeNum")));
		vo = service.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeEditNew.tiles";
	}

}
