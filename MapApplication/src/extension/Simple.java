package extension;

import processing.core.PApplet;
import processing.core.PGraphics;

public class Simple extends PApplet{
	
PGraphics pg;

public void setup() {
  size(100, 100);
  pg = createGraphics(50, 50);
}

public void draw() {
  pg.beginDraw();
  pg.background(255);
  pg.stroke(5);
  pg.fill(0);
  pg.text("Hello", 25, 25);
  pg.line(20, 20, mouseX, mouseY);
  pg.endDraw();
  
  image(pg, 51, 30);
}
}
