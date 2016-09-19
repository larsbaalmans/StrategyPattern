package nl.dubehh.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import nl.dubehh.ITravelStrategy;
import nl.dubehh.Person;
import nl.dubehh.strategies.TravelBicycle;
import nl.dubehh.strategies.TravelCityBus;
import nl.dubehh.strategies.TravelTaxi;
import nl.dubehh.strategies.TravelTrain;

public class ComboBox extends JComboBox<Object> implements ActionListener{

	private Person _person;
	private ITravelStrategy[] _strategies;
	
	public ComboBox(Person p, int x, int y, int w, int h){
		this._strategies = new ITravelStrategy[]{ new TravelBicycle(), new TravelCityBus(), new TravelTaxi(), new TravelTrain()};
		this._person = p;
		setModel(new DefaultComboBoxModel<Object>(_strategies));
		setSelectedIndex(0);
		setBounds(x, y, w, h);
		addActionListener(this);
		setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e){
		JComboBox<Object> box = (JComboBox<Object>) e.getSource();
		this._person.setTravelStrategy((ITravelStrategy) box.getSelectedItem());
	}
}
