package org.tank.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tank extends Unit {

	private Bullet bullet;
	private Direction direction;
	private int movement;
	private Image img_up,img_down,img_left,img_right;

	public Tank(Rectangle box, Image image, int defense, int duration,
			int movement, Direction direction, Bullet bullet) {
		super(box, image, defense, duration);
		this.movement = movement;
		this.direction = direction;
		this.bullet = bullet;
		try {
			img_up=ImageIO.read(new File("tank_up.gif"));
			img_down=ImageIO.read(new File("tank_down.gif"));
			img_left=ImageIO.read(new File("tank_left.gif"));
			img_right=ImageIO.read(new File("tank_right.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		switch(direction){
		case UP:
			setImage(img_up);
			break;
		case DOWN:
			setImage(img_down);
			break;
		case LEFT:
			setImage(img_left);
			break;
		case RIGHT:
			setImage(img_right);
			break;
		}
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public Bullet shoot() {
		Rectangle newBox = bullet.getBox();
		newBox.x = (int) getBox().getCenterX() - newBox.width / 2;
		newBox.y = (int) getBox().getCenterY() - newBox.height / 2;
		int dx = 0, dy = 0;
		switch (direction) {
		case UP:
			dy = newBox.height + getBox().height / 2;
			dy = -dy;
			break;
		case DOWN:
			dy = newBox.height + getBox().height / 2;
			break;
		case LEFT:
			dx = newBox.width + getBox().width / 2;
			dx = -dx;
			break;
		case RIGHT:
			dx = newBox.width + getBox().width / 2;
			break;
		}
		newBox.x += dx;
		newBox.y += dy;
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
