package trawnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Trawnik extends All_in  {

	protected static String filename;

public Trawnik() throws FileNotFoundException{
		ArrayList<Character> grass_array = new ArrayList<>();
		File f = new File(filename);
		FileReader fr = new FileReader(f);
		int c = 0;
		char ch;

		int x_max = 80;
		int y_max = 40;
		int final_scale = 10;

		try (BufferedReader br = new BufferedReader(fr)) 
		{ 
			
			//konstrukcja try-with-resources
			while ((c = br.read()) != -1) {
				ch = (char) c;
				if (ch == '*' || ch == '-') {
					grass_array.add(ch);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int j = 0; j < (x_max * final_scale * y_max * final_scale); j++)
			final_array.add(0.0);
		
	
		Setup s = new Setup();
		Water w = new Water();
		Sprinkler_file file =new Sprinkler_file();
		s.setup_algorytm(grass_array);
		
		w.read_data_from_water_array(grass_array);
		s.circle_version(grass_array, reflection); // wartosc reflection jeden albo zero pobiera z GUI, decyduje czy z odbiciem

		w.read_data_from_water_array_circle(grass_array);
		file.sprinklerFile();

		Bitmap.draw_bitmap();
			

	
	}




}
