package co.uni.prj.notice.service;

import java.util.List;
import co.uni.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeList();

	NoticeVO noticeSelect(NoticeVO vo);

	int noticeInsert(NoticeVO vo);

	int noticeUpdate(NoticeVO vo);

	int noticeDelete(NoticeVO vo);

	// 검색할 때 key(title), value(날씨 등) 주는 것
	List<NoticeVO> noticeSearch(String key, String value);
	
	void noticeHitUpdate(int noticeId);

}
