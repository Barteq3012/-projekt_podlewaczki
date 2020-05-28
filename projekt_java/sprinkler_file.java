package trawnik;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class sprinkler_file extends all_in {
        
    
   public void sprinkler_file (String name) throws FileNotFoundException {
        PrintWriter file = new PrintWriter(name);
        file.println("Position x:  Position y:  Type:  Rotation:");
        for (int i = 0; i < water_array.size(); i++) {
            file.println("   " + water_array.get(i).getX() + "          " + water_array.get(i).getY() + "        " + water_array.get(i).getType() + "          " + water_array.get(i).getRotation());
        }
        file.close();
    }


   

}
