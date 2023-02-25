package co.five.mprj.review.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;
import co.five.mprj.review.service.ReviewService;
import co.five.mprj.review.service.ReviewVO;
import co.five.mprj.review.serviceImpl.ReviewServiceImpl;

public class ReviewDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();

		vo.setReviewNum(Integer.parseInt(request.getParameter("reviewNum")));
		System.out.println(Integer.parseInt(request.getParameter("reviewNum")));
		System.out.println(vo);
		String productNum = request.getParameter("productNum");
		System.out.println(productNum);

		int n = dao.reviewDelete(vo);
		if (n != 0) {

			ProductService service = new ProductServiceImpl();
			ProductVO pvo = new ProductVO();

			pvo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
			pvo = service.productSelect(pvo);
			request.setAttribute("product", pvo);

			List<ReviewVO> reviews = new ArrayList<ReviewVO>();
//			String productNum = request.getParameter("productNum");
			reviews = dao.reviewSelectList(productNum); // db에서 멤버테이블의 목록을 가져온다.
			request.setAttribute("reviews", reviews); // 결과를 jsp페이지에 전달하기 위해

			return "product/productDetail.tiles";

		} else {
			request.setAttribute("message", "공지 삭제가 실패했습니다.");
			return "reviews/reviewMessage.tiles";
		}
	}

}
