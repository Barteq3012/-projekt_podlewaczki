//to jest plik testuj¹cy generowanie bitmapy
// koloruje bitmape kolorami rgb 0-10 - tylko zielony
//11-20 zmniejsza sie ilosc zielonego a zwiêksza czerwonego
// powyzej 20 sam niebieski odcien 255

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

void draw_circle(int xc, int yc, int* final_array)
{

	int radius = final_scale * 10;
	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if(pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2))
				final_array[y * x_max * final_scale + x] = 5;

		}
	}

}

void draw_half_of_circle(int xc, int yc, int* final_array)
{

	int radius = final_scale * 5;
	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc )
				final_array[y * x_max * final_scale + x] = 18;

		}
	}

}
void draw_quarter_of_circle(int xc, int yc, int* final_array)
{

	int radius = final_scale * 10;
	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc && x < xc)
				final_array[y * x_max * final_scale + x] = 25;

		}
	}

}
void draw_circle_without_qurter(int xc, int yc, int* final_array)
{

	int radius = final_scale * 5;
	for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x < xc || y < yc))
				final_array[y * x_max * final_scale + x] = 8;

		}
	}

}






void save(char* file_name, int* final_array)
{

	int y, x;
	int width = x_max * final_scale;
	int height = y_max * final_scale;
	int size = width * height * 4; //for 32-bit bitmap only


	/*for (int y = 0; y < y_max * final_scale; y++)
	{
		for (int x = 0; x < x_max * final_scale; x++)
		{
			if (y < 20 * final_scale)
			{
				final_array[y * x_max * final_scale + x] = 5;
			}
			else if(y < 30 * final_scale)
			{
				final_array[y * x_max * final_scale + x] = 19;
			}
			else
			{
				final_array[y * x_max * final_scale + x] = 25;
			}

		}
	}

	*/




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


	draw_circle(x_max * final_scale / 2, y_max * final_scale / 2, final_array);
	draw_half_of_circle(x_max * final_scale / 4, y_max * final_scale / 4, final_array);
	draw_quarter_of_circle(x_max * final_scale, y_max * final_scale, final_array);
	draw_circle_without_qurter(x_max * final_scale / 1.3, y_max * final_scale / 1.3, final_array);
	save("output.bmp", final_array);

	printf("Czas wykonywania: %g sekund\n", time(NULL) - start);
	return 0;
}