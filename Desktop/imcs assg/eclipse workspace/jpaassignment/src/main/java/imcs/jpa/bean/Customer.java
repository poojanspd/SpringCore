package imcs.jpa.bean;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="customer")
@Access(AccessType.FIELD)

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customerId")
	private Integer custID;
	
	@NotNull
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="creditLimit")
	private Double creditLimit;
	
	@Column(name="salesRepID")
	private Integer salesRepID;

	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Embedded
	private Address address;

	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Order> orders;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Payments> payments;
	
	public Customer(Integer custID, String name) {
		this.custID = custID;
		this.customerName = name;
	}
	
	public Customer(Integer custID, String name, Double creditLimit) {
		this.custID = custID;
		this.customerName = name;
		this.creditLimit = creditLimit;
	}

	public Customer(Integer custID, String customerName, Double creditLimit, Integer salesRepID, String phoneNumber) {
		super();
		this.custID = custID;
		this.customerName = customerName;
		this.creditLimit = creditLimit;
		this.salesRepID = salesRepID;
		this.phoneNumber = phoneNumber;
	}

	public Customer(Integer custID, String customerName, Double creditLimit, Integer salesRepID, String phoneNumber, Address address) {
		super();
		this.custID = custID;
		this.customerName = customerName;
		this.creditLimit = creditLimit;
		this.salesRepID = salesRepID;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

}
