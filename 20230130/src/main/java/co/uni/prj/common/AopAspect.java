package co.uni.prj.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//나는 component이자 aspect입니다
@Component
@Aspect
public class AopAspect {

	@Pointcut("execution(* co.uni.prj..*Impl.*(..))")
	public void allPointCut() {
	}

//	@After("execution(* co.uni.prj..*Impl.*(..))")
//	public void beforeLog() {
//		System.out.println("================= 동작시작 =================");
//	}

	@Before("allPointCut()")
	public void beforeLog() {
		System.out.println("================= Impl 메소드 실행 전 동작 =================");
	}

	@After("execution(* co.uni.prj..*Impl.*(..))")
	public void afgerLog() {
		System.out.println("+++++++++++++++++ Impl 메소드 실행 후 동작 +++++++++++++++++");
	}

//	@Around("allPointCut()")
	public void aroundLog() {
		System.out.println("----------------- Impl 메소드 시작과 끝에 동시 동작 -----------------");
	}
}