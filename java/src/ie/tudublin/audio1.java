package ie.tudublin;

import processing.core.PApplet;

public class audio1 extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		x1 = random(0, width);
		x2 = random(0, width);
		y1 = random(0, height);
		y2 = random(0, height);

		float range = 5;

		x1dir = random(-range, range);
		x2dir = random(-range, range);
		y1dir = random(-range, range);
		y2dir = random(-range, range);

		smooth();
		
	}
	
	public void draw()
	{	
	}
}
