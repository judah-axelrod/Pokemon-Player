package pokemon_player;

import java.util.Arrays;

public class Poke {
	public String name;
	public String type1;
	public String type2;
	public String nature;
	public int level = 100;
	public double[] base_stats = new double[6];
	public double[] actual_stats = new double[6];
	public double[] battle_stats = new double[6];
	public double[] ivs = new double[6];
	public double[] evs = new double[6];
	public Node atk_mod = DLL.stat_mods();
	public Node def_mod = DLL.stat_mods();
	public Node spa_mod = DLL.stat_mods();
	public Node spd_mod = DLL.stat_mods();
	public Node spe_mod = DLL.stat_mods();
	public Move[] moveset = new Move[4];
	public String status = "None";
	public int status_turns = 0;
	public Poke(String name, String type1, String type2, String nature, int level, double[] base_stats, double[] ivs, double[] evs) {
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.level = level;
		for (int i=0; i<base_stats.length; i++) {
			this.base_stats[i] = base_stats[i];
			this.ivs[i] = ivs[i];
			this.evs[i] = evs[i];
			if(i == 0) {
				actual_stats[i] = ((2*base_stats[i] + ivs[i] + evs[i]/4)*level)/100 + level + 10;
			}else {
				actual_stats[i] = ((2*base_stats[i] + ivs[i] + evs[i]/4)*level)/100 + 5;
			}
			battle_stats[i] = actual_stats[i];
		}
		if(nature.equalsIgnoreCase("Lonely") || nature.equalsIgnoreCase("Adamant") || nature.equalsIgnoreCase("Brave") || nature.equalsIgnoreCase("Naughty")) { actual_stats[1] = 1.1*actual_stats[1];}
		if(nature.equalsIgnoreCase("Bold") || nature.equalsIgnoreCase("Relaxed") || nature.equalsIgnoreCase("Impish") || nature.equalsIgnoreCase("Lax")) { actual_stats[2] = 1.1*actual_stats[2];}
		if(nature.equalsIgnoreCase("Modest") || nature.equalsIgnoreCase("Quiet") || nature.equalsIgnoreCase("Mild") || nature.equalsIgnoreCase("Rash")) { actual_stats[3] = 1.1*actual_stats[3];}
		if(nature.equalsIgnoreCase("Calm") || nature.equalsIgnoreCase("Gentle") || nature.equalsIgnoreCase("Sassy") || nature.equalsIgnoreCase("Careful")) { actual_stats[1] = 1.1*actual_stats[4];}
		if(nature.equalsIgnoreCase("Timid") || nature.equalsIgnoreCase("Hasty") || nature.equalsIgnoreCase("Jolly") || nature.equalsIgnoreCase("Naive")) { actual_stats[5] = 1.1*actual_stats[5];}
		
		if(nature.equalsIgnoreCase("Bold") || nature.equalsIgnoreCase("Modest") || nature.equalsIgnoreCase("Calm") || nature.equalsIgnoreCase("Timid")) { actual_stats[1] = 0.9*actual_stats[1];}
		if(nature.equalsIgnoreCase("Lonely") || nature.equalsIgnoreCase("Mild") || nature.equalsIgnoreCase("Hasty") || nature.equalsIgnoreCase("Gentle")) { actual_stats[2] = 0.9*actual_stats[2];}
		if(nature.equalsIgnoreCase("Adamant") || nature.equalsIgnoreCase("Jolly") || nature.equalsIgnoreCase("Impish") || nature.equalsIgnoreCase("Careful")) { actual_stats[3] = 0.9*actual_stats[3];}
		if(nature.equalsIgnoreCase("Naive") || nature.equalsIgnoreCase("Rash") || nature.equalsIgnoreCase("Naughty") || nature.equalsIgnoreCase("Lax")) { actual_stats[1] = 0.9*actual_stats[4];}
		if(nature.equalsIgnoreCase("Quiet") || nature.equalsIgnoreCase("Brave") || nature.equalsIgnoreCase("Relaxed") || nature.equalsIgnoreCase("Sassy")) { actual_stats[5] = 0.9*actual_stats[5];}

//		System.out.println("MOVESET INFORMATION");
//		for (int j=0; j<moveset.length; j++) {
//			moveset[j] = new Move(j+1);
//		}
	}
	
	public String toString() {
		return "Poke [name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", nature=" + nature + ", level=" + level + ", base_stats="
				+ Arrays.toString(base_stats) + ", actual_stats=" + Arrays.toString(actual_stats) + ", ivs="
				+ Arrays.toString(ivs) + ", evs="
				+ Arrays.toString(evs) + "]";
	}
}
