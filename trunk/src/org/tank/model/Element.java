package org.tank.model;

import java.awt.Image;
import java.awt.Rectangle;

public class Element {

	public static final int MOVEMENT = 5;
	public static final int MAP_WIDTH = 480;
	public static final int MAP_HEIGHT = 360;
	public static final Rectangle MAP = new Rectangle(MAP_WIDTH, MAP_HEIGHT);

	private Rectangle box;
	private Image image;

	public Element(Rectangle box, Image image) {
		super();
		this.box = box;
		this.image = image;
	}

	public Rectangle getBox() {
		return box;
	}

	public Image getImage() {
		return image;
	}

	public void setBox(Rectangle box) {
		this.box = box;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
