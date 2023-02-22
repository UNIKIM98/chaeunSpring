package co.uni.prj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uni.prj.notice.map.NoticeMapper;
import co.uni.prj.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper noticeMapper;
	// ↑ Setter에 의한 주입

	@Override
	public List<NoticeVO> noticeList() {
		return noticeMapper.noticeList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return noticeMapper.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return noticeMapper.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return noticeMapper.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return noticeMapper.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearch(String key, String value) {
		return noticeMapper.noticeSearch(key, value);
	}

	@Override
	public void noticeHitUpdate(int noticeId) {
		noticeMapper.noticeHitUpdate(noticeId);
	}

}
