#ifndef WATER_H_INCLUDED
#define WATER_H_INCLUDED

#define x_max 80
#define y_max 40

#define final_scale 50

#define type_360_cycles 1
#define type_270_cycles 2
#define type_180_cycles 3
#define type_90_cycles 4

#define type_360_range 2
#define type_180_range 2
#define type_90_range 4
#define type_max_range 4

void watering_point(int xc, int yc, int type, int rotation);
void read_data_from_water_array();
void read_data_from_water_array_circle();

#endif 
