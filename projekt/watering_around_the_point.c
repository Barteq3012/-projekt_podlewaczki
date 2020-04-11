//to jest plik z funkcj¹ która na podstawie po³o¿enia, obrotu i typu podlewa dany obszar


#define _CRT_SECURE_NO_WARNINGS
#include <ctype.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int x_max = 80;
int y_max = 40;
int final_scale = 10;

int type_360_range = 1;
int type_270_range = 3;
int type_180_range = 2;
int type_90_range = 4;

int type_360_cycles = 1;
int type_270_cycles = 2;
int type_180_cycles = 3;
int type_90_cycles = 4;

void watering_point(int xc, int yc, int type, int rotation, int* final_array)
{
	int radius = 0;
	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (type == 360)
			{
				radius = final_scale * type_360_range;
				if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2))
					final_array[y * x_max * final_scale + x] += type_360_cycles;

			}

			if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x < xc || y > yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				if (rotation == 2)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x < xc || y < yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				if (rotation == 3)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x > xc || y < yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				if (rotation == 4)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x > xc || y > yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
			}

			if (type == 180)
			{
				radius = final_scale * type_180_range;
				if (rotation == 1)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && x > xc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				if (rotation == 2)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y > yc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				if (rotation == 3)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && x < xc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				if (rotation == 4)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
			}

			if (type == 90)
			{
				radius = final_scale * type_90_range;
				if (rotation == 1)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc && x > xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				if (rotation == 2)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y > yc && x > xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				if (rotation == 3)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y > yc && x < xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				if (rotation == 4)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc && x < xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
			}
		}
	}
}




void save(char* file_name, int* final_array)
{

	int y, x;
	int width = x_max * final_scale;
	int height = y_max * final_scale;
	int size = width * height * 4; //for 32-bit bitmap only


	char header[54] = { 0 };
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
	for (y = 0; y < height; y++) {
		for (x = 0; x < width; x++) {
			int p = (y * width + x) * 4;

			int data = final_array[(height - y - 1) * width + x];
			int r = 0, g = 0, b = 0;

			if(data <= 10)
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

int main(void)
{
	double start = time(NULL);

	int* final_array = NULL;
	final_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(int));
	//sprawdzenie
	watering_point(x_max * final_scale / 4, y_max * final_scale / 2, 90, 1, final_array);
	watering_point(x_max * final_scale / 3, y_max * final_scale / 2, 90, 2, final_array);
	watering_point(x_max * final_scale / 2, y_max * final_scale / 2, 90, 3, final_array);
	watering_point(x_max * final_scale / 1.5, y_max * final_scale / 2, 90, 4, final_array);

	save("output.bmp", final_array);

	printf("Czas wykonywania: %g sekund\n", time(NULL) - start);
	return 0;
}