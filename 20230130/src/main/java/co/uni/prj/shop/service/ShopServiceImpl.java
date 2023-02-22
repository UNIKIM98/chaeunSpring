package co.uni.prj.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uni.prj.shop.map.ShopMapper;
import co.uni.prj.shop.vo.ShopCustomerVO;
import co.uni.prj.shop.vo.ShopEmployeeVO;
import co.uni.prj.shop.vo.ShopMemberVO;
import co.uni.prj.shop.vo.ShopUserVO;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper mapper;

	@Override
	public List<Map<String, Object>> getCustomerList() {
		return mapper.getCustomerList();
	}

	@Override
	public List<ShopUserVO> getShopList() {
		return mapper.getShopList();
	}

	@Override
	public ShopMemberVO loginCheck(ShopMemberVO vo) {
		return mapper.loginCheck(vo);
	}

	@Override
	public boolean isIdCheck(String shId) {
		return mapper.isIdCheck(shId);
	}

	@Override
	public int setShopUser(ShopUserVO vo) {
		return mapper.setShopUser(vo);
	}

	@Override
	public int setCustomer(ShopCustomerVO vo) {
		return mapper.setCustomer(vo);
	}

	@Override
	public int setMember(ShopMemberVO vo) {
		return mapper.setMember(vo);
	}

	@Override
	public List<ShopCustomerVO> getCustObjectList() {
		// TODO Auto-generated method stub
		return mapper.getCustObjectList();
	}

	// ▶ 시험문제=========================================================
	@Override
	public int setEmployee(ShopEmployeeVO vo) {
		// TODO Auto-generated method stub
		return mapper.setEmployee(vo);
	}

	@Override
	public List<ShopCustomerVO> getEmployeeList() {
		// TODO Auto-generated method stub
		return mapper.getEmployeeList();
	}
}
