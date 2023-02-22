package co.uni.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.uni.prj.member.service.MemberService;

@RestController
public class MemberRestController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/AjaxMemberIdCheck.do")
	public String AjaxMemberIdCheck(@RequestParam("memberId") String memberId, Model model) {
		boolean check = memberService.isIdCheck(memberId);
		String str = (check == true) ? "1" : "2";
		
		return str;
	}
}
