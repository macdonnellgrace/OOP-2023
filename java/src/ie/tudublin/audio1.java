package ie.tudublin;

import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioBuffer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class audio1 extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(500, 500);
	}

    int frameSize = 1024;

	public void setup() {
		colorMode(HSB);


        minim = new Minim(this);

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ab = ai.mix;
		
	}
	
	public void draw()
	{	
		background(0);
        stroke(255);

        int half = (height / 2);
        for (int i = 0; i < ab.size(); i++)
        {
            line(i, half, i, half + ab.get(i) * half);
        }
	}
}
