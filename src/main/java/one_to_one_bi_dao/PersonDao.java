package one_to_one_bi_dao;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import one_to_one_bi_dto.AdharCard;
import one_to_one_bi_dto.Person;

public class PersonDao {
public EntityManager getEntityManager() {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	return entityManager;
}
public void SavePerson(Person person) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(person);
	entityTransaction.commit();
}
public void updatePerson(int id,Person person) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Person person2=entityManager.find(Person.class,id );
	entityTransaction.begin();
	person.setId(id);
	person.setAdharCard(person2.getAdharCard());
	entityManager.merge(person);
	entityTransaction.commit();
	
}
public void deletePerson(int id) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Person person2=entityManager.find(Person.class,id );
	entityTransaction.begin();
	entityManager.remove(person2);
	entityTransaction.commit();
}
public void getPersonById(int id) {
	EntityManager entityManager=getEntityManager();
	Person person=entityManager.find(Person.class, id);
	System.out.println(person);
}
public void getAllPerson() {
	EntityManager entityManager=getEntityManager();
	javax.persistence.Query query=entityManager.createQuery("select p from Person p");
	List<Person> list=query.getResultList();
	System.out.println(list);
	
	
	
}

}
