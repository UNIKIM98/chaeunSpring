package co.five.mprj.notice.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class NoticeVO { // 공지사항 게시판 정보
	// 공지글 번호
	private int noticeNum;

	// 공지글 제목
	private String noticeTitle;

	// 공지글 내용
	private String noticeSubject;

	// 공지글 작성자
	private String noticeWriter;

	// 공지글 작성일
	private String noticeDate;

	// 공지글 조회수
	private int noticeHit;

	// 공지글 첨부 이미지 URL
	private String noticeFileUrl;

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getNoticeHit() {
		return noticeHit;
	}

	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}

	public String getNoticeFileUrl() {
		return noticeFileUrl;
	}

	public void setNoticeFileUrl(String noticeFileUrl) {
		this.noticeFileUrl = noticeFileUrl;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeSubject=" + noticeSubject
				+ ", noticeWriter=" + noticeWriter + ", noticeDate=" + noticeDate + ", noticeHit=" + noticeHit
				+ ", noticeFileUrl=" + noticeFileUrl + "]";
	}

}
