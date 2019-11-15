package w3.aspatharas.webApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccountsManager {
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {}
	
	public static void begin() {
		factory = Persistence.createEntityManagerFactory("AccountUnit");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	public static void create(String email,String name,String password) {
		Accounts newAccount = new Accounts();
		newAccount.setEmail(email);
		newAccount.setName(name);
		newAccount.setPassword(password);
		entityManager.persist(newAccount);
	}
	
	public static Accounts read(String email) {
		
		return(entityManager.find(Accounts.class, email));
	}
	
	public static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
}
