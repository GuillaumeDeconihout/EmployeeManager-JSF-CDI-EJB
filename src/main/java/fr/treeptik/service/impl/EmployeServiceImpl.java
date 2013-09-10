package fr.treeptik.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@Stateless
public class EmployeServiceImpl implements EmployeService {

    @Inject
    private Logger log;

    @Inject
    private EmployeDAO dao;
    
    @Override
	public void register(Employe employe) throws ServiceException {
        try {
			log.info("Registering " + employe.getNom());
			dao.register(employe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
    }

	@Override
	public List<Employe> findAll() throws ServiceException {
		try {
			log.info("FindAll");
			return dao.findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void remove(Integer id) throws ServiceException {
		try {
			log.info("Removing ID : " + id);
			dao.remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public Employe update(Employe employe) throws ServiceException {
		try {
			log.info("Updating " + employe.getNom());
			return dao.update(employe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
