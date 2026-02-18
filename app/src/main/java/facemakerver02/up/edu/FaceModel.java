package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import android.util.Log;

import java.util.Random;
public class FaceModel {
    //declare variables
    public int _skinRedValue = 0;
    public int _skinGreenValue = 0;
    public int _skinBlueValue = 0;
    public int _eyesRedValue = 0;
    public int _eyesGreenValue = 0;
    public int _eyesBlueValue = 0;
    public int _hairRedValue = 0;
    public int _hairGreenValue = 0;
    public int _hairBlueValue = 0;
    public int hairStyle = 0;
    public FaceModel() {
        randomize();
    }

    /**
     * Randomizes the hair, skin, and eye colors of the avatar
     */
    public void randomize() {
        Random random = new Random();
        _skinRedValue = random.nextInt(256);
        _skinGreenValue = random.nextInt(256);
        _skinBlueValue = random.nextInt(256);
        _eyesRedValue = random.nextInt(256);
        _eyesGreenValue = random.nextInt(256);
        _eyesBlueValue = random.nextInt(256);
        _hairRedValue = random.nextInt(256);
        _hairGreenValue = random.nextInt(256);
        _hairBlueValue = random.nextInt(256);
        hairStyle = random.nextInt(4);
        //Log.d("check", skinColor + " " + eyeColor + " " + hairColor + " " + hairStyle);
    }

}
