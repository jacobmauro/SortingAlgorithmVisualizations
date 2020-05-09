import java.awt.Color;

import javax.swing.JComponent;

public class Rectangle extends JComponent {

	private int value;
	private int width;
	private int height;
	private Color color;
	private Color originalColor;
	
	public Rectangle(int value, int width, int height, Color color) {
		this.value = value;
		this.height = height;
		this.width = width;
		this.color = color;
		this.originalColor = color;
	}
	
	public void highlight() {
		this.color = new Color(52, 235, 122);
	}
	
	public void unhighlight() {
////		this.color = new Color(235, 52 + (int)(1.83 * value), 52);
//		this.color = new Color(66, 245 - (int)(1.79 * value), 245);
		this.color = this.originalColor;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
