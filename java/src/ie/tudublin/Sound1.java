package ie.tudublin;

import ddf.minim.Minim;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioBuffer;
import processing.core.PApplet;


public class Sound1 extends PApplet {

    Minim m;
    AudioBuffer b;

    // Mic input
    // AudioInput ai;

    // Loading files and playing them
    AudioPlayer ap;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        m = new Minim(this);
        // ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ap = m.loadFile("java\\data\\tomp3.cc - 08 PsychNerD and Marco G  More Cowbell.mp3");
        ap.play();
        b = ap.mix;
    }

    float y = 400;
    float lerpedAvg;

    public void draw()
    {
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
            // noFill();
            // circle(i, h, b.get(i) * h);
        }

        // Getting avg amplitude (loudness) of samples in buffer
        float total = 0;
        for (int i = 0; i < b.size(); i++) {
            total += abs(b.get(i));
        }
        float avg = total / b.size();

        lerpedAvg = lerp(lerpedAvg, avg, 0.1f);

        // Drawing circle with avg
        noFill();
        circle(h, h, avg * h * 5);
        stroke(250, 255, 255);
        circle(h * 0.5f, h, lerpedAvg * h * 5);

        circle(h, y, 50);
        y += random(-10, 10);

        lerped = lerp(lerped, y, 0.1f);
        stroke(100, 255, 255);
        circle(h + 200, lerped, 50);

    }

    float lerped = 0;

}