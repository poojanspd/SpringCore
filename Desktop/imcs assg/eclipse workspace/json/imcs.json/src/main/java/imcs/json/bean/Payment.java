package imcs.json.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	private String cardName;
	private String cardNumber;
	private Date dateFrom;
	private Date dateTo;
	private CardType cardtype;

}
