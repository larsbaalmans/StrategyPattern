package nl.dubehh.strategies;

import nl.dubehh.ITravelStrategy;

public class TravelTaxi implements ITravelStrategy{

	@Override
	public void travel() {
	}

	@Override
	public double getSpeed() {
		return 3;
	}
	
	@Override
	public String toString(){
		return "Taxi";
	}
}
