package co.five.mprj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;

public class MainCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 처음 로그인했을때 보여줄 메인페이지
		System.out.println("===========");
		return "main/main.tiles"; // main폴더 밑에 있는 main.jsp을 보여주세요
	}

}
