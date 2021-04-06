package hcmk.com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="admin")
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="userNameAdmin")
    String userNameAdmin; 
	@Column(name="firstName")
    String firstName;
	@Column(name="lastName")
    String lastName;
	@Column(name="contact")
    String contact;
	@Column(name="password")
    String password;
	public Admin() {
		super();
	}
	public Admin(String userNameAdmin, String firstName, String lastName, String contact, String password) {
		super();
		this.userNameAdmin = userNameAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.password = password;
	}
	public String getUserNameAdmin() {
		return userNameAdmin;
	}
	public void setUserNameAdmin(String userNameAdmin) {
		this.userNameAdmin = userNameAdmin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [userNameAdmin=" + userNameAdmin + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contact=" + contact + ", password=" + password + "]";
	} 
	
	
}
