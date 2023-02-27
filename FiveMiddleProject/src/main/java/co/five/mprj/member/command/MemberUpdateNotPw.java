package co.five.mprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.common.Command;
import co.five.mprj.member.service.MemberService;
import co.five.mprj.member.service.MemberVO;
import co.five.mprj.member.serviceImpl.MemberServiceImpl;

public class MemberUpdateNotPw implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("비밀번호 없이 업데이트 하는 페이지 도착");
		MemberVO vo = new MemberVO();

		MemberService service = new MemberServiceImpl();

		

		// 패스워드 암호화
//		try {
//			AES256Util aes = new AES256Util();
//			try {
//				password = aes.encrypt(password);
//			} catch (NoSuchAlgorithmException e) {
//				e.printStackTrace();
//			} catch (GeneralSecurityException e) {
//				e.printStackTrace();
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberNickname(request.getParameter("memberNickname"));

		System.out.println("vo값▶ " + vo);

		int cnt = service.memberUpdate(vo);

		// Ajax 처리
		String json = null;

		ObjectMapper mapper = new ObjectMapper();

		if (cnt > 0) {
			// 수정 성공했을 경우
			vo = service.memberSelect(vo);
			try {
				json = mapper.writeValueAsString(vo);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json + "===============");
//			return "Ajax:" + "{\"retCode\": \"OK\"}";
			return "Ajax:" + json;
		}
		// 수정 실패했을 경우
		return "Ajax:" + "{\"retCode\":\"Fail\"}";
	}

}
