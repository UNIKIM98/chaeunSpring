package co.five.mprj.cart.map;

import java.util.List;

import co.five.mprj.cart.service.CartVO;

public interface CartMapper {
	// 장바구니 전체조회
	List<CartVO> cartSelectList(String memberId);
	
	// 장바구니에 등록 (상품 페이지에서 '장바구니 담기' 버튼 누를때 사용됨)
	int cartInsert(CartVO vo);
	
	// 장바구니 삭제
	int cartDelete(CartVO vo);
	
	//장바구니에서 결제창으로
	CartVO cartToOrder(int cartNum);
}
