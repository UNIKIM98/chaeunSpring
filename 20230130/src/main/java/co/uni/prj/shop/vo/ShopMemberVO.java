package co.uni.prj.shop.vo;

import co.uni.prj.common.PageVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopMemberVO extends PageVO {
	// ▶ 마스터VO
	private String shId;
	private String shPassword;
	private String shGubun;

}
