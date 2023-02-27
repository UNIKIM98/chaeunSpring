package co.five.mprj.web;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.five.mprj.FileUpload;
import co.five.mprj.MainCommand;
import co.five.mprj.admin.command.AdminMemberList;
import co.five.mprj.admin.command.AdminOrdersList;
import co.five.mprj.admin.command.AdminProductCkedit;
import co.five.mprj.admin.command.AdminProductInsertForm;
import co.five.mprj.admin.command.AdminProductList;
import co.five.mprj.admin.command.AdminProductUpdate;
import co.five.mprj.admin.command.AdminProductUpdateForm;
import co.five.mprj.admin.command.AjaxAdminDel;
import co.five.mprj.admin.command.AjaxAdminMemberList;
import co.five.mprj.admin.command.AjaxAdminProductDelete;
import co.five.mprj.cart.command.AjaxCartDelete;
import co.five.mprj.cart.command.AjaxCartInsert;
import co.five.mprj.cart.command.AjaxCartList;
import co.five.mprj.cart.command.CartMain;
import co.five.mprj.cart.command.CartToOrder;
import co.five.mprj.common.Command;
import co.five.mprj.member.command.AjaxMemberIdCheck;
import co.five.mprj.member.command.AjaxMemberNickCheck;
import co.five.mprj.member.command.MemberDelete;
import co.five.mprj.member.command.MemberDeleteForm;
import co.five.mprj.member.command.MemberEditForm;
import co.five.mprj.member.command.MemberJoin;
import co.five.mprj.member.command.MemberJoinForm;
import co.five.mprj.member.command.MemberLogin;
import co.five.mprj.member.command.MemberLoginForm;
import co.five.mprj.member.command.MemberLogout;
import co.five.mprj.member.command.MemberSelect;
import co.five.mprj.member.command.MemberUpdate;
import co.five.mprj.member.command.MemberUpdateNoajax;
import co.five.mprj.member.command.MemberUpdateNotPw;
import co.five.mprj.notice.command.AdminNoticeDelete;
import co.five.mprj.notice.command.AdminNoticeList;
import co.five.mprj.notice.command.Notice;
import co.five.mprj.notice.command.NoticeDelete;
import co.five.mprj.notice.command.NoticeEditForm;
import co.five.mprj.notice.command.NoticeInsert;
import co.five.mprj.notice.command.NoticeInsertForm;
import co.five.mprj.notice.command.NoticeList;
import co.five.mprj.notice.command.NoticeSelect;
import co.five.mprj.notice.command.NoticeUpdate;
import co.five.mprj.orders.command.AjaxOrdersSelectList;
import co.five.mprj.orders.command.Kakaopay;
import co.five.mprj.orders.command.OrderListInsert;
import co.five.mprj.orders.command.OrdersHistory;
import co.five.mprj.orders.command.myProductList;
import co.five.mprj.product.command.ProductAllList;
import co.five.mprj.product.command.ProductDetail;
import co.five.mprj.product.command.ProductSelect;
import co.five.mprj.qna.command.QnaInsertForm;
import co.five.mprj.qna.command.AdminQnaList;
import co.five.mprj.qna.command.AjaxQnaList;
import co.five.mprj.qna.command.QnaDelete;
import co.five.mprj.qna.command.QnaEditForm;
import co.five.mprj.qna.command.QnaInsert;
import co.five.mprj.qna.command.QnaMain;
import co.five.mprj.qna.command.QnaUpdate;
import co.five.mprj.review.command.Review;
import co.five.mprj.review.command.ReviewDelete;
import co.five.mprj.review.command.ReviewEditForm;
import co.five.mprj.review.command.ReviewInsert;
import co.five.mprj.review.command.ReviewList;
import co.five.mprj.review.command.ReviewSelect;
import co.five.mprj.review.command.ReviewUpdate;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		// ============================================================================================

		// ▶ 메인화면
		map.put("/main.do", new MainCommand()); // 처음 실행하는 페이지
		map.put("/review.do", new Review());

		// ▶ ck에디터
		map.put("/ckEditor.do", new Ckeditor()); // ckeditor
		map.put("/fileupload.do", new FileUpload());

		// ============================================================================================

		// ▶ 회원가입 (지은)
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼
		map.put("/AjaxMemberIdCheck.do", new AjaxMemberIdCheck()); // 회원아이디 중복확인
		map.put("/AjaxMemberNickCheck.do", new AjaxMemberNickCheck()); // 회원닉네임 중복확인
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입

		// ▶ 로그인,로그아웃 (지은)
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); // 로그인
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃
		map.put("/memberEditForm.do", new MemberEditForm()); // 회원 정보 수정 폼 (비밀번호 확인)
		map.put("/memberSelect.do", new MemberSelect()); // 회원 정보 단건 조회
		map.put("/memberUpdate.do", new MemberUpdate()); // 회원 정보 수정

		// ▶ 강의관리(지은)
		map.put("/adminProductList.do", new AdminProductList()); // 강의 리스트
		map.put("/adminProductInsertForm.do", new AdminProductInsertForm()); // 강의 등록 폼 호출
		map.put("/adminProductCkedit.do", new AdminProductCkedit()); // 강의 등록 -Ckedit사용
		map.put("/ajaxAdminProductDelete.do", new AjaxAdminProductDelete()); // 강의 삭제
		map.put("/adminProductUpdateForm.do", new AdminProductUpdateForm()); // 강의 수정 폼 호출
		map.put("/adminProductUpdate.do", new AdminProductUpdate()); // 강의 수정

		// ▶ 내 강의실 (지은)
		map.put("/myProductList.do", new myProductList());

		// ============================================================================================

		// ▶ 공지사항 (정은)
		map.put("/notice.do", new Notice()); // 공지사항 기본화면
		map.put("/noticeList.do", new NoticeList()); // 공지게시판에 공지글 데이터를 넘겨줌
		map.put("/noticeInsertForm.do", new NoticeInsertForm()); // 공지사항 작성 폼
		map.put("/noticeSelect.do", new NoticeSelect()); // 공지사항 상세조회
		map.put("/noticeInsert.do", new NoticeInsert()); // 공지사항 글쓰기 데이터 전달
		map.put("/noticeEditForm.do", new NoticeEditForm()); // 공지사항 수정 폼
		map.put("/noticeUpdate.do", new NoticeUpdate()); // 공지사항 수정
		map.put("/noticeDelete.do", new NoticeDelete()); // 공지사항 삭제
		map.put("/adminNoticeList.do", new AdminNoticeList()); // 공지사항 관리자 페이지
		map.put("/adminNoticeDelete.do", new AdminNoticeDelete()); // 공지 삭제

		// ▶ 마이페이지 (정은)
		map.put("/memberEditForm.do", new MemberEditForm()); // 회원 정보 수정 폼
		map.put("/memberSelect.do", new MemberSelect()); // 회원 정보 단건 조회
		map.put("/memberUpdate.do", new MemberUpdate()); // 회원 정보 수정
		map.put("/memberUpdateNotPw.do", new MemberUpdateNotPw()); // 회원 정보 수정(비밀번호 수정X)
		map.put("/memberUpdateNoajax.do", new MemberUpdateNoajax()); // 회원정보수정(ajax 안 쓰고)
		map.put("/memberDeleteForm.do", new MemberDeleteForm()); // 회원 탈퇴 폼
		map.put("/memberDelete.do", new MemberDelete()); // 회원 정보 삭제(회원탈퇴)

		// ▶ 상품 상세조회 (정은)
		map.put("/productSelect.do", new ProductSelect()); // 상품 정보 단건 조회

		// ============================================================================================

		// ▶ 상품조회(경민)
		map.put("/prodListAjax.do", new ProductAllList()); // 강좌전체

		// ▶ 리뷰(경민)
		map.put("/reviewList.do", new ReviewList()); // 리뷰리스트
		map.put("/reviewInsert.do", new ReviewInsert());// 리뷰등록
		map.put("/reviewDelete.do", new ReviewDelete());// 리뷰삭제
		map.put("/reviewUpdate.do", new ReviewUpdate());// 리뷰수정
		map.put("/reviewEditForm.do", new ReviewEditForm());// 수정폼
		map.put("/reviewSelect.do", new ReviewSelect());// 선택

		// ▶ 결제 (경민)
		map.put("/orderListInsert.do", new OrderListInsert());
		map.put("/ordersHistory.do", new OrdersHistory());
		map.put("/kakaopay.do", new Kakaopay());

		// ============================================================================================

		// ▶ 장바구니 (채은)
		map.put("/cartMain.do", new CartMain()); // 장바구니 jsp 호출
		map.put("/ajaxCartList.do", new AjaxCartList()); // (ajax)장바구니 전체출력
		map.put("/ajaxCartInsert.do", new AjaxCartInsert()); // (ajax)장바구니 담기
		map.put("/ajaxCartDelete.do", new AjaxCartDelete()); // (ajax)장바구니 삭제
		map.put("/cartToOrder.do", new CartToOrder());

		// ▶ 회원 관리(채은)
		map.put("/adminMemberList.do", new AdminMemberList()); // 회원관리 jsp 호출
		map.put("/ajaxAdminMemberList.do", new AjaxAdminMemberList()); // (ajax)회원 전체출력
		map.put("/ajaxAdminDel.do", new AjaxAdminDel()); // (ajax)회원삭제
		map.put("/adminOrdersList.do", new AdminOrdersList()); // 회원 구매 목록

		// ▶ 수강강좌목록 가져오기 (채은)
		map.put("/ajaxOrdersSelectList.do", new AjaxOrdersSelectList());

		// ▶ FAQ(==QNA)
		map.put("/qnaMain.do", new QnaMain());
		map.put("/adminQnaList.do", new AdminQnaList());
		map.put("/qnaInsertForm.do", new QnaInsertForm());
		map.put("/qnaInsert.do", new QnaInsert());
		map.put("/qnaEditForm.do", new QnaEditForm());
		map.put("/qnaUpdate.do", new QnaUpdate());
		map.put("/qnaDelete.do", new QnaDelete());
		map.put("/ajaxQnaList.do", new AjaxQnaList());

		// ============================================================================================

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 분석, 실행, 결과를 돌려주는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		System.out.println(page + "==============");
		Command command = map.get(page);
		String viewPage = command.exec(request, response);

		// view Resolve start
		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("Ajax:")) {
				// ajax
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print(viewPage.substring(5));
				return;
			} else if (!viewPage.endsWith(".tiles")) {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp"; // 타일즈 적용안하는 것
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}

}
