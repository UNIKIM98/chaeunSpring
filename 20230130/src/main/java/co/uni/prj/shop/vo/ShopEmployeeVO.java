package co.uni.prj.shop.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShopEmployeeVO {

	private ShopMemberVO shopMember; // 전회원 VO

	private String shEmpId; // 직원 아이디
	private String empName; // 직원 이름
	private String empDepartment; // 직원 소속부서(마케팅부, 관리부)
	private String empPosition; // 직원 직급(팀장, 사원)

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul") //VO => 화면(JSON) // 컨트롤러 결과를 화면으로 보낼 때
	@DateTimeFormat(pattern = "yyyy-MM-dd")//화면(JSON) => VO //화면에서 파라미터를 VO에 담을 때
	private Date empHireDate; // 직원 입사일

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date empEndDate; // 직원 퇴사일
}
