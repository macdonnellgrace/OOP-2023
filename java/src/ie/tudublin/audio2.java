package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 

    }



    public void draw()
    {   
          background(0);
          stroke(255);
          
          float half = height / 2;
          for(int i = 0; i < ab.size(); i++)
          {

            line(i, half, 1, half + ab.get(i) *half );

            
          }

          println(map(5, 0, 10, 1000, 2000));
    }

    fft.forward(ab);

    for (int i = 0; i < fft.specSize(); i++ )
    {
        line(i, height, i, height - fft.getBand(i) * 5.0f)
    }

    }        

