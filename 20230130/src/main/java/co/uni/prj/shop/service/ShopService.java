package co.uni.prj.shop.service;

import java.util.List;
import java.util.Map;

import co.uni.prj.shop.vo.ShopCustomerVO;
import co.uni.prj.shop.vo.ShopEmployeeVO;
import co.uni.prj.shop.vo.ShopMemberVO;
import co.uni.prj.shop.vo.ShopUserVO;

public interface ShopService {
	// ▶ 고객 리스트 : Map 구조로 받음
	List<Map<String, Object>> getCustomerList();

	// ▶ 점포 리스트
	List<ShopUserVO> getShopList();

	// ▶ 로그인
	ShopMemberVO loginCheck(ShopMemberVO vo);

	// ▶ id 중복체크
	boolean isIdCheck(String shId);

	// ▶ INSERT(사용자 insert)
	int setShopUser(ShopUserVO vo);

	// ▶ 고객정보 추가
	int setCustomer(ShopCustomerVO vo);

	// ▶ 아이디 패스워드 구분 입력
	int setMember(ShopMemberVO vo);

	// 객체 지향
	List<ShopCustomerVO> getCustObjectList();

	// ▶ 시험문제=========================================================
	int setEmployee(ShopEmployeeVO vo); // 직원 회원가입(INSERT)

	List<ShopCustomerVO> getEmployeeList(); // 직원 리스트(SELECT) : 객체 형태로 받아오기
}
