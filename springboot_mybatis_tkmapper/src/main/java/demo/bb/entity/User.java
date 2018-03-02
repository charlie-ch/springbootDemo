package demo.bb.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
public class User {

	@Id
	@Column(name="uid")
	//@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
	@GeneratedValue(generator="UUID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String uid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
