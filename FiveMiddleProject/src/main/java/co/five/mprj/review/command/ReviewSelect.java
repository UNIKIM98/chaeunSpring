package co.five.mprj.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.review.service.ReviewService;
import co.five.mprj.review.service.ReviewVO;
import co.five.mprj.review.serviceImpl.ReviewServiceImpl;

public class ReviewSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		
		vo.setReviewNum(Integer.valueOf(request.getParameter("reviewNum")));
		vo = dao.reviewSelect(vo);
		request.setAttribute("review", vo);
		return "reviews/reviewSelect.tiles";
	}

}
