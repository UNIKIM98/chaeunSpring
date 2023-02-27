package co.five.mprj.review.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
	private int reviewNum;
	private String reviewWriter;
	private String reviewSubject;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date reviewDate;
	private int productNum;
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewSubject() {
		return reviewSubject;
	}
	public void setReviewSubject(String reviewSubject) {
		this.reviewSubject = reviewSubject;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNum=" + reviewNum + ", reviewWriter=" + reviewWriter + ", reviewSubject="
				+ reviewSubject + ", reviewDate=" + reviewDate + ", productNum=" + productNum + "]";
	}


}
