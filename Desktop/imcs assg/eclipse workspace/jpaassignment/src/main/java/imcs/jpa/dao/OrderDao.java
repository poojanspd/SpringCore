package imcs.jpa.dao;

import imcs.jpa.bean.Order;

public interface OrderDao {
	
	boolean addOrder(Order order);
	
	Order updateOrder(Order order);
	
	boolean deleteOrder(Integer id);
	
	Order getOrder(Integer id);

}
