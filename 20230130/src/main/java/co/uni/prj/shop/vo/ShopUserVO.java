package co.uni.prj.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopUserVO extends ShopMemberVO {

	private String shUserId;
	private String shUserName;
	private String shUserShopName;

	// 상위(shopmember) 필드 확장
	private String shPassword;
	private String shGubun;

}
