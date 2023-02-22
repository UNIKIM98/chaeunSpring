package co.uni.prj.common;

import co.uni.prj.shop.vo.ShopMemberVO;
import co.uni.prj.shop.vo.ShopUserVO;

public class TestClass {
	public void testVO() {
		ShopMemberVO vo = new ShopMemberVO();
		vo.last = 10; // pageVO가 public이기 때문에 가능
		vo.setFirst(1);
		vo.setShId("Hello");
		
		ShopUserVO uvo = new ShopUserVO();		
		
	}

}
