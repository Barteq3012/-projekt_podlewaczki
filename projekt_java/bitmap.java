package bitmap;


import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class bitmap {

	static int x_max = 800;
	static int y_max = 400;
	
	
	
	
	public static void display(BufferedImage image){

		   GUI.BitmapLabel.setIcon(new ImageIcon(image));
	   
	}
	
	public static void draw_circle()
	{
		//bitmap
		int x = 770;
		int y = 30;
		int r = 100;
		BufferedImage image = new BufferedImage(x_max, y_max, BufferedImage.TYPE_4BYTE_ABGR);
		for(int i = 1; i < y_max; i++)
		{
			for(int j = 1; j < x_max; j++) 
			{
				if((Math.pow(x - j, 2) + Math.pow(y - i, 2)) <= Math.pow(r,  2))
				{
					image.setRGB(j, i, Color.BLUE.getRGB());
				}
				
			}
			
		}
	
		bitmap.display(image);

	}
	public static void main(String[] args)
	{
		//...
	}
	
}

