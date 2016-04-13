package at.ciit.services;

import java.util.ArrayList;
import java.util.List;

import at.ciit.products.Car;
import at.ciit.services.factories.CarFactory;

public class Branch {
	private Region region;
	
	public Branch(Region region) {
		this.region = region;
	}

	private List<Car> sold = new ArrayList<Car>();
	
	private List<Car> ordered = new ArrayList<Car>();;
	
	private List<Car> stored = new ArrayList<Car>();;
	
	private List<Car> handedOver = new ArrayList<Car>();;
	
	private CarFactory factory = new CarFactory();

	private Corporation corporation = new Corporation();
	
	public void order(Car p){
		corporation.checkAvailabily(p, this.region);
		System.out.println("--- car ordered ---");
	}
	
	public void sell(Car p){
		getSold().add(p);
		System.out.println("--- car sold ---");
		factory.manufacture(p, this);		
	}
	
	public void receive(Car p) {
		//TODO: check if was ordered
		//TODO: check parameters
		getOrdered().remove(p);
		getStored().add(p);
		System.out.println("--- car received on branch ---");
	}
	
	public void handOver(Car p){
		getStored().remove(p);
		getHandedOver().add(p);
	}

	public List<Car> getSold() {
		return sold;
	}

	public void setSold(List<Car> sold) {
		this.sold = sold;
	}

	public List<Car> getOrdered() {
		return ordered;
	}

	public void setOrdered(List<Car> ordered) {
		this.ordered = ordered;
	}

	public List<Car> getStored() {
		return stored;
	}

	public void setStored(List<Car> stored) {
		this.stored = stored;
	}

	public List<Car> getHandedOver() {
		return handedOver;
	}

	public void setHandedOver(List<Car> handedOver) {
		this.handedOver = handedOver;
	}
}
