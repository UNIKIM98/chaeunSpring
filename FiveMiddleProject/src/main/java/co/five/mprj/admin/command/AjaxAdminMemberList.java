package co.five.mprj.admin.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class AjaxAdminMemberList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService service = new MemberServiceImpl();
		List<MemberVO> list = service.memberSelectList();
		System.out.println("(AjaxAdminMemberList)전체회원목록 ▶ " + list);

		ObjectMapper mapper = new ObjectMapper();

		String json = null;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}

}
