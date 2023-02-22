package co.uni.prj.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopCustomerVO { //shopMember 자식.. ... 쉬는시간좀....
	
	//▶ 객체중심으로 설계할 때
	private ShopMemberVO shopMember;
	
	//▶ 내꺼
	private String shCustomerId;
	private String shCustomerName;
	private String shCustomerTel;	

//	// 상위(shopmember) 필드 확장
//	private String shPassword;
//	private String shGubun;

}
