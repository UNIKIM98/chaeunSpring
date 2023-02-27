package co.five.mprj.admin.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.five.mprj.common.Command;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;
import co.five.mprj.product.serviceImpl.ProductServiceImpl;

public class AdminProductCkedit implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		String saveDir = request.getServletContext().getRealPath("/attech/"); // 현재 프로젝트 디렉토리로
		int maxSize = 1024 * 1024 * 1024; // 최대 10M까지 업로드

		try {
			MultipartRequest multi = new MultipartRequest( // 파일을 업로드시 request객체를 대체한다.
					request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());

			vo.setProductName(multi.getParameter("productName"));
			vo.setProductExplain(multi.getParameter("productExplain"));
			vo.setProductTrainer(multi.getParameter("productTrainer"));
			vo.setProductDate(Integer.valueOf(multi.getParameter("productDate")));
			vo.setProductPrice(Integer.valueOf(multi.getParameter("productPrice")));
			vo.setProductYoutubeurl(multi.getParameter("productYoutubeurl"));
			vo.setProductSubject(multi.getParameter("content"));

			String ofileName = multi.getOriginalFileName("nfile");
			String pfileName = multi.getFilesystemName("nfile");

			if (ofileName != "") { // 올라가는 파일 경로가 있을 경우

				vo.setProductThumbnailUrl(pfileName);
			}

			int n = dao.productInsert(vo);
			if (n != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 등록되었습니다.');location.href='adminProductList.do';");
				out.println("</script>");

				out.flush();
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 등록되지 않았습니다.');location.href='adminProductList.do';");
				out.println("</script>");

				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "admin/adminProductList.tiles";

	}

}
