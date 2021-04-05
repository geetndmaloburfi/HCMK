package hcmk.com.hibernate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name="product")
@Table(name="product")
public class Product {
	@Id 
	@Column(name="productId")
	int productId;
	@Column(name = "productName")
	String productName;
	@Column(name = "title")
	String title;
	@Column(name="metal")
	String metal;
	@Column(name="summary")
	String summary;
	@Column(name = "price")
	String price;
	@Column(name="makingCharge")
	String makingCharge;
	@Column(name = "quantity")
	int quantity;
	@Column(name = "purity")
	int purity; 
	@Column(name = "cDate")
	String cDate;
	@Column(name="mDate")
	String  mDate;
	@Column(name="categoryId")
	int categoryId;
	@Column(name="supplyId")
	int  supplyId;
	@Column(name="photos")
	String photos;
	@Column(name="bestseller")
	Boolean bestseller;
	public Product() {
			
		}
	
	
	


	public Product(String productName, String title, String metal, String summary, String price, String makingCharge,
			int quantity, int purity, String cDate, String mDate, int categoryId, int supplyId, String photos,
			Boolean bestseller) {
		super();
		this.productName = productName;
		this.title = title;
		this.metal = metal;
		this.summary = summary;
		this.price = price;
		this.makingCharge = makingCharge;
		this.quantity = quantity;
		this.purity = purity;
		this.cDate = cDate;
		this.mDate = mDate;
		this.categoryId = categoryId;
		this.supplyId = supplyId;
		this.photos = photos;
		this.bestseller = bestseller;
	}





	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", title=" + title + ", metal="
				+ metal + ", summary=" + summary + ", price=" + price + ", makingCharge=" + makingCharge + ", quantity="
				+ quantity + ", purity=" + purity + ", cDate=" + cDate + ", mDate=" + mDate + ", categoryId="
				+ categoryId + ", supplyId=" + supplyId + ", photos=" + photos + ", bestseller="+bestseller+"]";
	}


	public Boolean getBestseller() {
		return bestseller;
	}





	public void setBestseller(Boolean bestseller) {
		this.bestseller = bestseller;
	}





	public Product(String photos) {
		
		this.photos = photos;
	}
	public int getProductId() { 
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMetal() {
		return metal;
	}
	public void setMetal(String metal) {
		this.metal = metal;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMakingCharge() {
		return makingCharge;
	}
	public void setMakingCharge(String makingCharge) {
		this.makingCharge = makingCharge;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPurity() {
		return purity;
	}
	public void setPurity(int purity) {
		this.purity = purity;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	
}