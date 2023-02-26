package co.micol.prj.member.command;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.AES256Util;
import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberAddAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 매개변수 : jsp에서 form 태그 안에 있는 name들
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String memberPassword = request.getParameter("memberPassword");
		System.out.println(memberId);

		try {
			AES256Util aes = new AES256Util();
			try {
				memberPassword = aes.encrypt(memberPassword);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String memberAge = request.getParameter("memberAge");
		String memberAddress = request.getParameter("memberAddress");
		String memberTel = request.getParameter("memberTel");

		MemberVO vo = new MemberVO();
		vo.setMemberId(memberId);
		vo.setMemberPassword(memberPassword);
		vo.setMemberName(memberName);
		vo.setMemberAge(Integer.parseInt(memberAge));
		vo.setMemberTel(memberTel);
		vo.setMemberAddress(memberAddress);
		vo.setMemberAuthor("USER");

		System.out.println(vo + "====================");

		MemberService service = new MemberServiceImpl();
		int cnt = service.memberInsert(vo);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();

		// {"retCode":"Success","data":vo}

		if (cnt > 0) {
			map.put("retCode", "Success");
			map.put("data", vo);
		} else {
			map.put("retCode", "Fail");
		}
		String json = null;
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// json 포멧으로 넘겨줘야함
		return "Ajax:" + json;
	}

}
