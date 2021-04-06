package hcmk.com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="cartDetail")
@Table(name="cartDetail")
public class CartDetail {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cartDetailId")
	long cartDetailId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cartId")
	Cart cartId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productId")
	Product productId;
	@Column(name="discount")
	String discount;
	@Column(name="tax")
	String tax;
	@Column(name="totalPrice")
	String totalPrice;
	@Column(name="quantity")
	int quantity;
	
	@Override
	public String toString() {
		return "CartDetail [cartDetailId=" + cartDetailId + ", cartId=" + cartId + ", productId=" + productId
				+ ", discount=" + discount + ", tax=" + tax + ", totalPrice=" + totalPrice + ", quantity=" + quantity
				+ "]";
	}
	public CartDetail() {	}
	public long getCartDetailId() {
		return cartDetailId;
	}
	public void setCartDetailId(long cartDetailId) {
		this.cartDetailId = cartDetailId;
	}
	public Cart getCartId() {
		return cartId;
	}
	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartDetail(long cartDetailId, Cart cartId, Product productId, String discount, String tax, String totalPrice,
			int quantity) {
		super();
		this.cartDetailId = cartDetailId;
		this.cartId = cartId;
		this.productId = productId;
		this.discount = discount;
		this.tax = tax;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	public CartDetail(Cart cartId, Product productId, String discount, String tax, String totalPrice, int quantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.discount = discount;
		this.tax = tax;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	

	
}
