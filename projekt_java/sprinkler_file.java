package trawnik;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

public class sprinkler_file extends all_in {

    public void sprinklerFile() {
		
	try(PrintWriter file = new PrintWriter("sprinkler_file.txt", "UTF-8")){
		file.println("Position x:  Position y:  Type:  Rotation:");
 		for (int i = 0; i < water_array.size(); i++) {
				if(water_array.get(i).getType()==360)
            		file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + water_array.get(i).getRotation());
				
				else if (water_array.get(i).getType()==180 && water_array.get(i).getRotation()==1){
					String rotation;
					rotation="east";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);	}
				else if (water_array.get(i).getType()==180 && water_array.get(i).getRotation()==2){
					String rotation;
					rotation="south";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==180 && water_array.get(i).getRotation()==3){
					String rotation;
					rotation="west";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==180 && water_array.get(i).getRotation()==4){
					String rotation;
					rotation="north";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==90 && water_array.get(i).getRotation()==1){
					String rotation;
					rotation="north-east";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==90 && water_array.get(i).getRotation()==2){
					String rotation;
					rotation="south-east";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==90 && water_array.get(i).getRotation()==3){
					String rotation;
					rotation="south-west";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==90 && water_array.get(i).getRotation()==4){
					String rotation;
					rotation="north-west";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==270 && water_array.get(i).getRotation()==1){
					String rotation;
					rotation="west-south";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==270 && water_array.get(i).getRotation()==2){
					String rotation;
					rotation="west-north";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==270 && water_array.get(i).getRotation()==3){
					String rotation;
					rotation="east-north";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				else if (water_array.get(i).getType()==270 && water_array.get(i).getRotation()==4){
					String rotation;
					rotation="east-south";
					file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + rotation);}
				

       }
file.close();}
catch (IOException e) {
			e.printStackTrace();
		}
  
}

}

   

