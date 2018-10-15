package imcs.jpa.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name="orders")
public class Order {
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippingDate=" + shippingDate + ", status=" + status + ", comments=" + comments + ", orders="
				+ orders + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderId")
	private Integer orderID;
	
	@Column(name="orderDate")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name="requiredDate")
	@Temporal(TemporalType.DATE)
	private Date requiredDate;
	
	@Column(name="shippingDate")
	@Temporal(TemporalType.DATE)
	private Date shippingDate;
	
	@Column(name="status")
	private String status; //enum ?
	
	@Column(name="comments")
	private String comments;
	
	@ManyToOne 
	//@JoinColumn(name="customer",nullable=false)
	private Customer customer;
	
	@OneToMany(mappedBy ="order",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<OrderLineItem> orders;
}
