package org.tank.model;

import java.awt.Image;
import java.awt.Rectangle;

public class Tank extends Unit {

	private Bullet bullet;
	private Direction direction;
	private int movement;

	public Tank(Rectangle box, Image image, int defense, int duration,
			int movement, Direction direction, Bullet bullet) {
		super(box, image, defense, duration);
		this.movement = movement;
		this.direction = direction;
		this.bullet = bullet;
	}

	public Bullet getBullet() {
		return bullet;
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

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public Bullet shoot() {
		Rectangle newBox = bullet.getBox();
		newBox.x = (int) getBox().getCenterX() - newBox.width / 2;
		newBox.y = (int) getBox().getCenterY() - newBox.height / 2;
		Bullet newBullet = new Bullet(newBox, bullet.getImage(), bullet
				.getAttack(), bullet.getMovement(), direction);
		return newBullet;
	}

	public void step() {
		setBox(nextStep());
	}

	public void upgrade(Bonus bonus) {
		Tank obj = bonus.getTank();
		setMovement(obj.getMovement());
		setDefense(obj.getDefense());
		setDuration(obj.getDuration());
		setBullet(bonus.getBullet());
	}

}
