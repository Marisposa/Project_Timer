import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

//This is a simple timer.
public class WeckerModell extends JFrame
implements ActionListener
{
	private JLabel labeltimer1;
	private JLabel labeltimer2;
	private JLabel labelOutput;
	private JButton button;
	private JTextField textfield1;
	private JTextField textfield2;
	private Container contentPane;
	public WeckerModell()
	{
		super ("Timer");
		contentPane = this.getContentPane();
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout (new GridLayout(4,2));
		panel.setBorder(BorderFactory.createEmptyBorder(15,30,15,30));
		labeltimer1 = new JLabel ("Erste Timerzeit:");
		labeltimer1.setPreferredSize(new Dimension(100,26));
		panel.add(labeltimer1);
		textfield1 = new JTextField ();
		textfield1.setPreferredSize(new Dimension(100,26));
		panel.add(textfield1);
		labeltimer2 = new JLabel ("Zweite Timerzeit:");
		panel.add(labeltimer2);
		textfield2 = new JTextField();
		textfield2.setPreferredSize(new Dimension(100,26));
		panel.add(textfield2);
		button = new JButton ("Start");
		button.addActionListener(this);
		panel.add(button);
		labelOutput = new JLabel ("", SwingConstants.CENTER);
		labelOutput.setPreferredSize(new Dimension(100,26));
		labelOutput.setBorder(BorderFactory.createLoweredBevelBorder());
		panel.add(labelOutput);
		contentPane.add(BorderLayout.CENTER, panel);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if (evt.getSource().equals(button))
		{
			float counter1 = 0;
			float counter2 = 0;
			int timerTime1;
			int timerTime2;
			try
			{
			counter1 = Float.parseFloat(textfield1.getText().replace(',' , '.'));
			counter2 = Float.parseFloat(textfield2.getText().replace(',' , '.'));
			
			}
			catch (NumberFormatException e)
			{
				labelOutput.setText("Bitte eine Zahl eingeben.");
			}
			timerTime1 = (int)(counter1 * 60 * 1000);
			Timer timer = new Timer(timerTime1, this);
			timer.setRepeats(false);
			timer.start();
		}
		else
		{
			String counter1 = textfield1.getText();
			String counter2 = textfield2.getText();
			labelOutput.setText(counter1 + " min abgelaufen");
		} 
	};
	public static void main(String [] args)
	{
		new WeckerModell();
	}
}
