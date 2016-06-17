package edu.ucm.pds.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import edu.ucm.pds.beans.Item;
import edu.ucm.pds.beans.Order;

@ManagedBean
@SessionScoped
public class Home implements Serializable {


	private List<Item> pizzasAdded;

	private Item selectedPizza;

	private boolean paymentSuccess = false;
	private boolean isGuestCheckout = false;

	private int totalCost;
	public int getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}


	public Home(){		
		pizzasAdded = new ArrayList<Item>();
	}


	public void addToCart(ActionEvent event) {

		Item newPizza = new Item(selectedPizza.getItemId(),selectedPizza.getItemName(),selectedPizza.getPrice(),selectedPizza.getItemDesc());

		newPizza.setQty(selectedPizza.getQty());
		newPizza.setType(selectedPizza.getType());

		pizzasAdded.add(newPizza);

		calculateTotal();
	}

	public String buyPizzas(){

		Login login = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("login");

		if(!login.isLoginSucces()){
			return "guestCheckout";
		}
		return "confirmation";
	}

	public Item getSelectedPizza() {
		return selectedPizza;
	}


	public void setSelectedPizza(Item selectedPizza) {
		this.selectedPizza = selectedPizza;
	}


	public List<Item> getPizzasAdded() {
		return pizzasAdded;
	}

	public void setPizzasAdded(List<Item> pizzasAdded) {
		this.pizzasAdded = pizzasAdded;
	}

	public void doPayment(ActionEvent event) {
		paymentSuccess=true;
		PizzaMaker maker = (PizzaMaker)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("pizzaMaker");

		maker.getPizzasOrdered().addAll(pizzasAdded);

		pizzasAdded.clear();
	}

	public String guestCheckout() {
		paymentSuccess=false;
		Order order = new Order();
		order.setItems(pizzasAdded);
		return "confirmation";

	}


	public void onLoad(PhaseEvent event) {

	}

	public int calculateTotal() {

		totalCost = 0;

		for (Item item : pizzasAdded) {
			totalCost = totalCost+(item.getPrice()*item.getQty()*item.getType());
		}

		return totalCost;
	}

	public String goToProductPage() {
		return "ppage";
	}




	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}


	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}


	public boolean isGuestCheckout() {
		return isGuestCheckout;
	}


	public void setGuestCheckout(boolean isGuestCheckout) {
		this.isGuestCheckout = isGuestCheckout;
	}




}
