package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {


	public void settings() {
		size(500, 500);
	}

	public void setup() {
		reset();
	}

	float playerX, playerY;
	float playerSpeed = 5;
	float playerWidth = 40;
	float halfPlayerWidth = playerWidth / 2;

	float bugX, bugY, bugWidth = 30;
	float halfBugWidth = bugWidth / 2;

	int score = 0;

	void reset() {
		resetBug();

		// x and y coords of player are in the middle of the screen
		// proportionate to screen size
		playerX = width / 2;
		playerY = height - 50;
	}

	void resetBug() {
		bugX = random(halfBugWidth, width - halfBugWidth);
		bugY = 50;
	}

	void drawBug(float x, float y) {
		// Draw the bug
		stroke(255);
		triangle(x, y, x-10, y+10, x+10, y+10);
	}

	void drawPlayer(float x, float y, float w) {

		stroke(255);
		circle(x, y, w);

	}

	public void keyPressed() {
		if (keyCode == LEFT) {
			if (playerX > halfPlayerWidth) {
				playerX -= playerSpeed;
			}
		}
		if (keyCode == RIGHT) {
			if (playerX < width - halfPlayerWidth) {
				playerX += playerSpeed;
			}
		}
		if (keyCode == ' ')
		{
			if (playerX > bugX - halfBugWidth && playerX < bugX + halfBugWidth)
			{
				stroke(255,0,0);
				line(playerX, playerY, playerX, bugY);
				score ++;
				resetBug();
				
			}
			else
			{
				stroke(255,0,0);
				line(playerX, playerY, playerX, 0);
				stroke(0,0,0);
			}
		}
	}

	void moveBug() {
		// every second
		if ((frameCount % 30) == 0) {

			// x coord moves random place
			bugX += random(-5, 5);

			
			if (bugX < halfBugWidth) {
				bugX = halfBugWidth;
			}
			if (bugX > width - halfBugWidth) {
				bugX = width - halfBugWidth;
			}
			bugY += 2;
		}
	}

	int gameMode = 0;

	public void draw() {
		background(0);
		if (gameMode == 0)
		{
			fill(255);
			drawPlayer(playerX, playerY, playerWidth);
			drawBug(bugX, bugY);
			moveBug();

			text("Score: " + score, 20, 20);
		}
		else
		{
			textAlign(CENTER, CENTER);
			text("GAME OVER", width / 2, height / 2);
		}

		if (bugY > height - 50)
		{
			gameMode = 1;
		}

	}
}
