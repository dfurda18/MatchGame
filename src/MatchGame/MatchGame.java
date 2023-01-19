package MatchGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import GameInterface.GameAction;

public class MatchGame implements ActionListener {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	MatchGame
	//
	// Synopsis				:   This class represents a MatchGame.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-05		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	public static enum Colors {RED, GREEN, YELLOW, BLUE};				// The enum that represents the colors
	
	public static enum Sounds {RED, GREEN, YELLOW, BLUE, WIN, LOSE};	// The enum that represents the sounds
	
	private static int FRAME_TIME = 500;								// The wait time between  displaying the sequence
	
	private static int BUTTON_PRESSED_TIME = 300;						// The wait time to light a pushed button
	
	private Level level;												// The level tracker
	
	private int sequenceCounter;										// Data member to keep track of the sequence
	
	private boolean sequenceToggle = true;								// Flag to toggle the on/off of the sequences
	
	private Timer sequenceTimer;										// The timer user to show the sequence
	
	private Sequence gameSequence;										// The game sequence
	
	private Sequence userSequence;										// The player's sequence
	
	private HiScore score;												// The score tracker
	
	private SoundManager soundManager;									// The sound manger
	
	public static void main(String[] args) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void main
		//
		// Method parameters	:	String[] The command line parameters (not used).
		//
		// Method return		:	void
		//
		// Synopsis				:   Initial method called when starting the application.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGame game = new MatchGame();			// Create a new MatchGame object
		
