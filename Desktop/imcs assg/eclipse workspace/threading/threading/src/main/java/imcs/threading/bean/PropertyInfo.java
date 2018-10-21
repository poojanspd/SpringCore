package imcs.threading.bean;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name="propertyInfo")
public class PropertyInfo {

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column
	private Integer customerId;
	@Override
	public String toString() {
		return + customerId + " " + customerName + " "
				+ propertyAddress + " " + tax + " " + fillingDate;
	}
	
	@Column
	private String customerName;
	
	@Column
	private String propertyAddress;
	
	@Column
	private int tax;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fillingDate;
}
