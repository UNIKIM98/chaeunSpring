package co.five.mprj.review.service;

import java.util.List;

public interface ReviewService {
	List<ReviewVO> reviewSelectList(String productNum);//리뷰조회
	ReviewVO reviewSelect(ReviewVO vo);
	int reviewInsert(ReviewVO vo);  //리뷰 저장
	int reviewUpdate(ReviewVO vo);  //리뷰 수정
	int reviewDelete(ReviewVO vo);  //리뷰 삭제
	
}
