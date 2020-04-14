#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "create_files.h"
#include "setup.h"
#include "water.h"
#include "create_garden.h"


int main(int argc, char** argv)
{
	double start = time(NULL);
	
	FILE* grass_file = argc > 1 ? fopen(argv[1], "r") : stdin;
	grass_load(grass_file);
	trial_version();
	read_data_from_water_array();
	circle_version();
	read_data_from_water_array_circle();
	save("output.bmp");
	water_point_file("water_point.txt");


	printf("Czas wykonywania: %g sekund\n", time(NULL) - start);
	return 0;
}
