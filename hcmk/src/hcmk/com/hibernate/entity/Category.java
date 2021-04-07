package hcmk.com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="category")
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="categoryId")
	long categoryId; 
	@Column(name="categoryName")
	String categoryName;
	@Column(name="categorydes")
	String categorydes;
	@OneToMany(mappedBy="categoryId",fetch = FetchType.LAZY)
	List<Product> products=new ArrayList<Product>();
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category(String categoryName, String categorydes, List<Product> products) {
		
		this.categoryName = categoryName;
		this.categorydes = categorydes;
		this.products = products;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategorydes() {
		return categorydes;
	}
	public void setCategorydes(String categorydes) {
		this.categorydes = categorydes;
	}
	public Category(long categoryId, String categoryName, String categorydes) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categorydes = categorydes;
	}
	public Category(String categoryName, String categorydes) {
		super();
		this.categoryName = categoryName;
		this.categorydes = categorydes;
	}
	public Category() {
		
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categorydes=" + categorydes
				+ "]";
	}

}
