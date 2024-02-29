package ie.tudublin;

import ddf.minim.Minim;
import ddf.minim.AudioInput;
import ddf.minim.AudioBuffer;
import processing.core.PApplet;


public class Sound1 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioBuffer b;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        b = ai.mix;
    }

    public void draw() {
        colorMode(HSB);
        background(0);
        stroke(255);
        float h = height / 2;
        for (int i=0; i<b.size(); i++)
        {
            // Adding colour
            float hue = map(i, 0, b.size(), 0 , 256);
            stroke(hue, 255, 255);

            // Drawing lines from centre line
            // line(i, h, i, h + b.get(i) * h);

            // Drawing circles of differing radii at centre line
            noFill();
            circle(i, h, b.get(i) * h);
        }

    }

}