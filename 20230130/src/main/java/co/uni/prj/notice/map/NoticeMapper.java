package co.uni.prj.notice.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.uni.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeList();

	NoticeVO noticeSelect(NoticeVO vo);

	int noticeInsert(NoticeVO vo);

	int noticeUpdate(NoticeVO vo);

	int noticeDelete(NoticeVO vo);

	// key 라는 리퀘스트가 날아오면 key 변수로 쓰고, val이라는 리퀘스트가 날아오면 value 변수로 쓰겠다
	// (매개변수가 두 개 이상이므로 @Param 붙여줌)
	// ▶ 검색할 때 key(title), value(날씨 등) 주는 것
	List<NoticeVO> noticeSearch(@Param("key") String key, @Param("val") String value);

	void noticeHitUpdate(int noticeId);

}
