package co.five.mprj.notice.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 글 삭제
		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeNum(Integer.parseInt(request.getParameter("noticeNum")));
		int n = service.noticeDelete(vo);

		try {
			if (n != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되었습니다.');location.href='notice.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되지 않았습니다.');location.href='notice.do';");
				out.println("</script>");

				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "notice/noticeList.tiles";
	}

}
