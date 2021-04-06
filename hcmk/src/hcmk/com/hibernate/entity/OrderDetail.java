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

@Entity(name="orderDetail")
@Table(name="orderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="orderDetailId")
	long orderDetailId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orderId")
	Orders orderId;
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
	@Column(name="paid")
	boolean paid;
	public OrderDetail() {
		super();
	}
	public OrderDetail(Orders orderId, Product productId, String discount, String tax, String totalPrice, int quantity,
			boolean paid) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.discount = discount;
		this.tax = tax;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.paid = paid;
	}
	public OrderDetail(long orderDetailId, Orders orderId, Product productId, String discount, String tax,
			String totalPrice, int quantity, boolean paid) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
		this.discount = discount;
		this.tax = tax;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.paid = paid;
	}
	public long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Orders getOrderId() {
		return orderId;
	}
	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
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
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", discount=" + discount + ", tax=" + tax + ", totalPrice=" + totalPrice + ", quantity=" + quantity
				+ ", paid=" + paid + "]";
	}
	
	

}
