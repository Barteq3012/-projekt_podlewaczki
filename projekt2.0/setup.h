

#ifndef SETUP_H_INCLUDED
#define SETUP_H_INCLUDED

#define x_max 80
#define y_max 40

#define final_scale 50
#define type_max_range 4
#define type_360_range 2
#define type_270_range 3
#define type_180_range 2
#define type_90_range 4


typedef struct water
{
	int rotation; // obrot poszczegolnej podlewczki
	int type; // typ podlewaczki
	int use; //zeby dana podlewaczka dziala tylko raz 
} water_type;


water_type* water_array;

int watering_condition(int circle_x, int circle_y, int type, int rotation);
int circle_condition(int circle_x, int circle_y);
void circle_version();
void setup_algorytm();
void set_water(int x, int y, int type, int rotation, int use);


	

#endif 
