package GameInterface;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class Modal extends JPanel{
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Modal
	//
	// Synopsis				:   This class is a Modal that contains a body and an action button.
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
	public Modal () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Modal
		//
		// Method parameters	:	void
		//
		// Method return		:	Modal A new instance of the class Modal.
		//
		// Synopsis				:   Creates a new instance of the Modal with default values. It will be hidden by 
		//							default.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super();								// Perform the JPanel constructor functionality
		
												// Set the Modal's border empty
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.setLayout(new GroupLayout(this));	// Set the layout as a GroupLayout
		
		this.setOpaque(false);					// Make the modal's background transparent
		
		this.setVisible(false);					// Hide the Modal
	}
	public void showModal () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showModal
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the modal without changing its contents.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.setVisible(true);				// Shows the Modal
	}
	public void showModal (ModalTitle title, Button button) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showModal
		//
		// Method parameters	:	ModalTitle The Modal's Title component.
		//							Button The modal's action button.
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the modal after changing its contents.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.removeAll();				// Remove all the Modal's components
		
										// Set an empty border
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
										// Set the Modal's bounds depending on the Title's parameters margin and size
		this.setBounds(title.getMargin().width, title.getMargin().height, title.getModalSize().width, title.getModalSize().height);
		
		this.add(title);				// Add the title to the Modal
		
		this.add(button);				// Add the button to the Modal
		
		this.setVisible(true);			// Show the modal	
		
	}
	public void hideModal () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hideModal
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Hides the modal.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.setVisible(false);			// Hide the modal
	}
	protected void paintComponent(Graphics graphics) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void paintComponent
		//
		// Method parameters	:	Graphics The graphics object that paints in the application.
		//
		// Method return		:	void
		//
		// Synopsis				:   This method extends the JPanel functionality to consistently paint the modal's
		//							Background with a color that has alpha channel.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		graphics.setColor(new Color(0,0,0, 0.3f));			// Set the painting color to black with 30% alpha
		
		graphics.fillRect(0, 0, getWidth(), getHeight());	// Fill the modal's area with the color
		
		super.paintComponent(graphics);						// Call the parent's paining method
	}
}
