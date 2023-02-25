package co.five.mprj.qna.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.five.mprj.common.DataSource;
import co.five.mprj.qna.map.QnaMapper;
import co.five.mprj.qna.service.QnaService;
import co.five.mprj.qna.service.QnaVO;

public class QnaServiceImpl implements QnaService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private QnaMapper map = sqlSession.getMapper(QnaMapper.class);

	@Override
	public List<QnaVO> qnaSelectList() {
		// TODO Auto-generated method stub
		return map.qnaSelectList();
	}

	@Override
	public QnaVO qnaSelect(QnaVO vo) {
		// TODO Auto-generated method stub
		qnaHitUpdate(vo.getQnaNum());
		return map.qnaSelect(vo);
	}

	@Override
	public int qnaInsert(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.qnaInsert(vo);
	}

	@Override
	public int qnaUpdate(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.qnaUpdate(vo);
	}

	@Override
	public int qnaDelete(QnaVO vo) {
		// TODO Auto-generated method stub
		return map.qnaDelete(vo);
	}

	@Override
	public void qnaHitUpdate(int qnaNum) {
		map.qnaHitUpdate(qnaNum);

	}

}
