package co.five.mprj.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("공지글 출력 페이지 도착");
		
		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeSelectList();
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json + "==============");
		return "Ajax:" + json;
	}

}
