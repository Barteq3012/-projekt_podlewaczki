#define _CRT_SECURE_NO_WARNINGS
#include <ctype.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct water {
    int rotation; // obrot poszczegolnej podlewczki
    int type; // typ podlewaczki
    int use; //zeby dana podlewaczka dziala tylko raz 
} water_type;

int x_max = 80;
int y_max = 40;
int final_scale = 30;

int type_360_range = 2;
int type_270_range = 3;
int type_180_range = 2;
int type_90_range = 4;

int type_360_cycles = 1;
int type_270_cycles = 2;
int type_180_cycles = 3;
int type_90_cycles = 4;

char* grass_array = NULL;
water_type* water_array = NULL;
int* final_array = NULL;

//char* grass_file_name = "in.txt";


void set_water(int x, int y, int type, int rotation, int use)
{
	water_array[y * x_max * final_scale + x].type = type;
	water_array[y * x_max * final_scale + x].rotation = rotation;
	water_array[y*x_max*final_scale+x].use+=use;

}

void grass_load(FILE* fp)
{
   grass_array = calloc(x_max * y_max, sizeof(char));
   water_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(water_type));
   final_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(int));

   int x = 0;
   int y = 0;

   char ch;
   while ((ch = (char) getc(fp)) != EOF)
   {
      if(ch == '*' || ch == '-')
      {
         grass_array[y * x_max + x] = ch;
      }
      else
      {
         continue; //tu mozna zrobic obsluge bledu
      }
      
      x++;
      if(x == x_max)
      {
         x = 0;
         y++;
      }
   }
}

void watering_point(int xc, int yc, int type, int rotation)
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
			else if (type == 270)
			{
				radius = final_scale * type_270_range;
				if (rotation == 1)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x < xc || y > yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				else if (rotation == 2)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x < xc || y < yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				else if (rotation == 3)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x > xc || y < yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
				else if (rotation == 4)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && (x > xc || y > yc))
						final_array[y * x_max * final_scale + x] += type_270_cycles;
				}
			}
			else if (type == 180)
			{
				radius = final_scale * type_180_range;
				if (rotation == 1)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && x > xc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				else if (rotation == 2)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y > yc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				else if (rotation == 3)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && x < xc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
				else if (rotation == 4)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc)
						final_array[y * x_max * final_scale + x] += type_180_cycles;
				}
			}
			else if (type == 90)
			{
				radius = final_scale * type_90_range;
				if (rotation == 1)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc && x > xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				else if (rotation == 2)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y > yc&& x > xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				else if (rotation == 3)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y > yc&& x < xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
				else if (rotation == 4)
				{
					if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2) && y < yc && x < xc)
						final_array[y * x_max * final_scale + x] += type_90_cycles;
				}
			}
		}
	}
} 

void save(char* file_name)
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

void circle_version()
{

double minimum=0.4;  
double relation=0.0;
int w=0;

for(int x=5; x<x_max; x+=3){                            
                                                       
        for(int y=5; y<y_max; y+=3){
		if(grass_array[y*x_max+x]=='*' && water_array[y*x_max+x].type==0 && water_array[y*x_max+x].rotation==0 && grass_array[y * x_max + x+2] != '-'&&
			      	grass_array[y * x_max + x-2] != '-'&& grass_array[(y-2) * x_max + x] != '-' &&  grass_array[(y+2) * x_max + x] != '-'){
              

					set_water(x*final_scale, y*final_scale, 360, 1, 2);
                               
                        }}


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
				set_water(x * final_scale, (y + 1)* final_scale - 1, 90, 1, 1);
			}

			y_rel -= 2;

			if ((x_rel < 0 || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel < 0 || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				set_water(x * final_scale, y * final_scale, 90, 2, 1);
			}

			x_rel += 2;

			if ((x_rel >= x_max || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel < 0 || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				set_water((x + 1) * final_scale - 1, y * final_scale, 90, 3, 1); 
			}

			y_rel += 2;

			if ((x_rel >= x_max || grass_array[y * x_max + x_rel] == '-') &&
				(y_rel >= y_max || grass_array[y_rel * x_max + x] == '-') &&
				(grass_array[y * x_max + x] == '*'))
			{
				set_water((x + 1)* final_scale - 1, (y + 1) * final_scale - 1, 90, 4, 1);
			}

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
				set_water((x + 1)* final_scale - 1, y * final_scale, 180, 3, 1);
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
				set_water(x * final_scale, (y + 1)* final_scale -1, 180, 4, 1);
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
				set_water((x + 1) * final_scale - 1, y* final_scale, 270, 1, 1);
			}

			y_rel = y + 1;

			if (x_rel < x_max && 
				y_rel < y_max &&
				grass_array[y_rel * x_max + x_rel] == '-' &&
				grass_array[y_rel * x_max + x] == '*' &&
				grass_array[y * x_max + x_rel] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
				set_water((x + 1)* final_scale - 1, (y + 1)* final_scale - 1, 270, 2, 1);
			}

			x_rel = x - 1;

			if (x_rel >= 0 &&
				y_rel < y_max &&
				grass_array[y_rel * x_max + x_rel] == '-' &&
				grass_array[y_rel * x_max + x] == '*' &&
				grass_array[y * x_max + x_rel] == '*' &&
				(grass_array[y * x_max + x] == '*'))
			{
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
				set_water(x * final_scale, y * final_scale, 270, 4, 1);
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
				water_array[y * x_max * final_scale + x].rotation != 0 && water_array[y*x_max*final_scale+x].use==1)
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
                                water_array[y * x_max * final_scale + x].rotation != 0 && water_array[y*x_max*final_scale+x].use==2)
                        {
                                type = water_array[y * x_max * final_scale + x].type;
                                rotation = water_array[y * x_max * final_scale + x].rotation;
                                watering_point(x, y, type, rotation);
                        }

                }
        }

}


int main(int argc, char** argv)
{
	double start = time(NULL);

	FILE* grass_file= argc> 1 ? fopen (argv[1], "r"):stdin;
	grass_load(grass_file);
	trial_version();
	read_data_from_water_array();
	circle_version();
	read_data_from_water_array_circle();
	watering_point(100,100,360,1);
	save("output.bmp");


	printf("Czas wykonywania: %g sekund\n", time(NULL) - start);
	return 0;

}
