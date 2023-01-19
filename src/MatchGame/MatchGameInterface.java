package MatchGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import GameInterface.*;

public class MatchGameInterface {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	MatchGameInterface
	//
	// Synopsis				:   This class represents a MatchGame's interface.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-05		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private static Dimension screenSize = new Dimension (750, 1000);				// Screen size
	
	private static Dimension infoModalSize = new Dimension (500, 220);				// Regular modal size
	
	private static Dimension infoMargin = new Dimension (125, 300);					// Regular modal margin
	
	private static Dimension splashScreenModalSize = new Dimension (500, 220);		// Splash Screen Modal size
	
	private static Dimension splashScreenTitleSize = new Dimension (415, 64);		// splash screen title size
	
	private static Dimension splashScreenMargin = new Dimension (125, 300);			// Splash screen modal margin
	
	private static Dimension splashScreenButtonMargin = new Dimension (182, 120);	// Splash screen modal button margin
	
	private static Dimension splashScreenButtonSize = new Dimension (145, 50);		// Splash screen button size
	
	private static Dimension fredSize = new Dimension (600, 530);					// Fred image size
	
	private static Dimension redButtonMargin = new Dimension (181, 235);			// Red button margin
	
	private static Dimension redButtonSize = new Dimension (190, 230);				// Red button size
	
	private static Dimension greenButtonMargin = new Dimension (379, 235);			// Green button margin
	
	private static Dimension greenButtonSize = new Dimension (190, 230);			// Green button size
	
	private static Dimension yellowButtonMargin = new Dimension (181, 465);			// Yellow button margin
	
	private static Dimension yellowButtonSize = new Dimension (190, 230);			// Yellow button size
	
	private static Dimension blueButtonMargin = new Dimension (379, 465);			// Blue button margin
	
	private static Dimension blueButtonSize = new Dimension (190, 230);				// Blue button size
	
	private static Dimension playButtonMargin = new Dimension (263, 392);			// Play button margin
	
	private static Dimension playButtonSize = new Dimension (210, 140);				// Play button size
	
																					// Regular text size
	private static Dimension globalTextSize = new Dimension (MatchGameInterface.screenSize.width, 70);
	
	private static JFrame frame;						// Data member for the main window frame
	
	private static JLayeredPane gameInterface;			// Data member for the game interface container
	
	private static JPanel title;						// Data member for the title element
	
	private static JPanel fred;							// Data member for the Fred image
	
	private static Background background;				// Data member for the background
	
	private static Modal modal;							// Data member for the Modal
	
	private static ModalTitle modalTitle;				// Data member for the modal title
	
	private static Button modalButton;					// Data member for the modal button
	
	private static ShadowText highScorePanel;			// Data member for the hi-score panel
	
	private static ShadowText scorePanel;				// Data member for the score panel
	
	private static ColorButton redButton;				// Data member for the red button
	
	private static ColorButton greenButton;				// Data member for the green button
	
	private static ColorButton yellowButton;			// Data member for the yellow button
	
	private static ColorButton blueButton;				// Data member for the blue button
	
	private static TextButton playButton;				// Data member for the play button
	
	public static void createInterface () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void createInterface
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Creates all the interface elements and shows the initial splash screen.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.createMainWindow();		// Create the main window frame
		
		MatchGameInterface.createModal();			// Create the modal
		
		MatchGameInterface.createGameInterface();	// Create the game interface
		
