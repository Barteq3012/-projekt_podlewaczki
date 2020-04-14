#include <math.h>
#include <stdio.h>
#include <stdlib.h>

#include "create_files.h"
#include "setup.h"
#include "water.h"
#include "create_garden.h"


void set_water(int x, int y, int type, int rotation, int use)
{
	water_array[y * x_max * final_scale + x].type = type;
	water_array[y * x_max * final_scale + x].rotation = rotation;
	water_array[y * x_max * final_scale + x].use += use;
}


int watering_condition(int circle_x, int circle_y, int type, int rotation)
{
	int xc = circle_x; // * final_scale;
	int yc = circle_y; // * final_scale;
	int radius = 0;
	for (int y = yc - type_max_range * final_scale; y < yc + type_max_range * final_scale + 1; y++)
	{
		for (int x = xc - type_max_range * final_scale; x < xc + type_max_range * final_scale + 1; x++)
		{
			if (type == 360)
			{
				radius = final_scale * type_360_range;
				if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2))
					if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
						return 1;
			}
			else if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x <= xc || y >= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 2)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x <= xc || y <= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 3)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x >= xc || y <= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 4)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x >= xc || y >= yc))
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
			}
			else if (type == 180)
			{
				radius = final_scale * type_180_range;
				if (rotation == 1)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && x >= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 2)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y >= yc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 3)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && x <= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 4)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y <= yc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
			}
			else if (type == 90)
			{
				radius = final_scale * type_90_range;
				if (rotation == 1)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y <= yc && x >= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 2)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y >= yc && x >= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 3)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y >= yc && x <= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
				else if (rotation == 4)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y <= yc && x <= xc)
						if (x < 0 || x >= x_max * final_scale || y < 0 || y >= y_max * final_scale || grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
							return 1;
				}
			}
		}
	}

	return 0;
}



int circle_condition(int circle_x, int circle_y)
{
	int cx = circle_x * final_scale;
	int cy = circle_y * final_scale;
	for (int y = fmax(cy - type_360_range * final_scale, 0); y < fmin(cy + type_360_range * final_scale + 1,
	                                                                y_max * final_scale); y++)
	{
		for (int x = fmax(cx - type_360_range * final_scale, 0); x < fmin(cx + type_360_range * final_scale + 1,
		                                                                x_max * final_scale); x++)
		{
			if (powf(cx - x, 2) + powf(cy - y, 2) <= powf(type_360_range * final_scale, 2))
			{
				if (grass_array[(y / final_scale) * x_max + (x / final_scale)] == '-')
					return 1;
			}
		}
	}

	return 0;
}

void circle_version()
{
	
	int condition = 0;

	for (int x = 0; x < x_max; x += 2)
	{
		for (int y = 0; y < y_max; y += 2)
		{
			if (grass_array[y * x_max + x] == '*' && water_array[y * final_scale * x_max * final_scale + x * final_scale
			].type == 0 && water_array[y * final_scale * x_max * final_scale + x * final_scale].rotation == 0)
			{
				if (circle_condition(x, y) == 0)
					set_water(x * final_scale, y * final_scale, 360, 1, 2);
			}
		}
	}
}

