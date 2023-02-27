package co.five.mprj.notice.serviceImpl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import co.five.mprj.common.DataSource;
import co.five.mprj.notice.map.NoticeMapper;
import co.five.mprj.notice.service.NoticeService;
import co.five.mprj.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);

	// 공지글 전체 조회
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	// 공지글 단건 조회
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		noticeHitUpdate(vo.getNoticeNum()); // 조회수를 증가
		return map.noticeSelect(vo);
	}

	// 공지글 저장
	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	// 공지글 수정
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	// 공지글 삭제
	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	// 조회수 증가
	@Override
	public void noticeHitUpdate(int noticeNum) {
		map.noticeHitUpdate(noticeNum);
	}

}
