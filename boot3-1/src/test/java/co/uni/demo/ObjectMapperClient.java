package co.uni.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

//import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootTest //오브젝트 메퍼만 테스트 할 꺼면 @ 안 해도 됨
public class ObjectMapperClient {

	//@Test
	public void write() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("100");
		vo.setFirstName("김채운");
		vo.setHireDate(new Date());

		String str = ob.writeValueAsString(vo);

		System.out.println(str);
		
		/*
		 * ▶ 아무것도 안 했을 때의 콘솔 출력값
		 * {"employeeId":"100","firstName":"김채운",
		 * "lastName":null,"salary":null,
		 * "hireDate":1677025822430,"departmentId":null,
		 * "jobId":null}
		 * 
		 * ▶ 어노테이션 사용해서 JSON 값 바꾸기
		 * @JsonIgnore
		 * : 
		 * 
		 * @JsonInclude(JsonInclude.Include.NON_NULL)
		 * : null값은 표시하지 않겠다
		 * 
		 * @JsonFormat(patern="")
		 * : 형식 변경(날짜 등)
		 * 
		 * @JsonProperty(value = "empId")
		 * : 이름 바꿔줌
		 * 
		 * */
	}
	
	
	@Test
	public void read() throws JsonMappingException, JsonProcessingException {
		String json = "{\"employeeId\":\"100\",\"firstName\":\"김채운\",\"hireDate\":\"2023/02/22\"}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		EmpVO vo = mapper.readValue(json, EmpVO.class);
		
		System.out.println(vo.getFirstName());
	}
}
