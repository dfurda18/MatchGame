package GameInterface;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Background extends JPanel {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Background
	//
	// Synopsis				:   This class represents an interface element that works as a background in an 
	//							interface. It is meant to be used as a frame layer in a JLayeredPane.
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

	public Background (Dimension size, String fileURL) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Background
		//
		// Method parameters	:	Dimension The background's size.
		//							String The image to paint as background.
		//
		// Method return		:	Background A new instance of the class Background.
		//
		// Synopsis				:   Creates a new instance of the Background class with the specified size and image. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		super();										// Perform the JPanel construction actions
		
		this.add(new JLabel(new ImageIcon(getClass().getResource(fileURL))));	// Add a JLabel with the image to the background
		
		this.setPreferredSize(size);					// Set the background's preferred size
		
		this.setBounds(0,0,size.width, size.height);	// Set the background's bounds
	}
}
