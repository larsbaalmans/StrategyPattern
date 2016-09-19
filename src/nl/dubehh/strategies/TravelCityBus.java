package nl.dubehh.strategies;

import nl.dubehh.ITravelStrategy;

public class TravelCityBus implements ITravelStrategy{

	@Override
	public void travel() {
	}

	@Override
	public double getSpeed() {
		return 5;
	}
	
	@Override
	public String toString(){
		return "CityBus";
	}

}
