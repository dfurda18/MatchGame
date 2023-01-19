package MatchGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sequence {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Sequence
	//
	// Synopsis				:   This class represents a Sequence of colors.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-05		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private List<MatchGame.Colors> sequence;			// Data member that represents the sequence
	
	public Sequence () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Sequence
		//
		// Method parameters	:	void
		//
		// Method return		:	Sequence A new instance of the class Sequence.
		//
		// Synopsis				:   Creates a new instance of the Sequence class with an empty sequence.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.sequence = new ArrayList<MatchGame.Colors>();		// Create an empty sequence
	}
	public Sequence (int level) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Sequence
		//
		// Method parameters	:	int The level.
		//
		// Method return		:	Sequence A new instance of the class Sequence.
		//
		// Synopsis				:   Creates a new random instance of the Sequence class with a size higer than the 
		//							level by two.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.sequence = new ArrayList<MatchGame.Colors>();		// Create an empty sequence
		
		Random randomGenerator = new Random();					// Declare and instantiate a Random object
		
																// Loop level + 2 times
		for (int sequenceCounter = 0; sequenceCounter < level+2; sequenceCounter++) {
			
																// Add a random color to the sequence
			this.sequence.add(MatchGame.Colors.values()[randomGenerator.nextInt(MatchGame.Colors.values().length)]);
		}
	}
	public MatchGame.Colors getNumber (int position) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	MatchGame.Colors getNumber
		//
		// Method parameters	:	int The position of the color in the sequence
		//
		// Method return		:	MatchGame.Colors The color in the specified position.
		//
		// Synopsis				:   Returns the color in the sequence that is located in the specified position.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.sequence.get(position);				// Return the sequence's element in the specified position
	}
	public int length () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int length
		//
		// Method parameters	:	void
		//
		// Method return		:	int The sequence's length.
		//
		// Synopsis				:   Returns this sequence's length.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.sequence.size();				// Return the sequence length
	}
	public void add(MatchGame.Colors color) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void add
		//
		// Method parameters	:	MatchGame.Colors The color to add to the sequence.
		//
		// Method return		:	void
		//
		// Synopsis				:   Adds a color to the sequence.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.sequence.add(color);					// Add the color to the sequence
	}
	public boolean equals(Sequence otherSequence) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	boolean equals
		//
		// Method parameters	:	Sequence The sequence to compare with.
		//
		// Method return		:	boolean True if both sequences are equal.
		//
		// Synopsis				:   Compares two sequences and returns true if the sequences are equal.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if (this.length() != otherSequence.length()) {		// Check if both sequences have the same length
			
			return false;									// Return false if they dont
		}
															// Loop through the sequence
		for (int sequenceCounter = 0; sequenceCounter < this.sequence.size(); sequenceCounter++) {
			
															// Check if the elements are different
			if(this.getNumber(sequenceCounter) != otherSequence.getNumber(sequenceCounter)) {
				
				return false;								// Return false if they are different
			}
		}
		return true;										// Return true if all elements are equal
	}
}
