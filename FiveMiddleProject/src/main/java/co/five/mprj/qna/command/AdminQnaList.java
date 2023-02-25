package co.five.mprj.qna.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.qna.service.QnaService;
import co.five.mprj.qna.service.QnaVO;
import co.five.mprj.qna.serviceImpl.QnaServiceImpl;

public class AdminQnaList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 강의 리스트 보기
		QnaService dao = new QnaServiceImpl();
		List<QnaVO> list = new ArrayList<QnaVO>();

		list = dao.qnaSelectList();
		System.out.println(list);
		request.setAttribute("QNAList", list);

		return "admin/adminQnaList.tiles";
	}
}
