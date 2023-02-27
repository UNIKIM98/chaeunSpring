package co.five.mprj.qna.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaVO {
	private int qnaNum;
	private String qnaTitle;
	private String qnaSubject;
	private String qnaWriter;
	private String qnaDate;
	private String qnaFileUrl;
	private int qnaHit;

	public int getQnaNum() {
		return qnaNum;
	}

	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaSubject() {
		return qnaSubject;
	}

	public void setQnaSubject(String qnaSubject) {
		this.qnaSubject = qnaSubject;
	}

	public String getQnaWriter() {
		return qnaWriter;
	}

	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public int getQnaHit() {
		return qnaHit;
	}

	public void setQnaHit(int qnaHit) {
		this.qnaHit = qnaHit;
	}

	public String getQnaFileUrl() {
		return qnaFileUrl;
	}

	public void setQnaFileUrl(String qnaFileUrl) {
		this.qnaFileUrl = qnaFileUrl;
	}

	@Override
	public String toString() {
		return "QnaVO [qnaNum=" + qnaNum + ", qnaTitle=" + qnaTitle + ", qnaSubject=" + qnaSubject + ", qnaWriter="
				+ qnaWriter + ", qnaDate=" + qnaDate + ", qnaFileUrl=" + qnaFileUrl + ", qnaHit=" + qnaHit + "]";
	}

}
