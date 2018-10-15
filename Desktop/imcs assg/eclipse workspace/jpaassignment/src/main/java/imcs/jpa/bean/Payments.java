package imcs.jpa.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="payment")
public class Payments {
	@Id
	@Column(name="checkNo")
	private int checkNo;
	
	@ManyToOne
	//@JoinColumn(name="customer",nullable=false)
	private Customer customer;
	
	@Column(name="paymentDate")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;

	@Column(name="amount")
	private double amount;
	
	//Constructor
	
	//Payment related methods.
}