													// Show the splash screen modal
		MatchGameInterface.modal.showModal(MatchGameInterface.modalTitle, MatchGameInterface.modalButton);
	}
	public static void createMainWindow () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void createMainWindow
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Creates the main window frame.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.frame = new JFrame("Match Game");			// Instantiate the main frame
		
																		// Set the frame's size
		MatchGameInterface.frame.setSize(MatchGameInterface.screenSize.width, MatchGameInterface.screenSize.height);
		
		MatchGameInterface.frame.setResizable(false);					// Disable the resizable attributes of the window
		
		MatchGameInterface.frame.setLocationRelativeTo(null);			// Unset the location relative of the window
		
																		// Set the default functionality of the window to close the application
		MatchGameInterface.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MatchGameInterface.gameInterface = new JLayeredPane();			// Instantiate the layered pane that containes the interface
		
																		// Set the pane's preferable size
		MatchGameInterface.gameInterface.setPreferredSize(MatchGameInterface.screenSize);
		
		MatchGameInterface.frame.add(MatchGameInterface.gameInterface);	// Add the pane to the main window frame
		
																		// Create the game's background
		MatchGameInterface.background = new Background(screenSize, "/images/Background.png");
		
																		// Add the background to the main pane
		MatchGameInterface.gameInterface.add(MatchGameInterface.background, JLayeredPane.FRAME_CONTENT_LAYER,3);
		
		MatchGameInterface.frame.pack();								// Pack the window frame
		
		MatchGameInterface.frame.setVisible(true);						// Show the window frame
	}
	public static void createModal () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void createModal
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Creates the modal element.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.modal = new Modal();		// Instantiate the modal
		
													// Add the modal to the main pane
		MatchGameInterface.gameInterface.add(MatchGameInterface.modal, JLayeredPane.MODAL_LAYER);
		
													//Create the modal title with the game's title
		MatchGameInterface.modalTitle = new ModalTitle("/images/Title.png", splashScreenModalSize, splashScreenMargin, splashScreenTitleSize);
		
													// Create the polygone X coordinates that define the continue button
		int boundsX[] = {0,splashScreenButtonSize.width-1,splashScreenButtonSize.width-1,0};
		
													// Create the polygone Y coordinates that define the continue button
		int boundsY[] = {0,0,splashScreenButtonSize.height-1,splashScreenButtonSize.height-1};
		
													// Create the modal's button
		MatchGameInterface.modalButton = new TextButton(new ButtonOptions(splashScreenButtonMargin, splashScreenButtonSize, new Polygon(boundsX, boundsY, 4), "Berlin Sans FB", Color.WHITE, 36), "Continue");
	}
	public static void createGameInterface () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void createGameInterface
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Creates the game interface.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.title = new JPanel();		// Create the title panel
		
		MatchGameInterface.title.setOpaque(false);		// Make the title's background transparent
		
														// Set the title's bounds
		MatchGameInterface.title.setBounds(0, 20, screenSize.width, splashScreenTitleSize.height+5);
		
														// Set the title's contents with the title image
		MatchGameInterface.title.add(new JLabel(new ImageIcon(MatchGameInterface.class.getClassLoader().getResource("images/Title.png"))));
		
		MatchGameInterface.title.setVisible(false);		// Hide the title
		
														// Add the title to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.title, JLayeredPane.DEFAULT_LAYER);
		
														// Create the high score text with the desired configuration and text
		MatchGameInterface.highScorePanel = new ShadowText(new ButtonOptions(new Dimension (0,100), MatchGameInterface.globalTextSize, "Berlin Sans FB", Color.WHITE, 42), "Hi-Score: 0");
		
		MatchGameInterface.highScorePanel.hide();		// Hide the high score panel
		
														// Add the high score text to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.highScorePanel.getText(), JLayeredPane.DEFAULT_LAYER);
		
														// Add the high score shadow to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.highScorePanel.getShadow(), JLayeredPane.DEFAULT_LAYER);
		
		MatchGameInterface.fred = new JPanel();			// Create the Fred image panel
		
		MatchGameInterface.fred.setOpaque(false);		// Make the Fred image's background transparent
		
														// Set the Fred's image's bounds
		MatchGameInterface.fred.setBounds(75, 200, fredSize.width, fredSize.height);
		
														// Add a resized shape image
		MatchGameInterface.fred.add(new JLabel(new ImageIcon(new ImageIcon(MatchGameInterface.class.getClassLoader().getResource("images/FRED_PLAY.png")).getImage().getScaledInstance(fredSize.width, fredSize.height,Image.SCALE_DEFAULT))));
		
		MatchGameInterface.fred.setVisible(false);		// Hide the Fred image
		
														// Add the Fred image to the interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.fred, JLayeredPane.FRAME_CONTENT_LAYER,0);
		
														// Create the polygone X coordinates that define the red button
		int boundsX[] = {18,70,160,180,190,190,170,140,120,100,90,85,65,30,7,0,0};
		
														// Create the polygone Y coordinates that define the red button
		int boundsY[] = {15,6,6,11,40,150,166,170,180,190,210,225,230,230,225,190,140};
		
		int points = 17;								// Set the number of points to 17
		
														// Create the red button with the desired configuration
		MatchGameInterface.redButton = new ColorButton(new ButtonOptions(MatchGameInterface.redButtonMargin, MatchGameInterface.redButtonSize, new Polygon(boundsX, boundsY, points)), "/images/RED_ON.png", "/images/RED_OFF.png");
		
		MatchGameInterface.redButton.setVisible(false);	// Hide the red button
		
														// Add the red button to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.redButton, JLayeredPane.DEFAULT_LAYER);
		
														// Create the polygone X coordinates that define the green button
		int greenX[] = {172,120,30,10,1,1,20,50,70,90,100,105,125,160,183,190,190};
		
														// Create the polygone Y coordinates that define the green button
		int greenY[] = {15,6,6,11,40,150,166,170,180,190,210,225,230,230,225,190,140};
		
														// Create the green button with the desired configuration
		MatchGameInterface.greenButton = new ColorButton(new ButtonOptions(MatchGameInterface.greenButtonMargin, MatchGameInterface.greenButtonSize, new Polygon(greenX, greenY, points)), "/images/GREEN_ON.png", "/images/GREEN_OFF.png");
		
		MatchGameInterface.greenButton.setVisible(false);// Hide the green button
		
														// Add the green button to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.greenButton, JLayeredPane.DEFAULT_LAYER);
		
														// Create the polygone X coordinates that define the yellow button
		int yellowX[] = {18,70,160,180,190,190,170,140,120,100,90,85,65,30,7,0,0};
		
														// Create the polygone Y coordinates that define the yellow button
		int yellowY[] = {220,229,229,224,195,85,69,65,55,45,25,10,5,5,10,45,95};
		
														// Create the yellow button with the desired configuration
		MatchGameInterface.yellowButton = new ColorButton(new ButtonOptions(MatchGameInterface.yellowButtonMargin, MatchGameInterface.yellowButtonSize, new Polygon(yellowX, yellowY, points)), "/images/YELLOW_ON.png", "/images/YELLOW_OFF.png");
		
		MatchGameInterface.yellowButton.setVisible(false);// Hide the yellow button
		
														// Add the yellow button to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.yellowButton, JLayeredPane.DEFAULT_LAYER);
		
														// Create the polygone X coordinates that define the blue button
		int blueX[] = {172,120,30,10,1,1,20,50,70,90,100,105,125,160,183,190,190};
		
														// Create the polygone Y coordinates that define the blue button
		int blueY[] = {220,229,229,224,195,85,69,65,55,45,25,10,5,5,10,45,95};
		
														// Create the blue button with the desired configuration
		MatchGameInterface.blueButton = new ColorButton(new ButtonOptions(MatchGameInterface.blueButtonMargin, MatchGameInterface.blueButtonSize, new Polygon(blueX, blueY, points)), "/images/BLUE_ON.png", "/images/BLUE_OFF.png");
		
		MatchGameInterface.blueButton.setVisible(false);// Hide the blue button
		
														// Add the blue button to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.blueButton, JLayeredPane.DEFAULT_LAYER);
		
		int playX[] = {10,35,115,181,206,181,115,35};	// Create the polygone X coordinates that define the play button
		
		int playY[] = {80,35,10,35,80,115,150,115};		// Create the polygone Y coordinates that define the play button
		
														// Create the play button with the desired configuration
		MatchGameInterface.playButton = new TextButton(new ButtonOptions(MatchGameInterface.playButtonMargin, MatchGameInterface.playButtonSize, new Polygon(playX, playY, 8), "Berlin Sans FB", Color.WHITE, 36), "Start");
		
		MatchGameInterface.playButton.setVisible(false);// Hide the play button
		
														// Add the play button to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.playButton, JLayeredPane.DEFAULT_LAYER+1);
		
														// Create the text for the score panel
		MatchGameInterface.scorePanel = new ShadowText(new ButtonOptions(new Dimension (0,750), MatchGameInterface.globalTextSize,  "Berlin Sans FB", Color.WHITE, 42), "Score: 0");
		
		MatchGameInterface.scorePanel.hide();			// Hide the score panel
		
														// Add the score text to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.scorePanel.getText(), JLayeredPane.DEFAULT_LAYER);
		
														// Add the score shadow to the game interface
		MatchGameInterface.gameInterface.add(MatchGameInterface.scorePanel.getShadow(), JLayeredPane.DEFAULT_LAYER);
	}

	public static void showGameInterface () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showGameInterface
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the game interface.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.title.setVisible(true);			// Show the title
		
		MatchGameInterface.highScorePanel.show();			// Show the hi-score panel
		
		MatchGameInterface.scorePanel.show();				// Show the score panel
		
		MatchGameInterface.fred.setVisible(true);			// Show the Fred image
		
		MatchGameInterface.redButton.setVisible(true);		// Show the red button
		
		MatchGameInterface.greenButton.setVisible(true);	// Show the green button
		
		MatchGameInterface.yellowButton.setVisible(true);	// Show the yellow button
		
		MatchGameInterface.blueButton.setVisible(true);		// Show the blue button
		
		MatchGameInterface.playButton.setVisible(true);		// Show the play button
	}
	public static void showModal(String [] titleText, String buttonText, GameAction action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showModal
		//
		// Method parameters	:	String[] The array that has the title's text shown in different lines.
		//							String The button text
		//							GameAction The game action to execute then the button is clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the modal with the specified contents.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
															// Create the polygone X coordinates that define the continue button
		int boundsX[] = {0,MatchGameInterface.splashScreenButtonSize.width-1,MatchGameInterface.splashScreenButtonSize.width-1,0};
		
															// Create the polygone Y coordinates that define the continue button
		int boundsY[] = {0,0,MatchGameInterface.splashScreenButtonSize.height-1,MatchGameInterface.splashScreenButtonSize.height-1};
		
		String htmlText = "<html><body><div><center>";		// Start the HTML content
		
															// Loop through each text
		for(int lineCounter = 0; lineCounter < titleText.length;lineCounter++) {
			
			htmlText += titleText[lineCounter];				// Add the next text line to the content
			
			if(lineCounter < titleText.length-1) {			// Check if there's still more text after this
				
				htmlText += "<br>";							// Add a line break
			}
		}
		htmlText += "</center></div></body></html>";		// Finish the content
		
															// Calculate the modal's size
		Dimension size = new Dimension(MatchGameInterface.infoModalSize.width, 100+(titleText.length*50));
		
															// Calculate the modal's margin
		Dimension margin = new Dimension(MatchGameInterface.infoMargin.width, 325-(titleText.length*25/2));
		
															// Calculate the modal's title's size
		Dimension titleSize = new Dimension(445, titleText.length*50);
		
															// Calaculate the modal's title margin
		Dimension modalButtonMargin = new Dimension(MatchGameInterface.splashScreenButtonMargin.width, 25+(titleText.length*50));
		
															// Create the new content for the modal title
		MatchGameInterface.modalTitle = new ModalTitle(htmlText, size, margin, titleSize, new ButtonOptions(MatchGameInterface.splashScreenButtonMargin, MatchGameInterface.splashScreenButtonSize, "Berlin Sans FB", Color.WHITE, 36));
											
															// Create the new modal's button
		MatchGameInterface.modalButton = new TextButton(new ButtonOptions(modalButtonMargin, splashScreenButtonSize, new Polygon(boundsX, boundsY, 4), "Berlin Sans FB", Color.WHITE, 36), buttonText);
		
		MatchGameInterface.modalButton.setClickAction(action);	// Set the button's action
		
															// Show the modal
		MatchGameInterface.modal.showModal(MatchGameInterface.modalTitle, MatchGameInterface.modalButton);
	}
	public static Button getModalButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getModalButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the modal's button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.modalButton;	// Return the modla's button
	}
	public static Modal getModal () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getModal
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the modal.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.modal;	// Return the modal
	}
	public static ColorButton getRedButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getRedButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the red button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.redButton;	// Return the red button
	}
	public static ColorButton getGreenButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getGreenButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the green button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.greenButton;	// Return the green button
	}
	public static ColorButton getYellowButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getYellowButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the yellow button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.yellowButton;	// Return the yellow button
	}
	public static ColorButton getBlueButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getBlueButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the blue button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.blueButton;	// Return the blue button
	}
	public static TextButton getPlayButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void getPlayButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Returns the play button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return MatchGameInterface.playButton;	// Return the play
	}
	public static void disableColorButtons () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void disableColorButtons
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Disables the color buttons.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.redButton.disable();		// Disable the red button
		
		MatchGameInterface.greenButton.disable();	// Disable the green button
		
		MatchGameInterface.yellowButton.disable();	// Disable the yellow button
		
		MatchGameInterface.blueButton.disable();	// Disable the blue button
	}
	public static void enableColorButtons () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void enableColorButtons
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Enables the color buttons.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.redButton.enable();		// Enable the red button
		
		MatchGameInterface.greenButton.enable();	// Enable the green button
		
		MatchGameInterface.yellowButton.enable();	// Enable the yellow button
		
		MatchGameInterface.blueButton.enable();		// Enable the blue button
	}
	public static void turnOffButtons () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void turnOffButtons
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Turns off the color buttons.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.redButton.off();		// Turn off the red button
		
		MatchGameInterface.greenButton.off();	// Turn off the grenn button
		
		MatchGameInterface.yellowButton.off();	// Turn off the yellow button
		
		MatchGameInterface.blueButton.off();	// Turn off the blue button
	}
	public static void turnOffButton (MatchGame.Colors color) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void turnOffButton
		//
		// Method parameters	:	MatchGame.Colors The color of the button to turn off
		//
		// Method return		:	void
		//
		// Synopsis				:   Turns off a specified button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		switch (color) {							// Switch over the colors
		case RED:
			MatchGameInterface.redButton.off();		// Turn the red button off
			break;
		case GREEN:
			MatchGameInterface.greenButton.off();	// Turn the green button off
			break;
		case YELLOW:
			MatchGameInterface.yellowButton.off();	// Turn the yellow button off
			break;
		case BLUE:
			MatchGameInterface.blueButton.off();	// Turn the blue button off
			break;
		default:
			break;
		}
	}
	public static void turnOnButton (MatchGame.Colors color) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void turnOnButton
		//
		// Method parameters	:	MatchGame.Colors The color of the button to turn on
		//
		// Method return		:	void
		//
		// Synopsis				:   Turns on a specified button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		MatchGameInterface.turnOffButtons(); 		// Turn off all buttons
		
		switch (color) {							// Switch over the colors
		case RED:
			MatchGameInterface.redButton.on();		// Turn on the red button
			break;
		case GREEN:
			MatchGameInterface.greenButton.on();	// Turn on the green button
			break;
		case YELLOW:
			MatchGameInterface.yellowButton.on();	// Turn on the yellow button
			break;
		case BLUE:
			MatchGameInterface.blueButton.on();		// Turn on the blue button
			break;
		default:
			break;
		}
		
	}
	public static void setScore (int score) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setScore
		//
		// Method parameters	:	int The score to display
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the specified score.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
											// Replaces the score text with the new score
		MatchGameInterface.scorePanel.setText("Score: "+ score);
	}
	public static void setHiScore (int score) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setHiScore
		//
		// Method parameters	:	int The hi-score to display
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the specified hi-score.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
											// Replaces the hi-score text with the new score
		MatchGameInterface.highScorePanel.setText("Hi-Score: "+ score);
	}
}
