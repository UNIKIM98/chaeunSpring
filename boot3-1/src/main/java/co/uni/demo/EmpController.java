package co.uni.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RequestMapping("emp") //이거 하면 밑에서 GetMapping 할 때 "/~~" 안 해주ㅓ도 됨
//@CrossOrigin
@Controller
@Log4j2
public class EmpController {

	@Autowired
	EmpMapper empMapper;

//	Logger logger = LoggerFactory.getLogger(EmpController.class);

	@GetMapping("/empList") // 커멘드객체 : 자동으로 모델에 등록되어있음!
	public String empList(Model model, @ModelAttribute("esvo") EmpSearchVO svo, Paging paging) {
		// @ModelAttribute("esvo") >> 하면

		// ▶ 파라미터로 받아오기 위헤서 잠시 주석처리함
//		vo.setFirst(0);
//		vo.setLast(10);

		// ▷ 한 페이지에 몇 개씩 볼 건지 설정
//		paging.setPageUnit(5);

		// ▷
		svo.setFirst(paging.getFirst());
		svo.setLast(paging.getLast());

		paging.setTotalRecord(empMapper.getcountTotal(svo));
		model.addAttribute("empList", empMapper.getEmpList(svo));
		model.addAttribute("jobList", empMapper.getJobList());

		log.debug("empList왔음", empMapper.getEmpList(svo));
		return "emplist";
	}

	@GetMapping("/emp/{id}") // {~~} : 단건조회
	@ResponseBody // javaVO 객체를 JSON 구조의 String으로 자동 변환
	public EmpVO getEmp(@PathVariable String id) {
		return empMapper.getEmp(id);
	}

	@PostMapping("/emp") // 등록
	@ResponseBody
	public EmpVO insertEmp(EmpVO vo) {
		empMapper.insertEmp(vo);
		return vo;
	}

	@PutMapping("/emp") // 수정
	@ResponseBody
	public EmpVO updateEmp(@RequestBody EmpVO vo) {
		//@RequestBody해줘야 json으로 값을 받을 수 있음
		empMapper.updateEmp(vo);
		return vo;
	}

	@DeleteMapping("/emp/{id}") // 삭제
	@ResponseBody
	public Map<String, Object> deleteEmp(@PathVariable String id) {
		empMapper.deleteEmp(id);
		return Collections.singletonMap("result", "success");
	}

}
