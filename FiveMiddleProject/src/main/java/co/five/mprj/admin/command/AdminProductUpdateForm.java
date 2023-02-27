package co.five.mprj.admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;

public class AdminProductUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 강의 수정 폼 호출 -> 기존에 정보를 담아서 넘기기 
		
		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		vo.setProductNum(Integer.valueOf(request.getParameter("productNum")));
		
		vo= dao.productSelect(vo);
		System.out.println(vo);
		request.setAttribute("list", vo);
		
		return "admin/adminProductUpdateForm.tiles";
	}

}
