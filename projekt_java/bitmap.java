package trawnik;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class bitmap extends all_in {
	static private int r = 0;
	static private int g = 0;
	static private int b = 0;
	static private int data = 0;
	static int width = x_max * final_scale;
	static int height = y_max * final_scale;
	static double average = 0.0;
	static double sum = 0.0;
	static double counter = 0.0;
	
	//@@@
	static BufferedImage image = new BufferedImage(x_max * final_scale, y_max * final_scale,
			BufferedImage.TYPE_4BYTE_ABGR);
	//@@@
	
	
	public static void display(BufferedImage image) {

		GUI.BitmapLabel.setIcon(new ImageIcon(image));

	}

	public static void draw_bitmap() {
		for (int i = 0; i < width * height; i++) {
			if (final_array.get(i) != 0) {
				sum += final_array.get(i);
				counter++;
				
			}
		}
	average = sum/counter;
	average = Math.round(average);
	System.out.println("srednia" + average);
	System.out.println("ilosc " + counter);
	System.out.println("suma " + sum);

		
		for (int i = 0; i < y_max * final_scale; i++) {
			for (int j = 0; j < x_max * final_scale; j++) {
				data = final_array.get(i * x_max * final_scale + j);
				
				data -= average;
				if(data == (-average)) {
					r = 0;
					g = 0;
					b = 0;
				}else if (data < 0) {
					r = 0;
					g = (int) (255.0 - (Math.abs(data) / 10.0 * 255.0));
					b = 0;
				} else if (data == 0) {
					r = 0;
					g = 255;
					b = 0;

				} else if (data > 0 && data <= 20)  {
					r = (int) ((data / 20.0) * 255.0);
					g = (int) (255.0 - (data / 20.0 * 255.0));
					b = 0;
				} else {
					r = 0;
					g = 0;
					b = 255;
				}
				
				Color myColor = new Color(r, g, b);
				image.setRGB(j, i, myColor.getRGB());

				// Color.BLUE.getRGB()
			}

		}

		bitmap.display(image);

	}
	
	public static void clear_bitmap() {
		
		for (int i = 0; i < y_max * final_scale; i++) {
			for (int j = 0; j < x_max * final_scale; j++) {
		
				Color myColor = new Color(0, 0, 0);
				image.setRGB(j, i, myColor.getRGB());
				
			}

		}

		bitmap.display(image);

	}

	public static void main(String[] args) {
		// ...
	}

}
