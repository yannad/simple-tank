package org.tank.view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import org.tank.control.MoveAction;
import org.tank.control.ShootAction;
import org.tank.model.Bullet;
import org.tank.model.Direction;
import org.tank.model.Element;
import org.tank.model.Tank;
import org.tank.model.Wall;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public final int WIDTH = 500, HEIGHT = 400;
	public final String TITLE = "Tank";

	private ArrayList<Element> elements;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = null;
				try {
					frame = new GameFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	public GameFrame() throws IOException {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		elements = new ArrayList<Element>();
		ElementComponent elementComponent = new ElementComponent(elements);
		add(elementComponent);
		// add some unit
		Bullet bullet = new Bullet(new Rectangle(0, 0, 2, 2), ImageIO.read(new File("bullet.gif")), 5, 1, null);
		Tank hero = new Tank(new Rectangle(240, 340, 16, 16), ImageIO.read(new File("tank_up.gif")), 5, 5, 2, Direction.UP, bullet);
		elements.add(hero);
		int i=20;
		while(--i>0){
		Wall wall=new Wall(new Rectangle(new Random().nextInt(460), new Random().nextInt(300), 16, 16), ImageIO.read(new File("wall.gif")), new Random().nextInt(5), new Random().nextInt(10));
		elements.add(wall);
		}
		// add some action
		InputMap imap = elementComponent.getInputMap(JComponent.WHEN_FOCUSED);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "tank.up");
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "tank.down");
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "tank.left");
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "tank.right");
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "tank.shoot");
		ActionMap amap = elementComponent.getActionMap();
		amap.put("tank.up", new MoveAction(elementComponent, hero, Direction.UP));
		amap.put("tank.down", new MoveAction(elementComponent, hero, Direction.DOWN));
		amap.put("tank.left", new MoveAction(elementComponent, hero, Direction.LEFT));
		amap.put("tank.right", new MoveAction(elementComponent, hero, Direction.RIGHT));
		amap.put("tank.shoot", new ShootAction(elementComponent, hero));
		
	}

}
