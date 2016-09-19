package nl.dubehh.swing;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;

import nl.dubehh.Person;
import nl.dubehh.strategies.TravelBicycle;

public class Frame extends JFrame implements ActionListener{
	
	private final String TITLE = "Snelheidsmeter";
	private final int WIDTH = 600;
	private final int HEIGHT= 300;
	private Image image;
	private int distance = 0;
	Panel panelCenter;
	JButton button;
	
	private Person _person;
	
	public Frame(Person p){
		this._person = p;
		
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		add(new ComboBox(p, 0, 0, 100, 25));
		
		button = new JButton("Maak Trip!");
		button.addActionListener(this);
		button.setBounds(105, 0, 100, 25);
		add(button);
		
		Panel panelLeft = new Panel("House");
		panelLeft.setBounds(10, 85, 120, 130);
		add(panelLeft);
		
		Panel panelRight = new Panel("Office");
		panelRight.setBounds(WIDTH-150, 85, 130, 130);
		add(panelRight);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(_person.getTravelStrategy() == null) _person.setTravelStrategy(new TravelBicycle());
		
		distance = 0;
		
		button.setEnabled(false);
		
		System.out.println(_person.getTravelStrategy().toString());
		
		Panel panelCenter = new Panel(_person.getTravelStrategy().toString());
		panelCenter.setBounds(130+distance, 85, 100, 130);
		add(panelCenter);
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
				panelCenter.setBounds(130+distance, 85, 80, 130);
				distance += _person.getTravelStrategy().getSpeed();
				if (distance >= 230){
					remove(panelCenter);
					button.setEnabled(true);
					timer.cancel();
				} else {
					repaint();	
				}
			}
		}, 1000, 20);
	}
}
