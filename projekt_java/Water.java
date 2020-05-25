
package trawnik;

import java.util.ArrayList;


public class Water extends all_in  {
    
    Water (){
    }
    
    
    
    void watering_point(int xc, int yc, int type, int rotation, ArrayList<Integer> final_array)
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
                                    final_array.add(y * x_max * final_scale + x,v);
                                    
                                }
                                    
					
			}
			else if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x <= xc || y >= yc)){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x <= xc || y <= yc)){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x >= xc || y <= yc)){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x >= xc || y >= yc)){
                                             int v = final_array.get(y * x_max * final_scale + x)+type_270_cycles;
                                             final_array.add(y * x_max * final_scale + x,v);
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
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && x <= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                            
                                        }
						
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_180_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
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
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc && x >= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc && x <= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc && x <= xc){
                                            int v = final_array.get(y * x_max * final_scale + x)+type_90_cycles;
                                            final_array.add(y * x_max * final_scale + x,v);
                                        }
						
				}
			}
		}
	}
}

public void read_data_from_water_array(ArrayList<Integer> final_array)
{
	int type;
	int rotation;

	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (water_array.get(y * x_max * final_scale + x).getType() != 0 &&
				water_array.get(y * x_max * final_scale + x).getRotation() != 0 && water_array.get(y * x_max * final_scale + x).getUse()
				== 1)
			{
				type = water_array.get(y * x_max * final_scale + x).getType();
				rotation = water_array.get(y * x_max * final_scale + x).getRotation();
				watering_point(x, y, type, rotation, final_array);
			}
		}
	}
}

public void read_data_from_water_array_circle(ArrayList<Integer> final_array)
{
	int type;
	int rotation;
	int use;

	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (water_array.get(y * x_max * final_scale + x).getType()!= 0 &&
				water_array.get(y * x_max * final_scale + x).getRotation() != 0 && water_array.get(y * x_max * final_scale + x).getUse()
				== 2)
			{
				type = water_array.get(y * x_max * final_scale + x).getType();
				rotation = water_array.get(y * x_max * final_scale + x).getRotation();
				watering_point(x, y, type, rotation, final_array);
			}
		}
