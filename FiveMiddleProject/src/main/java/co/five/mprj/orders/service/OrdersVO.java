package co.five.mprj.orders.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrdersVO {
	private int ordersNum;
	private Date ordersDate;
	private String ordersStatus;
	private int productNum;
	private String memberId;
	private Date ordersDeadline;

	// JOIN해서 가져올 아이들
	private String productName;
	private int productPrice;
	private int productDate;
	private String productThumbnailUrl;
	private String productYoutubeurl;

	public int getOrdersNum() {
		return ordersNum;
	}

	public void setOrdersNum(int ordersNum) {
		this.ordersNum = ordersNum;
	}

	public Date getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(Date ordersDate) {
		this.ordersDate = ordersDate;
	}

	public String getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getOrdersDeadline() {
		return ordersDeadline;
	}

	public void setOrdersDeadline(Date ordersDeadline) {
		this.ordersDeadline = ordersDeadline;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDate() {
		return productDate;
	}

	public void setProductDate(int productDate) {
		this.productDate = productDate;
	}

	public String getProductThumbnailUrl() {
		return productThumbnailUrl;
	}

	public void setProductThumbnailUrl(String productThumbnailUrl) {
		this.productThumbnailUrl = productThumbnailUrl;
	}

	public String getProductYoutubeurl() {
		return productYoutubeurl;
	}

	public void setProductYoutubeurl(String productYoutubeurl) {
		this.productYoutubeurl = productYoutubeurl;
	}

	@Override
	public String toString() {
		return "OrdersVO [ordersNum=" + ordersNum + ", ordersDate=" + ordersDate + ", ordersStatus=" + ordersStatus
				+ ", productNum=" + productNum + ", memberId=" + memberId + ", ordersDeadline=" + ordersDeadline
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", productDate=" + productDate
				+ ", productThumbnailUrl=" + productThumbnailUrl + ", productYoutubeurl=" + productYoutubeurl + "]";
	}

}
