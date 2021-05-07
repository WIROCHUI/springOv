package com.olva.eser.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WS_PAGO_ESER")
@NamedQueries({
	@NamedQuery(name = "wsPagoEser.findByEstado", query = "SELECT e FROM WsPagoEser e where e.estado = :estado "),
})
public class WsPagoEser  implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WS_PAGO_ESER")
    @SequenceGenerator(name = "SEQ_WS_PAGO_ESER", sequenceName = "SEQ_WS_PAGO_ESER", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    @Getter @Setter private Long id;
	
	@Column(name = "EVENT_TYPE")
    @Getter @Setter private String eventType;
	
	@Column(name = "OPERATION_NUMBER")
    @Getter @Setter private String operationNumber;
	
	@Column(name = "CIP")
    @Getter @Setter private String cip;
	
	@Column(name = "CURRENCY")
    @Getter @Setter private String currency;
	
	@Column(name = "AMOUNT")
    @Getter @Setter private BigDecimal amount;
	
	@Column(name = "PAYMENT_DATE")
    @Getter @Setter private String paymentDate;
	
	@Column(name = "TRANSACTION_CODE")
    @Getter @Setter private String transactionCode;
	
	@Column(name = "DATA_JSON")
    @Getter @Setter private String dataJson;
	
	@Column(name = "MSJ_ERROR")
    @Getter @Setter private String msjError;
	
	@Column(name = "ESTADO")
    @Getter @Setter private String estado;
	
	@Column(name = "CREATE_DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	@Getter	@Setter	private Date createDatetime;
	
	@Column(name = "MODIFY_DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	@Getter	@Setter	private Date modifyDatetime;
	
	
	
	public WsPagoEser() {
	}

	public WsPagoEser(Long id, String eventType, String operationNumber, String cip, String currency, BigDecimal amount,
			String paymentDate, String transactionCode, String dataJson, String msjError, String estado,
			Date createDatetime, Date modifyDatetime) {
		this.id = id;
		this.eventType = eventType;
		this.operationNumber = operationNumber;
		this.cip = cip;
		this.currency = currency;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.transactionCode = transactionCode;
		this.dataJson = dataJson;
		this.msjError = msjError;
		this.estado = estado;
		this.createDatetime = createDatetime;
		this.modifyDatetime = modifyDatetime;
	}

	public WsPagoEser(Long id, BigDecimal amount, String transactionCode) {
		this.id = id;
		this.amount = amount;
		this.transactionCode = transactionCode;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 405004355194945820L;


}
