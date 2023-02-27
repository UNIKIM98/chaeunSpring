package co.five.mprj.notice.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = request.getServletContext().getRealPath("/attech/");
		
		int maxSize = 1024*1024*1024;
		
		try {
			MultipartRequest multi = new MultipartRequest( 
					request, saveDir, maxSize, "utf-8", 
					new DefaultFileRenamePolicy()); 

			vo.setNoticeNum(Integer.parseInt(multi.getParameter("noticeNum")));
			vo.setNoticeWriter(multi.getParameter("noticeWriter")); 
			vo.setNoticeDate(multi.getParameter("noticeDate"));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeSubject(multi.getParameter("content"));
			vo.setNoticeHit(Integer.parseInt(multi.getParameter("noticeHit")));
			
			String ofileName = multi.getOriginalFileName("nfile"); 
			String pfileName = multi.getFilesystemName("nfile"); 
			
			if(ofileName != "") { 
				pfileName = saveDir + pfileName; // 저장directory + 저장명

				vo.setNoticeFileUrl(pfileName);
			}
			
			int n = service.noticeUpdate(vo);
			
			if(n != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글 수정에 성공했습니다.');location.href='adminNoticeList.do';");
				out.println("</script>");

				out.flush();

			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글 수정에 실패했습니다.');location.href='adminNoticeList.do';");
				out.println("</script>");

				out.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "admin/adminNoticeList.tiles";
	}

}
