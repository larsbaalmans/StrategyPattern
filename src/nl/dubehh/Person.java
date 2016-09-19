package nl.dubehh;

public class Person{
	
	private ITravelStrategy _strategy;
	
	public void makeTravel(){
		_strategy.travel();
	}
	
	public void setTravelStrategy(ITravelStrategy strategy){
		this._strategy = strategy;
	}
	
	public ITravelStrategy getTravelStrategy(){
		return _strategy;
	}
}
