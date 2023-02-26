package co.micol.prj.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberDelAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String memberId = request.getParameter("memberId");
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(memberId);
		System.out.println(vo.getMemberId() + "======id========");
		int cnt = service.memberDelete(vo);
		Map<String, Object> map = new HashMap<>();
		String json = null;
		ObjectMapper mapper = new ObjectMapper();

		if (cnt > 0) {
			map.put("retCode", "Success");
			System.out.println("성공");
		} else {
			map.put("retCode", "Fail");
			System.out.println("실패");
		}

		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}

}
