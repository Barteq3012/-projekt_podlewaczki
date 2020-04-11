#include <stdio.h>
#include <stdlib.h>




// sprawdz stosunek ilosci wspolrzednych obszaru niepodlanego do calego ktory obejmuje kolo o konkretnym promieniu

double check (char* grass_array, int circle_x,int circle_y, int* final_small_array){


        int rad=2; //ten promien mozna zmienic na inny
        double relation= 0.0;
        double check_area=0.0;
        double dry_area=0.0;
        int x;
        int y;

        int x_max = 80;
        int y_max = 40;

// policzenie sredniej dla calego podlanego trawnika

        double avg= 0.0;
        for (int h = 0; h <y_max; h++)
    for (int w = 0; w <x_max; w++)
        if(grass_array[h*w]=='*')
                avg+=final_small_array[h*w];




        for(int i=0; i<2*rad; i++){
                y=circle_y-rad+i;
                for(int j=0; j<2*rad; j++){
                        x=circle_x-rad+j;
        if (((x - circle_x) * (x - circle_x)) + ((y - circle_y) * (y - circle_y)) <= (rad * rad))
                        {
                                if(grass_array[y*j+x]=='*' && final_small_array[y*j+x]==0){
                                        dry_area++;
                                        check_area++;
                                }
                                else if (grass_array[y*j+x]=='*' &&  final_small_array[y*j+x]<avg){ //teren duzo mniej podlany wstosunku do innych
                                        dry_area=dry_area/*+wspolczynnik*/;
                                        check_area++;                   // to trzeba ustalic, jezeli sa obszary duzo mniej podlane wstosunku do innych to traktujemy je podobnie jak niepodlane 
                                }                                       //ale dodajemy troche mniejsza liczbe                   

                                else if(grass_array[y*j+x]=='-'){
                                        check_area++;
                                }
                        }
                }
        }
                                relation=dry_area/check_area;
return relation;
}


// sprawdza po punktach trawnika czy moze tam umiescic podlewaczke

void grasscheck(char* grass_array, int * final_small_array){
double minimum=0.4; // to trzeba ustalic jaka wartosc nam odpowiada jako minimalny stosunek niepodlanego obszaru do podlanego dla kola o promieniu 2
double relation=0.0;
int x_max = 80;
int y_max = 40;

for(int x=0; x<x_max; x+=5){                            // tutaj te 5 takie przykladowe trzeba ustalic co ile bedziemy przeskakiwac pole 
                                                        // bo bezsensu jest sprawdzac kazde

        for(int y=0; y<y_max; y+=5){
                relation=check(grass_array, x, y, final_small_array);
                        if (relation>=minimum){
                               // tutaj funkcja ktora decyduje jaka podlewaczke umiescic
                        }}}


}
int main(){}
