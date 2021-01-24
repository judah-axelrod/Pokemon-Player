package pokemon_player;
import java.util.*;

public class Pokedex {
	public static HashMap<String,Poke> Dex() {
		
		double[] ivs = {31,31,31,31,31,31};
		double[] evs = {0,0,0,0,0,0};
		
		HashMap<String,Poke> pokedex = new HashMap<String,Poke>();
		
		//Parameters: Name, Type1, Type2, Nature, Level, Base Stats, IVs
		
		//003
		double[]  base_stats003 = {80,82,83,100,100,80};
		String nature003 = "Hardy";
		Poke Venusaur = new Poke("Venusaur", "Grass", "Poison", nature003, 100, base_stats003, ivs, evs);
		pokedex.put("Venusaur", Venusaur);
//		System.out.println(pokedex.get("Venusaur"));
		
		//006
		double[]  base_stats006 = {78,84,78,109,85,100};
		String nature006 = "Hardy";
		Poke Charizard = new Poke("Charizard", "Fire", "Flying", nature006, 100, base_stats006, ivs, evs);
		pokedex.put("Charizard", Charizard);
		
		//009
		double[] base_stats009 = {79,83,100,85,105,78};
		String nature009 = "Hardy";
		Poke Blastoise = new Poke("Blastoise", "Water", "None", nature009, 100, base_stats009, ivs, evs);
		pokedex.put("Blastoise", Blastoise);
		
		//152
		double[] base_stats152 = {45,49,65,49,65,45};
		String nature152 = "Hardy";
		Poke Chikorita = new Poke("Chikorita", "Grass", "None", nature152, 5, base_stats152, ivs, evs);
		pokedex.put("Chikorita", Chikorita);
		
		
		
		return pokedex;
	}
}
