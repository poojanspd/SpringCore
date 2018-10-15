package imcs.jpa.dao;

import javax.persistence.EntityManager;

import imcs.jpa.bean.Order;
import imcs.jpa.util.JPAUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean addOrder(Order order) {
		EntityManager entitymanager = getEntityManager();
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(order);
			entitymanager.getTransaction().commit();
			return true;
		}
		finally {
			entitymanager.close();
		}
		
	}

	private EntityManager getEntityManager() {
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Order updateOrder(Order order) {
		EntityManager entitymanager = getEntityManager();
		try {
			entitymanager.getTransaction().begin();
			entitymanager.merge(order);
			entitymanager.getTransaction().commit();
			return order;
		}
		finally {
			entitymanager.close();
		}

	}

	@Override
	public boolean deleteOrder(Integer id) {
		EntityManager entitymanager = getEntityManager();
		try {
			entitymanager.getTransaction().begin();
			Order order= entitymanager.find(Order.class, id);
			entitymanager.remove(order);
			entitymanager.getTransaction().commit();
			return true;
		}
		finally {
			entitymanager.close();
		}
	}

	@Override
	public Order getOrder(Integer id) {
		EntityManager entitymanager = getEntityManager();
		try {
			Order order= entitymanager.find(Order.class, id);
						return order;
		}
		finally {
			entitymanager.close();
		}
		// TODO Auto-generated method stub
	
	}

}
