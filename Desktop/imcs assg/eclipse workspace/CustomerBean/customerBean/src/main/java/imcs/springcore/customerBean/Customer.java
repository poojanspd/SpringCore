package imcs.springcore.customerBean;


public class Customer {
	 
	public Customer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String name;
	
	private String address;

	public void display() {
System.out.println("Customer display method");		
	}
}
