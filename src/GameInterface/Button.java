package GameInterface;
import javax.swing.JPanel;

import java.awt.Cursor;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.GroupLayout;

public class Button extends JPanel {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Button
	//
	// Synopsis				:   This class is a Button that can be clicked only when the mouse is inside an 
	//							specified polygon.
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

	private Polygon polygon;		// Data member of the polygon representing the button's clickable area
	
	private GameAction action;		// Data member of the action take when the button is clicked
	
	private boolean isEnabled;		// Data member that knows if the button is enabled
	
	public Button (ButtonOptions options) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Button
		//
		// Method parameters	:	ButtonOptions The options that define the Button's characteristics_
		//							- Size: Dimension
		//							- Margin: Dimension
		//							- Clickable Area: Polygon
		//
		// Method return		:	Button A new instance of the class Button.
		//
		// Synopsis				:   Creates a new instance of the Button class with the specified size and margin and
		//							clickable area. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super();										// Perform the JPanel construction actions
		
		this.isEnabled = true;							// Set the isEnabled state to true
		
		this.setOpaque(false);							// Make the Button's background transparent
		
		this.setLayout(new GroupLayout(this));			// Set the layout as a GroupLayout
		
		this.setPreferredSize(options.getSize());		// Set the preferred size as the size form the options variable
		
														// Set the bounds of the button using the option's margin and size
		this.setBounds(options.getMargin().width,options.getMargin().height,options.getSize().width, options.getSize().height);
		
		this.polygon = options.getPolygon();			// Set the button's polygon from the option variable
		
        Button currentButton = this;					// Create a variable pointing at the current object for accessibility
        
        												// Add a listener for the mouse movement
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {		// Override the event when the mouse is moved

                										// Check if the button is enabled and the mouse position inside the 
            											// button's polygon
                if(currentButton.isEnabled && currentButton.getPolygon().contains(e.getX(), e.getY())) {
                	
                										// Set the mouse cursor sprite to a hand
                	currentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                										// Set the mouse cursor as the default arrow
                	currentButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {	// This event is not implemented
            }
            
        });
		this.addMouseListener(new MouseListener() {		// Add a listener to the button when the mouse is clicked
            @Override
            public void mouseClicked(MouseEvent e) {	// Override the event when the mouse is clicked

            											// Check if the button is enabled and the mouse position inside the 
														// button's polygon
                if(currentButton.isEnabled && currentButton.getPolygon().contains(e.getX(), e.getY())) {
                	
                	currentButton.action.performAction();	// Perform the action's defined action
                }
            }

			@Override
			public void mousePressed(MouseEvent e) {	// This event is not implemented
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {	// This event is not implemented
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {	// This event is not implemented
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {		// This event is not implemented
				// TODO Auto-generated method stub
				
			}
        });
	}
	
	public Polygon getPolygon () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Polygon getPolygon
		//
		// Method parameters	:	void
		//
		// Method return		:	Polygon This Button's polygon.
		//
		// Synopsis				:   Returns the button's polygon.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.polygon;		// Return the Button's polygon
	}
	
	public void enable () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void enable
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Enables the button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.isEnabled = true;		// Set the isEnabled attribute to true
	}
	public void disable () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void disable
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Disables the button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.isEnabled = false;		// Set the isEnabled attribute to false
	}
	
	public void setClickAction (GameAction action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setClickAction
		//
		// Method parameters	:	GameAction The action that the button will perform when clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the Button's action.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.action = action;		// Set the Button's action with the action passed as parameter
	}
	
}
