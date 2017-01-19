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
import javax.persistence.Table;

/**
 * Taxes generated by hbm2java
 */
@Entity
@Table(name = "Taxes", catalog = "invoicedb")
public class Taxes implements java.io.Serializable {

	private Integer id;
	private String name;
	private Integer percentage;
	private Set<LineItem> lineItems = new HashSet<LineItem>(0);

	public Taxes() {
	}

	public Taxes(String name, Integer percentage, Set<LineItem> lineItems) {
		this.name = name;
		this.percentage = percentage;
		this.lineItems = lineItems;
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

	@Column(name = "Name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Percentage")
	public Integer getPercentage() {
		return this.percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Taxes_LineItem", catalog = "invoicedb", joinColumns = {
			@JoinColumn(name = "TaxesID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "LineItemID", nullable = false, updatable = false) })
	public Set<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

}
