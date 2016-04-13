package at.ciit.services.factories;

import at.ciit.products.Engine;
import at.ciit.products.options.EngineOptions;
import at.ciit.products.states.ProductState;

public class EngineFactory {
	public Engine manufacture(EngineOptions setup) {
		Engine engine = new Engine();
		engine.setSetup(setup);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}		
		engine.setState(ProductState.MANUFACTURED);
		System.out.println("--- engine manufactured ---");
		return engine;
	}	
}
