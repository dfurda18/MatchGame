package MatchGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class SoundManager {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	SoundManager
	//
	// Synopsis				:   This class represents a SoundManager.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-05-05		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private List<Clip> audios;				// Data member that represents a list of audio clips
	
	public SoundManager () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	SoundManager
		//
		// Method parameters	:	void
		//
		// Method return		:	SoundManager A new instance of the class SoundManager.
		//
		// Synopsis				:   Creates a new instance of the SoundManager with an empty audio list.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		audios = new ArrayList<Clip>();		// Create an empty list of audios
		try {
			
		} catch (Exception e) {
														// Handle the exception in the case there's a problem
			JOptionPane.showMessageDialog(null, "There was a problem accessing the audio device."+e.getMessage());
		}
	}
	public void addSound (String file) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void addSound
		//
		// Method parameters	:	String The location of the audio file.
		//
		// Method return		:	void
		//
		// Synopsis				:   Reads the file and creates an audio file from it.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		String pathString = "";
		try {
			URL pathFile = getClass().getResource(file);
			System.out.println(pathFile.getPath());
			pathString = pathFile.getPath();
															// Create the audio input stream
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(pathFile);
			
			Clip clip = AudioSystem.getClip();				// Get an object that can play audio clips on the computer
			
			clip.open(audioStream);							// Open the audio file
								
			audios.add(clip);								// Add the audio clip to the list
		} catch (Exception e) {
															// Handle if there was a problem
			JOptionPane.showMessageDialog(null, "There was a problem reading the sound file." + pathString);
		}
	}
	public void playSound (int soundId) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playSound
		//
		// Method parameters	:	int The position of the audio to play.
		//
		// Method return		:	void
		//
		// Synopsis				:   Play the audio in the specified position.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		try {
			audios.get(soundId).setFramePosition(0);		// Set the audio to the initial position 
			
			audios.get(soundId).start();					// Play the audio
		} catch (Exception e) {
															// Handle if there is a problem
			JOptionPane.showMessageDialog(null, "There was a problem playing the sound."+e.getMessage());
		}
	}
	public void playSound (MatchGame.Sounds soundId) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playSound
		//
		// Method parameters	:	MatchGame.Sounds The position of the audio to play.
		//
		// Method return		:	void
		//
		// Synopsis				:   Play the audio in the specified position.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-05-05		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		try {
			audios.get(soundId.ordinal()).setFramePosition(0);		// Set the audio to the initial position 
			
			audios.get(soundId.ordinal()).start();							// Play the audio
		} catch (Exception e) {
																	// Handle if there is a problem
			JOptionPane.showMessageDialog(null, "There was a problem playing the sound."+e.getMessage());
		}
	}
}
