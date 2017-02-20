package rubugunday.assign3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayExitScreen {
	
	public void displayExitScreen(int score)
	{
	JFrame frame = new JFrame();
	JPanel pane = new JPanel(new BorderLayout());
	
	JLabel label = new JLabel("End of Quiz",JLabel.CENTER);
	label.setFont(label.getFont().deriveFont(45.0f));
	pane.add(label,BorderLayout.CENTER);
	
	JLabel scoreLabel = new JLabel("Your score is: "+ score);
	scoreLabel.setFont(scoreLabel.getFont().deriveFont(50.0f));
	scoreLabel.setForeground(Color.GREEN);
	pane.add(scoreLabel, BorderLayout.AFTER_LAST_LINE);
	//JPanel panel = new JPanel(new FlowLayout());
	//panel.setOpaque(false);
	JButton button1 = new JButton("Click to close.");
	button1.addActionListener(new ActionListener()
		{	

		@Override
		public void actionPerformed(ActionEvent ae) {
			//System.out.println("Button clicked");
			frame.dispose();
			System.exit(0);
			
				
		}	
	});
	
	
	pane.add(button1);
	//frame.add(panel);
	//pane.add(panel, BorderLayout.SOUTH);
	frame.add(pane);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	frame.pack();
	frame.setVisible(true);
	}
}
