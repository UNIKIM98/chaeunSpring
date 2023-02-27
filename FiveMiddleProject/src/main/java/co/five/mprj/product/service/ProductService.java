package co.five.mprj.product.service;

import java.util.List;

public interface ProductService {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);  //상품 저장
	int productUpdate(ProductVO vo);  //상품 수정
	int productDelete(ProductVO vo);  //상품 삭제
}
