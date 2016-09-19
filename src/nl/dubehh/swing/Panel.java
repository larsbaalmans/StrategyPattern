package nl.dubehh.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel{
	private BufferedImage image;
	private String ImageName;
	private int DISTANCE = 0;
	private Timer timer;
	private int speed = 1;
	
	public Panel(String ImageName) {
		super();
		this.ImageName = ImageName;
		try {
			image = ImageIO.read(getClass().getResource("/resources/" + ImageName + ".png"));
		} catch (IOException e) {
			
		}
	}
	
	public void Animate(){
		timer = new Timer();
		DISTANCE = 0;
		
		timer.scheduleAtFixedRate(new TimerTask() {
		  @Override
		  public void run() {
		    DISTANCE +=1;
		    if (DISTANCE >= 240) {
		    	timer.cancel();
		    }
		  }
		}, 1000, 20);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (ImageName == "House"){
		    g.drawImage(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH),0, 30, null);
	    } else if (ImageName == "Office") {
	    	g.drawImage(image.getScaledInstance(120, 120, Image.SCALE_SMOOTH),0, 15, null);
	    } else if (ImageName == "Bycicle"){
	    	g.drawImage(image.getScaledInstance(40, 40, Image.SCALE_SMOOTH),0 + DISTANCE, 60, null);
	    } else if (ImageName == "CityBus"){
	    	g.drawImage(image.getScaledInstance(80, 80, Image.SCALE_SMOOTH),0 + DISTANCE, 60, null);
	    } else if (ImageName == "Taxi"){
	    	g.drawImage(image.getScaledInstance(80, 80, Image.SCALE_SMOOTH),0 + DISTANCE, 60, null);
	    } else if (ImageName == "Train"){
	    	g.drawImage(image.getScaledInstance(80, 80, Image.SCALE_SMOOTH),0 + DISTANCE, 50, null);
	    }
	    repaint();
    }

}
