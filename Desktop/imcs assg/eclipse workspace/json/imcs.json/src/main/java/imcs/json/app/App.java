package imcs.json.app;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import imcs.json.bean.Address;
import imcs.json.bean.CardType;
import imcs.json.bean.Customer;
import imcs.json.bean.Payment;

public class App {
	public static void main(String[] args) {
		serialize();
		deserialize();
	
	}

	private static void deserialize() {
		ObjectMapper objectmapper = new ObjectMapper();
		objectmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			Customer customer =objectmapper.readValue(new File("C:\\Users\\pooja\\Desktop\\imcs assg\\customer.json"), Customer.class);
			System.out.println(customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void serialize() {
		Customer customer = new Customer(101,"poojan",Date.valueOf("2001-01-01"),14000.00,null,null);
		Address address = new Address("abcd",123,"harrison","123432");
		Payment payment = new Payment("poojan","132434566562",Date.valueOf("2000-11-12"),Date.valueOf("2019-11-11"),CardType.CREDITCARD);
		customer.setAddress(address);
		customer.setPayment(payment);
		ObjectMapper objectmapper= new ObjectMapper();
		/*SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
		objectmapper.setDateFormat(dateform);*/

		objectmapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		try {
			objectmapper.writeValue(new File("C:\\Users\\pooja\\Desktop\\imcs assg\\customer.json"), customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
