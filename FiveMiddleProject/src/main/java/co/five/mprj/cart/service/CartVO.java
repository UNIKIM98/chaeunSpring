package co.five.mprj.cart.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	private int cartNum;
	private int productNum;
	private String productName;
	private int productPrice;
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProductExplain() {
		return productExplain;
	}
	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}
	private int productDate;
	private String productThumbnailUrl;
	private String memberId;
	private String productExplain;
	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", productNum=" + productNum + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productDate=" + productDate + ", productThumbnailUrl="
				+ productThumbnailUrl + ", memberId=" + memberId + ", productExplain=" + productExplain + "]";
	}

}
