package imcs.json.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String streetName;
	private int streetNo;
	private String city;
	private String pinCode;

}
