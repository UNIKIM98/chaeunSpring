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

public class UpdateMemberAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo = new MemberVO();
		MemberService service = new MemberServiceImpl();

		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberTel(request.getParameter("memberTel"));

		int cnt = service.memberUpdate(vo);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();

		String json = null;

		if (cnt > 0) {
			MemberVO svo = new MemberVO();
			svo = service.memberSelect(vo);
			map.put("retCode", "Success");
			map.put("data", svo);
		} else {
			map.put("retCode", "Fail");
		}

		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "Ajax:" + json;
	}

}
