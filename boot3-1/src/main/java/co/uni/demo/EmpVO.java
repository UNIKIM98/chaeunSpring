package co.uni.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpVO {
	//@JsonProperty(value = "empId")
	String employeeId;
	String firstName;
	String lastName;
	String salary;
	String email;
	String phoneNumber;

	@JsonFormat(pattern = "yyyy/MM/dd")
	Date hireDate;

	// 검색
	@JsonIgnore
	String departmentId;

//	@JsonIgnore
	String jobId;

	// 페이징 ▶ EmpSearchVO 로 바꿔줌
//	Integer first;
//	Integer last;
//	
}
