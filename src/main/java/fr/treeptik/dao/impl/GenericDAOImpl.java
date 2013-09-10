package fr.treeptik.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.treeptik.dao.GenericDAO;


public class GenericDAOImpl<T,PK> implements GenericDAO<T, PK> {
	
	
	@Inject
	protected EntityManager entitymanager;
	

	private Class<T> type;
	

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	@Override
	public T register(T entity) {
		entitymanager.persist(entity);
		return entity;
	}

	@Override
	public T findById(PK id) {
		return entitymanager.find(type, id);
	}

	@Override
	public void remove(PK id)  {
		Query query = entitymanager.createQuery("delete from "+ type.getSimpleName() + " o where o.id= :id"); 
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public List<T> findAll() {
		return entitymanager.createQuery("select o from "+ type.getSimpleName() + " o",type).getResultList();
	}


}
