package trawnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Font;

public class GUI{

	public static JFrame frame;
	public static JLabel BitmapLabel;
	private JTextField TxtShape;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					
					
					//bitmap.draw_bitmap();
					Trawnik grass = new Trawnik();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1020, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(200, 0, 800, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		BitmapLabel = new JLabel("");
		BitmapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BitmapLabel.setForeground(Color.WHITE);
		BitmapLabel.setBounds(0, 0, 800, 400);
		panel.add(BitmapLabel);
		
		JLabel SetNameOfFileLabel = new JLabel("Wprowadz nazw\u0119 pliku:");
		SetNameOfFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		SetNameOfFileLabel.setBounds(10, 11, 180, 14);
		frame.getContentPane().add(SetNameOfFileLabel);
		
		TxtShape = new JTextField();
		TxtShape.setBackground(SystemColor.text);
		TxtShape.setText("trawnik.txt");
		TxtShape.setBounds(10, 36, 180, 20);
		frame.getContentPane().add(TxtShape);
		TxtShape.setColumns(10);
		
		JLabel CorrectShapeLabel = new JLabel("Kszta\u0142t wprowadzony pomy\u015Blnie");
		CorrectShapeLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CorrectShapeLabel.setBounds(10, 101, 180, 14);
		frame.getContentPane().add(CorrectShapeLabel);
		
		JButton GuiShapeButton = new JButton("Kszta\u0142t z GUI");
		GuiShapeButton.setBounds(10, 67, 180, 23);
		frame.getContentPane().add(GuiShapeButton);
		
		JRadioButton ReflectionRadioButton = new JRadioButton("Odbicia");
		ReflectionRadioButton.setBackground(SystemColor.activeCaption);
		ReflectionRadioButton.setForeground(Color.BLACK);
		ReflectionRadioButton.setSelected(true);
		ReflectionRadioButton.setBounds(10, 122, 109, 23);
		frame.getContentPane().add(ReflectionRadioButton);
		
		JLabel CycleTimeLabel = new JLabel("Wprowadz czas cyklu:");
		CycleTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CycleTimeLabel.setBounds(10, 148, 180, 14);
		frame.getContentPane().add(CycleTimeLabel);
		
		textField_1 = new JTextField();
		textField_1.setText("0.1");
		textField_1.setBounds(10, 170, 180, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton StartButton = new JButton("Start");
		StartButton.setBounds(10, 261, 180, 23);
		frame.getContentPane().add(StartButton);
		
		JButton StopButton = new JButton("Stop");
		StopButton.setBounds(10, 295, 180, 23);
		frame.getContentPane().add(StopButton);
		
		JButton ClearButton = new JButton("Wyczy\u015B\u0107");
		ClearButton.setBounds(10, 326, 180, 23);
		frame.getContentPane().add(ClearButton);
		
		JLabel EndLabel = new JLabel("Koniec!");
		EndLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EndLabel.setFont(new Font("Arial", Font.BOLD, 18));
		EndLabel.setForeground(SystemColor.text);
		EndLabel.setBounds(10, 374, 180, 14);
		frame.getContentPane().add(EndLabel);
		
		JLabel CycleTimeLabel_1 = new JLabel("Wprowadz iloœæ cykli:");
		CycleTimeLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CycleTimeLabel_1.setBounds(10, 196, 180, 14);
		frame.getContentPane().add(CycleTimeLabel_1);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setColumns(10);
		textField.setBounds(10, 218, 180, 20);
		frame.getContentPane().add(textField);
	}
}
