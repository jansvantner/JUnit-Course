package at.ciit.services;

import at.ciit.products.Car;
import at.ciit.products.states.ProductState;

public class TransportCompany {
	public void moveToBranch(Car p, Branch b)  {
		p.setState(ProductState.IN_TRANSPORT);
		move(p);		
		System.out.println("--- car transported---");
		b.receive(p);		
	}

	private void move(Car p) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException ignored) {
		}		
	}
}
