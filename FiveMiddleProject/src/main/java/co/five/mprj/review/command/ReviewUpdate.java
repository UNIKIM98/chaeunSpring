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

public class ReviewUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("왔슈");

		ReviewService dao = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();

		vo.setReviewNum(Integer.parseInt(request.getParameter("reviewNum")));
		vo.setReviewWriter(request.getParameter("reviewWriter"));
		vo.setReviewSubject(request.getParameter("reviewSubject"));
		
		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));

//		System.out.println("새로운...vo//" + vo);
		int n = 0;
		n = dao.reviewUpdate(vo);

		// 상품 다시 띄우기 위해 정보 가져오기
		ProductService service = new ProductServiceImpl();
		ProductVO pvo = new ProductVO();

		pvo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		pvo = service.productSelect(pvo);
		request.setAttribute("product", pvo);
		
		
		List<ReviewVO> reviews = new ArrayList<ReviewVO>();
		String productNum = request.getParameter("productNum");

		reviews = dao.reviewSelectList(productNum); // db에서 멤버테이블의 목록을 가져온다.
		request.setAttribute("reviews", reviews); // 결과를 jsp페이지에 전달하기 위해
		
		

		return "product/productDetail.tiles";
	}

}
