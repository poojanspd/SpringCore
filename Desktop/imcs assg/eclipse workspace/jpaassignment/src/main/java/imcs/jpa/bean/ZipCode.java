package imcs.jpa.bean;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

//Separate class for zipcode as it is generally used for many operations.

@Data
@NoArgsConstructor
@Embeddable
public class ZipCode {
	String value;

	public ZipCode(String value) {
		this.value = value;
	}
	
	public String getString() {
		return value;
	}
	
	//Other operations to validate, automatically check, search or query.
	
}