package GameInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Polygon;

public class ButtonOptions {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	ButtonOptions
	//
	// Synopsis				:   This class stores sets of parameters used as options by different interface objects.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-04		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private Dimension size;				// The element's size
	
	private Dimension margin;			// The left and top margin of the element relative to its container.
	
	private String font;				// The font type for the text elements
	
	private Color color;				// The color of the text elements
	
	private int fontSize;				// The font size of the text elements
	
	private Polygon polygon;			// The polygon representing the area of the element
	
	public ButtonOptions (Dimension margin,  Dimension size, Polygon polygon, String font, Color color, int fontSize) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ButtonOptions
		//
		// Method parameters	:	Dimension The element's margin.
		//							Dimension The element's size.
		//							Polygon The polygon representing the element's area.
		//							String The text component's font.
		//							Color The text component's color.
		//							int The text component's size.
		//
		// Method return		:	ButtonOptions A new instance of the class ButtonOptions. Normally used for buttons
		//							with text.
		//
		// Synopsis				:   Creates a new instance of the ButtonOptions class with the specified information.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.size = size;				// Set the size
		
		this.margin = margin;			// Set the margin
		
		this.font = font;				// Set the font
		
		this.color = color;				// Set the color
		
		this.fontSize = fontSize;		// Set the font size
		
		this.polygon = polygon;			// Set the polygon
	}
	public ButtonOptions (Dimension margin,  Dimension size, String font, Color color, int fontSize) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ButtonOptions
		//
		// Method parameters	:	Dimension The element's margin.
		//							Dimension The element's size.
		//							String The text component's font.
		//							Color The text component's color.
		//							int The text component's size.
		//
		// Method return		:	ButtonOptions A new instance of the class ButtonOptions. Normally used for text
		//							components.
		//
		// Synopsis				:   Creates a new instance of the ButtonOptions class with the specified information.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.size = size;				// Set the size
		
		this.margin = margin;			// Set the margin
		
		this.font = font;				// Set the font
		
		this.color = color;				// Set the color
		
		this.fontSize = fontSize;		// Set the font size
	}
	public ButtonOptions (Dimension margin,  Dimension size, Polygon polygon) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ButtonOptions
		//
		// Method parameters	:	Dimension The element's margin.
		//							Dimension The element's size.
		//							Polygon The polygon representing the element's area.
		//
		// Method return		:	ButtonOptions A new instance of the class ButtonOptions. Normally used for buttons
		//							without text.
		//
		// Synopsis				:   Creates a new instance of the ButtonOptions class with the specified information.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.size = size;				// Set the size
		
		this.margin = margin;			// Set the margin
		
		this.polygon = polygon;			// Set the polygon
	}

	public Dimension getSize () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Dimension getSize
		//
		// Method parameters	:	void
		//
		// Method return		:	Dimension The size stored
		//
		// Synopsis				:   Returns the size information stored.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.size;				// Return the size
	}
	public Dimension getMargin () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Dimension getMargin
		//
		// Method parameters	:	void
		//
		// Method return		:	Dimension The margin stored
		//
		// Synopsis				:   Returns the margin information stored.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.margin;				// Return the margin
	}
	public String getFont () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	String getFont
		//
		// Method parameters	:	void
		//
		// Method return		:	String The font stored
		//
		// Synopsis				:   Returns the font information stored.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.font;				// Return the font
	}
	public Color getColor () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Color getColor
		//
		// Method parameters	:	void
		//
		// Method return		:	Color The color stored
		//
		// Synopsis				:   Returns the color information stored.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.color;				// Return the color
	}
	public int getFontSize () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int getFontSize
		//
		// Method parameters	:	void
		//
		// Method return		:	int The font's size stored
		//
		// Synopsis				:   Returns the font's size information stored.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.fontSize;			// Return the font's size
	}
	public Polygon getPolygon () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Polygon getPolygon
		//
		// Method parameters	:	void
		//
		// Method return		:	Polygon The polygon stored
		//
		// Synopsis				:   Returns the polygon information stored.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-04		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.polygon;			// Return the polygon
	}
}
