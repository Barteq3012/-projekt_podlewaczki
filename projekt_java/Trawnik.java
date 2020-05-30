package trawnik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Trawnik extends all_in {

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("No input file given.");
			return;
		}

		ArrayList<Character> grass_array = new ArrayList<>();
		ArrayList<Integer> final_array = new ArrayList<>();
		File f = new File(args[0]);
		FileReader fr = new FileReader(f);
		int c = 0;
		char ch;

		// int x = 0;
		// int y = 0;

		int x_max = 80;
		int y_max = 40;
		int final_scale = 50;

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


		
		for (int i = 0; i < (x_max * final_scale * y_max * final_scale); i++)
			final_array.add(0);

		for(int i = 0; i < y_max; i++)
		{
			for(int j = 0; j < x_max; j++)
			{
				System.out.print(grass_array.get(i * x_max + j ));
			}
			System.out.println();
		}
		
		Setup s = new Setup();
		Water w = new Water();
		s.setup_algorytm(grass_array);
		

		System.out.println(water_array.size());
		w.read_data_from_water_array(final_array);
		s.circle_version(grass_array);
		w.read_data_from_water_array_circle(final_array);
	}




}
