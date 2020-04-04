#include <stdio.h>

int x_max = 80;
int y_max = 40;
int final_scale = 100;
char* grass_array = NULL;
int* water_array = NULL;

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