package GameInterface;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

public class ModalTitle extends JPanel {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	ModalTitle
	//
	// Synopsis				:   This class is a body or title contained in a modal component.
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

	private Dimension modalSize;		// The modal's size
	
	private Dimension margin;			// The modal's margin
	
	public ModalTitle (String imageUrl, Dimension modalSize, Dimension margin, Dimension titleSize) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ModalTitle
		//
		// Method parameters	:	String The image to place in the body.
		//							Dimension The Modal's size
		//							Dimension The Modal's margin
		//							Dimension The Title's size
		//
		// Method return		:	ModalTitle A new instance of the class ModalTitle with an image in the body.
		//
		// Synopsis				:   Creates a new instance of the ModalTitle with the specified image, size, margin
		//							and title size
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super();							// Call the JPanel's constructor functionality
		
		this.modalSize = modalSize;			// Set the modal's size
		
		this.margin = margin;				// Set the modal's margin
		
											// Add a label with the image
		this.add(new JLabel(new ImageIcon(getClass().getResource(imageUrl))));
		
		this.setPreferredSize(titleSize);	// Set the modal'stitle's preferred size
		
											// Set the title's bounds to be centered within the modal
		this.setBounds((modalSize.width-titleSize.width)/2,30,titleSize.width, titleSize.height);
		
		this.setOpaque(false);				// Set the background transparent
	}
	public ModalTitle (String text, Dimension modalSize, Dimension margin, Dimension titleSize, ButtonOptions options ) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ModalTitle
		//
		// Method parameters	:	String The text to show.
		//							Dimension The Modal's size
		//							Dimension The Modal's margin
		//							Dimension The Title's size
		//							ButtonOptions The text's configuration.
		//
		// Method return		:	ModalTitle A new instance of the class ModalTitle with text in the body.
		//
		// Synopsis				:   Creates a new instance of the ModalTitle with the specified image, size, margin
		//							and title size
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super();								// Call the JPanel's constructor functionality
		
		this.setLayout(new GroupLayout(this));	// Set the Layout as a GroupLayout
		
		this.modalSize = modalSize;				// Set the modal's size
		
		this.margin = margin;					// Set the modal's margin
		
												// Create a ShadowText with the options and text
		ShadowText shadowText = new ShadowText (options, text);
		
		this.add(shadowText.getText());			// Add the text to the modal
		
		this.add(shadowText.getShadow());		// Add the text's shadow to the modal
		
												// Set the text's bounds to be slightly to the right
		shadowText.getText().setBounds(2,0,modalSize.width+2,titleSize.height);
												
												// Set the shadow's bounds to be slightly below
		shadowText.getShadow().setBounds(0,2,modalSize.width+2,titleSize.height);
						
												// Set the title's bounds
		this.setBounds(5,15,titleSize.width, titleSize.height);
		
		this.setOpaque(false);					// Make the background transparent
	}
	public Dimension getModalSize () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Dimension getModalSize
		//
		// Method parameters	:	void
		//
		// Method return		:	Dimension The modal's size
		//
		// Synopsis				:   Returns the modal's size stored in the title.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.modalSize;			// Return the modal's size
	}
	public Dimension getMargin () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Dimension getMargin
		//
		// Method parameters	:	void
		//
		// Method return		:	Dimension The modal's margin
		//
		// Synopsis				:   Returns the modal's margin stored in the title.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.margin;				// Return the modal's margin
	}
}
