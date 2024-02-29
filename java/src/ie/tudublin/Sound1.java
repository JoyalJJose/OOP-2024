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
        background(0);
        stroke(255);

    }

}