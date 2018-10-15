package imcs.jpa.bean;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

/*@Entity
@Table(name="address")
*/
@Embeddable
public class Address{
	/*@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="addressId")*/
	
	@Column
	String addressLine1;
	
	@Column
	String addressLine2;

	@Column
	String city;
	
	@Enumerated(EnumType.STRING)
	@Column
	State state; // See enum State
	
	@Embedded
	@Column
	ZipCode postalCode; // See class zipcode
	
	String country;
	public Address(String addressLine1, String addressLine2, String city, String stateName, String postalCode,
			String country) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = State.getState(stateName);
		this.postalCode = new ZipCode(postalCode);
		this.country = country;
	}
	public Address(String addressLine12, String addressLine22, String city2, State ar, ZipCode zipCode,
			String country2) {
		this.addressLine1 = addressLine12;
		this.addressLine2 = addressLine22;
		this.city = city2;
		this.state = ar;
		this.postalCode =zipCode;
		this.country = country2;
	}
	
	//Constructors
	
	
	// Some address methods.
}
