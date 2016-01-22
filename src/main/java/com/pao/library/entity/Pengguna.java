package com.pao.library.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="users")//, uniqueConstraints=@UniqueConstraint(columnNames="username",name="username"))
public class Pengguna {

	@Id @GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")	
	private String id;	
	
	@Column(unique=true, nullable=false)
	@NotNull @NotEmpty @Size(max=20)
	private String username;
	private String password;

	@Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
	private boolean enabled;
	private String fullName;
	private String address;
	@Email
	@Column(unique=true, nullable=false)
	private String email;
	private String phone;
	//set photo dataType Binary for save photo
	
//	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class, cascade=CascadeType.ALL)
	@ManyToMany
	@JoinTable(name="user_role",
				joinColumns=@JoinColumn(name="id_role"),
				inverseJoinColumns=@JoinColumn(name="id_user"))
	private List<Hakakses> roleUser = new ArrayList<>();
	
//	public User(String id, String username, String password, boolean enabled, String fullName, String address,
//			String email, String phone, List<Role> roleUser) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.enabled = enabled;
//		this.fullName = fullName;
//		this.address = address;
//		this.email = email;
//		this.phone = phone;
//		this.roleUser = roleUser;
//	}
//
//	public User(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Hakakses> getRoleUser() {
		return roleUser;
	}
	public void setRoleUser(List<Hakakses> roleUser) {
		this.roleUser = roleUser;
	}
	
	
}
