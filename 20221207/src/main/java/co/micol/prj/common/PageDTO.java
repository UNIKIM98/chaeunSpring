package co.micol.prj.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	// 필드
	private int startPage; // 시작페이지
	private int endPage; // 마지막페이지
	private int currPage; // 현재페이지
	private boolean prev, next; // 이전, 이후
	private int total; // 데이터 건수(전체 몇 건인지)

	// 생성자
	public PageDTO(Criteria cri, int total) {
		this.currPage = cri.getPage();
		this.total = total;

		// Math.ceil(double type) : 올림기능
		// ▶▶▶▶▶▶▶현재 페이지 기준으로 마지막 페이지
		this.endPage = (int) (Math.ceil(this.currPage / 10.0) * 10);
		this.startPage = this.endPage - (10 - 1);

		// ▶▶▶▶▶▶▶전체 건수 기준으로 마지막 페이지(ex 155건이면 마지막 페이지는 16)
		int realEnd = (int) Math.ceil(total * 1.0 / cri.getAmount());
		if (this.endPage > realEnd) {
			this.endPage = realEnd;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

}
