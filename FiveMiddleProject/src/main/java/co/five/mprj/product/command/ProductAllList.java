package co.five.mprj.product.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;


public class ProductAllList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ProductService dao = new ProductServiceImpl();
		List<ProductVO> products = new ArrayList<ProductVO>();

		products = dao.productSelectList();  //db에서 멤버테이블의 목록을 가져온다.
		request.setAttribute("products", products); //결과를 jsp페이지에 전달하기 위해
		
		return "product/productList.tiles";
}
}
