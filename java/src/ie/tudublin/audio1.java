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
        float cgap = 255 / (float)ab.size();


        for (int i = 0; i < ab.size(); i++)
        {
            stroke(cgap * i, 255, 255);
            line(i, half, i, half + ab.get(i) * half);
        }

        float avg = total / (float) ab.size();
        float r = avg * 20;
        

        lerpedR = lerp(lerpedR, 20, 0);

        circle(100, 200, r);

	}
    float lerpedR = 0;
}
