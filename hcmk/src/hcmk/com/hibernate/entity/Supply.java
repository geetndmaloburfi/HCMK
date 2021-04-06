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

@Entity(name="supply")
@Table(name="supply")
public class Supply {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="supplyId")
	long supplyId;
	@Column(name="name")
	String name;
	@Column(name="address",length=3000)
	String address;
	@Column(name="city")
	String city;
	@Column(name="country")
	String country;
	@Column(name="pincode")
	String pincode;
	@Column(name="contact")
	String contact;
	@OneToMany(mappedBy="supplyId",fetch = FetchType.LAZY)
	List<Product> supplying=new ArrayList<Product>();
	
	
	
	
	public Supply() {
		super();
	}
	
	@Override
	public String toString() {
		return "Supply [supplyId=" + supplyId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", pincode=" + pincode + ", contact=" + contact + ", products=" + supplying
				+ "]";
	}

	public Supply(String name, String address, String city, String country, String pincode, String contact,
			List<Product> products) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.contact = contact;
		this.supplying = products;
	}

	public Supply(long supplyId, String name, String address, String city, String country, String pincode,
			String contact, List<Product> products) {
		super();
		this.supplyId = supplyId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.contact = contact;
		this.supplying = products;
	}

	public long getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(long supplyId) {
		this.supplyId = supplyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<Product> getSupplying() {
		return supplying;
	}
	public void setSupplying(List<Product> products) {
		this.supplying = products;
	}
	
	
	
	
	
	

}
