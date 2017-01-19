package com.duke.db.beans;
// Generated 18-Jan-2017 5:19:36 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "Customer", catalog = "invoicedb")
public class Customer implements java.io.Serializable {

	private Integer id;
	private Address address;
	private Subscription subscription;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Set<Business> businesses = new HashSet<Business>(0);
	private Set<Invoice> invoices = new HashSet<Invoice>(0);

	public Customer() {
	}

	public Customer(Address address, Subscription subscription) {
		this.address = address;
		this.subscription = subscription;
	}

	public Customer(Address address, Subscription subscription, String firstName, String lastName, String email,
			String phone, Set<Business> businesses, Set<Invoice> invoices) {
		this.address = address;
		this.subscription = subscription;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.businesses = businesses;
		this.invoices = invoices;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AddressID", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBSCRIPTIONID", nullable = false)
	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Column(name = "FirstName", length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LastName", length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "Email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Customer_Business", catalog = "invoicedb", joinColumns = {
			@JoinColumn(name = "CustomerID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "BusinessID", nullable = false, updatable = false) })
	public Set<Business> getBusinesses() {
		return this.businesses;
	}

	public void setBusinesses(Set<Business> businesses) {
		this.businesses = businesses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

}
