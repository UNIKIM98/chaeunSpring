package co.five.mprj.qna.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.qna.service.QnaService;
import co.five.mprj.qna.service.QnaVO;
import co.five.mprj.qna.serviceImpl.QnaServiceImpl;

public class QnaDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		QnaService service = new QnaServiceImpl();
		QnaVO vo = new QnaVO();

		vo.setQnaNum(Integer.valueOf(request.getParameter("qnaNum")));
		vo = service.qnaSelect(vo);
		System.out.println(vo);
		request.setAttribute("qnaNum", vo);

		int n = service.qnaDelete(vo);
		try {
			if (n > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('[삭제성공] 글을 정상적으로 삭제하였습니다.');location.href='adminQnaList.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('[삭제실패] 글을 정상적으로 삭제하지 못했습니다.');location.href='adminQnaList.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "admin/adminProductList.tiles";
	}

}
