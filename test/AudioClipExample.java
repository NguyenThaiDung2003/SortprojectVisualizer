package test;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JApplet;

public class AudioClipExample extends JApplet{
	
	public static AudioClip Intro;
	
	public void init() {
		Intro = Applet.newAudioClip(Get_Location("/test/intro.wav"));
		Intro.play();
	}
	
	public URL Get_Location(String filename) {
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
		} catch(Exception e) {}
		return url;
	}

}
