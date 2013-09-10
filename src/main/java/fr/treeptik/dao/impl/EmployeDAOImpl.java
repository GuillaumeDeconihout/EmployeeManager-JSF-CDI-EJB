package fr.treeptik.dao.impl;

import javax.ejb.Stateless;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;

@Stateless
public class EmployeDAOImpl extends GenericDAOImpl<Employe, Integer> implements EmployeDAO{

   public EmployeDAOImpl() {
	   super(Employe.class);
}

	
	
}
