package GameInterface;

import javax.swing.JLayeredPane;

public class TextButton extends Button {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	TextButton
	//
	// Synopsis				:   This class is a Button that is shown as a text that can be clicked  
	//							only when the mouse is inside an specified polygon. 
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-04		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextButton (ButtonOptions options, String text) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	TextButton
		//
		// Method parameters	:	ButtonOptions The options that define the Button's characteristics_
		//							- Size: Dimension
		//							- Margin: Dimension
		//							- Clickable Area: Polygon
		//							- font size: String
		//							- color: Color
		//							- font size: int
		//							String The text
		//
		// Method return		:	Button A new instance of the class TextButton.
		//
		// Synopsis				:   Creates a new instance of the TextButton class with the specified size and margin,
		//							clickable area and text.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super(options);												// Call the parent's constructor
		
		ShadowText buttonText = new ShadowText(options, text);		// Create a shadow text with the options and text
		
																	// Set the text's bounds
		buttonText.getText().setBounds(2,0,options.getSize().width+2,options.getSize().height);
		
																	// Set the shadow's bounds
		buttonText.getShadow().setBounds(0,2,options.getSize().width+2,options.getSize().height);
		
		this.add(buttonText.getText(), JLayeredPane.DEFAULT_LAYER);	// Add the text in the default layer
		
																	// Add the shadow in the background layer
		this.add(buttonText.getShadow(), JLayeredPane.FRAME_CONTENT_LAYER);
	}
	
	
}
