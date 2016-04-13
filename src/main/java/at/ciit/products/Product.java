package at.ciit.products;

import at.ciit.products.states.ProductState;

public class Product {
	private ProductState state;

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}
}
