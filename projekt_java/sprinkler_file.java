package trawnik;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

public class sprinkler_file extends all_in {

    public void sprinklerFile() {
	try(PrintWriter file = new PrintWriter("sprinkler_file.txt", "UTF-8")){
		file.println("Position x:  Position y:  Type:  Rotation:");
 		for (int i = 0; i < water_array.size(); i++) {
            		file.println("     " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "          " + water_array.get(i).getType() + "          " + water_array.get(i).getRotation());
        }
file.close();}
catch (IOException e) {
			e.printStackTrace();
		}
  
}

}

   

