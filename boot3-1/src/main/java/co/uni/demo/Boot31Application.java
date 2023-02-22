package co.uni.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "co.uni.demo")//mapper 인터페이스 위치를 알려줌
public class Boot31Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot31Application.class, args);
	}

	
}
