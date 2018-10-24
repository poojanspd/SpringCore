package imcs.webapp;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Customer {
	

	private String fname;
	private String lname;
	private String address;
	private String country;
	private String rent;
	private int amount;
	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Customer(String fname, String lname, String address, String country, String rent, Integer amount) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.country = country;
		this.rent = rent;
		this.amount = amount;
	}
	
	
	
}
