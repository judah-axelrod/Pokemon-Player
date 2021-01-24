package pokemon_player;



public class StatMoves {
	
	//Build dex of stat moves
	
	public static void StatChange(Poke atk_poke, Poke def_poke, Move move) {
		if(move.stat_mod == "Atk-1") {
			if(def_poke.atk_mod.prev!=null) {
				def_poke.atk_mod = def_poke.atk_mod.prev;
				System.out.println(def_poke.name + "'s Attack Fell!");
			}else {
				System.out.println(def_poke.name + "'s Attack Can't Go Lower!");
			}
		}
		else if(move.stat_mod == "Atk+1") {
			if(atk_poke.atk_mod.prev!=null) {
				atk_poke.atk_mod = atk_poke.atk_mod.next;
				System.out.println(atk_poke.name + "'s Attack Rose!");
			}else {
				System.out.println(atk_poke.name + "'s Attack Can't Go Higher!");
			}
		}
		else if(move.stat_mod == "Atk+1, Def+1") {
			if(atk_poke.atk_mod.next!=null) {
				atk_poke.atk_mod = atk_poke.atk_mod.next;
				System.out.println(atk_poke.name + "'s Attack Rose!");
			}else {
				System.out.println(atk_poke.name + "'s Attack Can't Go Any Higher!");
			}
			if(atk_poke.def_mod.next!=null) {
				atk_poke.def_mod = atk_poke.def_mod.next;
				System.out.println(atk_poke.name + "'s Defense Rose!");
			}else {
				System.out.println(atk_poke.name + "'s Defense Can't Go Any Higher!");
			}
		}
		else if(move.stat_mod == "Spd-2") {
			if(def_poke.spd_mod.prev!=null) {
				if(def_poke.spd_mod.prev.prev!=null) {
					def_poke.spd_mod = def_poke.spd_mod.prev.prev;
					System.out.println(def_poke.name + "'s Sp. Defense Harshly Fell!");
				}else {
					def_poke.spd_mod = def_poke.spd_mod.prev;
					System.out.println(def_poke.name + "'s Sp. Defense Harshly Fell!");
				}
			}else {
				System.out.println(def_poke.name + "'s Sp. Defense Can't Go Any Lower!");
			}
			

		}
		
		
		return;
	}
	
	
	
}
