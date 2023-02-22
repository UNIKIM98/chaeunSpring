package co.uni.demo;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	List<Map> getJobList();

	// 전체조회
	List<EmpVO> getEmpList(EmpSearchVO svo);

	// 검색조회
	int getcountTotal(EmpSearchVO svo);

	// 단건조회
	EmpVO getEmp(String employeeId);

	// 등록
	int insertEmp(EmpVO vo);

	// 수정
	int updateEmp(EmpVO vo);

	// 삭제
	int deleteEmp(String employeeId);

}
