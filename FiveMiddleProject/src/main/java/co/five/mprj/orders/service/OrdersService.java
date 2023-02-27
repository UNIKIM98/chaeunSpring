package co.five.mprj.orders.service;

import java.sql.Date;
import java.util.List;

public interface OrdersService {
	// 전체 조회
	List<OrdersVO> ordersSelectList(String memberId);

	// 저장
	int ordersInsert(OrdersVO vo);

	// status 업데이트
	int ordersStatusUpdate(OrdersVO vo);

	// join해서 PRODUCT_NAME,PRODUCT_THUMBNAIL_URL 가지고오기
	List<OrdersVO> ordersSelectProduct(String memberId);

	// 결제내역
	List<OrdersVO> ordersListProduct(String memberId);

	Date ordersDeadlineSelect(OrdersVO vo);
}
