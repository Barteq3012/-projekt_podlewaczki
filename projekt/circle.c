#include <stdio.h> 
#include <math.h>
#define PI 3.14 

//sprawdzenie czy punkt znajduje sie w danym obszarze, mozna zmienic zeby zaznaczalo wszystkie punkty ktore sie w nim znajduja

// rad=radius
// circle_x, circle_y - wspolrzedne srodka kola
// percent - jaki fragment kola chcemy



//dla calego kola 360

void isInsideCircle(int circle_x, int circle_y, int rad, int x, int y) 
{
       	//porownuje promien kola z odlegloscia jego srodka od podanego punktu
     
    if ((x - circle_x) * (x - circle_x) + 
        (y - circle_y) * (y - circle_y) <= rad * rad) 
         printf("Punkt (%d, %d) znajduje sie w kole\n", x, y);
    else
	    printf("Punkt (%d, %d)nie znajduje sie w kole\n", x, y);
        
} 
  
// dla kazdego fragmentu kola
void isInsideSector(int rad, int x, int y, float percent, float startAngle, int circle_x, int circle_y)
{
   
    float endAngle =( 360*(percent/100)) + startAngle;// obliczam kat koncowy

    
    float polarrad = sqrt(((x-circle_x)*(x-circle_x))+((y-circle_y)*(y-circle_y))); // przekształcam na wspolrzedne biegunowe
    float angle=atan2(y-circle_y, x-circle_x)*(180/PI);
	if( angle<0)
	angle+=360;
	if(endAngle>360)
		endAngle-=360;
    // Sprawdzam czy pollarrad jest mniejszy niż rad i czy kąt jest pomiędzy początkiem i końcem
    //dziala przy zalozeniu ze luk rysujemy przeciwnie do wskazowek zegara i katy z przedzialu 0-360
   
   if(startAngle<endAngle){
    if (angle>=startAngle && angle<=endAngle && polarrad<rad)
        printf("Punkt (%d, %d) znajduje sie we fragmecie kola\n", x, y);
    else
        printf("Punkt (%d, %d)nie znajduje sie we fragmecie kola\n", x, y);
   }

   else if(startAngle>endAngle){
   
	   if (angle>=startAngle && polarrad<rad)
       		 printf("Punkt (%d, %d) znajduje sie we fragmecie kola\n", x, y);
	else if (angle<=endAngle && polarrad<rad)
       		 printf("Punkt (%d, %d) znajduje sie we fragmecie kola\n", x, y);
		else
       			 printf("Punkt (%d, %d)nie znajduje sie we fragmecie kola\n", x, y);
	
   
   }

}

int main()
{

	int x =5, y =3;
    int circle_x = 4, circle_y = 2, rad = 5;
   isInsideCircle(circle_x, circle_y, rad, x, y);
                  

    
    float percent  = 50, startAngle =270;
    isInsideSector(rad, x, y, percent, startAngle, circle_x, circle_y);
    return 0;
}
