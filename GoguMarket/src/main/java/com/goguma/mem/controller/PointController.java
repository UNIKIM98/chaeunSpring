package com.goguma.mem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {
	
	@GetMapping("/myCoupon")
	public String myCoupon() {
		return "myPages/myCoupon";
	}
	
}
