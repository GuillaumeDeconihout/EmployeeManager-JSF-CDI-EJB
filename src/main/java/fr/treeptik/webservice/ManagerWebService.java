package fr.treeptik.webservice;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@WebService
@Stateless
public class ManagerWebService {
	
	@Inject
	private EmployeService employeService;
	
	
	public void register(Employe employe) throws ServiceException {
		employeService.register(employe);
	}
	
	

}
