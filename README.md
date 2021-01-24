# Pokemon-Player
This is a work-in-progress Java project that allows one or two users to access a 1-vs-1 text-based Pokemon battler through the **Battle.java** file. Here is a walkthrough of all the files in the pokemon_player folder:
- **Battle.java** is the battle interface. Users can enter their pokemon and their pokemon's moves and then proceed to battle until one faints.
- **BattleTurn.java** runs through one iteration of a turn in battle (where both pokemon get to attack once).
- **Poke.java** is the Pokemon class that currently has all relevant attributes that can affect a Pokemon in battle (Stats, Moves, Nature, Type(s), EVs, IVs, etc.)
- **Move.java** is the Move class that has relevant attributes about pokemon's attacks (Type, Power, Accuracy, Class)
- **Pokedex.java** is where the full list of Pokemon is housed. Currently only a few pokemon are entered, but the user can easily enter any others by following the same format. The user needs to enter the following information about a pokemon to do this: Name, Type(s), Base Stats, Nature, EVs/IVs, Level, Pokedex Number from the canon games
- **Attackdex.java** is where the full list of Attacks are housed. Again, only a limited number of moves are currently entered, but the user can easily enter any others by following the same format. They need to enter: Name, Type, Power, Accuracy, Move Class (Phsyical, Special, or Status), and what type of modification it does if a Status move
- **StatMoves.java** is a helper class for attacks that affect a pokemon's stats
- **Status.java** is a helper class for attacks that induce status effects in battle. Currently supported statuses are: Paralysis, Poison, Bad Poison, Sleep, Leech Seed, Burn. Freeze still needs to be added, as well as a few minor statuses that correspond to moves that haven't been added yet either.
- **Modifiers.java** is a helper class that houses all types of modifiers that affect battle damage, i.e. Same-Type Attack Bonus (STAB) and Type Advantage/Disadvantage. (Fairy type is included in this.)
- **IO.java** is a helper class that allows for text input and output
- **Node.java** and **DLL.java** are Node and Double-Linked List data structures that are used throughout the program.

## Next Steps/Still in Progress
1. I am currently working on incorporating .csv data on Pokemon, Attacks, Status and Modification types. The data cleaning will be done in R and incorporated into the respective classes, likely using the Scanner class.
2. I would like to extend functionality so that each user can have multiple pokemon and switch them in and out.
3. I would like to also incorporate Pokemon Abilities into the battler, which will definitely introduce a lot of complexity.
