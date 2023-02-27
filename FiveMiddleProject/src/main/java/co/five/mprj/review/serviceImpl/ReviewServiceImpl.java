package co.five.mprj.review.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.five.mprj.common.DataSource;
import co.five.mprj.review.map.ReviewMapper;
import co.five.mprj.review.service.ReviewService;
import co.five.mprj.review.service.ReviewVO;

public class ReviewServiceImpl implements ReviewService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ReviewMapper map = sqlSession.getMapper(ReviewMapper.class);

	@Override
	public List<ReviewVO> reviewSelectList(String productNum) {

		return map.reviewSelectList(productNum);
	}

	@Override
	public ReviewVO reviewSelect(ReviewVO vo) {

		return map.reviewSelect(vo);
	}

	@Override
	public int reviewInsert(ReviewVO vo) {

		return map.reviewInsert(vo);
	}

	@Override
	public int reviewUpdate(ReviewVO vo) {

		return map.reviewUpdate(vo);
	}

	@Override
	public int reviewDelete(ReviewVO vo) {

		return map.reviewDelete(vo);
	}

}
