#define _CRT_SECURE_NO_WARNINGS

#include <math.h>
#include <stdio.h>
#include <stdlib.h>


#include "setup.h"
#include "water.h"
#include "create_garden.h"

void watering_point(int xc, int yc, int type, int rotation)
{
	int radius = 0;
	for (int y = fmax(yc - type_max_range * final_scale, 0); y < fmin(yc + type_max_range * final_scale + 1,
	                                                                y_max * final_scale); y++)
	{
		for (int x = fmax(xc - type_max_range * final_scale, 0); x < fmin(xc + type_max_range * final_scale + 1,
		                                                                x_max * final_scale); x++)
		{
			if (type == 360)
			{
				radius = final_scale * type_360_range;
				if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2))
					final_array[y * x_max * final_scale + x] += type_360_cycles;
			}
			else if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x <= xc || y >= yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				else if (rotation == 2)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x <= xc || y <= yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				else if (rotation == 3)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x >= xc || y <= yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				else if (rotation == 4)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && (x >= xc || y >= yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
			}
			else if (type == 180)
			{
				radius = final_scale * type_180_range;
				if (rotation == 1)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && x >= xc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				else if (rotation == 2)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y >= yc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				else if (rotation == 3)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && x <= xc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				else if (rotation == 4)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y <= yc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
			}
			else if (type == 90)
			{
				radius = final_scale * type_90_range;
				if (rotation == 1)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y <= yc && x >= xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				else if (rotation == 2)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y >= yc && x >= xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				else if (rotation == 3)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y >= yc && x <= xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				else if (rotation == 4)
				{
					if (powf(xc - x, 2) + powf(yc - y, 2) <= powf(radius, 2) && y <= yc && x <= xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
			}
		}
	}
}

void read_data_from_water_array()
{
	int type;
	int rotation;

	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (water_array[y * x_max * final_scale + x].type != 0 &&
				water_array[y * x_max * final_scale + x].rotation != 0 && water_array[y * x_max * final_scale + x].use
				== 1)
			{
				type = water_array[y * x_max * final_scale + x].type;
				rotation = water_array[y * x_max * final_scale + x].rotation;
				watering_point(x, y, type, rotation);
			}
		}
	}
}

void read_data_from_water_array_circle()
{
	int type;
	int rotation;
	int use;

	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (water_array[y * x_max * final_scale + x].type != 0 &&
				water_array[y * x_max * final_scale + x].rotation != 0 && water_array[y * x_max * final_scale + x].use
				== 2)
			{
				type = water_array[y * x_max * final_scale + x].type;
				rotation = water_array[y * x_max * final_scale + x].rotation;
				watering_point(x, y, type, rotation);
			}
		}
	}
}



