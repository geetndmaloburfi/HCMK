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

@Entity(name="address")
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="addressId")
    long addressId;
	@Column(name="streetAddress",length=3000)
    String streetAddress;
	@Column(name="city")
	String city;
	@Column(name="country")
	String country;
	@Column(name="pincode")
	String pincode;
	@Column(name="panNo")
	String panNo;
	@Column(name="adharNo")
	String adharNo;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userName")
	Users userName;
	@OneToMany(mappedBy="addressId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Orders> orders=new ArrayList<Orders>();
	
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetAddress=" + streetAddress + ", city=" + city + ", country="
				+ country + ", pincode=" + pincode + ", panNo=" + panNo + ", adharNo=" + adharNo + ", UserName="
				+ userName + "]";
	}
	public Address(String streetAddress, String city, String country, String pincode, String panNo, String adharNo,
			Users userName) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.panNo = panNo;
		this.adharNo = adharNo;
		this.userName = userName;
	}
	public Address() {
		super();
	}
	public Address(long addressId, String streetAddress, String city, String country, String pincode, String panNo,
			String adharNo, Users userName) {
		super();
		this.addressId = addressId;
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.panNo = panNo;
		this.adharNo = adharNo;
		this.userName = userName;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public Users getUserName() {
		return userName;
	}
	public void setUserName(Users userName) {
		this.userName = userName;
	}
	
}
