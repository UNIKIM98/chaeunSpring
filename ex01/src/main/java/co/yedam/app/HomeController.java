package co.yedam.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// 컨트롤러 안에 있는 메소드를 '핸들러 메소드' 라고 부름
	// public String main() 이런게 핸들러 메소드임!
	// 스프링 버전이 낮으면 @GetMapping이 지원 안 됨(3.1은 없음..)
	@RequestMapping("/main")
	public String main() {
		return "main"; // view페이지로 넘어갈 때는 페이지만 넘어주면 됨
	}

	// ▶ insert 폼 띄우기
	@GetMapping("/insert")
	public String insertForm(EmpVO vo, Model model) {
		model.addAttribute("name", "choi");
		return "redirect:main"; // 등록처리/수정처리 등을 할 때는 돌아갈 때 반드시 redirect:해서 다른페이지로 가게 유도...ㅠㅠ 무슨말일까....울고싶넴 처리
								// 끝나고 다른 페이지로 가는 거니까 redirect...

	}

//	// ▶ insert 작업
//	@PostMapping("/insert")
//	public String insert(EmpVO vo) {
//		return "main";
//	}

}
