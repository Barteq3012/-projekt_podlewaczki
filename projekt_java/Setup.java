package trawnik;

import java.util.ArrayList;

public class Setup extends All_in {

private int watering_condition(int circle_x, int circle_y, int type, int rotation, ArrayList<Character> grass_array)
{
	int xc = circle_x; 
	int yc = circle_y; 
	int radius = 0;
	for (int y = yc - type_max_range * final_scale; y < yc + type_max_range * final_scale + 1; y++)
	{
		for (int x = xc - type_max_range * final_scale; x < xc + type_max_range * final_scale + 1; x++)
		{
			if (type == 360)
			{
				radius = final_scale * type_360_range;
				if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2))
					if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
						return 1;
			}
			else if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x <= xc || y >= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x <= xc || y <= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x >= xc || y <= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && (x >= xc || y >= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
			}
			else if (type == 180)
			{
				radius = final_scale * type_180_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && x >= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && x <= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
			}
			else if (type == 90)
			{
				radius = final_scale * type_90_range;
				if (rotation == 1)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc && x >= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 2)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc && x >= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 3)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y >= yc && x <= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
				else if (rotation == 4)
				{
					if (Math.pow(xc - x, 2) + Math.pow(yc - y, 2) <= Math.pow(radius, 2) && y <= yc && x <= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
							return 1;
				}
			}
		}
	}

	return 0;
}


private int circle_condition(int circle_x, int circle_y, ArrayList<Character> grass_array, int bonus)
{
	int cx = circle_x * final_scale;
	int cy = circle_y * final_scale;
	if(bonus==1)
	return 0;
	for (int y = Math.max(cy - type_360_range * final_scale, 0); y < Math.min(cy + type_360_range * final_scale + 1,
	                                                                y_max * final_scale); y++)
	{
		for (int x = Math.max(cx - type_360_range * final_scale, 0); x < Math.min(cx + type_360_range * final_scale + 1,
		                                                                x_max * final_scale); x++)
		{
			if (Math.pow(cx - x, 2) + Math.pow(cy - y, 2) <= Math.pow(type_360_range * final_scale, 2))
			{
				if (grass_array.get((y / final_scale) * x_max + (x / final_scale)) == '-')
					return 1;
			}
		}
	}

	return 0;
}

public void circle_version(ArrayList<Character> grass_array, int bonus)
{
	int n=0;
	    
	for (int x = 0; x < x_max; x += 2)
	{
		for (int y = 0; y < y_max; y += 2)
		{ 
			if (grass_array.get(y * x_max + x) == '*')
			{
					for(int i=0; i<water_array.size(); i++)
					if(water_array.get(i).getX()==x*final_scale && water_array.get(i).getY()==y*final_scale)
						n++;
					if(n==0){
				if (circle_condition(x, y, grass_array, bonus) == 0){

					int other=0;
					int all=0;
					int r=2;
						for(int i = 0; i < y_max; i++)
						{
						for(int j = 0; j < x_max; j++){
       	
     
    							if ((j - x) * (j - x) +(i - y) * (i - y) <= r * r){
								all++;
								if(grass_array.get(i * x_max + j)=='-')
									other++;
		
									}
		     
		                                   }}			double extra;
									if(other!=0)
		 								extra=(all/other)*0.2;
											else extra=0;
                                    Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, y * final_scale, 360, 1, 2,extra);
                                    water_array.add(new_sprinkler);
                                
                                		}
									     }
					
			}
						n=0;
		}
	}
}


