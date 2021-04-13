package hcmk.com.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CartProduct {

	
		// TODO Auto-generated constructor stub
		@JsonProperty("address")
		long  productId;
		@JsonIgnore
		String productName;
		int productQuantity;
		double productPrice;
		double productMC;
		double totalPrice;
		String productPhoto;
		
		@Override
		public String toString() {
			return "CartProduct [productId=" + productId + ", productName=" + productName + ", productQuantity="
					+ productQuantity + ", productPrice=" + productPrice + ", productMC=" + productMC
					+ ", productPhoto=" + productPhoto + "]";
		}


		
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}


		public int getProductQuantity() {
			return productQuantity;
		}


		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}


		

		public long getProductId() {
			return productId;
		}





		public void setProductId(long productId) {
			this.productId = productId;
		}





		public double getProductPrice() {
			return productPrice;
		}





		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}





		public double getProductMC() {
			return productMC;
		}





		public void setProductMC(double productMC) {
			this.productMC = productMC;
		}





		public String getProductPhoto() {
			return productPhoto;
		}


		public void setProductPhoto(String productPhoto) {
			this.productPhoto = productPhoto;
		}


		public CartProduct() {	
	}

}
