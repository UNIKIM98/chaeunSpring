package co.five.mprj.qna.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.five.mprj.common.Command;
import co.five.mprj.qna.service.QnaService;
import co.five.mprj.qna.service.QnaVO;
import co.five.mprj.qna.serviceImpl.QnaServiceImpl;

public class QnaInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		QnaService service = new QnaServiceImpl();
		QnaVO vo = new QnaVO();
		HttpSession session = request.getSession();

		String saveDir = request.getServletContext().getRealPath("/attech/");
		int maxSize = 1024 * 1024 * 1024;

		try {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			vo.setQnaTitle(multi.getParameter("qnaTitle"));
			vo.setQnaDate(multi.getParameter("qnaDate"));
			vo.setQnaSubject(multi.getParameter("content"));
			vo.setQnaWriter((String) session.getAttribute("memberNickname"));

			String ofileName = multi.getOriginalFileName("nfile");
			String pfileName = multi.getFilesystemName("nfile");
			System.out.println(vo);

			if (ofileName != "") {
				vo.setQnaFileUrl(pfileName);
			}

			int n = service.qnaInsert(vo);
			if (n > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;

				out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('[등록완료] 글이 정상적으로 등록되었습니다.');location.href='adminQnaList.do';");
				out.println("</script>");

				out.flush();
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('[등록실패] 글을 정상적으로 등록하지 못했습니다.');location.href='adminQnaList.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "admin/adminQnaList.tiles";
	}

}
