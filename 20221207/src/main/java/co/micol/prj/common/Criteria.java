package co.micol.prj.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	// ▶ 필드=============================================================
	private int page; // 현재 페이지
	private int amount; // 한 페이지에 몇 건의 정보를 출력할 것인지(ex 10, 50, 100 ...)
	private String searchCondition; // 검색조건
	private String keyword; // 검색키워드(제목, 작성자)

	// ▶ 생성자=============================================================
	// 세팅값이 없으면?
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	// 세팅값이 있으면?
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
}
