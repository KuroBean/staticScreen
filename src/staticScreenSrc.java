import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staticScreenSrc extends JPanel {
	Timer timer;
	int sandSize=1;//2 or 1 best
	int greyness=50;//after 100, chooses value within 100 above 0 and below 255
	public void paintComponent(Graphics g) {
		// Rectangle bounds=g.getClipBounds();
		super.paintComponent(g);
		for (int x = 0; x < getWidth(); x=x+sandSize) {
			for (int y = 0; y < getHeight(); y=y+sandSize) {
				int col = (int) (Math.round(Math.random() * 100) % greyness);
				//System.out.println(col);
				//WARNING PRINTING LIMITS REFRESH RATE
				if (Math.random() > 0.5) {
					col = 255 - col;
				}
				
				
				g.setColor(new Color(col, col, col));
				g.fillRect(x, y, sandSize,sandSize);
			}
		}
	}

	public static void main(String[] args) {

		final int INTERVAL = 17;//msec 17 for 60 fps

		var panel = new staticScreenSrc();

		// panel.setBackground(Color.GREEN.darker());
		var frame = new JFrame("A simple graphics program");
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		Timer timer = new Timer(INTERVAL, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Refresh the panel
				panel.revalidate();
				panel.repaint();
			}
		});

		timer.start();

	}

}
