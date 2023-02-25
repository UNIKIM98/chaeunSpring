package co.five.mprj.notice.service;

import java.util.List;

public interface NoticeService {
	// 공지글 전체 조회
	List<NoticeVO> noticeSelectList();
	
	// 공지글 단건 조회
	NoticeVO noticeSelect(NoticeVO vo);
	
	// 공지글 저장
	int noticeInsert(NoticeVO vo);
	
	// 공지글 수정
	int noticeUpdate(NoticeVO vo);
	
	// 공지글 삭제
	int noticeDelete(NoticeVO vo);
	
	// 조회수 증가
	void noticeHitUpdate(int noticeNum); 
	
}
