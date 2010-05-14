package org.tank.control;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.tank.model.Direction;
import org.tank.model.Element;
import org.tank.model.Tank;
import org.tank.view.ElementComponent;

@SuppressWarnings("serial")
public class MoveAction extends AbstractAction {

	private ElementComponent elementComponent;
	private Tank tank;
	private Direction direction;

	public MoveAction(ElementComponent elementComponent, Tank tank,
			Direction direction) {
		super();
		this.elementComponent = elementComponent;
		this.tank = tank;
		this.direction = direction;
	}

	public void actionPerformed(ActionEvent e) {
		tank.setDirection(direction);
		elementComponent.repaint();
		Rectangle nextStep = tank.nextStep();
		if (!Element.MAP.contains(nextStep))
			return;
		for (Element elem : elementComponent.getElements()) {
			if (tank == elem)
				continue;
			if (nextStep.intersects(elem.getBox()))
				return;
		}
		tank.step();
		elementComponent.repaint();
	}

}
