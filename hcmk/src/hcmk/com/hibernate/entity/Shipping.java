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

@Entity(name="shipping")
@Table(name="shipping")
public class Shipping {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="shippingId")
	long shippingId;
	@Column(name="shippingName")
	String shippingName;
	@Column(name="shippingContact")
	String shippingContact;
	@OneToMany(mappedBy="shippingId",fetch = FetchType.LAZY)
	List<Orders> orders=new ArrayList<Orders>();
	public long getShippingId() {
		return shippingId;
	}
	public void setShippingId(long shippingId) {
		this.shippingId = shippingId;
	}
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public String getShippingContact() {
		return shippingContact;
	}
	public void setShippingContact(String shippingContact) {
		this.shippingContact = shippingContact;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Shipping(long shippingId, String shippingName, String shippingContact, List<Orders> orders) {
		super();
		this.shippingId = shippingId;
		this.shippingName = shippingName;
		this.shippingContact = shippingContact;
		this.orders = orders;
	}
	public Shipping(String shippingName, String shippingContact, List<Orders> orders) {
		super();
		this.shippingName = shippingName;
		this.shippingContact = shippingContact;
		this.orders = orders;
	}
	public Shipping() {
		super();
	}
	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", shippingName=" + shippingName + ", shippingContact="
				+ shippingContact + ", orders=" + orders + "]";
	}
	
}
