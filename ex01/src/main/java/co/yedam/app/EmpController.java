package co.yedam.app;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
 * pojo 기능을 쓸 수 있도록 해줌
 * pojo : 상속받지 않고(상속 없이) 선언한 class 그 자체?
 * */

@RestController
public class EmpController {

	@RequestMapping("emp")
	public ModelAndView emp(@ModelAttribute("emp") EmpVO vo, @ModelAttribute("page") int page) { // () 안에 넣어주면 핸들러 서블릿이
																									// 핸들러를 만들때 알아서 객체를
																									// 다 만들어 넣어줌!
		// @ModelAttribute == model.addAttribute
		System.out.println(vo);
		// commend 객체는 자동으로 모델에 담아줌! 대신 EmpVO면 empVO로! 첫 글자만 소문자로 바꿔서 담아줌~!
		// restController에서 view랑 model 둘 다 넘겨주고 싶으면(원래는 return 타입 보통 EmpVO)
		// ModelAndView 사용
		System.out.println(page);
		ModelAndView mv = new ModelAndView("emp");
		mv.setViewName("emp");
		mv.addObject("result", "success");
		return mv;
	}

}
