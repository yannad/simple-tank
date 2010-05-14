package org.tank.view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import org.tank.model.Element;

@SuppressWarnings("serial")
public class ElementComponent extends JComponent {

	private ArrayList<Element> elements;

	public ElementComponent(){
		
	}
	
	public ElementComponent(ArrayList<Element> elements) {
		super();
		this.elements = elements;
	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}

	@Override
	public void paintComponent(Graphics arg0) {
		for (Element e : elements) {
			arg0.drawImage(e.getImage(), e.getBox().x, e.getBox().y, null);
		}
	}

}
