package co.uni.prj.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.uni.prj.member.service.MemberService;
import co.uni.prj.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	// ================================================================================
	@RequestMapping("/memberListSelect.do")
	public String memberListSelect(Model model) {
		model.addAttribute("lists", memberService.memberListSelect());
		return "member/memberListSelect";
	}

	// ================================================================================
	// form에 말아서 넘어와야 처리 가능하게 @PostMapping로 설정
	// 아래에서 HttpSession은 메소드 안에서 선언해도 되지만 매개변수로 설정하는 경우가 더 많음
	@PostMapping("/memberLogin.do")
	public String memberSelect(MemberVO vo, Model model, HttpSession session) {
		vo = memberService.memberSelect(vo);
		System.out.println("memberLogin");
		System.out.println(vo);
		if (vo != null) {
			// jsp에서 가져오고
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("memberAuthor", vo.getMemberAuthor());
			session.setAttribute("memberName", vo.getMemberName());

			// jsp로 보낼 거 담고
			model.addAttribute("message", vo.getMemberName() + "님 환영합니다!");
		} else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀렸습니다.");
		}
		return "member/memberMessage";
	}

	// ================================================================================
	// 단순 form호출 시(값을 전달하지 않을 때) >> request, get
	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}

	// ================================================================================
	@RequestMapping("/memberLogout.do")
	public String memberLogout(Model model, HttpSession session) {
		model.addAttribute("message", session.getAttribute("memberName") + "님 정상 로그아웃 되었습니다.");
		session.invalidate();
		return "member/memberMessage";
	}

	@RequestMapping("/memberJoinForm.do")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}

	@PostMapping("/memberJoin.do")
	public void memberJoin(MemberVO vo, HttpServletResponse response) {
		System.out.println(vo + "회원가입할 vo 정보====================");
		vo.setMemberAuthor("USER");

		int cnt = memberService.memberInsert(vo);
		try {
			if (cnt > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('[회원가입성공] " + vo.getMemberName() + "님 환영합니다 :D ');location.href='home.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('[회원가입실패] 회원가입 페이지로 이동합니다.');location.href='memberJoinForm.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
