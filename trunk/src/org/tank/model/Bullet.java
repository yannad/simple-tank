package org.tank.model;

import java.awt.Image;
import java.awt.Rectangle;

public class Bullet extends Element {

	private final int attack;
	private final Direction direction;
	private final int movement;

	public Bullet(Rectangle box, Image image, int attack, int movement,
			Direction direction) {
		super(box, image);
		this.attack = attack;
		this.movement = movement;
		this.direction = direction;
	}

	public int getAttack() {
		return attack;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getMovement() {
		return movement;
	}

	public Rectangle nextStep() {
		Rectangle next = new Rectangle(getBox());
		switch (direction) {
		case UP:
			next.y -= movement;
			break;
		case DOWN:
			next.y += movement;
			break;
		case LEFT:
			next.x -= movement;
			break;
		case RIGHT:
			next.x += movement;
			break;
		}
		return next;
	}

	public void step() {
		setBox(nextStep());
	}
}
