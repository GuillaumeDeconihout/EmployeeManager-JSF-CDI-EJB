package fr.treeptik.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@ManagedBean(name = "employeMB")
public class EmployeManagedBean {

	@Inject
	private FacesContext facesContext;

	@Inject
	private EmployeService employeService;

	private ListDataModel<Employe> listDataModel;

	private Employe employe;

	@PostConstruct
	public void init() {
		setEmploye(new Employe());
	}

	public void register() throws Exception {
		try {
			employeService.register(getEmploye());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			init();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getLocalizedMessage(), "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public String remove() throws Exception {
		employe = listDataModel.getRowData();
		employeService.remove(employe.getId());
		initListDataModel();
		return "list";
	}	
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public ListDataModel<Employe> getListDataModel() throws Exception {

		if (listDataModel == null) {
			initListDataModel();
		}

		return listDataModel;
	}

	public void setListDataModel(ListDataModel<Employe> listDataModel) {
		this.listDataModel = listDataModel;
	}

	private void initListDataModel() throws Exception {
		listDataModel = new ListDataModel<>(employeService.findAll());
	}

}
