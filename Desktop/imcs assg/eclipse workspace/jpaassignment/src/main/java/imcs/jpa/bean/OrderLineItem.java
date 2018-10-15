package imcs.jpa.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="orderLineItem")
public class OrderLineItem {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="orderCode")
	private int orderCode;
	
	@ManyToOne
	//@JoinColumn(name="order",nullable=false)
	private Order order;
	
	@Column(name="orderName")
	private String orderName;
	
	@Column(name="orderDescription")
	private String orderDescription;
	
	@Column(name="quantityOrdered")
	private int quantityOrdered;
	
	@Column(name="price")
	private double priceEach;
	
	@Column(name="orderLineNumber")
	private int orderLineNumber;
	
	
}
