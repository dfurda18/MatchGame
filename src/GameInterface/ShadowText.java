package GameInterface;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class ShadowText {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	ShadowText
	//
	// Synopsis				:   This class is a component that has a text and a shadow.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-04		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private JLabel text;		// The text
	private JLabel shadow;		// The shadow
	
	public ShadowText (ButtonOptions options, String text) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ShadowText
		//
		// Method parameters	:	ButtonOptions The text's configuration.
		//							- font size: String
		//							- color: Color
		//							- margin: Dimension
		//							- size: Dimension
		//							- font size: int
		//
		// Method return		:	ShadowText A new instance of the class ShadowText.
		//
		// Synopsis				:   Creates a new instance of the ShadowText which is a text with a drop shadow.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.text = new JLabel(text);					// Create the text label
		
		this.shadow = new JLabel(text);					// Create the shadow label
		
														// Set the text's font and size
		this.text.setFont(new Font("Berlin Sans FB", Font.PLAIN, options.getFontSize()));
		
		this.text.setForeground(options.getColor());	// Set the text's color
		
														// Set the text's bounds from the option's margin and size
		this.text.setBounds(options.getMargin().width+2, 
							options.getMargin().height, 
							options.getSize().width, 
							options.getSize().height);
		
		this.text.setHorizontalAlignment(JLabel.CENTER);// Center the text
		
		this.text.setOpaque(false);						// Set the background of the text transparent
		
														// Set the shadow's font and size
		this.shadow.setFont(new Font("Berlin Sans FB", Font.PLAIN, options.getFontSize()));
		
		this.shadow.setForeground(Color.BLACK);			// Set the shadow's color as black
		
														// Set the shadow´s bounds from the option's margin and size
		this.shadow.setBounds(options.getMargin().width, options.getMargin().height+2, options.getSize().width, options.getSize().height);
		
		this.shadow.setHorizontalAlignment(JLabel.CENTER);	// Center the shadow
		
		this.shadow.setOpaque(false);					// Set the background of the shadow transparent
	}

	public int getWidth () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int getWidth
		//
		// Method parameters	:	void
		//
		// Method return		:	int The text's width
		//
		// Synopsis				:   Returns the shadow text's width.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.shadow.getPreferredSize().width+3;	// Return the size +3 to consider the text's placement to 
														// generate a shadow effect
	}
	public void setText (String text) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setText
		//
		// Method parameters	:	String The new text.
		//
		// Method return		:	void
		//
		// Synopsis				:   Set the text's content.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.text.setText(text);			// Set the text's text
		
		this.shadow.setText(text);			// Set the shadow's text
	}
	public JLabel getText() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	JLabel getText
		//
		// Method parameters	:	void
		//
		// Method return		:	JLabel The text component
		//
		// Synopsis				:   Returns the text component.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.text;				// Return the text component
	}
	public JLabel getShadow() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	JLabel getShadow
		//
		// Method parameters	:	void
		//
		// Method return		:	JLabel The shadow component
		//
		// Synopsis				:   Returns the shadow component.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.shadow;				// Return the shadow component
	}
	public void show() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void show
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows this component.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.text.setVisible(true);			// Show the text component
		
		this.shadow.setVisible(true);		// Show the shadow component
	}
	public void hide() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hide
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Hides this component.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.text.setVisible(false);		// Hide the text component
		
		this.shadow.setVisible(false);		// Hide the shadow component
	}
}
