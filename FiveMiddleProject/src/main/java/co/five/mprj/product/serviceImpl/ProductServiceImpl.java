package co.five.mprj.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.five.mprj.common.DataSource;
import co.five.mprj.product.map.ProductMapper;
import co.five.mprj.product.service.ProductService;
import co.five.mprj.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ProductMapper map = sqlSession.getMapper(ProductMapper.class);
	
	
	@Override
	public List<ProductVO> productSelectList() {
		
		return map.productSelectList();
	}
	@Override
	public ProductVO productSelect(ProductVO vo) {
		
		return map.productSelect(vo);
	}
	@Override
	public int productInsert(ProductVO vo) {
		
		return map.productInsert(vo);
	}
	@Override
	public int productUpdate(ProductVO vo) {
		
		return map.productUpdate(vo);
	}
	@Override
	public int productDelete(ProductVO vo) {
		
		return map.productDelete(vo);
	}
	
	
}
