package co.five.mprj.notice.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.five.mprj.common.Command;
import co.five.mprj.notice.service.NoticeVO;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		// 공지사항 글 등록하기 (MultiPartRequest를 이용해야함 -> 지금은 cos.jar 이용)
		// 파일업로드 처리하는 방법 : MultiPartRequest가 날아오면 1. cos 라이브러리 이용 2. 3. apache커몬 파일업로드 라이브러리..?

		// notice 등록
		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		// 파일 업로드 위해
		String saveDir = request.getServletContext().getRealPath("/attech/");
		
		int maxSize = 1024*1024*1024; // 최대 10MB까지 업로드 가능
		
		try {
			MultipartRequest multi = new MultipartRequest( // 파일 업로드시 얘가 request객체를 대체함 (파일이 있으면 form에서 multipart로 올라와서 일반 객체로는 못 읽음)
					request, saveDir, maxSize, "utf-8", 
					new DefaultFileRenamePolicy()); // multipart객체 초기화할때 (넘어올객체, 저장위치, 파일최대사이즈, 인코딩타입, 이미 같은 파일 이름이 있다면 자동으로 rename해라)
			// 객체 생성하는 순간 메모리에 파일이 올라와있음!!
			
			
			// 값을 담고
			// (multipart -> ckEditor.jsp(글 등록하는 폼)에 가서 form에 보면 <form 어쩌구 enctype="multipart/form-data"> 이렇게!
			vo.setNoticeWriter(multi.getParameter("noticeWriter")); // vo에 담아라! (multipart로 담아야함)
			vo.setNoticeDate(multi.getParameter("noticeDate"));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeSubject(multi.getParameter("content"));
			
//			// 파일 이름 확인
			String ofileName = multi.getOriginalFileName("nfile"); // 1. 원본 파일 이름 // 원래 오리지널 파일 이름은 ofileName에 넣어라(nfile: form에서 넘기는 파일 객체)
//			// 이때 파일이 이미 저장됨!(파일이 올라감)
			String pfileName = multi.getFilesystemName("nfile"); // 2. 실제 저장되는 파일 이름 // 물리적 공간에 저장되는 파일 이름은 pfileName에 넣어라
			
			if(ofileName != "") { // 원본 파일 이름이 비어있지 않다면(파일이 들어왔다)
				pfileName = saveDir + pfileName; // 저장 directory와 저장명 (물리적 위치가 어디인지 알아야하니까)
				
				// DB에 저장하기 위해 파일 이름 담아줌
				vo.setNoticeFileUrl(pfileName);
			}
			
			int n = service.noticeInsert(vo);
			if(n != 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글이 등록되었습니다.');location.href='adminNoticeList.do';");
				out.println("</script>");

				out.flush();
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글 등록에 실패했습니다.');location.href='adminNoticeList.do';");
				out.println("</script>");

				out.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "admin/adminNoticeList.tiles"; // 출력해주는곳
	}

}