void trial_version()
{
	for (int y = 0; y < y_max; y++)
	{
		for (int x = 0; x < x_max; x++)
		{
			// setting positions of 90 type
			int x_rel = x - 1;
			int y_rel = y + 1;

			if ((x_rel < 0 || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel >= y_max || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, (y + 1) * final_scale - 1, 90, 1) == 0)
					set_water(x * final_scale, (y + 1) * final_scale - 1, 90, 1, 1);
			}

			y_rel -= 2;

			if ((x_rel < 0 || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel < 0 || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 90, 2) == 0)
					set_water(x * final_scale, y * final_scale, 90, 2, 1);
			}

			x_rel += 2;

			if ((x_rel >= x_max || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel < 0 || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, y * final_scale, 90, 3) == 0)
					set_water((x + 1) * final_scale - 1, y * final_scale, 90, 3, 1);
			}

			y_rel += 2;

			if ((x_rel >= x_max || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel >= y_max || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 90, 4) == 0)
					set_water((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 90, 4, 1);
			}
			
			if ((x + y) % 2 == 1)
				continue;

			//setting positions of 180 type

			x_rel = x - 1;
			y_rel = y;

			if ((x_rel < 0 || grass_array[y_rel * x_max + x_rel] == '-') &&
				y_rel >= 0 + 1 &&
				y_rel < y_max - 1 &&
				grass_array[(y_rel - 1) * x_max + x] == '*' &&
				grass_array[(y_rel + 1) * x_max + x] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 180, 1) == 0)
					set_water(x * final_scale, y * final_scale, 180, 1, 1);
			}

			x_rel = x;
			y_rel = y - 1;

			if ((y_rel < 0 || grass_array[y_rel * x_max + x_rel] == '-') &&
				x_rel >= 0 + 1 &&
				x_rel < x_max - 1 &&
				grass_array[y * x_max + (x_rel - 1)] == '*' &&
				grass_array[y * x_max + (x_rel + 1)] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 180, 2) == 0)
					set_water(x * final_scale, y * final_scale, 180, 2, 1);
			}

			x_rel = x + 1;
			y_rel = y;

			if ((x_rel >= x_max || grass_array[y_rel * x_max + x_rel] == '-') &&
				y_rel >= 0 + 1 &&
				y_rel < y_max - 1 &&
				grass_array[(y_rel - 1) * x_max + x] == '*' &&
				grass_array[(y_rel + 1) * x_max + x] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, y * final_scale, 180, 3) == 0)
					set_water((x + 1) * final_scale - 1, y * final_scale, 180, 3, 1);
			}

			x_rel = x;
			y_rel = y + 1;

			if ((y_rel >= y_max || grass_array[y_rel * x_max + x_rel] == '-') &&
				x_rel >= 0 + 1 &&
				x_rel < x_max - 1 &&
				grass_array[y * x_max + (x_rel - 1)] == '*' &&
				grass_array[y * x_max + (x_rel + 1)] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, (y + 1) * final_scale - 1, 180, 4) == 0)
					set_water(x * final_scale, (y + 1) * final_scale - 1, 180, 4, 1);
			}


			//setting positions of 270 type

			y_rel = y - 1;
			x_rel = x + 1;

			if (x_rel < x_max &&
				y_rel >= 0 &&
				grass_array[y_rel * x_max + x_rel] == '-' &&
				grass_array[y_rel * x_max + x] == '*' &&
				grass_array[y * x_max + x_rel] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, y * final_scale, 270, 1) == 0)
					set_water((x + 1) * final_scale - 1, y * final_scale, 270, 1, 1);
			}

			y_rel = y + 1;

			if (x_rel < x_max &&
				y_rel < y_max &&
				grass_array[y_rel * x_max + x_rel] == '-' &&
				grass_array[y_rel * x_max + x] == '*' &&
				grass_array[y * x_max + x_rel] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 270, 2) == 0)
					set_water((x + 1) * final_scale - 1, (y + 1) * final_scale - 1, 270, 2, 1);
			}

			x_rel = x - 1;

			if (x_rel >= 0 &&
				y_rel < y_max &&
				grass_array[y_rel * x_max + x_rel] == '-' &&
				grass_array[y_rel * x_max + x] == '*' &&
				grass_array[y * x_max + x_rel] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, (y + 1) * final_scale - 1, 270, 3) == 0)
					set_water(x * final_scale, (y + 1) * final_scale - 1, 270, 3, 1);
			}

			y_rel = y - 1;

			if (x_rel >= 0 &&
				y_rel >= 0 &&
				grass_array[y_rel * x_max + x_rel] == '-' &&
				grass_array[y_rel * x_max + x] == '*' &&
				grass_array[y * x_max + x_rel] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				if (watering_condition(x * final_scale, y * final_scale, 270, 4) == 0)
					set_water(x * final_scale, y * final_scale, 270, 4, 1);
			}
		}
	}
}

