package hcmk.com.hibernate.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name="product")
@Table(name="product")
public class Product {
	@Id 
	@Column(name="productId")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	long productId;
	
	@Column(name = "productName")
	String productName;
	
	@Column(name = "title")
	String title;
	
	@Column(name="metal")
	String metal;
	
	@Column(name="summary",length=3000)
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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="supplyId")
	Supply supplyId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	Category categoryId;
	
	
	
	@Column(name="photos")
	String photos;
	
	@Column(name="bestseller")
	Boolean bestseller;
	@OneToMany(mappedBy="productId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<CartDetail> cartDetailId=new ArrayList<CartDetail>();
	
	
	public Product() {
			
		}
	
	
	


	public Product(long productId, String productName, String title, String metal, String summary, String price,
			String makingCharge, int quantity, int purity, String cDate, String mDate, Category categoryId,
			Supply supplyId, String photos, Boolean bestseller) {
		super();
		this.productId = productId;
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





	public Product(String productName, String title, String metal, String summary, String price, String makingCharge,
			int quantity, int purity, String cDate, String mDate, Category categoryId, Supply supplyId, String photos,
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestseller == null) ? 0 : bestseller.hashCode());
		result = prime * result + ((cDate == null) ? 0 : cDate.hashCode());
		result = prime * result + ((cartDetailId == null) ? 0 : cartDetailId.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((mDate == null) ? 0 : mDate.hashCode());
		result = prime * result + ((makingCharge == null) ? 0 : makingCharge.hashCode());
		result = prime * result + ((metal == null) ? 0 : metal.hashCode());
		result = prime * result + ((photos == null) ? 0 : photos.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + purity;
		result = prime * result + quantity;
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((supplyId == null) ? 0 : supplyId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (bestseller == null) {
			if (other.bestseller != null)
				return false;
		} else if (!bestseller.equals(other.bestseller))
			return false;
		if (cDate == null) {
			if (other.cDate != null)
				return false;
		} else if (!cDate.equals(other.cDate))
			return false;
		if (cartDetailId == null) {
			if (other.cartDetailId != null)
				return false;
		} else if (!cartDetailId.equals(other.cartDetailId))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (mDate == null) {
			if (other.mDate != null)
				return false;
		} else if (!mDate.equals(other.mDate))
			return false;
		if (makingCharge == null) {
			if (other.makingCharge != null)
				return false;
		} else if (!makingCharge.equals(other.makingCharge))
			return false;
		if (metal == null) {
			if (other.metal != null)
				return false;
		} else if (!metal.equals(other.metal))
			return false;
		if (photos == null) {
			if (other.photos != null)
				return false;
		} else if (!photos.equals(other.photos))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (purity != other.purity)
			return false;
		if (quantity != other.quantity)
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (supplyId == null) {
			if (other.supplyId != null)
				return false;
		} else if (!supplyId.equals(other.supplyId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", title=" + title + ", metal="
				+ metal + ", summary=" + summary + ", price=" + price + ", makingCharge=" + makingCharge + ", quantity="
				+ quantity + ", purity=" + purity + ", cDate=" + cDate + ", mDate=" + mDate + ", supplyId=" + supplyId
				+ ", categoryId=" + categoryId + ", photos=" + photos + ", bestseller=" + bestseller + ", cartDetailId="
				+ cartDetailId + "]";
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
	public long getProductId() { 
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
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	public Supply getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(Supply supplyId) {
		this.supplyId = supplyId;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	
}