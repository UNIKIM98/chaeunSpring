package co.micol.prj.notice.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.common.Criteria;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;

public class NoticePagingAjax implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");

		// 검색조건 필드
		String searchCondition = request.getParameter("searchCondition");
		String keyword = request.getParameter("keyword");

		Criteria cri = new Criteria(Integer.parseInt(page), Integer.parseInt(amount));

		// 검색조건 설정
		cri.setSearchCondition(searchCondition);
		cri.setKeyword(keyword);

		NoticeService service = new NoticeServiceImpl();

		List<NoticeVO> list = new ArrayList<>();
		if (page != null) {
			list = service.noticePagingList(cri);
		} else if (page == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script language='javascript'>");
				out.println("alert('페이지를 입력해주세요.');location.href='noticePagingForm.do';");
				out.println("</script>");

				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String json = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}

}
