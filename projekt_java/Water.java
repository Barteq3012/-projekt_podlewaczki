package trawnik;

import java.util.ArrayList;
import java.util.List;

public class Water extends all_in  {    



    
    void watering_point(int xc, int yc, int type, int rotation)
{
	int radius = 0;
	
      
	for (int y = Math.max(yc - type_max_range * final_scale, 0); y < Math.min(yc + type_max_range * final_scale + 1,
	                                                                y_max * final_scale); y++)
	{
		for (int x = Math.max(xc - type_max_range * final_scale, 0); x < Math.min(xc + type_max_range * final_scale + 1,
		                                                                x_max * final_scale); x++)
		{
			if (type == 360)
			{
				radius = final_scale * type_360_range;
				if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2)){
                                   int v = final_array.get(y * x_max * final_scale + x)+type_360_cycles;
                                    final_array.set(y * x_max * final_scale + x, v);
                                    
                                }
                                    
					
			}
			else if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x <= xc || y >= yc)){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x <= xc || y <= yc)){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x >= xc || y <= yc)){
                                           int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x >= xc || y >= yc)){
                                             int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                             final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
			}
			else if (type == 180)
			{
				radius = final_scale * type_180_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && x >= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && x <= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                            
                                        }
						
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
			}
			else if (type == 90)
			{
				radius = final_scale * type_90_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc && x >= xc){
                                           int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc && x >= xc){
                                           int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc && x <= xc){
                                           int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc && x <= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.set(y * x_max * final_scale + x, v);
                                        }
						
				}
			}
		}
	}
}

void read_data_from_water_array()
{
	

	for (int i = 0; i < water_array.size(); i++)
	{
		
			if ( water_array.get(i).getUse()== 1)
			{
				
				watering_point(water_array.get(i).getX(), water_array.get(i).getY(), water_array.get(i).getType(), water_array.get(i).getRotation());
			}
		
	}

}

public void read_data_from_water_array_circle()
{

	for (int i = 0; i < water_array.size(); i++)
	{
		
			if ( water_array.get(i).getUse()== 2)
			{
				
				watering_point(water_array.get(i).getX(), water_array.get(i).getY(), water_array.get(i).getType(), water_array.get(i).getRotation());
			}
		

	}
}
}
