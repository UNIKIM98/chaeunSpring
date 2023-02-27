package co.five.mprj.review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;
import co.five.mprj.review.service.ReviewService;
import co.five.mprj.review.service.ReviewVO;
import co.five.mprj.review.serviceImpl.ReviewServiceImpl;

public class ReviewEditForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		// vo.setReviewNum(Integer.valueOf(request.getParameter("reviewNum")));
		vo.setReviewNum(Integer.parseInt(request.getParameter("reviewNum")));
		vo = dao.reviewSelect(vo);
		request.setAttribute("review", vo);
		System.out.println(vo.getProductNum());

		// 상품 다시 띄우기 위해 정보 가져오기
		ProductService service = new ProductServiceImpl();

		ProductVO pvo = new ProductVO();

//		pvo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		pvo = service.productSelect(pvo);
		request.setAttribute("product", pvo);

		return "reviews/reviewEditForm.tiles";
	}

}
