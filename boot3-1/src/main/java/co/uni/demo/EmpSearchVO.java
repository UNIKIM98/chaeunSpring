package co.uni.demo;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO {
	// 페이징
	Integer first;
	Integer last;
	String keyword;

}
