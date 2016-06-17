package edu.ucm.pds.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import edu.ucm.pds.beans.Item;
import edu.ucm.pds.beans.Location;
import edu.ucm.pds.beans.Order;
import edu.ucm.pds.db.LocationDAO;
import edu.ucm.pds.db.OrderDAO;
import edu.ucm.pds.db.PizzaDAO;

@ManagedBean(eager=true)
@ApplicationScoped
public class PizzaMaker extends Thread  implements Serializable {


	private List<Item> pizzasOrdered;
	private List<Item> pizzasDelivered;

	private List<Location> stores;
	private List<Order> orders;
	private List<Item> pizzasMenu;

	private PizzaDAO pDao;
	private LocationDAO lDao;
	private OrderDAO oDAO;

	public List<Location> getStores() {
		return stores;
	}

	public void setStores(List<Location> stores) {
		this.stores = stores;
	}



	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void run() {

		try {
			while(true){

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	@PostConstruct
	public void start() {
		pizzasOrdered = new ArrayList<Item>();
		pizzasDelivered = new ArrayList<Item>();
		orders = new ArrayList<Order>();
		selectedLocation = new Location();
		selectedPizza = new Item(0, "", 0, "");

		pDao = new PizzaDAO();
		lDao = new LocationDAO();
		oDAO = new OrderDAO();

		loadPizzaMenu();

	}


	private void loadPizzaMenu(){

		pizzasMenu = pDao.getItems();
		stores = lDao.getLocations();
	}

	public Item getPizza() {
		return pizza;
	}


	public void setPizza(Item pizza) {
		this.pizza = pizza;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}

	private Item pizza;
	private Location location;




	public List<Item> getPizzasOrdered() {
		return pizzasOrdered;
	}

	public void setPizzasOrdered(List<Item> pizzasOrdered) {
		this.pizzasOrdered = pizzasOrdered;
	}

	public List<Item> getPizzasDelivered() {
		return pizzasDelivered;
	}

	public void setPizzasDelivered(List<Item> pizzasDelivered) {
		this.pizzasDelivered = pizzasDelivered;
	}


	private Item selectedPizza;

	public void addNewPizza(ActionEvent event){
		selectedPizza = new Item(0, "", 0, "");
	}

	public void addPizza(ActionEvent event) {
		System.out.println(selectedPizza);
		pDao.insertPizza(selectedPizza);
	}

	public void removePizza(ActionEvent event){
		pizzasMenu.remove(selectedPizza);
		pDao.deleteItem(selectedPizza);
	}

	private Location selectedLocation;
	public Item getSelectedPizza() {
		return selectedPizza;
	}

	public void setSelectedPizza(Item selectedPizza) {
		this.selectedPizza = selectedPizza;
	}

	public Location getSelectedLocation() {
		return selectedLocation;
	}

	public void setSelectedLocation(Location selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	public void addNewLocation(ActionEvent event){
		selectedLocation = new Location();
	}

	public void addLocation(ActionEvent event){
		System.out.println(selectedLocation);
		lDao.insertLocation(selectedLocation);
	}

	public void removeLocation(ActionEvent event){
		lDao.deleteLocation(selectedLocation);
		stores.remove(selectedLocation);

	}

	public List<Item> getPizzasMenu() {
		return pizzasMenu;
	}

	public void setPizzasMenu(List<Item> pizzasMenu) {
		this.pizzasMenu = pizzasMenu;
	}



}
