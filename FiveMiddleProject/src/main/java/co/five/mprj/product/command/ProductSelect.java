package co.five.mprj.product.command;

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

public class ProductSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 상품 단건 조회 (상세페이지에 띄우기 위해)
		ProductService service = new ProductServiceImpl();

		ProductVO vo = new ProductVO();
		String productNum = request.getParameter("productNum");
		vo.setProductNum(Integer.parseInt(productNum));
		vo = service.productSelect(vo);
		request.setAttribute("product", vo);
		request.setAttribute("productNum", productNum);
		
		System.out.println(productNum);
		
		// 리뷰 페이지 띄우기
		ReviewService dao = new ReviewServiceImpl();
		List<ReviewVO> reviews = new ArrayList<ReviewVO>();

		reviews = dao.reviewSelectList(productNum); // db에서 멤버테이블의 목록을 가져온다.
		request.setAttribute("reviews", reviews); // 결과를 jsp페이지에 전달하기 위해
		System.out.println("리뷰확인중"+reviews);
		return "product/productDetail.tiles";
	}

}
