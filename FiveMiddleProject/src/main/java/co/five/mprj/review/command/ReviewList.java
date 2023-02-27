package co.five.mprj.review.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.common.Command;
import co.five.mprj.review.service.ReviewService;
import co.five.mprj.review.service.ReviewVO;
import co.five.mprj.review.serviceImpl.ReviewServiceImpl;

public class ReviewList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("리뷰리스트 도착==================");
		ReviewService dao = new ReviewServiceImpl();
		ObjectMapper mapper = new ObjectMapper();

		List<ReviewVO> reviews = new ArrayList<ReviewVO>();
		
		String productNum = request.getParameter("productNum");
		System.out.println(productNum+"프로덕트넘");
		
		reviews = dao.reviewSelectList(productNum); // db에서 멤버테이블의 목록을 가져온다.
		request.setAttribute("reviews", reviews); // 결과를 jsp페이지에 전달하기 위해
		System.out.println(reviews);
		
		String json = null;
		try {
			json = mapper.writeValueAsString(reviews);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}
}
