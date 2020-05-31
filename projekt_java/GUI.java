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
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI{

	public static JFrame frame;
	public static JLabel BitmapLabel;
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
					//Trawnik grass = new Trawnik();
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
		
		JLabel CorrectShapeLabel = new JLabel("Wprowadz kszta³t trawnika");
		CorrectShapeLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CorrectShapeLabel.setBounds(10, 101, 180, 14);
		frame.getContentPane().add(CorrectShapeLabel);
		
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
		
		JButton StopButton = new JButton("Stop");
		StopButton.setBounds(10, 295, 180, 23);
		frame.getContentPane().add(StopButton);
		
		JButton ClearButton = new JButton("Wyczy\u015B\u0107");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				bitmap.clear_bitmap();
				all_in.final_array.clear();
				all_in.water_array.clear();
				bitmap.average = 0.0;
				bitmap.sum = 0.0;
				bitmap.counter = 0.0;
				}
			});
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
		
		JButton shapeButton = new JButton("Kszta³t z pliku");
		shapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				System.out.println("xd");
				
				 System.out.println("Open");
			        //openSuccess.setText("  ");
			        JFileChooser chooseFile = new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt"); //dodajesz tutaj rozszrzezenie ktore chcesz by wyszukiwal
			        chooseFile.setAcceptAllFileFilterUsed(false); //wylacz by byly wsystkie pliki widoczne
			        chooseFile.setFileFilter(filter);
			        int result = chooseFile.showOpenDialog(frame);
			        if (result == JFileChooser.APPROVE_OPTION) {
			
			        	File file = chooseFile.getSelectedFile();
			            Trawnik.filename = file.getAbsolutePath();
			          
			        }

			  
			       else if (result == JFileChooser.CANCEL_OPTION) {
			            System.out.println("Cancel was selected");
			        }

			}                                      
				
		
		});
		shapeButton.setBounds(10, 33, 180, 23);
		frame.getContentPane().add(shapeButton);
		
		JButton StartButton = new JButton("Start");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				try {
					if(Trawnik.filename != null) {
					Trawnik grass = new Trawnik();
					}
					else {
						CorrectShapeLabel.setForeground(Color.RED);
						CorrectShapeLabel.setText("Najpierw wprowadz plik!");
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				}
			});
		StartButton.setBounds(10, 261, 180, 23);
		frame.getContentPane().add(StartButton);
		
		JButton SaveButton = new JButton("Zapisz bitmap\u0119");
		SaveButton.setBounds(10, 67, 180, 23);
		frame.getContentPane().add(SaveButton);
	}
}
