package co.five.mprj.notice.command;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class AdminNoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService service = new NoticeServiceImpl();

		NoticeVO vo = new NoticeVO();
		vo.setNoticeNum(Integer.parseInt(request.getParameter("noticeNum")));
		vo = service.noticeSelect(vo);
		request.setAttribute("noticeNum", vo);

		int n = service.noticeDelete(vo);
		
		try {
			if (n > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되었습니다.');location.href='adminNoticeList.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되지 않았습니다.');location.href='adminNoticeList.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "admin/adminNoticeList.tiles";
	}

}
