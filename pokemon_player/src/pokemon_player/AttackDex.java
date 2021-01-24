package pokemon_player;

import java.util.HashMap;

public class AttackDex {
	public static HashMap<String,Move> Dex() {
			
			HashMap<String,Move> attackdex = new HashMap<String,Move>();
			
			
			//Parameters: Name, Type, Power, Accuracy, Physical?
			
			//Surf
			Move Surf = new Move("Surf", "Water", 95, 100, "Special");
			attackdex.put("Surf", Surf);
//			System.out.println(attackdex.get("Surf"));
			
			//Earthquake
			Move Earthquake = new Move("Earthquake", "Ground", 100, 100, "Physical");
			attackdex.put("Earthquake", Earthquake);
			
			//Fire Blast
			Move Fire_Blast = new Move("Fire Blast", "Fire", 110, 85, "Special");
			attackdex.put("Fire Blast", Fire_Blast);
			
			//Giga Drain
			Move Giga_Drain = new Move("Giga Drain", "Grass", 75, 100, "Special");
			attackdex.put("Giga Drain", Giga_Drain);
			
			//Water Gun
			Move Water_Gun = new Move("Water Gun", "Water", 40, 100, "Special");
			attackdex.put("Water Gun", Water_Gun);
			
			//Ember
			Move Ember = new Move("Ember", "Fire", 40, 100, "Special");
			attackdex.put("Ember", Ember);
			
			//Mega Drain
			Move Mega_Drain = new Move("Mega Drain", "Grass", 40, 100, "Special");
			attackdex.put("Mega Drain", Mega_Drain);
			
			//Test
			Move test_move = new Move("TEST", "Normal", 10, 10, "Physical");
			attackdex.put("TEST",test_move);
			
			//Air Slash
			Move Air_Slash = new Move("Air Slash", "Flying", 75, 95, "Special");
			attackdex.put("Air Slash",Air_Slash);
			
			//Sludge Bomb
			Move Sludge_Bomb = new Move("Sludge Bomb", "Poison", 90, 100, "Special");
			attackdex.put("Sludge Bomb",Sludge_Bomb);
			
			//Body Slam
			Move Body_Slam = new Move("Body Slam", "Normal", 85, 100, "Physical");
			attackdex.put("Body Slam",Body_Slam);
			
			//Bulk Up
			Move Bulk_Up = new Move("Bulk Up", "Fighting", 0, 100, "Stat");
			Bulk_Up.stat_mod = "Atk+1, Def+1";
			attackdex.put("Bulk Up", Bulk_Up);
			
			//Fake Tears
			Move Fake_Tears = new Move("Fake Tears", "Dark", 0, 100, "Stat");
			Fake_Tears.stat_mod = "Spd-2";
			attackdex.put("Fake Tears", Fake_Tears);
			
			//Growl
			Move Growl = new Move("Growl", "Normal", 0, 100, "Stat");
			Growl.stat_mod = "Atk-1";
			attackdex.put("Growl", Growl);
			
			//Stun Spore
			Move Stun_Spore = new Move("Stun Spore", "Grass", 0, 75, "Status");
			Stun_Spore.status = "PAR";
			attackdex.put("Stun Spore", Stun_Spore);
			
			//Sleep Powder
			Move Sleep_Powder = new Move("Sleep Powder", "Grass", 0, 75, "Status");
			Sleep_Powder.status = "SLP";
			attackdex.put("Sleep Powder", Sleep_Powder);
			
			//Toxic
			Move Toxic = new Move("Toxic", "Poison", 0, 90, "Status");
			Toxic.status = "TXC";
			attackdex.put("Toxic", Toxic);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			return attackdex;
		}
}
