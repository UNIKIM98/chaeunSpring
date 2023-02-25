package co.five.mprj.qna.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.common.Command;
import co.five.mprj.qna.service.QnaService;
import co.five.mprj.qna.service.QnaVO;
import co.five.mprj.qna.serviceImpl.QnaServiceImpl;

public class AjaxQnaList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 강의 리스트 보기
		System.out.println("AjaxQnaList 도착완==================");
		QnaService service = new QnaServiceImpl();
		List<QnaVO> list = new ArrayList<QnaVO>();
		ObjectMapper mapper = new ObjectMapper();

		list = service.qnaSelectList();
		System.out.println("(AjaxQnaList)" + list);

		String json = null;

		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}

}
