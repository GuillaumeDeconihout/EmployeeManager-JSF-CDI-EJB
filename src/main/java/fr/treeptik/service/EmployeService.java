package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;

public interface EmployeService {

	void register(Employe employe) throws ServiceException;
	List<Employe> findAll() throws ServiceException;
	void remove(Integer id) throws ServiceException;
}