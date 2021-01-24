package pokemon_player;
//import java.util.Random;

public class BattleTurn {
	public static void Turn(Poke attack_poke, Poke defend_poke) {

		//////////////Attacking poke moves
		double random = 100*Math.random();
		System.out.println("Enter move for " + attack_poke.name + ": \n" + attack_poke.moveset[0].name +
				"\t" + attack_poke.moveset[1].name + "\n" + attack_poke.moveset[2].name + "\t" + attack_poke.moveset[3].name + "\n");
		String move_choice = IO.readString();
		int moveslot = 0;
		move_loop:
		while(true) {
			for(int i=0; i<4; i++) {
				if(move_choice.equalsIgnoreCase(attack_poke.moveset[i].name)) {
					moveslot = i;
					break move_loop;
				}
			}
			System.out.println("Enter a valid move");
			move_choice = IO.readString();
		}
		//Check if statused and cannot move
		if(attack_poke.status == "PAR") {
			random = 100*Math.random();
			if(random <= 25) {
				System.out.println("\n" + attack_poke.name + " is paralyzed. It cannot move!");
				return;
			}
		}
		else if(attack_poke.status == "SLP") {
			random = 100*Math.random();
			if(random <= (double)(100/3) || attack_poke.status_turns >= 3) {
				attack_poke.status = "None";
				attack_poke.status_turns = 0;
				System.out.println("\n" + attack_poke.name + " woke up!");
			}else {
				System.out.println("\n" + attack_poke.name + " is fast asleep.");
				attack_poke.status_turns++;
			}
		}
		//Determine damage pre-modifiers
		double damage = 0;
		double percent_damage = 0;
		double percent_health = 0;
		String[] stats = {"HP", "Attack", "Defense", "Sp. Atk", "Sp. Def", "Speed"};
		Move atk_move = attack_poke.moveset[moveslot];
//DAMAGING MOVE
		if (atk_move.classification == "Physical") {
			if(random <= atk_move.accuracy) {
				damage = (double)((0.4*attack_poke.level + 2) * atk_move.power * attack_poke.battle_stats[1] / defend_poke.battle_stats[2]) / 50 + 2;
			}else {
				damage = 0;
				System.out.println("\n" + attack_poke.name + " missed!");
			}
		}else if(atk_move.classification == "Special"){
			if(random <= atk_move.accuracy) {
				damage = (double)((0.4*attack_poke.level + 2) * atk_move.power * attack_poke.battle_stats[3] / defend_poke.battle_stats[4]) / 50 + 2;
			}else {
				damage = 0;
				System.out.println("\n" + attack_poke.name + " missed!");
				return;
			}
//STAT MOVE
		}else if(atk_move.classification == "Stat") {
			StatMoves.StatChange(attack_poke, defend_poke, atk_move);
				//Attacking poke stat changes
				attack_poke.battle_stats[1] = attack_poke.actual_stats[1]*attack_poke.atk_mod.data;
				attack_poke.battle_stats[2] = attack_poke.actual_stats[2]*attack_poke.def_mod.data;
				attack_poke.battle_stats[3] = attack_poke.actual_stats[3]*attack_poke.spa_mod.data;
				attack_poke.battle_stats[4] = attack_poke.actual_stats[4]*attack_poke.spd_mod.data;
				attack_poke.battle_stats[5] = attack_poke.actual_stats[5]*attack_poke.spe_mod.data;
				//Defending poke stat changes
				defend_poke.battle_stats[1] = defend_poke.actual_stats[1]*defend_poke.atk_mod.data;
				defend_poke.battle_stats[2] = defend_poke.actual_stats[2]*defend_poke.def_mod.data;
				defend_poke.battle_stats[3] = defend_poke.actual_stats[3]*defend_poke.spa_mod.data;
				defend_poke.battle_stats[4] = defend_poke.actual_stats[4]*defend_poke.spd_mod.data;
				defend_poke.battle_stats[5] = defend_poke.actual_stats[5]*defend_poke.spe_mod.data;
				
//STATUS MOVE			
		}else if(atk_move.classification == "Status") {
			if(atk_move.status == "PAR") {
				random = 100*Math.random();
				if(defend_poke.status == "PAR") {
					System.out.println("\n" + defend_poke.name + " is already paralyzed.");
					return;
				}else if(defend_poke.status != "None") {
					System.out.println("\n But it failed!");
					return;
				}
				if(random <= atk_move.accuracy) {
					Status.Paralyze(defend_poke);
					System.out.println("\n" + defend_poke.name + " was paralyzed!");
					return;
				}else {
					System.out.println("\n" + attack_poke.name + " missed!");
					return;
				}
			}else if(atk_move.status == "BRN") {
				random = 100*Math.random();
				if(defend_poke.status == "BRN") {
					System.out.println("\n" + defend_poke.name + " is already burned.");
					return;
				}else if(defend_poke.status != "None") {
					System.out.println("\n But it failed!");
					return;
				}
				if(random <= atk_move.accuracy) {
					Status.Burn(defend_poke);
					System.out.println("\n" + defend_poke.name + " was burned!");
					return;
				}else {
					System.out.println("\n" + attack_poke.name + " missed!");
					return;
				}
			}else if(atk_move.status == "PSN" || atk_move.status == "TXC") {
				random = 100*Math.random();
				if(defend_poke.status == "PSN" || defend_poke.status == "TXC") {
					System.out.println("\n" + defend_poke.name + " is already poisoned.");
					return;
				}else if(defend_poke.status != "None") {
					System.out.println("\n But it failed!");
					return;
				}
				if(random <= atk_move.accuracy) {
					if(atk_move.status == "PSN") {
						Status.Poison(defend_poke);
						System.out.println("\n" + defend_poke.name + " was poisoned!");
					}else {
						Status.BadPoison(defend_poke);
						System.out.println("\n" + defend_poke.name + " was badly poisoned!");
					}
					return;
				}else {
					System.out.println("\n" + attack_poke.name + " missed!");
					return;
				}
			}else if(atk_move.status == "SEED") {
				random = 100*Math.random();
				if(defend_poke.status == "SEED") {
					System.out.println("\n" + defend_poke.name + " is already seeded.");
					return;
				}
				if(random <= atk_move.accuracy) {
					Status.LeechSeed(defend_poke);
					System.out.println("\n" + defend_poke.name + " was seeded!");
					return;
				}else {
					System.out.println("\n" + defend_poke.name + " evaded the attack.");
					return;
				}
			}else if(atk_move.status == "SLP") {
				random = 100*Math.random();
				if(defend_poke.status == "SLP") {
					System.out.println("\n" + defend_poke.name + " is already asleep.");
					return;
				}else if(defend_poke.status != "None") {
					System.out.println("\n But it failed!");
					return;
				}
				if(random <= atk_move.accuracy) {
					Status.Sleep(defend_poke);
					System.out.println("\n" + defend_poke.name + " fell asleep!");
					return;
				}else {
					System.out.println("\n" + attack_poke.name + " missed!");
					return;
				}
			}
		}
		//Apply modifiers
		if(atk_move.classification == "Physical" || atk_move.classification == "Special") {	
			double mod = Modifiers.modifier(attack_poke.type1, attack_poke.type2, defend_poke.type1, defend_poke.type2, atk_move.type);
			if (mod == 0 ) {
				System.out.println("\n" + atk_move.name + " doesn't affect " + defend_poke.name + ".");
			}
			else if (mod < 1) { 
				System.out.println("\nIt's not very effective.");
			}
			else if (mod > 2) { 
				System.out.println("\nIt's super effective!");
			}	
			random = 100*Math.random();
			if(random <= 4.166667) {
				mod = 1.5*mod;
				System.out.println("\nA critical hit!");
			}
			damage = Math.round(damage*mod);
			defend_poke.battle_stats[0] -= damage;
			percent_damage = Math.round((double)100*damage / defend_poke.actual_stats[0]);
			if(defend_poke.battle_stats[0] < 0) { defend_poke.battle_stats[0] = 0;}
			percent_health = Math.round((double)100*defend_poke.battle_stats[0] / defend_poke.actual_stats[0]);
			if(damage > 0) {
				System.out.println("\n" + attack_poke.name + "'s " + atk_move.name + " did " + Math.round(damage) + " (" + Math.round(percent_damage) + "%) damage.");
				System.out.println("\n" + defend_poke.name + " has " + Math.round(defend_poke.battle_stats[0]) + "/" + Math.round(defend_poke.actual_stats[0]) + " (" + Math.round(percent_health) +"%) HP.\n");
			}
		}
	}
}
