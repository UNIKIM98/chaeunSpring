package co.uni.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.uni.prj.notice.service.NoticeService;
import co.uni.prj.notice.vo.NoticeVO;

@RestController // @Controller+@RespnseBody == @RestController
public class NoticeRestController {
	@Autowired
	NoticeService noticeService;

	@PostMapping(value = "/AjaxSearchList.do", produces = "application/json;charset=UTF-8")
	public String AjaxSearchList(@RequestParam("key") String key, @RequestParam("val") String val, Model model) {

		String str = null;
		System.out.println(key + val);
		ObjectMapper map = new ObjectMapper();
		try {
			str = map.writeValueAsString(noticeService.noticeSearch(key, val));
			System.out.println(str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}

	
	
//	public String AjaxSearchJson(@RequestBody Map<String, String> body) { //Map을 이용한 표현 방식
//		String key = body.get("key");
//		String val = body.get("val");
		
	@PostMapping(value = "/AjaxSearchJson.do", produces = "application/json;charset=UTF-8")
	public String AjaxSearchJson(@RequestBody NoticeVO vo) { // VO 객체를 이용한 표현 방식
		String key = vo.getKey();
		String val = vo.getVal();

		String str = null;
		ObjectMapper json = new ObjectMapper();

		try {
			str = json.writeValueAsString(noticeService.noticeSearch(key, val));
			System.out.println(str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
