package pokemon_player;

//import java.util.Arrays;

public class Move {
	public String name;
	public String type;
	public double power;
	public double accuracy;
	public String classification;
	public Poke user;
	public String stat_mod = "";
//	public double[] stat_mod_user_num = new double[]{0,0,0,0,0,0};
//	public double[] stat_mod_user_denom = new double[]{0,0,0,0,0,0};
//	public double[] stat_mod_target_num = new double[]{0,0,0,0,0,0};
//	public double[] stat_mod_target_denom = new double[]{0,0,0,0,0,0};
	public String status = "None";
	public Move(String name, String type, double power, double accuracy, String classification) {
		this.name = name;
		this.type = type;
		this.power = power;
		this.accuracy = accuracy;
		this.classification = classification;	
	}
	
	public String toString() {
		return "Move [name=" + name + ", type=" + type + ", power=" + power + ", accuracy=" + accuracy + ", classification="
				+ classification + "]";
	}
	
}
