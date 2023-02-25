package co.five.mprj.admin.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;

public class AjaxAdminProductDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 강의 삭제 Ajax

		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		vo.setProductNum(Integer.valueOf(request.getParameter("productNum")));
		vo = dao.productSelect(vo);
		System.out.println(vo);
		request.setAttribute("productNum", vo);

		int n = dao.productDelete(vo);
		try {
			if (n > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되었습니다.');location.href='adminProductList.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되지 않았습니다.');location.href='adminProductList.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "admin/adminProductList.tiles";
	}

}
