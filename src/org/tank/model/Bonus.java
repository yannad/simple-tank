package org.tank.model;

import java.awt.Image;
import java.awt.Rectangle;

public class Bonus extends Element {

	private final Bullet bullet;
	private final Tank tank;

	public Bonus(Rectangle box, Image image, Tank tank, Bullet bullet) {
		super(box, image);
		this.tank = tank;
		this.bullet = bullet;
	}

	public Bullet getBullet() {
		return bullet;
	}

	public Tank getTank() {
		return tank;
	}

}
