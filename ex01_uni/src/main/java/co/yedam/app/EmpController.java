package co.yedam.app;


import org.springframework.stereotype.Controller;
/*
 * pojo : 아무고토 상속받지 않고(상속 없이) 선언한 클래스 그 잡채
 * component-scan 이 어노테이션(@)을 다 디져서 객체(bean)을 생성하고,
 * 생성한 bean을 스프링 컨테이너에 등록함!
 * 그리고 서블릿에서 호출할 수 있도록 커맨드화 해줌~!
 * 그럼 왜 굳이 @Component 안 하고 @Controller하는 걸까
 * */
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	
	@RequestMapping("emp")
	public String emp(EmpVO vo) {
		System.out.println(vo);
		return "emp";
	}
}
