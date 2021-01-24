package pokemon_player;
import java.util.*;

public class Modifiers {
	public static double modifier(String atk_type1, String atk_type2, String def_type1, String def_type2, String move_type) {
		double mod = 1.0;
		double[][] typechart = TypeChart();
		HashMap<Integer,String> typemap = new HashMap<Integer,String>();
		String[] types = {"Normal","Fire","Water","Electric","Grass","Ice","Fighting","Poison","Ground","Flying","Psychic","Bug","Rock","Ghost","Dragon","Dark","Steel","Fairy"};
		
		for (int i=0; i<types.length; i++) {
			typemap.put(i, types[i]);
		}
		//STAB
		if (atk_type1.equalsIgnoreCase(move_type) || atk_type2.equalsIgnoreCase(move_type)) {
			mod = 1.5*mod;
		}
		//Type Advantage
		for(int t = 0; t<typechart.length; t++) {
			for(int u = 0; u<typechart.length; u++) {
				if(typemap.get(t).equalsIgnoreCase(move_type) && (typemap.get(u).equalsIgnoreCase(def_type1) ||
					typemap.get(u).equalsIgnoreCase(def_type2))){
						mod = mod*typechart[t][u];
				}
			}
		}

		return mod;
	}
	
	//Type chart
	public static double[][] TypeChart(){
			HashMap<Integer,String> typemap = new HashMap<Integer,String>();
			String[] types = {"Normal","Fire","Water","Electric","Grass","Ice","Fighting","Poison","Ground","Flying","Psychic","Bug","Rock","Ghost","Dragon","Dark","Steel","Fairy"};
			
			for (int i=0; i<types.length; i++) {
				typemap.put(i, types[i]);
			}
			double[][] typechart = new double[types.length][types.length];
			for (int p = 0; p<typechart.length; p++) {
				for (int q = 0; q<typechart.length; q++) {
					typechart[p][q] = 1.0;
					if(typemap.get(p).equalsIgnoreCase("Normal")){
						if(typemap.get(q).equalsIgnoreCase("Rock") || typemap.get(q).equalsIgnoreCase("Steel")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Ghost")) { typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Fire")){
						if(typemap.get(q).equalsIgnoreCase("Grass") || typemap.get(q).equalsIgnoreCase("Bug") ||
							typemap.get(q).equalsIgnoreCase("Steel") || typemap.get(q).equalsIgnoreCase("Ice")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Water") || typemap.get(q).equalsIgnoreCase("Rock") ||
							typemap.get(q).equalsIgnoreCase("Dragon") || typemap.get(q).equalsIgnoreCase("Fire")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Water")){
						if(typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Rock") ||
							typemap.get(q).equalsIgnoreCase("Ground")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Water") || typemap.get(q).equalsIgnoreCase("Grass") ||
							typemap.get(q).equalsIgnoreCase("Dragon")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Electric")){
						if(typemap.get(q).equalsIgnoreCase("Water") || typemap.get(q).equalsIgnoreCase("Flying")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Grass") || typemap.get(q).equalsIgnoreCase("Electric") ||
							typemap.get(q).equalsIgnoreCase("Dragon")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Ground")) { typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Grass")){
						if(typemap.get(q).equalsIgnoreCase("Water") || typemap.get(q).equalsIgnoreCase("Rock") ||
							typemap.get(q).equalsIgnoreCase("Ground")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Grass") || typemap.get(q).equalsIgnoreCase("Bug") ||
							typemap.get(q).equalsIgnoreCase("Steel") || typemap.get(q).equalsIgnoreCase("Dragon") ||
							typemap.get(q).equalsIgnoreCase("Poison") || typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Flying")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Ice")){
						if(typemap.get(q).equalsIgnoreCase("Dragon") || typemap.get(q).equalsIgnoreCase("Flying") ||
							typemap.get(q).equalsIgnoreCase("Grass") || typemap.get(q).equalsIgnoreCase("Ground")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Water") || typemap.get(q).equalsIgnoreCase("Ice") ||
							typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Steel")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Fighting")){
						if(typemap.get(q).equalsIgnoreCase("Normal") || typemap.get(q).equalsIgnoreCase("Rock") ||
							typemap.get(q).equalsIgnoreCase("Dark") || typemap.get(q).equalsIgnoreCase("Steel") ||
							typemap.get(q).equalsIgnoreCase("Ice")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Psychic") || typemap.get(q).equalsIgnoreCase("Bug") ||
							typemap.get(q).equalsIgnoreCase("Fairy") || typemap.get(q).equalsIgnoreCase("Flying") || typemap.get(q).equalsIgnoreCase("Poison")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Ghost")) {typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Poison")){
						if(typemap.get(q).equalsIgnoreCase("Fairy") || typemap.get(q).equalsIgnoreCase("Grass")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Ghost") || typemap.get(q).equalsIgnoreCase("Rock") ||
							typemap.get(q).equalsIgnoreCase("Ground") || typemap.get(q).equalsIgnoreCase("Poison")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Ground")){
						if(typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Poison") ||
							typemap.get(q).equalsIgnoreCase("Rock") || typemap.get(q).equalsIgnoreCase("Steel") || typemap.get(q).equalsIgnoreCase("Electric")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Bug") || typemap.get(q).equalsIgnoreCase("Grass")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Flying")) {typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Flying")){
						if(typemap.get(q).equalsIgnoreCase("Grass") || typemap.get(q).equalsIgnoreCase("Bug") ||
							typemap.get(q).equalsIgnoreCase("Fighting")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Electric") || typemap.get(q).equalsIgnoreCase("Steel") ||
							typemap.get(q).equalsIgnoreCase("Rock")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Psychic")){
						if(typemap.get(q).equalsIgnoreCase("Poison") || typemap.get(q).equalsIgnoreCase("Fighting")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Steel") || typemap.get(q).equalsIgnoreCase("Psychic") ||
							typemap.get(q).equalsIgnoreCase("Fairy") || typemap.get(q).equalsIgnoreCase("Flying") || typemap.get(q).equalsIgnoreCase("Poison")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Dark")) {typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Bug")){
						if(typemap.get(q).equalsIgnoreCase("Grass") || typemap.get(q).equalsIgnoreCase("Psychic") ||
							typemap.get(q).equalsIgnoreCase("Dark")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Fairy") || typemap.get(q).equalsIgnoreCase("Fighting") || typemap.get(q).equalsIgnoreCase("Flying") || typemap.get(q).equalsIgnoreCase("Ghost") ||
							typemap.get(q).equalsIgnoreCase("Steel") || typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Poison")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Rock")){
						if(typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Ice") ||
							typemap.get(q).equalsIgnoreCase("Bug") || typemap.get(q).equalsIgnoreCase("Flying")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Steel") || typemap.get(q).equalsIgnoreCase("Fighting") ||
							typemap.get(q).equalsIgnoreCase("Ground")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Ghost")){
						if(typemap.get(q).equalsIgnoreCase("Psychic") || typemap.get(q).equalsIgnoreCase("Ghost")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Dark")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Normal")) {typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Dragon")){
						if(typemap.get(q).equalsIgnoreCase("Dragon")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Steel")) { typechart[p][q] = 0.5;}
						else if (typemap.get(q).equalsIgnoreCase("Fairy")) {typechart[p][q] = 0;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Dark")){
						if(typemap.get(q).equalsIgnoreCase("Psychic") || typemap.get(q).equalsIgnoreCase("Ghost")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Dark") || typemap.get(q).equalsIgnoreCase("Fighting") ||
							typemap.get(q).equalsIgnoreCase("Fairy")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Steel")){
						if(typemap.get(q).equalsIgnoreCase("Rock") || typemap.get(q).equalsIgnoreCase("Ice") ||
							typemap.get(q).equalsIgnoreCase("Fairy")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Water") || typemap.get(q).equalsIgnoreCase("Electric") ||
							typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Steel")) { typechart[p][q] = 0.5;}
					}
					else if(typemap.get(p).equalsIgnoreCase("Fairy")){
						if(typemap.get(q).equalsIgnoreCase("Dark") || typemap.get(q).equalsIgnoreCase("Fighting") ||
							typemap.get(q).equalsIgnoreCase("Dragon")) { typechart[p][q] = 2.0;}
						else if (typemap.get(q).equalsIgnoreCase("Fire") || typemap.get(q).equalsIgnoreCase("Steel") ||
							typemap.get(q).equalsIgnoreCase("Poison")) { typechart[p][q] = 0.5;}
					}					
				}
			}
			return typechart;
	}
	
	
	
	//TESTING CODE
	public static void main(String[] args) {
		
		double mod = modifier("Dragon", "Steel", "Fairy", "Fire", "Dragon");
		System.out.println(mod);
	}
}