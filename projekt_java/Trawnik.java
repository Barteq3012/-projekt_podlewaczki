
package trawnik;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Trawnik  {


    public static void main(String[] args) throws IOException {
        ArrayList<Character>grass_array= new ArrayList<>();
        //ArrayList<Integer>final_array= new ArrayList<>();
        File f = new File(args[0]);
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int c=0;
        char ch;  
        
    
                while((c=br.read())!=-1){
                    ch = (char) c;
                    if(ch=='*' || ch=='-'){
                    grass_array.add(ch);
                    }
                   
                }
      
          System.out.println(grass_array.size());
	   Setup s = new Setup(grass_array);
          s.setup_algorytm(grass_array);
            s.circle_version(grass_array);
         
    }
    
        
    }
        
