package imcs.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import imcs.jpa.bean.Customer;
import imcs.jpa.util.JPAUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer loadStudent(int id) {
		EntityManager entitymanager= getEntityManager();
		try {
			Customer customer =entitymanager.find(Customer.class, 1);
			return customer;
		}
		finally {
			entitymanager.close();
		}
		
		
	}

	private EntityManager getEntityManager() {
		
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		EntityManager entitymanager= getEntityManager();
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(customer);
			entitymanager.getTransaction().commit();
		}
		finally {
			entitymanager.close();
		}
		return customer;

	}

	@Override
	public void saveCustomers(List<Customer> customer) {
		EntityManager entitymanager= getEntityManager();
		EntityTransaction transaction= entitymanager.getTransaction();
		try {
			transaction.begin();
			for(int i=0;i<customer.size();i++) {
				entitymanager.persist(customer.get(i));
			if(i%50==0) {
			
				transaction.commit();
				transaction.begin();
				entitymanager.clear();
				
		}
			}
			}
		finally {
			entitymanager.close();
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		EntityManager entitymanager= getEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.merge(customer);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return customer;
	}

	@Override
	public boolean deleteCustomer(int id) {
		EntityManager entitymanager= getEntityManager();
		try{
			entitymanager.getTransaction().begin();
			Customer customer = entitymanager.find(Customer.class,id);
			entitymanager.remove(customer);
			entitymanager.getTransaction().commit();
		}
		finally {
			entitymanager.close();
		}

		return true;
	}

	@Override
	public List<Customer> getCustomer() {
		Query query = getEntityManager().createQuery("from Customer as c orderBy c.customerName asc");
		return query.getResultList();
	}

}
