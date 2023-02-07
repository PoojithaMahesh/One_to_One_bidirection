package one_to_one_bi_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_bi_dto.AdharCard;
import one_to_one_bi_dto.Person;

public class AdharCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveAdharCard(AdharCard adharCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=adharCard.getPerson();
		entityTransaction.begin();
		entityManager.persist(adharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	public void updateAdharCard(int id,AdharCard adharCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		AdharCard adharCard2=entityManager.find(AdharCard.class, id);
		entityTransaction.begin();
		adharCard.setId(id);
		adharCard.setPerson(adharCard2.getPerson());
		entityManager.merge(adharCard);
		entityTransaction.commit();
	}
	public void deleteAdharCard(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		AdharCard adharCard2=entityManager.find(AdharCard.class, id);
		entityTransaction.begin();
		entityManager.remove(adharCard2);
		entityTransaction.commit();
		
	}
	public void getAdharCardById(int id) {
		EntityManager entityManager=getEntityManager();
		AdharCard adharCard=entityManager.find(AdharCard.class, id);
		System.out.println(adharCard);
		
	}
	public void getAllAdharcard() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from AdharCard a");
		List<AdharCard> list=query.getResultList();
		System.out.println(list);
	}
}
