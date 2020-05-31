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



	
	public static void display(BufferedImage image){

		   GUI.BitmapLabel.setIcon(new ImageIcon(image));
	   
	}
	
	public static void draw_bitmap()
	{
		/*for(int x = 0; x < 100000; x++) {
			if(final_array.get(x) > 30) {
			System.out.println(final_array.get(x));
			System.out.println(x);
			}
		}*/
		
		BufferedImage image = new BufferedImage(x_max * final_scale, y_max * final_scale, BufferedImage.TYPE_4BYTE_ABGR);
		for(int i = 0; i < y_max * final_scale; i++)
		{
			for(int j = 0; j < x_max * final_scale; j++) 
			{
				data = final_array.get(i * x_max * final_scale + j);
				
				if(data == 0) {
					r = 0;
					g = 0;
					b = 0;
				}
				else if(data <= 10)
				{
					r = 0;
					g = (int)(data / 10.0 * 255.0);
					
				}
				else if (data <= 20)
				{
					r = (int)((data / 10.0) * 255.0 - 255.0);
					g = (int)(255.0 - (data / 10.0 * 255.0) + 255.0);
					b = 0;
				}
				else
				{	
					r = 0;
					g = 0;
					b = 255;
				}
				Color myColor = new Color(r, g, b);
				image.setRGB(j, i, myColor.getRGB());
				
				//Color.BLUE.getRGB()
			}
			
		}
	
		bitmap.display(image);
		
	}
	public static void main(String[] args)
	{
		//...
	}
	
}

