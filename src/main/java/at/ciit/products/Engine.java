package at.ciit.products;

import at.ciit.products.options.EngineOptions;

public class Engine extends Product {

	private EngineOptions setup;
	
	public EngineOptions getSetup() {
		return setup;
	}

	public void setSetup(EngineOptions setup) {
		this.setup = setup;
	}

}
