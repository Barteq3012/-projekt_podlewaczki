#include <stdio.h>
#include <stdlib.h>


// sprawdza stosunek ilosci wspolrzednych obszaru niepodlanego do calego ktory obejmuje kolo o konkretnym promieniu
int x_max = 80;
int y_max = 40;
int final_scale=10;


double check (char* grass_array, int circle_x,int circle_y, int* final_array){


        int rad=final_scale*2; //ten promien mozna zmienic na inny
        double relation= 0.0;
        double check_area=0.0;
        double dry_area=0.0;
        int x;
        int y;

        

// policzenie sredniej dla calego podlanego trawnika

       double avg= 0.0;
        for (int h = 0; h <y_max*final_scale; h++)
    	for (int w = 0; w <x_max*final_scale; w++)
       	 if(grass_array[h*w*final_scale+h]=='*')
                avg+=final_array[h*w*final_scale+h];


        for(int i=0; i<2*rad; i++){
                y=circle_y-rad+i;
                for(int j=0; j<2*rad; j++){
                        x=circle_x-rad+j;

        if (((x - circle_x) * (x - circle_x)) + ((y - circle_y) * (y - circle_y)) <= (rad * rad))
                    {
                          if(grass_array[y*j*final_scale+x]=='*' && final_array[y*j*final_scale+x]==0){
                                   dry_area++;
                                   check_area++;
                                }
                                else if (grass_array[y*j*final_scale+x]=='*' &&  final_array[y*j*final_scale+x]<avg){ //teren duzo mniej podlany wstosunku do innych
                                        dry_area=dry_area/*+wspolczynnik*/;
                                        check_area++;                   // to trzeba ustalic, jezeli sa obszary duzo mniej podlane wstosunku do innych 
                                }                                       //to traktujemy je podobnie jak niepodlane ale dodajemy troche mniejsza liczbe                   

                                else if(grass_array[y*j*final_scale+x]=='-'){
                                        check_area++;
                                }
                        }
                }
        }
                                relation=dry_area/check_area;
return relation;
}


// sprawdza po punktach trawnika czy moze tam umiescic podlewaczke

void grasscheck(char* grass_array, int * final_array){
double minimum=0.4; // to trzeba ustalic jaka wartosc nam odpowiada, 
double relation=0.0;//jako minimalny stosunek niepodlanego obszaru do podlanego dla kola o promieniu 2


for(int x=0; x<x_max*final_scale; x+=50){                            // tutaj te 50 takie przykladowe trzeba ustalic co ile bedziemy przeskakiwac pole 
                                                        // bo bezsensu jest sprawdzac kazde

        for(int y=0; y<y_max*final_scale; y+=50){
                relation=check(grass_array, x, y, final_array);
                        if (relation>=minimum){
                               // tutaj funkcja ktora decyduje jaka podlewaczke umiescic
                        }}}


}
int main(){}
