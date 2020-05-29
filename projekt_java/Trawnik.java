package trawnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Trawnik{
    

    
   
    public static void start (String[] args) throws IOException {
        
        if(args.length == 0)
            {
            System.out.println("No input file given.");
            return;
            }
        
        ArrayList<Character>grass_array= new ArrayList<>();
        ArrayList<Integer>final_array= new ArrayList<>();
        File f = new File(args[0]);
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int c=0;
        char ch; 
       
        //int x = 0;
	//int y = 0;
        
          int x_max = 80;
          int y_max = 40;
         int final_scale = 50;
    
                while((c=br.read())!=-1){
                    ch = (char) c;
                    if(ch=='*' || ch=='-'){
                    grass_array.add(ch);
                    }
                    
                   
                }
                for(int i=0; i<(x_max * final_scale * y_max * final_scale); i++)
                    final_array.add(0);
      
    
                System.out.println(grass_array);
              Setup s = new Setup();
               Water w = new Water();
                s.setup_algorytm(grass_array);
                w.read_data_from_water_array(final_array);
                s.circle_version(grass_array);
                w.read_data_from_water_array_circle(final_array);
    }  
        
    }
