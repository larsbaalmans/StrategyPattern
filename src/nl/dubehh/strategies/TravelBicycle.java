package nl.dubehh.strategies;

import java.util.Timer;
import java.util.TimerTask;

import nl.dubehh.ITravelStrategy;

public class TravelBicycle implements ITravelStrategy {

	@Override
	public void travel() {
		
	}

	@Override
	public double getSpeed() {
		return 1;
	}
	
	@Override
	public String toString(){
		return "Bycicle";
	}

}
