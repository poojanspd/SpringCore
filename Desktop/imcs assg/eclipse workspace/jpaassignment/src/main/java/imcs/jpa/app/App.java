package imcs.jpa.app;

import java.sql.Date;

import imcs.jpa.bean.Address;
import imcs.jpa.bean.Customer;
import imcs.jpa.bean.Order;
import imcs.jpa.bean.State;
import imcs.jpa.bean.ZipCode;
import imcs.jpa.dao.CustomerDao;
import imcs.jpa.dao.CustomerDaoImpl;
import imcs.jpa.dao.OrderDao;
import imcs.jpa.dao.OrderDaoImpl;

public class App {

	public static void main(String[] args) {
		OrderDao orderdao= new OrderDaoImpl();
		CustomerDao dao=new CustomerDaoImpl();
	Customer customer = new Customer(null,"poojan",300.0,101,"2012222013",null);
	Address address = new Address("123","ABCD STREET","IRVING",State.AR,new ZipCode("12432"),"USA");
	customer.setAddress(address);
	dao.saveCustomer(customer);
	orderdao.addOrder(new Order(null,Date.valueOf("2017-09-09"),Date.valueOf("2019-09-09"),Date.valueOf("2019-09-09"),"pending","hello",customer,null));
	orderdao.updateOrder(new Order(2,Date.valueOf("2018-10-09"),Date.valueOf("2019-09-09"),Date.valueOf("2019-09-09"),"done","hello",customer,null));

	Customer customer1 = new Customer(null,"aman",300.0,101,"2012222013",null);
	Address address1 = new Address("525","xyz STREET","IRVING",State.AR,new ZipCode("12432"),"USA");
	customer1.setAddress(address1);
	dao.saveCustomer(customer1);
	orderdao.addOrder(new Order(null,Date.valueOf("2019-09-09"),Date.valueOf("2019-09-09"),Date.valueOf("2019-09-09"),"pending","hello",customer1,null));
	orderdao.addOrder(new Order(null,Date.valueOf("2017-02-01"),Date.valueOf("2018-09-09"),Date.valueOf("2019-09-09"),"pending","sending",customer,null));
	
	orderdao.deleteOrder(5);
	System.out.println(orderdao.getOrder(4));
	}

}
