package hcmk.com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

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

@Entity(name="orders")
@Table(name="orders")
public class Orders {
	@Id 
	@Column(name="orderId")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	long orderId;	
	@Column(name = "subTotal")
	String subTotal;
	@Column(name = "totalTax")
	String totalTax;
	@Column(name = "grandTotal")
	String grandTotal;
	@Column(name = "orderDate")
	String orderDate;	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shippingId")
	Shipping shippingId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userName")
	Users userName;
	@OneToMany(mappedBy="orderDetailId",fetch = FetchType.LAZY)
	List<OrderDetail> orderDetailId=new ArrayList<OrderDetail>();
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="addressId")
	Address addressId;
	public Orders() {
		super();
	}
	public Orders(String subTotal, String totalTax, String grandTotal, String orderDate, Shipping shippingId,
			Users userName, List<OrderDetail> orderDetailId, Address addressId) {
		super();
		this.subTotal = subTotal;
		this.totalTax = totalTax;
		this.grandTotal = grandTotal;
		this.orderDate = orderDate;
		this.shippingId = shippingId;
		this.userName = userName;
		this.orderDetailId = orderDetailId;
		this.addressId = addressId;
	}
	public Orders(long orderId, String subTotal, String totalTax, String grandTotal, String orderDate,
			Shipping shippingId, Users userName, List<OrderDetail> orderDetailId, Address addressId) {
		super();
		this.orderId = orderId;
		this.subTotal = subTotal;
		this.totalTax = totalTax;
		this.grandTotal = grandTotal;
		this.orderDate = orderDate;
		this.shippingId = shippingId;
		this.userName = userName;
		this.orderDetailId = orderDetailId;
		this.addressId = addressId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Shipping getShippingId() {
		return shippingId;
	}
	public void setShippingId(Shipping shippingId) {
		this.shippingId = shippingId;
	}
	public Users getUserName() {
		return userName;
	}
	public void setUserName(Users userName) {
		this.userName = userName;
	}
	public List<OrderDetail> getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(List<OrderDetail> orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public Address getAddressId() {
		return addressId;
	}
	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", subTotal=" + subTotal + ", totalTax=" + totalTax + ", grandTotal="
				+ grandTotal + ", orderDate=" + orderDate + ", shippingId=" + shippingId + ", userName=" + userName
				+ ", orderDetailId=" + orderDetailId + ", addressId=" + addressId + "]";
	}
	

}