package com.sanalberto.clientes;
// Generated 26 ene. 2021 11:10:12 by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Invoiceline generated by hbm2java
 */
@Entity
@Table(name = "invoiceline", catalog = "chinook")
public class Invoiceline implements java.io.Serializable {

	private Integer invoiceLineId;
	private Invoice invoice;
	private Track track;
	private BigDecimal unitPrice;
	private int quantity;

	public Invoiceline() {
	}

	public Invoiceline(Invoice invoice, Track track, BigDecimal unitPrice, int quantity) {
		this.invoice = invoice;
		this.track = track;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "InvoiceLineId", unique = true, nullable = false)
	public Integer getInvoiceLineId() {
		return this.invoiceLineId;
	}

	public void setInvoiceLineId(Integer invoiceLineId) {
		this.invoiceLineId = invoiceLineId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "InvoiceId", nullable = false)
	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TrackId", nullable = false)
	public Track getTrack() {
		return this.track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Column(name = "UnitPrice", nullable = false, precision = 10)
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "Quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
