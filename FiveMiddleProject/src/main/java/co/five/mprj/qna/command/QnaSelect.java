package co.five.mprj.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.qna.service.QnaService;
import co.five.mprj.qna.service.QnaVO;
import co.five.mprj.qna.serviceImpl.QnaServiceImpl;

public class QnaSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		QnaService service = new QnaServiceImpl();

		QnaVO vo = new QnaVO();

		vo.setQnaNum(Integer.parseInt(request.getParameter("qnaNum")));
		vo = service.qnaSelect(vo);
		
		System.out.println(vo);
		request.setAttribute("qna", vo);

		return "qna/qnaSelect.tiles";
	}

}
