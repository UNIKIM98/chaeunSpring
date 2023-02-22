package co.uni.prj.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.uni.prj.shop.service.ShopService;

@RestController
public class shopRestController {

	@Autowired
	private ShopService shopService;

	@GetMapping("/ajaxShopIdCheck.do")
	public String ajaxShopIdCheck(String id) {
		boolean b = shopService.isIdCheck(id);
		String str = (b == false) ? "false" : "true";
		return str;
	}

}
