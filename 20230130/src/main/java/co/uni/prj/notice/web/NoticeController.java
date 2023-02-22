package co.uni.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.uni.prj.notice.service.NoticeService;
import co.uni.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {

	// service로 등록된 noticeService객체를 setter방식으로 주입(autowired하면 setter에 의한 의존주입임!)
	@Autowired
	NoticeService noticeService;

	// 실경로를 가져오기 위해 사용
	@Autowired
	ServletContext servletContext;

	// ▶ 공지목록
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		// Model 인터페이스를 매개변수로 싣고, 모델객체에 다이렉트로 db 실어서 jsp로 보내려 함
		// 매소드에 의한 의존 주입

		model.addAttribute("notices", noticeService.noticeList());
		return "notice/noticeList";
	}

	/*
	 * ▶ RestController로 넘겨준 부분!
	 * 
	 * @RequestMapping(value = "/AjaxSearchList.do", produces =
	 * "application/json;charset=UTF-8")
	 * 
	 * @ResponseBody //호출한 페이지에 결과를 돌려줌! 아래에 리턴타입 앞에 적어줘도 됨! public String
	 * AjaxSearchList(@RequestParam("key") String key, @RequestParam("val") String
	 * val, Model model) {
	 * 
	 * String str = null; System.out.println(key + val); ObjectMapper map = new
	 * ObjectMapper(); try { str =
	 * map.writeValueAsString(noticeService.noticeSearch(key, val));
	 * System.out.println(str); } catch (JsonProcessingException e) {
	 * e.printStackTrace(); }
	 * 
	 * return str;
	 * 
	 * }
	 */

	// ▶ 공지 하나 고르기
	@PostMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		
		
		// ▷ select
		model.addAttribute("notice", noticeService.noticeSelect(vo));

		return "notice/noticeSelect";
	}

	// ▶ 공지 등록폼
	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm(HttpSession session, Model model) {
		model.addAttribute("memberId", session.getAttribute("memberId"));
		return "notice/noticeInsertForm";
	}

	// ▶ 공지 등록
	@PostMapping(value = "/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {

		// 파일 저장 위치 설정
		String saveFolder = servletContext.getRealPath("/resources/upload/");

		// 실제로 파일 저장하는 것
		// ↓ file이 비어있으면 true 반환
		if (!file.isEmpty()) {
			String fileName = UUID.randomUUID().toString(); // 파일 이름 중복되지 않게 하기 위해서 설정(동일한 파일을 올려도 중복되지 않게끔 설정)
			fileName = "_" + fileName + file.getOriginalFilename();

			// 업로드파일 설정
			File uploadFile = new File(saveFolder, fileName);

			try {
				System.out.println("파일을 업로드합니다.");
				file.transferTo(uploadFile);
				vo.setNoticeFile(file.getOriginalFilename()); // 원본 파일명
				vo.setNoticeFileDir(saveFolder + fileName); // 물리적 파일 저장 위치
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		noticeService.noticeInsert(vo);

		// db 저장 루틴
		// redirect : view로 가지 않고 바로 .do로 가게 하는 것
		return "redirect:noticeList.do";
	}

//	@RequestMapping("/noticeEdit.do")
//	public String noticeEdit(NoticeVO vo, Model model) {
//		vo = noticeService.noticeSelect(vo);
//		System.out.println(vo);
//		model.addAttribute("editNotice", vo);
//		return "notice/noticeEditForm";
//	}

	@RequestMapping("/noticeDelete.do")
	public void noticeDelete(NoticeVO vo, HttpServletResponse response) {

		// ▶ file 있으면 삭제
		if (vo.getNoticeFile() != null) {
			vo = noticeService.noticeSelect(vo);
			File file = new File(vo.getNoticeFileDir());
			boolean result = file.delete();

			System.out.println("파일삭제여부 : " + result);
		}

		// ▶ DB에서 삭제
		int cnt = noticeService.noticeDelete(vo);
		try {
			if (cnt > 0) {

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되었습니다.');location.href='noticeList.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 삭제되지 않았습니다.');location.href='noticeList.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/noticeUpdate.do")
	public void noticeUpdate(NoticeVO vo, MultipartFile file, HttpServletResponse response) {

		// 파일 저장 위치 설정
		String saveFolder = servletContext.getRealPath("/resources/upload/");
		// 실제로 파일 저장하는 것
		// ↓ file이 비어있으면 true 반환
		if (!file.isEmpty()) {
			String fileName = UUID.randomUUID().toString(); // 파일 이름 중복되지 않게 하기 위해서 설정(동일한 파일을 올려도 중복되지 않게끔 설정)
			fileName = "_" + fileName + file.getOriginalFilename();
			// 업로드파일 설정
			File uploadFile = new File(saveFolder, fileName);
			try {
				System.out.println("파일을 업로드합니다.");
				file.transferTo(uploadFile);
				vo.setNoticeFile(fileName); // 원본 파일명
				vo.setNoticeFileDir(saveFolder + fileName); // 물리적 파일 저장 위치
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		int cnt = noticeService.noticeUpdate(vo);

		try {
			if (cnt > 0) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 수정되었습니다.');location.href='noticeList.do';");
				out.println("</script>");

				out.flush();

			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('글이 정상적으로 수정되지 않았습니다.');location.href='noticeList.do';");
				out.println("</script>");

				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	// ▶ 교수님수정 : ModelAndView객체(model과 view를 같이 리턴할 수 있는 객체)
//	// @ModelAttribute
//	@PostMapping("/noticeEdit.do")
//	public String noticeEdit(@ModelAttribute("notice") NoticeVO vo, Model model) {
//		int n = noticeService.noticeUpdate(vo);
//		String viewPage = null;
//
//		if (n != 0) {
//			model.addAttribute("message", "[수정성공] 수정이 정상적으로 처리되었습니다.");
//			viewPage = "notice/noticeEditForm";
//
//		} else {
//			model.addAttribute("message", "[수정실패] 수정이 정상적으로 처리되지 못했습니다.");
//			viewPage = "notice/noticeMessage";
//		}
//		return viewPage;
//	}

//	// ▶ 교수님수정2
//	@RequestMapping("/noticeEditForm.do")
//	public String noticeEdit(NoticeVO vo, Model model) {
//		String viewPage = null;
//		int n = noticeService.noticeUpdate(vo);
//		System.out.println(vo);
//
//		if (n != 0) {
//			model.addAttribute("notice", vo);
//			viewPage = "notice/noticeSelect";
//		} else {
//			model.addAttribute("message", "[수정실패] 수정이 정상적으로 처리되지 못했습니다.");
//			viewPage = "notice/noticeMessage";
//		}
//		return viewPage;
//	}

}
