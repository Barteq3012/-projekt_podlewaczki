#include <stdio.h>
#include <stdlib.h>

struct water {
    int count; // ilosc podlewaczek w jednym miejscu
    int rotation; // obrot poszczegolnej podlewczki
    int type; // typ podlewaczki 0-3
} water_type;

int x_max = 80;
int y_max = 40;
int final_scale = 100;

char* grass_array = NULL;
water_type* water_array = NULL;

char* grass_file_name = "in.txt";

short* final_small_array = NULL;
short* final_array = NULL;

void grass_load(FILE* fp)
{
   grass_array = calloc(x_max * y_max, sizeof(char));
   water_array = calloc(x_max * y_max, sizeof(int));

   final_small_array = calloc(x_max * y_max, sizeof(short));
   final_array = calloc(x_max * final_scale * y_max * final_scale, sizeof(short));

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
int main(void)
{
   FILE* grass_file = fopen(grass_file_name, "r");

   grass_load(grass_file);

   return 0;

}