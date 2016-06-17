package edu.ucm.pds.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import edu.ucm.pds.beans.Customer;
import edu.ucm.pds.beans.User;
import edu.ucm.pds.db.CustomerDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private User user;

	private Customer customer; 
	private boolean loginSucces=false;

	private CustomerDAO cDao;

	public Login(){
		user = new User();
		customer = new Customer();
		cDao = new CustomerDAO();
	}

	public User getUser() {
		return user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoginSucces() {
		return loginSucces;
	}

	public void setLoginSucces(boolean loginSucces) {
		this.loginSucces = loginSucces;
	}

	public String loginUser() {

		user = cDao.validateUser(user);
		if(user!=null && user.getRole()>0){
			loginSucces=true;
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome "+user.getName()+"!","Welcome "+user.getName()+"!"));
			return "success";
		}
		else{
			user = new User();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid login details","Invalid login details"));
		}

		return "home";
	}

	public void register(ActionEvent event){
		loginSucces = true;
		customer.setRole(1);
		cDao.insertCustomer(customer);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered Successfully!","Registered Successfully!"));
	}

	public String logout(){
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(true)).invalidate();
		return "home";
	}

}
