import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class BubbleSort extends JComponent {

	private Rectangle[] nums;
	
	private final int DEFAULT_WIDTH = 25;
	private final int HEIGHT_MULTIPLIER = 10;
	
	JFrame frame;
	
	//constructor
	public BubbleSort(int size) {
		this.nums = new Rectangle[size];
		randomizeArray();
		
		this.frame = new JFrame("Insetion sort");
		this.frame.setSize(size*(DEFAULT_WIDTH+3), 99*HEIGHT_MULTIPLIER+75); //99 is highest random value
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.add(this);
	}
	
	//randomize integers in array
	public void randomizeArray() {
		Random rand = new Random();
		for(int i = 0; i < nums.length; i++) {
			int randValue = rand.nextInt(99)+1;
			this.nums[i] = new Rectangle(randValue, DEFAULT_WIDTH, randValue*HEIGHT_MULTIPLIER, new Color(66, 245 - (int)(1.79 * randValue), 245));
		}
	}
	
	//overridden toString used to print
	public String toString() {
		String numsString = "";
		for(int i = 0; i < nums.length; i++) {
			if(i == nums.length - 1) {
				numsString = numsString + nums[i].getValue();
			}else {
				numsString = numsString + nums[i].getValue() + ", ";
			}
		}
		return numsString;
	}
	
	//implementation of bubble sort
	Rectangle currentRect;
	public void bubbleSort() {
		int numsLength = nums.length;
		for (int i = 0; i < numsLength-1; i++) {
            for (int j = 0; j < numsLength-i-1; j++) {
            	wait(50);
                if (nums[j].getValue() > nums[j+1].getValue()) 
                { 
                    Rectangle temp = nums[j];
                    Rectangle temp2 = nums[j + 1];
                    
                    temp.highlight();
                    temp2.highlight();
                    this.repaint();
                    wait(50);
                    
                    nums[j] = temp2; 
                    nums[j+1] = temp; 
                    
                    temp.unhighlight();
                    temp2.unhighlight();
                    this.repaint();
                } 
            }
		}
	}
	
	//used to pause time
	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		}catch(Exception e) {
			System.out.println("Error in wait");
		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		int x = 2;
		for(int i = 0; i < nums.length; i++) {
			g2.setColor(Color.BLACK);
			g2.drawRect(x, 0, nums[i].getWidth(), nums[i].getHeight());
			g2.setColor(nums[i].getColor());
			g2.fillRect(x, 0, nums[i].getWidth(), nums[i].getHeight());
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("default", Font.BOLD, 15));
			g2.drawString(nums[i].getValue()+"", x+5, nums[i].getHeight()+15);
			x += 27;
		}
	}
	
	//driver
	public static void main(String[] args) {
		BubbleSort bs1 = new BubbleSort(20);
		System.out.println("Before sorting: " + bs1.toString());
		bs1.bubbleSort();
		System.out.println("After sorting: " + bs1.toString());
	}
	
}