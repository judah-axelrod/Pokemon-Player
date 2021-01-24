package pokemon_player;

public class Status {
	public static void Paralyze(Poke statused_poke) {
		if(statused_poke.type1 == "Electric" || statused_poke.type2 == "Electric" || statused_poke.type1 == "Ground" || statused_poke.type2 == "Ground") { return;}
		statused_poke.status = "PAR";
		statused_poke.battle_stats[5] *= 0.5;
	}
	
	public static void Burn(Poke statused_poke) {
		if(statused_poke.type1 == "Fire" || statused_poke.type2 == "Fire") {return;}
		statused_poke.status = "BRN";
		statused_poke.battle_stats[1] *= 0.5;
	}
	
	public static void Poison(Poke statused_poke) {
		if(statused_poke.type1 == "Poison" || statused_poke.type2 == "Poison" || statused_poke.type1 == "Steel" || statused_poke.type2 == "Steel") { return;}
		statused_poke.status = "PSN";
	}
	
	public static void BadPoison(Poke statused_poke) {
		if(statused_poke.type1 == "Poison" || statused_poke.type2 == "Poison" || statused_poke.type1 == "Steel" || statused_poke.type2 == "Steel") { return;}
		statused_poke.status = "TXC";
	}
	
	public static void LeechSeed(Poke statused_poke) {
		if(statused_poke.type1 == "Grass" || statused_poke.type2 == "Grass") {return;}
		statused_poke.status = "SEED";
	}
	
	public static void Sleep(Poke statused_poke) {
		statused_poke.status = "SLP";
	}
	
	
	public static void StatusDamage(Poke attack_poke, Poke defend_poke) {
		if(attack_poke.status == "BRN") {
			attack_poke.battle_stats[0] -= (double)(attack_poke.actual_stats[0])/16;
			System.out.println("\n" + attack_poke.name + " is hurt by burn.");
		}else if(attack_poke.status == "PSN") {
			attack_poke.battle_stats[0] -= (double)(attack_poke.actual_stats[0])/8;
			System.out.println("\n" + attack_poke.name + " is hurt by poison.");
		}else if(attack_poke.status == "TXC") {
			attack_poke.status_turns++;
			attack_poke.battle_stats[0] -= (double)(attack_poke.actual_stats[0])/(attack_poke.status_turns*16);
			System.out.println("\n" + attack_poke.name + " is hurt by poison.");
		}else if(attack_poke.status == "SEED") {
			attack_poke.battle_stats[0] -= (double)(attack_poke.actual_stats[0])/8;
			defend_poke.battle_stats[0] += (double)(defend_poke.actual_stats[0])/8;
			System.out.println("\n" + attack_poke.name + "'s health is sapped by Leech Seed.");
		}		
		if(defend_poke.status == "BRN") {
			defend_poke.battle_stats[0] -= (double)(defend_poke.actual_stats[0])/16;
			System.out.println("\n" + defend_poke.name + " is hurt by burn.");
		}else if(defend_poke.status == "PSN") {
			defend_poke.battle_stats[0] -= (double)(defend_poke.actual_stats[0])/8;
			System.out.println("\n" + defend_poke.name + " is hurt by poison.");
		}else if(defend_poke.status == "TXC") {
			defend_poke.status_turns++;
			defend_poke.battle_stats[0] -= (double)(defend_poke.actual_stats[0])/(defend_poke.status_turns*16);
			System.out.println("\n" + defend_poke.name + " is hurt by poison.");
		}else if(defend_poke.status == "SEED") {
			defend_poke.battle_stats[0] -= (double)(defend_poke.actual_stats[0])/8;
			attack_poke.battle_stats[0] += (double)(attack_poke.actual_stats[0])/8;
			System.out.println("\n" + defend_poke.name + "'s health is sapped by Leech Seed.");
		}
	}
}
