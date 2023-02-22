package co.uni.prj.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.uni.prj.shop.service.ShopService;
import co.uni.prj.shop.vo.ShopCustomerVO;
import co.uni.prj.shop.vo.ShopEmployeeVO;
import co.uni.prj.shop.vo.ShopMemberVO;
import co.uni.prj.shop.vo.ShopUserVO;

@Controller
public class shopController {

	@Autowired
	private ShopService shopService;

	@GetMapping("/customerList.do")
	public String customerList(Model model) {
		model.addAttribute("customers", shopService.getCustomerList());
		System.out.println(shopService.getCustomerList());
		return "shop/customerList";
	}

	@GetMapping("/shopList.do")
	public String shopList(Model model) {
		model.addAttribute("shops", shopService.getShopList());
		System.out.println(shopService.getShopList());
		return "shop/shopList";
	}

	// ▶ 객체 지향 타입으로 리스트 불러오기(객체 중심으로 설계했을 때)
	@GetMapping("/getCustomerList.do")
	public String getCustomerList(Model model) {
		model.addAttribute("customers", shopService.getCustObjectList());
		return "shop/getCustomerList";
	}

	@GetMapping("/setMemberJoinForm.do")
	public String setMemberJoinForm() {
		return "shop/setMemberJoinForm";
	}

	// ▶ 쇼핑몰 회원가입
//	@PostMapping("/shopMemberJoin.do")
//	public String shopMemberJoin() {
//		return "shop/shopMessage";
//	}

	// ▶ 고객 회원가입
	@PostMapping("formCustomerJoin.do")
	public String formCustomerJoin(ShopCustomerVO cVO, ShopMemberVO mVO, Model model) {

		String message = null;
		cVO.setShCustomerId(mVO.getShId());

		int n = shopService.setMember(mVO);// 멤버(공통)에 저장

		if (n != 0) {

			int m = shopService.setCustomer(cVO);// 개별테이블에 저장
			if (m != 0) {
				message = "회원가입 완료";
			} else {
				message = "회원가입 실패";
			}
		}

		model.addAttribute("message", message);
		return "shop/shopMessage";
	}

	// ▶ 점주 회원가입
	@PostMapping("shopUserJoin.do")
	public String shopUserJoin(ShopUserVO uVO, ShopMemberVO mVO, Model model) {
		System.out.println("점주 회원가입합니데이");
		System.out.println("userVO" + uVO);
		System.out.println("memberVO" + mVO);

		String message = null;
		uVO.setShUserId(mVO.getShId());

		int n = shopService.setMember(mVO);// 멤버(공통)에 저장

		if (n != 0) {

			int m = shopService.setShopUser(uVO);// 개별테이블에 저장
			if (m != 0) {
				message = "회원가입 완료";
			} else {
				message = "회원가입 실패";
			}
		}

		model.addAttribute("message", message);
		return "shop/shopMessage";
	}

	// ▶ 시험문제=========================================================
	// ▶ 직원 회원가입창(헤더에 JOIN 눌러도 연결됨)
	@RequestMapping("/setMemberJionForm.do")
	public String setMemberJionForm() {
		return "shop/setMemberJionForm";
	}

	// ▶ 직원 회원가입
	@PostMapping("/shopEmployeeJoin.do")
	public String shopEmployeeJoin(Model model, ShopMemberVO mvo, ShopEmployeeVO evo) { // emp vo 를 넣어주고 동작 시키면 된다.
		String message = null;
		System.out.println("▶ evo에 들어있는 empId=======" + evo.getShEmpId());
		System.out.println("▶ mvo에 들어있는 shId=======" + mvo.getShId());

		evo.setShEmpId(mvo.getShId());
		int n = shopService.setMember(mvo);

		if (n != 0) {
			int m = shopService.setEmployee(evo);
			if (m != 0) {
				message = "[회원가입완료] " + evo.getEmpName() + "님, 반갑습니다 :D";
			} else {
				message = "[회원가입실패] 회원가입 중 오류가 발생하였습니다 :(";
			}
		} else {
			message = "[회원가입실패] 회원가입 중 오류가 발생하였습니다 :(";
		}
		model.addAttribute("message", message);
		return "shop/shopMessage";
	}

	@GetMapping("/employeeList.do") // 객체중심으로 설계 했을때
	public String getEmployeeList(Model model) {
		System.out.println("왔슈");
		System.out.println(shopService.getEmployeeList());
		model.addAttribute("employees", shopService.getEmployeeList());
		System.out.println("모델 객체에 담았고 jsp로 이동할게예");
		return "shop/employeeList";
	}
}