public void setup_algorytm(ArrayList<Character> grass_array)
{
	for (int y = 0; y < y_max; y++)
	{
		for (int x = 0; x < x_max; x++)
		{
			// setting positions of 90 type
			int x_rel = x - 1;
			int y_rel = y + 1;

			if ((x_rel < 0 || grass_array.get(y * x_max + x_rel) == '-') &&
				(y_rel >= y_max || grass_array.get(y_rel * x_max + x) == '-') &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, (y + 1) * final_scale - 1, 90, 1, grass_array) == 0){
                                        
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, (y + 1) * final_scale - 1, 90, 1, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}

			y_rel -= 2;

			if ((x_rel < 0 || grass_array.get(y * x_max + x_rel) == '-') &&
				(y_rel < 0 || grass_array.get(y_rel * x_max + x) == '-') &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 90, 2, grass_array) == 0){
                                        
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, y * final_scale, 90, 2, 1, 0);
                                        water_array.add(new_sprinkler);

                                }
					
			}

			x_rel += 2;

			if ((x_rel >= x_max || grass_array.get(y * x_max + x_rel) == '-') &&
				(y_rel < 0 || grass_array.get(y_rel * x_max + x) == '-') &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, y * final_scale, 90, 3, grass_array) == 0){
                                        
                                        Water_sprinkler new_sprinkler = new Water_sprinkler((x + 1) * final_scale - 1, y * final_scale, 90, 3, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}

			y_rel += 2;

			if ((x_rel >= x_max || grass_array.get(y * x_max + x_rel) == '-') &&
				(y_rel >= y_max || grass_array.get(y_rel * x_max + x) == '-') &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 90, 4, grass_array) == 0){
                                
                                      Water_sprinkler new_sprinkler = new Water_sprinkler((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 90, 4, 1, 0);
                                       water_array.add(new_sprinkler);
							
                                    
                                
                                }
					
			}
			
			if ((x + y) % 2 == 1) //¿eby nie stawia³o na nieparystych miejscach a nie wszêdzie gdzie to mo¿liwe
				continue;

			//setting positions of 180 type

			x_rel = x - 1;
			y_rel = y;

			if ((x_rel < 0 || grass_array.get(y_rel * x_max + x_rel) == '-') &&
				y_rel >= 0 + 1 &&
				y_rel < y_max - 1 &&
				grass_array.get((y_rel - 1) * x_max + x) == '*' &&
				grass_array.get((y_rel + 1) * x_max + x) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 180, 1, grass_array) == 0){
                                
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, y * final_scale, 180, 1, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}

			x_rel = x;
			y_rel = y - 1;

			if ((y_rel < 0 || grass_array.get(y_rel * x_max + x_rel) == '-') &&
				x_rel >= 0 + 1 &&
				x_rel < x_max - 1 &&
				grass_array.get(y * x_max + (x_rel - 1)) == '*' &&
				grass_array.get(y * x_max + (x_rel + 1)) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 180, 2, grass_array) == 0){
                                        
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, y * final_scale, 180, 2, 1, 0);
                                        water_array.add(new_sprinkler);
                                    
                                
                                }
					
			}

			x_rel = x + 1;
			y_rel = y;

			if ((x_rel >= x_max || grass_array.get(y_rel * x_max + x_rel) == '-') &&
				y_rel >= 0 + 1 &&
				y_rel < y_max - 1 &&
				grass_array.get((y_rel - 1) * x_max + x) == '*' &&
				grass_array.get((y_rel + 1) * x_max + x) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, y * final_scale, 180, 3, grass_array) == 0){
                                        
                                        Water_sprinkler new_sprinkler = new Water_sprinkler((x + 1) * final_scale - 1, y * final_scale, 180, 3, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}

			x_rel = x;
			y_rel = y + 1;

			if ((y_rel >= y_max || grass_array.get(y_rel * x_max + x_rel) == '-') &&
				x_rel >= 0 + 1 &&
				x_rel < x_max - 1 &&
				grass_array.get(y * x_max + (x_rel - 1)) == '*' &&
				grass_array.get(y * x_max + (x_rel + 1)) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, (y + 1) * final_scale - 1, 180, 4, grass_array) == 0){
                                
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, (y + 1) * final_scale - 1, 180, 4, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}


			//setting positions of 270 type

			y_rel = y - 1;
			x_rel = x + 1;

			if (x_rel < x_max &&
				y_rel >= 0 &&
				grass_array.get(y_rel * x_max + x_rel) == '-' &&
				grass_array.get(y_rel * x_max + x) == '*' &&
				grass_array.get(y * x_max + x_rel) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, y * final_scale, 270, 1, grass_array) == 0){
                                        
                                        Water_sprinkler new_sprinkler = new Water_sprinkler((x + 1) * final_scale - 1, y * final_scale, 270, 1, 1, 0);
                                        water_array.add(new_sprinkler);
                                    
                                }
					
			}

			y_rel = y + 1;

			if (x_rel < x_max &&
				y_rel < y_max &&
				grass_array.get(y_rel * x_max + x_rel) == '-' &&
				grass_array.get(y_rel * x_max + x) == '*' &&
				grass_array.get(y * x_max + x_rel) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 270, 2, grass_array) == 0){
                                
                                        Water_sprinkler new_sprinkler = new Water_sprinkler((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 270, 2, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}

			x_rel = x - 1;

			if (x_rel >= 0 &&
				y_rel < y_max &&
				grass_array.get(y_rel * x_max + x_rel) == '-' &&
				grass_array.get(y_rel * x_max + x) == '*' &&
				grass_array.get(y * x_max + x_rel) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, (y + 1) * final_scale - 1, 270, 3, grass_array) == 0){
                                
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, (y + 1) * final_scale - 1, 270, 3, 1, 0);
                                        water_array.add(new_sprinkler);
                                }
					
			}

			y_rel = y - 1;

			if (x_rel >= 0 &&
				y_rel >= 0 &&
				grass_array.get(y_rel * x_max + x_rel) == '-' &&
				grass_array.get(y_rel * x_max + x) == '*' &&
				grass_array.get(y * x_max + x_rel) == '*' &&
				(grass_array.get(y * x_max + x) == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 270, 4, grass_array) == 0){
                                
                                        Water_sprinkler new_sprinkler = new Water_sprinkler(x * final_scale, y * final_scale, 270, 4, 1, 0);
                                        water_array.add(new_sprinkler);
                                
                                }
					
			}
		}
	}
}
    
}



