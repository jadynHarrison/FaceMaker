package facemakerver02.up.edu;
import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;
public class FaceModel {
    //declare variables
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public FaceModel() {
        randomize();
    }

    public void randomize() {
        Log.d("candles", "let's get lit");
        Random random = new Random();
        skinColor = random.nextInt(256);
        eyeColor = random.nextInt(256);
        hairColor = random.nextInt(256);
        hairStyle = random.nextInt(4);
        Log.d("check", skinColor + " " + eyeColor + " " + hairColor + " " + hairStyle);
    }

    public void onDraw(Canvas canvas) {
        //draws this Face object on a Canvas object
    }

    public void drawSkin(Canvas canvas) {
        //use skinColor int
    }

    public void drawEyes(Canvas canvas) {
        //use eyeColor int
    }

    public void drawHair(Canvas canvas) {
        //use hairColor and hairStyle ints
    }

    public void drawOtherFeatures(Canvas canvas) {

    }

}
