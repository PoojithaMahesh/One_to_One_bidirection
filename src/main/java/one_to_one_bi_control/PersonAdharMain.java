package one_to_one_bi_control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_bi_dao.PersonDao;
import one_to_one_bi_dto.AdharCard;
import one_to_one_bi_dto.Person;

public class PersonAdharMain {
public static void main(String[] args) {
	Person person=new Person();
	AdharCard adharCard=new AdharCard();
	person.setAddress("blr");
	person.setId(2);
	person.setName("kavya");
	person.setPhone(1234788);
	
	adharCard.setAddress("bkr");
	adharCard.setId(102);
	adharCard.setName("kavya p");
	adharCard.setPerson(person);
	person.setAdharCard(adharCard);
//	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//    EntityManager entityManager=entityManagerFactory.createEntityManager();
//    EntityTransaction entityTransaction=entityManager.getTransaction();
////    entityTransaction.begin();
////    entityManager.persist(person);
////    entityManager.persist(adharCard);
////    entityTransaction.commit();
//    Person person1=entityManager.find(Person.class, 1);
//    System.out.println(person);
//    
	PersonDao personDao=new PersonDao();
	personDao.SavePerson(person);
			
}
}
