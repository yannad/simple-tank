package org.tank.control;

import java.awt.Rectangle;

import org.tank.model.Bullet;
import org.tank.model.Element;
import org.tank.model.Unit;
import org.tank.view.ElementComponent;

public class BulletRunnable implements Runnable {

	private ElementComponent elementComponent;
	private Bullet bullet;

	public BulletRunnable(ElementComponent elementComponent, Bullet bullet) {
		super();
		this.elementComponent = elementComponent;
		this.bullet = bullet;
	}

	public void run() {
		while (true) {
			Rectangle nextStep = bullet.nextStep();
			if (!Element.MAP.contains(nextStep)) {
				elementComponent.getElements().remove(bullet);
				elementComponent.repaint();
				return;
			}
			for (Element e : elementComponent.getElements()) {
				if (e == bullet)
					continue;
				if (e.getBox().intersects(nextStep)) {
					if (!(e instanceof Unit))
						continue;
					Unit unit = (Unit) e;
					unit.attack(bullet);
					elementComponent.getElements().remove(bullet);
					if (unit.getDuration() <= 0) {
						elementComponent.getElements().remove(unit);
					}
					elementComponent.repaint();
					return;
				}
			}
			bullet.step();
			elementComponent.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}
