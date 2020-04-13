#include <stdio.h>
#include <stdlib.h>
#include <math.h>



typedef struct water {
    int rotation; // obrot poszczegolnej podlewczki
    int type; // typ podlewaczki
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
int* neighbour_array=NULL;

void grass_load(FILE* fp)
{
   grass_array = calloc(x_max * y_max, sizeof(char));
   water_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(water_type));
   final_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(int));
   neighbour_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(int)); //pola trawnika ktore sasiaduja z polem ktore nie jest trawa
}
void watering_point(int xc, int yc, int type, int rotation)
{
        int radius = 0;
	int neighbour=0; //sasiad pola z (*) jest pole z (-)
	int neighbour_number=0;	//z iloma polami (-) saisiaduje pola 

for (int y = 0; y < y_max * final_scale; y++)
        {
                for (int x = 0; x < x_max * final_scale; x++)
                {
                        if (type == 360)
                        {
                                radius = final_scale * type_360_range;
                                if (pow(xc - x, 2) + pow(yc - y, 2) <= pow(radius, 2)){
                                        final_array[y * x_max * final_scale + x] += type_360_cycles;
                                              
						if(grass_array[y*x_max*final_scale+x]=='*'){
						
							if(grass_array[y*x_max*final_scale+x+1]=='-')	
								neighbour_array[neighbour]=y*x_max*final_scale+x;
								neighbour_number++;

							if(grass_array[y*x_max*final_scale+x-1]=='-')
								neighbour_array[neighbour]=y*x_max*final_scale+x;
                                               		 	neighbour_number++;

							if(grass_array[(y+1)*x_max*final_scale+x]=='-')
								neighbour_array[neighbour]=y*x_max*final_scale+x;
                                                                neighbour_number++;

							if(grass_array[(y-1)*x_max*final_scale+x]=='-')
								neighbour_array[neighbour]=y*x_max*final_scale+x;
                                                                neighbour_number++;


							if(neighbour_number>0)
								neighbour++;
							neighbour_number=0;
						}}
                        }
		}
	
	}
	
for(int i=0; i<neighbour; i++){
	if(neighbour_number==1||neighbour_number==2)
		final_array[neighbour_array[i]]+=1;
	else if(neighbour_number>2)
	final_array[neighbour_array[i]]+=2;

}}
int main(void){

return 0;
}
