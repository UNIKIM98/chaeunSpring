package co.five.mprj.admin.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;

public class AdminProductList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 강의 리스트 보기
		ProductService dao = new ProductServiceImpl();
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		list = dao.productSelectList();
		request.setAttribute("list", list);

		return "admin/adminProductList2.tiles";
	}
}
