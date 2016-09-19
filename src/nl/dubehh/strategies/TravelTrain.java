package nl.dubehh.strategies;

import nl.dubehh.ITravelStrategy;

public class TravelTrain implements ITravelStrategy{

	@Override
	public void travel() {
		
	}

	@Override
	public double getSpeed() {
		return 10;
	}
	
	@Override
	public String toString(){
		return "Train";
	}

}
