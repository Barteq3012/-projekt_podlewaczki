#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>


#include "setup.h"
#include "create_garden.h"

void grass_load(FILE* fp)
{
	grass_array = calloc(x_max * y_max, sizeof(char));
	water_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(water_type));
	final_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(int));

	int x = 0;
	int y = 0;

	char ch;
	while ((ch = (char)getc(fp)) != EOF)
	{
		if (ch == '*' || ch == '-')
		{
			grass_array[y * x_max + x] = ch;
		}
		
		else{
			continue;
			}

		x++;
		if (x == x_max)
		{
			x = 0;
			y++;
		}
	}
}


