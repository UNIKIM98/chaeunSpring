package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;

public class ProductInfo implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

//		MemberService service = new MemberServiceImpl();
//		MemberVO vo = new MemberVO();

//		// 상품 상세정보 json 형식으로 넘겨주기
//		System.out.println(request.getParameter("productCode") + "===============넘어온 상품 코드");
//		vo = service.productDetail(request.getParameter("productCode"));
//		System.out.println(vo + "=====셀렉트한 상품 정보");
//
//		// 평점 높은 순으로 4개 상품 정보 json 형식으로 넘겨주기
//		List<Map<String, Object>> likeList = service.productList();
//		likeList = service.likeProductList();
//		System.out.println(likeList);
//
//		// 보낼 정보
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, Object> map = new HashMap<>();
//		map.put("data", vo);
//		map.put("likeList", likeList);
//
//		String json = null;
//		try {
//			json = mapper.writeValueAsString(map);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		String productCode = request.getParameter("productCode");
		System.out.println(productCode);
		request.setAttribute("productCode", productCode);

		return "jquery/productInfo.tiles";
	}

}
