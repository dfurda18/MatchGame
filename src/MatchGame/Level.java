package MatchGame;

public class Level {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Level
	//
	// Synopsis				:   This class represents a simple level logic that increases every time a level is 
	//							cleared a number of times.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-05		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private int level;					// Data member representing the current level
	
	private int wins;					// Data member representing the number of wins in the current level
	
	private final int NEEDED = 4;		// The amount of times needed to win before changing levels
	
	public Level () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Level
		//
		// Method parameters	:	void
		//
		// Method return		:	Level A new instance of the class Level.
		//
		// Synopsis				:   Creates a new instance of the Level class setting the initial level to 1 and the
		//							initial wins to 0.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.level = 1;					// Set the initial level to 1
		
		this.wins = 0;					// Set the initial wins to 0
	}
	public int getLevel () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int getLevel
		//
		// Method parameters	:	void
		//
		// Method return		:	int The current level
		//
		// Synopsis				:   Returns the current level.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.level;					// Return the current level
	}
	public int win () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int win
		//
		// Method parameters	:	void
		//
		// Method return		:	int The granted score when beating a level
		//
		// Synopsis				:   Registers a win and returns the score granted for beating a level. The score is
		//							calculated by multiplying the level by 10.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int score = (int)Math.pow(2,this.level-1) * 10;		// Calculate the score
		
		this.wins++;						// Increase the amount of wins
		
		if(wins >= NEEDED) {				// Check is the amount of wins achieved the amount needed to raise level
			
			this.wins = 0;					// Reset the amount of wins
			
			this.level++;					// Increase the level
		}
		return score;						// Return the calculated score
	}
	public int lose () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int lose
		//
		// Method parameters	:	void
		//
		// Method return		:	int The deducted score when losing in a level
		//
		// Synopsis				:   Returns the amount of score that must be deducted when losing a level. For this 
		//							game, it is twenty times the level.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return (int)Math.pow(2,this.level) * 20;				// Return score deducted
	}
}