		game.startGame();							// Start the game
	}
	
	public void startGame() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void startGame
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets up all the variables, shows the interface in the initial state.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.soundManager = new SoundManager();					// Initialize the sound manager
		
		this.soundManager.addSound("/audios/Beep1.wav");			// Add the first beep
		
		this.soundManager.addSound("/audios/Beep2.wav");			// Add the second beep
		
		this.soundManager.addSound("/audios/Beep3.wav");			// Add the third beep
		
		this.soundManager.addSound("/audios/Beep4.wav");			// Add the fourth beep
		
		this.soundManager.addSound("/audios/Win.wav");			// Add the winning sound
		
		this.soundManager.addSound("/audios/Lose.wav");			// Add the losing sound
		
		MatchGame currentObject = this;							// Create a pointer to the object to use in other classes methods
		
		this.level = new Level();								// Create a new level manager
		
		this.sequenceTimer = new Timer(FRAME_TIME, this);		// Create the timer to display the sequences
		
		this.score = new HiScore();								// Create the score manager
		
		MatchGameInterface.createInterface();					// Create the interface
		
																// Set the first modal button its action
		MatchGameInterface.getModalButton().setClickAction(new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void performAction
				//
				// Method parameters	:	void
				//
				// Method return		:	void
				//
				// Synopsis				:   Performs the first modal button action.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				MatchGameInterface.getModal().hideModal();			// Hide the modal
				
				MatchGameInterface.showGameInterface();				// Show the Game interface
				
				MatchGameInterface.disableColorButtons();			// Disable the color buttons
				
				MatchGameInterface.getPlayButton().enable();		// Enable the play button
				
				MatchGameInterface.getPlayButton().setVisible(true);// Show the play button
			}
		});
																// Set the red button's action
		MatchGameInterface.getRedButton().setClickAction(new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void performAction
				//
				// Method parameters	:	void
				//
				// Method return		:	void
				//
				// Synopsis				:   Performs the red button action.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				currentObject.colorButtonPressed(MatchGame.Colors.RED);		// Call the action when the red button is pressed
			}
		});
																// Set the green button's action													
		MatchGameInterface.getGreenButton().setClickAction(new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void performAction
				//
				// Method parameters	:	void
				//
				// Method return		:	void
				//
				// Synopsis				:   Performs the red button action.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				currentObject.colorButtonPressed(MatchGame.Colors.GREEN);	// Call the action when the green button is pressed
			}
		});
																	// Set the yellow button's action
		MatchGameInterface.getYellowButton().setClickAction(new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void performAction
				//
				// Method parameters	:	void
				//
				// Method return		:	void
				//
				// Synopsis				:   Performs the red button action.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				currentObject.colorButtonPressed(MatchGame.Colors.YELLOW);	// Call the action when the green button is pressed
			}
		});
																	// Set the blue button's action
		MatchGameInterface.getBlueButton().setClickAction(new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void performAction
				//
				// Method parameters	:	void
				//
				// Method return		:	void
				//
				// Synopsis				:   Performs the red button action.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				currentObject.colorButtonPressed(MatchGame.Colors.BLUE);	// Call the action when the green button is pressed
			}
		});
																	// Set the play button's action
		MatchGameInterface.getPlayButton().setClickAction(new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void performAction
				//
				// Method parameters	:	void
				//
				// Method return		:	void
				//
				// Synopsis				:   Performs the red button action.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				MatchGameInterface.getPlayButton().disable();			// Disable the play button
				
				MatchGameInterface.getPlayButton().setVisible(false);	// Hide the play button
				
																		// Create a new sequence depending on the level
				currentObject.gameSequence = new Sequence(currentObject.level.getLevel());
				
				currentObject.userSequence = new Sequence();			// Create an empty sequence for the user
				
				currentObject.showSequence();							// Show the sequence to the user
			}
		});
	}
	private void showSequence () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showSequence
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the random generated sequence.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.sequenceCounter = 0;				// Reset the sequence counter
		
		this.sequenceToggle = true;				// Reset the toggle flag to start turning the buttons on
		
		this.sequenceTimer.setRepeats(true);	// Set the Timer so it repeats
		
		this.sequenceTimer.start();				// Start the timer
		
	}
	public void colorButtonPressed (Colors button) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void colorButtonPressed
		//
		// Method parameters	:	Colors The color of the button that was pressed.
		//
		// Method return		:	void
		//
		// Synopsis				:   PErforms the action when a button is pressed.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGame currentObject = this;						// Create a pointer to the current object to use in external classes
		
															// Play the button's sound
		this.soundManager.playSound(MatchGame.Sounds.values()[button.ordinal()]);
		
		MatchGameInterface.turnOnButton(button);			// Turn the button
		
															// Create a timer to turn the button off
		Timer buttonTimer = new Timer(BUTTON_PRESSED_TIME, new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void actionPerformed
				//
				// Method parameters	:	ActionEvent The event tied to the timer.
				//
				// Method return		:	void
				//
				// Synopsis				:   This method is performed to turn the button off.
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				MatchGameInterface.turnOffButton(button);	// Turn the button off
				
				currentObject.addUserInput(button);			// Add the button to the user input
			}
			
		});
		buttonTimer.setRepeats(false);						// Set the timer not to repeat
		
		buttonTimer.start();								// Start the timer
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void actionPerformed
		//
		// Method parameters	:	ActionEvent The event tied to the sequence timer.
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is performed to show the sequence.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if(this.sequenceCounter >= this.gameSequence.length()) {	// Check if the counter has gone through the sequence
			
			MatchGameInterface.turnOffButtons();					// Turn off all the buttons
			
			MatchGameInterface.enableColorButtons();				// Enable the color buttons for the use interface
			
			this.sequenceTimer.stop();								// Stop the timer
		}else {
			MatchGameInterface.turnOffButtons();					// Turn off all the buttons
			
			if (this.sequenceToggle) {								// Check if it's time to turn a button on
				
																	// Play the next button's sound
				this.soundManager.playSound(MatchGame.Sounds.values()[this.gameSequence.getNumber(this.sequenceCounter).ordinal()]);
				
																	// Turn the next button on
				MatchGameInterface.turnOnButton(this.gameSequence.getNumber(this.sequenceCounter));
				
				this.sequenceCounter++;								// Increment the counter
			}
			this.sequenceToggle = !this.sequenceToggle;				// Flip the on/off flag
			
		}
	}
	public void addUserInput(Colors color) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void addUserInput
		//
		// Method parameters	:	Colors The color clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   This method adds the clicked color to the user sequence.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.userSequence.add(color);							// Add the color to the user sequence
		
																// Check if the user sequence has the same size as
																// the random sequence
		if(this.userSequence.length() >= this.gameSequence.length()) {
			
			MatchGameInterface.disableColorButtons();			// Disable the color buttons
			
			this.evaluateResults();								// Evaluate the results
		}
	}
	public void evaluateResults () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void evaluateResults
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   This method evaluates if the sequences are the same.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGame currentObject = this;							// Create a pointer to the current object for outside classes
		
		if(this.userSequence.equals(this.gameSequence)) {		// Check if both sequences are equal
			
			this.soundManager.playSound(MatchGame.Sounds.WIN);	// Play the winning sound
			
			score.add(this.level.win());						// Add the score and register the win
			
																// Create the text array for the modal
			String [] texts = {"Good job!", "The secuence is correct!"};
			
																// Show a modal with the text and continue button
			MatchGameInterface.showModal(texts, "Continue", new GameAction() {
				public void performAction () {
					// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
					// Method				:	void actionPerformed
					//
					// Method parameters	:	ActionEvent The event tied to the sequence timer.
					//
					// Method return		:	void
					//
					// Synopsis				:   This method is performed when the winning modal is closed..
					//
					// Modifications		:
					//							Date			Developer				Notes
					//							----			---------				-----
					//							2022-05-05		D. Urdapilleta			Initial setup
					//
					// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
					
					MatchGameInterface.getModal().hideModal();	// Hide the modal
					
					currentObject.restartGame();				// Restart the MatchGame for the next round
				}
			});
		} else {
			this.soundManager.playSound(MatchGame.Sounds.LOSE);	// Play the losing sound
			
			score.subtract(this.level.lose());					// Deduct the score
			
																// Create the text array for the modal
			String [] texts = {"Too Bad!", "The sequence is incorrect!"};
			
																// Show a modal with the text and continue button
			MatchGameInterface.showModal(texts, "Continue", new GameAction() {
				public void performAction () {
					// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
					// Method				:	void actionPerformed
					//
					// Method parameters	:	ActionEvent The event tied to the sequence timer.
					//
					// Method return		:	void
					//
					// Synopsis				:   This method is performed when the losing modal is closed..
					//
					// Modifications		:
					//							Date			Developer				Notes
					//							----			---------				-----
					//							2022-05-05		D. Urdapilleta			Initial setup
					//
					// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
					
					MatchGameInterface.getModal().hideModal();	// Close the modal
					
					if (score.isNegative()) {					// Check if the score is negative
						
						currentObject.endGame();				// End the game if it is
					} else {
						currentObject.restartGame();			// Restart the game if it isn't
					}
				}
			});
		}
		MatchGameInterface.setScore(this.score.getScore());		// Update the score in the interface
		
		MatchGameInterface.setHiScore(this.score.getHiScore());	// Update the hi-score in the interface
		
	}
	public void restartGame() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void restartGame
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the game ready for the next round.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.getPlayButton().enable();			// Enable the play button
		
		MatchGameInterface.getPlayButton().setVisible(true);	// Show the play button
	}
	public void endGame () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void endGame
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the end game modal and ends the game.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
																// Create the text array for the modal
		String [] texts = {"You lost this game!", "Your highest score was:",Integer.toString(this.score.getHiScore())};
		
																// Show a modal with the text and continue button
		MatchGameInterface.showModal(texts, "Exit", new GameAction() {
			public void performAction () {
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				// Method				:	void actionPerformed
				//
				// Method parameters	:	ActionEvent The event tied to the sequence timer.
				//
				// Method return		:	void
				//
				// Synopsis				:   This method is performed when the end game modal is closed..
				//
				// Modifications		:
				//							Date			Developer				Notes
				//							----			---------				-----
				//							2022-05-05		D. Urdapilleta			Initial setup
				//
				// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
				System.exit(0);				// Close the application
			}
		});
	}
}
