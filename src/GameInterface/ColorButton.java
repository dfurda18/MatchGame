package GameInterface;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorButton extends Button {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	ColorButton
	//
	// Synopsis				:   This class is a Button that uses its visuals from an image that can be clicked  
	//							only when the mouse is inside an specified polygon. It also has two different
	//							states depending if it is on or off.
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

	private JPanel onImage;				// The panel containing the ON graphics
	
	private JPanel offImage;			// The panel containing the OFF graphics
	
	public ColorButton (ButtonOptions options, String onImage, String offImage) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ColorButton
		//
		// Method parameters	:	ButtonOptions The options that define the Button's characteristics_
		//							- Size: Dimension
		//							- Margin: Dimension
		//							- Clickable Area: Polygon
		//							String The image for the ON graphics
		//							String The image for the OFF graphics
		//
		// Method return		:	Button A new instance of the class ColorButton.
		//
		// Synopsis				:   Creates a new instance of the ColorButton class with the specified size and margin,
		//							clickable area and images as graphics. The default state is OFF.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super(options);							// Call the parent's constructor method
		
		this.onImage = new JPanel();			// Create a JPanel for the ON graphics
							
												// Add a label with a scaled ON image to the ON graphics
		this.onImage.add(new JLabel(new ImageIcon(new ImageIcon (getClass().getResource(onImage)).getImage().getScaledInstance(
																							options.getSize().width, 
																							options.getSize().height-5, 
																							Image.SCALE_DEFAULT)
				)));
		
												// Set the ON image at the beginning of the button's space so it covers the 
												// button's area
		this.onImage.setBounds(0, 0, options.getSize().width, options.getSize().height);
		
		this.onImage.setOpaque(false);			// Make the OFF graphic's panel's background transparent
		
		this.add(this.onImage);					// Add the ON graphics to the button's panel
		
		this.onImage.setVisible(false);			// Hide the ON graphics
		
		this.offImage = new JPanel();			// Create a JPanel for the OFF graphics
		
												// Add a label with a scaled OFF image to the OFF graphics
		this.offImage.add(new JLabel(new ImageIcon(new ImageIcon (getClass().getResource(offImage)).getImage().getScaledInstance(
																							options.getSize().width, 
																							options.getSize().height-5, 
																							Image.SCALE_DEFAULT)
				)));
												// Set the OFF image at the beginning of the button's space so it covers the 
												// button's area
		this.offImage.setBounds(0, 0, options.getSize().width, options.getSize().height);
		
		this.offImage.setOpaque(false);			// Make the OFF graphic's panel's background transparent
		
		this.add(this.offImage);				// Add the OFF graphics to the button's panel
	}
	public void off () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void off
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Turns the button off.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.onImage.setVisible(false);			// Hide the ON graphics
		
		this.offImage.setVisible(true);			// Show the OFF graphics
	}
	
	public void on () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void on
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Turns the button on.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.offImage.setVisible(false);		// Hide the OFF graphics
		this.onImage.setVisible(true);			// Show the ON graphics
	}
}
