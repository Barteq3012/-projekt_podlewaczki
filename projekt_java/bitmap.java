package bitmap;


import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class bitmap {



	
	
	
	public static void display(BufferedImage image){

		   GUI.BitmapLabel.setIcon(new ImageIcon(image));
	   
	}
	
	public static void draw_circle()
	{
		//bitmap
		int x = 770;
		int y = 30;
		int r = 100;
		BufferedImage image = new BufferedImage(800, 400, BufferedImage.TYPE_4BYTE_ABGR);
		for(int i = 1; i < 400; i++)
		{
			for(int j = 1; j < 800; j++) 
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

