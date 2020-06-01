package trawnik;

import java.util.ArrayList;
import java.util.List;

public class all_in  {
    protected static final int x_max = 80;
    protected static final  int y_max = 40;
    protected static final int final_scale = 10;
    protected static int cycles  = 10;
    protected static double time  = 1.0;
    static int reflection = 0; //0 bez odbicia, 1 z odbiciem
     
    protected static final int type_360_range = 2;
    protected static final int type_270_range = 3;
    protected static final int type_180_range = 2;
    protected static final int type_90_range = 4;
    protected static final int type_max_range = 4;

    protected static final int type_360_cycles = 1;
    protected static final int type_270_cycles = 2;
    protected static final int type_180_cycles = 3;
    protected static final int type_90_cycles = 4;

    static List <Water_sprinkler> water_array= new ArrayList<>();
    static ArrayList<Double> final_array = new ArrayList<>();
	
    
}
