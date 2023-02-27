package co.five.mprj.review.map;

import java.util.List;

import co.five.mprj.review.service.ReviewVO;


public interface ReviewMapper {
	List<ReviewVO> reviewSelectList(String productNum);
	ReviewVO reviewSelect(ReviewVO vo);
	int reviewInsert(ReviewVO vo);
	int reviewUpdate(ReviewVO vo);  
	int reviewDelete(ReviewVO vo);
}
