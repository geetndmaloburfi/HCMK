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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="cart")
@Table(name="cart")
public class Cart {
	@Id 
	@Column(name="cartId")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	long cartId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userName")
	Users userName;	
	@OneToMany(mappedBy="cartId",fetch = FetchType.LAZY)
	List<CartDetail> cartDetailId=new ArrayList<CartDetail>();
	
	@Column(name = "grandTotal")
	String grandTotal;
	@Column(name = "placed")
	boolean placed;
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public Users getUserName() {
		return userName;
	}
	public void setUserName(Users userName) {
		this.userName = userName;
	}
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public boolean isPlaced() {
		return placed;
	}
	public void setPlaced(boolean placed) {
		this.placed = placed;
	}
	
	public List<CartDetail> getCartDetailId() {
		return cartDetailId;
	}
	public void setCartDetailId(List<CartDetail> cartDetailId) {
		this.cartDetailId = cartDetailId;
	}
	public Cart(long cartId, Users userName, String grandTotal, boolean placed,List<CartDetail> cartDetailId) {
		super();
		this.cartId = cartId;
		this.userName = userName;
		this.grandTotal = grandTotal;
		this.placed = placed;
		this.cartDetailId=cartDetailId;
	}
	public Cart(Users userName, String grandTotal, boolean placed,List<CartDetail> cartDetailId) {
		super();
		this.userName = userName;
		this.grandTotal = grandTotal;
		this.placed = placed;
		this.cartDetailId=cartDetailId;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userName=" + userName + ", cartDetailId=" + cartDetailId + ", grandTotal="
				+ grandTotal + ", placed=" + placed + "]";
	}
	
	

}
