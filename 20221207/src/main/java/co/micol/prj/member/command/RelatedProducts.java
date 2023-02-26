package co.micol.prj.member.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class RelatedProducts implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 평점 높은 순으로 4개 상품 정보 json 형식으로 넘겨주기
		MemberService service = new MemberServiceImpl();
		List<Map<String, Object>> likeList = service.productList();
		likeList = service.likeProductList();
		System.out.println(likeList);

		// 보낼 정보
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("likeList", likeList);

		String json = null;
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;
	}

}
