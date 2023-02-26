package co.micol.prj.notice.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeListPaging implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();

		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		ObjectMapper mapper = new ObjectMapper();
		String json = null;

		// ▶ 오^^.................
		List<List<String>> collect = new ArrayList<>();
		for (NoticeVO vo : notices) {
			List<String> data = new ArrayList<>();
			data.add(String.valueOf(vo.getNoticeId()));
			data.add(vo.getNoticeWriter());
			data.add(vo.getNoticeDate().toLocaleString());
			data.add(vo.getNoticeTitle());
			data.add(vo.getNoticeFile());
			data.add(String.valueOf(vo.getNoticeHit()));

			collect.add(data);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("data", collect);

		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "Ajax:" + json;
	}

}
