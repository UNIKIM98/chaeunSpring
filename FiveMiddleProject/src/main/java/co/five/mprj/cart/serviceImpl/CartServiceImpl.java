package co.five.mprj.cart.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.five.mprj.cart.map.CartMapper;
import co.five.mprj.cart.service.CartService;
import co.five.mprj.cart.service.CartVO;
import co.five.mprj.common.DataSource;

public class CartServiceImpl implements CartService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private CartMapper map = sqlSession.getMapper(CartMapper.class);
	
	// 장바구니 전체조회
	@Override
	public List<CartVO> cartSelectList(String memberId) {
		return map.cartSelectList(memberId);
	}

	// 장바구니 저장
	@Override
	public int cartInsert(CartVO vo) {
		return map.cartInsert(vo);
	}

	// 장바구니 삭제
	@Override
	public int cartDelete(CartVO vo) {
		return map.cartDelete(vo);
	}

	// 장바구니에서 결제창으로
	@Override
	public CartVO cartToOrder(int cartNum) {
		return map.cartToOrder(cartNum);
	}

}
