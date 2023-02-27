package co.yedam.app;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL) // null값 출력을 빼고싶다
public class EmpVO {
//	@JsonProperty(value = "empId") // 이름 바꾸기
	String employeeId;
	String firstName;
	String lastName;
//	@JsonProperty(defaultValue = "1000") // null값일때는 디폴트 값으로 이걸 넣어라(머야 근데 왜 안돼..?)
	String salary;
	@JsonFormat(pattern = "yyyy/MM/dd")
	// @DateTimeFormat <- 이걸 쓰던지, 형식에 맞춰 넘기던지 해야함
	Date hireDate;
	String departmentId;
//	@JsonIgnore // 제외하고 싶은 것 위에 적어주면 제외됨
	String jobId;
	String email;
	String phoneNumber;
	
	// 페이징 처리용
//	Integer first;
//	Integer last;
}
