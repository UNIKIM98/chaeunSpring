package co.uni.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;

	// ▼ jUnit 단위테스트 Annotation
	 @Test
	public void 전체조회() {
		EmpSearchVO vo = new EmpSearchVO();
		vo.setFirst(10);
		vo.setLast(20);

		List<EmpVO> list = empMapper.getEmpList(vo);
		System.out.println(list.get(0));// list에서 첫 번째 값만 가져오기
		assertNotNull(list);// ▶ jUnit 단위테스트에서 null인지 아닌지 확인하는 방법(boolean return)

	}
//
	 @Test
	public void 부서검색() {
		EmpSearchVO vo = new EmpSearchVO();
		vo.setDepartmentId("50");
		vo.setFirst(10);
		vo.setLast(20);

		List<EmpVO> list = empMapper.getEmpList(vo);

		assertEquals(list.get(0).getDepartmentId(), "50");
	}
//
	@Test
	public void 직무검색() {
		EmpSearchVO vo = new EmpSearchVO();
		vo.setJobId("IT_PROG");
		vo.setFirst(0);
		vo.setLast(10);

		List<EmpVO> jobList = empMapper.getEmpList(vo);
		System.out.println(jobList.get(0));
		assertEquals(jobList.get(0).getJobId(), "IT_PROG");
	}

}
