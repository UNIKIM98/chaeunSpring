package co.five.mprj.qna.map;

import java.util.List;

import co.five.mprj.qna.service.QnaVO;

public interface QnaMapper {
	// 전체 조회
	List<QnaVO> qnaSelectList();

	// 단건 조회
	QnaVO qnaSelect(QnaVO vo);

	// 저장
	int qnaInsert(QnaVO vo);

	// 수정
	int qnaUpdate(QnaVO vo);

	// 삭제
	int qnaDelete(QnaVO vo);

	// 조회수 증가
	void qnaHitUpdate(int qnaNum);
}
