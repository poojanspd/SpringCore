package imcs.threading.tasks;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import imcs.threading.bean.PropertyInfo;
import imcs.threading.jpautil.JPAUtil;

public class StoreToDB {

private static EntityManager getEntityManager() {
		
		return JPAUtil.getEntityManagerFactory().createEntityManager();
	}


public static  void savePropertyInfo(List<PropertyInfo> property) {
	EntityManager entitymanager= getEntityManager();
	EntityTransaction transaction= entitymanager.getTransaction();
	try {
		transaction.begin();
		for(int i=0;i<property.size();i++) {
			entitymanager.persist(property.get(i));
		}
		transaction.commit();}
	finally {
		entitymanager.close();
	}
}

public static void savePropertyInfo(PropertyInfo propertyInfo) {
	EntityManager entitymanager= getEntityManager();
	try {
		entitymanager.getTransaction().begin();
		entitymanager.persist(propertyInfo);
		entitymanager.getTransaction().commit();
	}
	finally {
		entitymanager.close();
	}

	
}

	
	
}
