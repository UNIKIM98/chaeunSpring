package co.five.mprj.product.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private int productNum;
	private String productName;
	private String productExplain;
	private String productTrainer;
	private int productPrice;
	private String productSubject;
	private int productDate;
	private String productImgUrl;
	private String productThumbnailUrl;
	private String productYoutubeurl;

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

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public String getProductTrainer() {
		return productTrainer;
	}

	public void setProductTrainer(String productTrainer) {
		this.productTrainer = productTrainer;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSubject() {
		return productSubject;
	}

	public void setProductSubject(String productSubject) {
		this.productSubject = productSubject;
	}

	public int getProductDate() {
		return productDate;
	}

	public void setProductDate(int productDate) {
		this.productDate = productDate;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
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
}
