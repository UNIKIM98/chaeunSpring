package co.micol.prj.notice.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeDeleteAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String noticeId = request.getParameter("noticeId");
		System.out.println(noticeId + "파라미터값(noticeId)======");

		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();

		vo.setNoticeId(Integer.parseInt(noticeId));
		int cnt = service.noticeDelete(vo);

		Map<String, Object> map = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();

		if (cnt > 0) {
			map.put("retCode", "Success");
			System.out.println("성공");
		} else {
			map.put("retCode", "Fail");
			System.out.println("실패");
		}

		String json = null;

		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "Ajax:" + json;
	}

}
