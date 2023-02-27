package co.five.mprj.member.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberNickname;
	private String memberGender;
	private String memberBirth;
	private String memberRole;
	private String memberPhone;

}
