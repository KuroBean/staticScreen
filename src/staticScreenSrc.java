import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staticScreenSrc extends JPanel {
	Timer timer;

	public void paintComponent(Graphics g) {
		// Rectangle bounds=g.getClipBounds();
		super.paintComponent(g);
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				int col = (int) (Math.round(Math.random() * 100) % 50);
				if (Math.random() > 0.5) {
					col = 255 - col;
				}
				g.setColor(new Color(col, col, col));
				g.fillRect(x, y, 1, 1);
			}
		}
	}

	public static void main(String[] args) {

		final int INTERVAL = 1000;

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
