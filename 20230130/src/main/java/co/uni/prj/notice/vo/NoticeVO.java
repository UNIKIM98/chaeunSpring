package co.uni.prj.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	// ▼ jsonFormat : Jackson 라이브러리에서 JSON 객체 사용할 때 날짜 포멧 설정
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date noticeDate;
	private String noticeSubject;
	private String noticeTitle;
	private int noticeHit;
	private String noticeFile;
	private String noticeFileDir;
	
	//▶ noticeSearchVO
	private String key;
	private String val;
}
