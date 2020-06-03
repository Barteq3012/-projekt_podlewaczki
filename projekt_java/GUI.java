package trawnik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {

	public static JFrame frame;
	public static JLabel BitmapLabel;
	private JTextField textField_1;
	private JTextField textField;
	private int is_end = 0; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);

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
		CorrectShapeLabel.setBounds(10, 11, 180, 14);
		frame.getContentPane().add(CorrectShapeLabel);

		JRadioButton ReflectionRadioButton = new JRadioButton("Odbicia");
		ReflectionRadioButton.setBackground(SystemColor.activeCaption);
		ReflectionRadioButton.setForeground(Color.BLACK);
		ReflectionRadioButton.setSelected(false);
		ReflectionRadioButton.setBounds(6, 111, 109, 23);
		frame.getContentPane().add(ReflectionRadioButton);

		JLabel CycleTimeLabel = new JLabel("Wprowadz czas cyklu(ms):");
		CycleTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CycleTimeLabel.setBounds(10, 148, 180, 14);
		frame.getContentPane().add(CycleTimeLabel);

		textField_1 = new JTextField();
		textField_1.setText("100");
		textField_1.setBounds(10, 170, 180, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton ClearButton = new JButton("Wyczy\u015B\u0107");
		ClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Bitmap.clear_bitmap();
				All_in.final_array.clear();
				All_in.water_array.clear();
				Bitmap.average = 0.0;
				Bitmap.sum = 0.0;
				Bitmap.counter = 0.0;
				is_end = 0;
				
			}
		});
		ClearButton.setBounds(10, 304, 180, 32);
		frame.getContentPane().add(ClearButton);

		JLabel EndLabel = new JLabel("Koniec!");
		EndLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EndLabel.setFont(new Font("Arial", Font.BOLD, 18));
		EndLabel.setForeground(SystemColor.text);
		EndLabel.setBounds(10, 374, 180, 14);
		frame.getContentPane().add(EndLabel);
		EndLabel.setVisible(false);
		
		JLabel saveLabel = new JLabel("Zapisano wsp\u00F3\u0142rz\u0119dne");
		saveLabel.setBounds(10, 349, 180, 14);
		frame.getContentPane().add(saveLabel);
		saveLabel.setVisible(false);

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

				JFileChooser chooseFile = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
				chooseFile.setAcceptAllFileFilterUsed(false);
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
		shapeButton.setBounds(10, 36, 180, 23);
		frame.getContentPane().add(shapeButton);

		JButton StartButton = new JButton("Start");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				All_in.cycles = Integer.parseInt(textField.getText());
				All_in.time = Integer.parseInt(textField_1.getText());

				if (ReflectionRadioButton.isSelected()) {
					All_in.reflection = 1;
				} else {
					All_in.reflection = 0;
				}

				if (Trawnik.filename != null) {
					Thread myThread = new Thread(() -> {
						for (int i = 0; i < All_in.cycles; i++) {
							try {
								Trawnik grass = new Trawnik();
								is_end++;
								if (is_end == All_in.cycles) {
									EndLabel.setVisible(true);
									saveLabel.setVisible(true);
								}else {
									EndLabel.setVisible(false);
									saveLabel.setVisible(false);
								}
							} catch (FileNotFoundException e2) {
								e2.printStackTrace();
							}
							try {
								Thread.sleep(All_in.time);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}

					});

					myThread.start();
					

				} else {
					CorrectShapeLabel.setForeground(Color.RED);
					CorrectShapeLabel.setText("Najpierw wprowadz plik!");
				}

			}
		});
		StartButton.setBounds(10, 261, 180, 32);
		frame.getContentPane().add(StartButton);

		JButton SaveButton = new JButton("Zapisz bitmap\u0119");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
			    File outputfile = new File("saved_bitmap.png");
			    try {
					ImageIO.write(Bitmap.image, "png", outputfile);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		SaveButton.setBounds(10, 70, 180, 23);
		frame.getContentPane().add(SaveButton);
		
		
	}
}
