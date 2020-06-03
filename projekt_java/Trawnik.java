package trawnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Trawnik extends All_in  {

	protected static String filename;

/*public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("No input file given.");
			return;
		}
*/ public Trawnik() throws FileNotFoundException{
		ArrayList<Character> grass_array = new ArrayList<>();
		File f = new File(filename);
		FileReader fr = new FileReader(f);
		int c = 0;
		char ch;

		// int x = 0;
		// int y = 0;

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
		
		
		/*//grass print
		for(int i = 0; i < y_max; i++)
		{
			for(int j = 0; j < x_max; j++)
			{
				System.out.print(grass_array.get(i * x_max + j ));
			}
			System.out.println();
		}
		*/
		Setup s = new Setup();
		Water w = new Water();
		Sprinkler_file file =new Sprinkler_file();
		s.setup_algorytm(grass_array);
		
		//System.out.println("Rozmiar water_array pierwsze wywolanie");
		//System.out.println(water_array.size());
		w.read_data_from_water_array(grass_array);
		s.circle_version(grass_array, reflection); // jeden albo zero pobiera z GUI czy z odbiciem
		//System.out.println("Rozmiar water_array drugie wywolanie");
		//System.out.println(water_array.size());
		w.read_data_from_water_array_circle(grass_array);
		file.sprinklerFile();

		Bitmap.draw_bitmap();
			

	
	}




}
