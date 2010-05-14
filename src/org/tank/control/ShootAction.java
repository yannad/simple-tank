package org.tank.control;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.tank.model.Bullet;
import org.tank.model.Tank;
import org.tank.view.ElementComponent;

@SuppressWarnings("serial")
public class ShootAction extends AbstractAction {

	private ElementComponent elementComponent;
	private Tank tank;

	public ShootAction(ElementComponent elementComponent, Tank tank) {
		super();
		this.elementComponent = elementComponent;
		this.tank = tank;
	}

	public void actionPerformed(ActionEvent e) {
		Bullet bullet = tank.shoot();
		System.out.println(bullet.getBox());
		elementComponent.getElements().add(bullet);
		Runnable runnable = new BulletRunnable(elementComponent, bullet);
		Thread thread = new Thread(runnable);
		thread.start();
	}

}
