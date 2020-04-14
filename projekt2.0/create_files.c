#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "create_files.h"
#include "setup.h"
#include "water.h"
#include "create_garden.h"

void save(char* file_name)
{
	int y, x;
	int width = x_max * final_scale;
	int height = y_max * final_scale;
	int size = width * height * 4; //for 32-bit bitmap only


	char header[54] = {0};
	strcpy(header, "BM");
	*(int*)(&header[2]) = 54 + size;
	*(int*)(&header[10]) = 54;
	*(int*)(&header[14]) = 40;
	*(int*)(&header[18]) = width;
	*(int*)(&header[22]) = height;
	*(short*)(&header[26]) = 1;
	*(short*)(&header[28]) = 32;
	*(int*)(&header[34]) = size;

	unsigned char* pixels = calloc(size, sizeof(char));
	for (y = 0; y < height; y++)
	{
		for (x = 0; x < width; x++)
		{
			int p = (y * width + x) * 4;

			int data = final_array[(height - y - 1) * width + x];
			int r = 0, g = 0, b = 0;

			if (data <= 10)
			{
				g = (int)(data / 10.0 * 255.0);
			}
			else if (data <= 20)
			{
				data -= 10;
				r = (int)(data / 10.0 * 255.0);
				g = (int)(255 - (data / 10.0 * 255.0));
			}
			else
			{
				b = 255;
			}

			pixels[p + 0] = (char)b;
			pixels[p + 1] = (char)g;
			pixels[p + 2] = (char)r;
		}
	}

	FILE* fout = fopen(file_name, "wb");
	fwrite(header, 1, 54, fout);
	fwrite(pixels, 1, size, fout);
	free(pixels);
	fclose(fout);
}

void water_point_file (char* file_name){

	FILE* out=fopen(file_name, "w");



	        for (int y = 0; y < y_max * final_scale; y++)
        {
                for (int x = 0; x < x_max * final_scale; x++)
                {       if(water_array[y * x_max * final_scale + x].type != 0)
                        fprintf(out, "wspolrzedne (%d, %d) typ podlewaczki: %d\n", y, x, water_array[y * x_max * final_scale + x].type);

		}

	
	}

		fclose(out);
}
