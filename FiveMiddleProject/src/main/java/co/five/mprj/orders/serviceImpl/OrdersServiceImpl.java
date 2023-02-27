package co.five.mprj.orders.serviceImpl;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.five.mprj.common.DataSource;
import co.five.mprj.orders.map.OrdersMapper;
import co.five.mprj.orders.service.OrdersService;
import co.five.mprj.orders.service.OrdersVO;

public class OrdersServiceImpl implements OrdersService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private OrdersMapper map = sqlSession.getMapper(OrdersMapper.class);


	@Override
	public int ordersInsert(OrdersVO vo) {
		return map.ordersInsert(vo);
	}

	@Override
	public int ordersStatusUpdate(OrdersVO vo) {
		return map.ordersStatusUpdate(vo);
	}

	@Override
	public List<OrdersVO> ordersSelectList(String memberId) {
		return map.ordersSelectList(memberId);
	}

	@Override
	public List<OrdersVO> ordersSelectProduct(String memberId) {
		return map.ordersSelectProduct(memberId);
	}

	@Override
	public List<OrdersVO> ordersListProduct(String memberId) {
		
		return map.ordersListProduct(memberId);
	}

	@Override
	public Date ordersDeadlineSelect(OrdersVO vo) {
		// TODO Auto-generated method stub
		return map.ordersDeadlineSelect(vo);
	}

}
