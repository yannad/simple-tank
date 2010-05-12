package org.tank.model;

import java.awt.Image;
import java.awt.Rectangle;

public class Unit extends Element {
	private int defense;
	private int duration;

	public Unit(Rectangle box, Image image, int defense, int duration) {
		super(box, image);
		this.defense = defense;
		this.duration = duration;
	}

	public void attack(Bullet bullet) {
		if (bullet.getAttack() > this.defense) {
			duration -= bullet.getAttack() - defense;
		}
	}

	public int getDefense() {
		return defense;
	}

	public int getDuration() {
		return duration;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
