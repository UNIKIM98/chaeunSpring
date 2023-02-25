package co.five.mprj.orders.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.five.mprj.common.Command;
import co.five.mprj.orders.service.OrdersService;
import co.five.mprj.orders.service.OrdersVO;
import co.five.mprj.orders.serviceImpl.OrdersServiceImpl;

public class AjaxOrdersSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
		OrdersService service = new OrdersServiceImpl();
		ObjectMapper mapper = new ObjectMapper();

		// ▶회원아이디 받아오기
		String memberId = request.getParameter("memberId");
		System.out.println(memberId);

		// ▶ 해당 회원의 구매내역 가져오기
		List<OrdersVO> list = service.ordersSelectList(memberId);
		System.out.println(list);

		// ▶ 현재 날짜 세팅
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStr = format.format(date);

		Date today = null;
		try {
			today = format.parse(dateStr);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// ▶ 구매내역 상태(YES/NO) 업데이트
		OrdersVO vo = new OrdersVO();
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.getOrdersDeadline()+"===============");
			if (vo.getOrdersDeadline().compareTo(today) > 0) {
				System.out.println("[TRUE] 수강 가능");

			} else {
				System.out.println("[FALSE] 수강기간이 만료되었습니다.");
				int n = service.ordersStatusUpdate(vo);

				if (n > 0) {
					System.out.println("[SUCCESS] 수강상태 변경 완료(NO)");
				} else {
					System.out.println("[FAIL] 수강상태 변경 실패");
				}
			}
		}

		// ▶ 업데이트된 list 다시 가져오기
		list = service.ordersSelectList(memberId);

		String json = null;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "Ajax:" + json;

	}

}
