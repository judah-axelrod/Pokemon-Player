package pokemon_player;

import java.util.*;

public class Battle {
	public static void main(String[] args) {
		HashMap<String,Poke> pokedex = Pokedex.Dex();
		HashMap<String,Move> attackdex = AttackDex.Dex();
		
		//Choose pokemon
		Poke poke1 = pokedex.get("Venusaur");
		Poke poke2 = pokedex.get("Charizard");
		//Choose moves
		poke1.moveset[0] = attackdex.get("Mega Drain");
		poke1.moveset[1] = attackdex.get("Sleep Powder");
		poke1.moveset[2] = attackdex.get("Toxic");
		poke1.moveset[3] = attackdex.get("Body Slam");
		
		poke2.moveset[0] = attackdex.get("Fire Blast");
		poke2.moveset[1] = attackdex.get("Bulk Up");
		poke2.moveset[2] = attackdex.get("Fake Tears");
		poke2.moveset[3] = attackdex.get("Body Slam");
		
		
		
		Poke faster_poke, slower_poke;
		int turn = 1;
		do {
			System.out.println("Turn "+turn+":");
			if(poke1.battle_stats[5] >= poke2.battle_stats[5]){ 
				faster_poke = poke1;
				slower_poke = poke2;
			}else {
				faster_poke = poke2;
				slower_poke = poke1;
			}
			BattleTurn.Turn(faster_poke, slower_poke);
			
			if(faster_poke.battle_stats[0] > 0 && slower_poke.battle_stats[0] > 0)	{
				BattleTurn.Turn(slower_poke, faster_poke);
			}
			turn++;
			Status.StatusDamage(faster_poke, slower_poke);
		} while(faster_poke.battle_stats[0] > 0 && slower_poke.battle_stats[0] > 0);
		
		if(faster_poke.battle_stats[0] == 0) {
			System.out.println(faster_poke.name + " has fainted!");
		}else {
			System.out.println(slower_poke.name + " has fainted!");
		}
			
	}
}
