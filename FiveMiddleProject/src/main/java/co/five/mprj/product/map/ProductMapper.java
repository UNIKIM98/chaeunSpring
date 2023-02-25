package co.five.mprj.product.map;

import java.util.List;

import co.five.mprj.product.service.ProductVO;
public interface ProductMapper {
	List<ProductVO> productSelectList();
	ProductVO productSelect(ProductVO vo);
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);  
	int productDelete(ProductVO vo);
	
	
}
