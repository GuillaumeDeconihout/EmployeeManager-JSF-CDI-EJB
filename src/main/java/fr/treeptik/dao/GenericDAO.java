package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;

public interface GenericDAO<T, PK> {
	T register(T entity) throws DAOException;

	T findById(PK id) throws DAOException;

	void remove(PK id) throws DAOException;

	List<T> findAll() throws DAOException;
}
