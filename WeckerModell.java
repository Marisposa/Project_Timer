import javax.swing.Timer;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class WeckerModell extends JFrame
implements ActionListener
{
	private JLabel labeltimer1;
	private JLabel labeltimer2;
	private JLabel labelAusgabe;
	private JButton button;
	private JTextField textfeld1;
	private JTextField textfeld2;
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
		textfeld1 = new JTextField ();
		textfeld1.setPreferredSize(new Dimension(100,26));
		panel.add(textfeld1);
		labeltimer2 = new JLabel ("Zweite Timerzeit:");
		panel.add(labeltimer2);
		textfeld2 = new JTextField();
		textfeld2.setPreferredSize(new Dimension(100,26));
		panel.add(textfeld2);
		button = new JButton ("Start");
		button.addActionListener(this);
		panel.add(button);
		labelAusgabe = new JLabel ("", SwingConstants.CENTER);
		labelAusgabe.setPreferredSize(new Dimension(100,26));
		labelAusgabe.setBorder(BorderFactory.createLoweredBevelBorder());
		panel.add(labelAusgabe);
		contentPane.add(BorderLayout.CENTER, panel);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) 
	{
		if (evt.getSource().equals(button))
		{
			float zaehler1 = 0;
			float zaehler2 = 0;
			int timerzeit1;
			int timerzeit2;
			try
			{
			zaehler1 = Float.parseFloat(textfeld1.getText().replace(',' , '.'));
			zaehler2 = Float.parseFloat(textfeld2.getText().replace(',' , '.'));
			
			}
			catch (NumberFormatException e)
			{
				labelAusgabe.setText("Bitte eine Zahl eingeben.");
			}
			timerzeit1 = (int)(zaehler1 * 60 * 1000);
			Timer timer = new Timer(timerzeit1, this);
			timer.setRepeats(false);
			timer.start();
		}
		else
		{
			String zaehler1 = textfeld1.getText();
			String zaheler2 = textfeld2.getText();
			labelAusgabe.setText(zaehler1 + " min abgelaufen");
		} 
	};
	public static void main(String [] args)
	{
		new WeckerModell();
	}
}
