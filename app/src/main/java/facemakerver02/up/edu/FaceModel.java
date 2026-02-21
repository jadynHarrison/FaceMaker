package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import java.util.Random;
public class FaceModel {
    //declare variables
    private int red;
    private int green;
    private int blue;
    private int _skinRedValue;
    private int _skinGreenValue;
    private int _skinBlueValue;
    private int _eyesRedValue;
    private int _eyesGreenValue;
    private int _eyesBlueValue;
    private int _hairRedValue;
    private int _hairGreenValue;
    private int _hairBlueValue;
    private int hairStyle;
    private int radioButtonOption;
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
        hairStyle = random.nextInt(3);
        radioButtonOption = random.nextInt(2);

        stayUpdated();
    }

    // updates the RGB values when the colors are randomized
    public void stayUpdated () {
        if (radioButtonOption == 0) {
            red = _hairRedValue;
            green = _hairGreenValue;
            blue = _hairRedValue;
        } else if (radioButtonOption == 1) {
            red = _skinRedValue;
            green = _skinGreenValue;
            blue = _skinBlueValue;
        } else if (radioButtonOption == 2) {
            red = _eyesRedValue;
            green = _eyesGreenValue;
            blue = _eyesBlueValue;
        }
    }

    // setter methods
    public void setRed(int _red) {
        red = _red;
    }
    public void setGreen(int _green) {
        green = _green;
    }
    public void setBlue(int _blue) {
        blue = _blue;
    }
    public void setSkinRed(int skin) {
        this._skinRedValue = skin;
    }
    public void setSkinGreen(int skin) {
        this._skinGreenValue = skin;
    }
    public void setSkinBlue(int skin) {
        this._skinBlueValue = skin;
    }
    public void setEyesRed(int eyes) {
        this._eyesRedValue = eyes;
    }
    public void setEyesGreen(int eyes) {
        this._eyesGreenValue = eyes;
    }
    public void setEyesBlue(int eyes) {
        this._eyesBlueValue = eyes;
    }
    public void setHairRed(int hair) {
        this._hairRedValue = hair;
    }
    public void setHairGreen(int hair) {
        this._hairGreenValue = hair;
    }
    public void setHairBlue(int hair) {
        this._hairBlueValue = hair;
    }
    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }
    public void setRadioButtonOption(int option) {
        this.radioButtonOption = option;
    }

    // getter methods
    public int getRed () {
        return red;
    }
    public int getGreen () {
        return green;
    }
    public int getBlue () {
        return blue;
    }
    public int getSkinRed() {
        return _skinRedValue;
    }
    public int getSkinGreen() {
        return _skinGreenValue;
    }

    public int getSkinBlue () {
        return _skinBlueValue;
    }
    public int getEyesRed () {
        return _eyesRedValue;
    }
    public int getEyesGreen () {
        return _eyesGreenValue;
    }
    public int getEyesBlue () {
        return _eyesBlueValue;
    }

    public int getHairRed () {
        return _hairRedValue;
    }
    public int getHairGreen () {
        return _hairGreenValue;
    }
    public int getHairBlue () {
        return _hairBlueValue;
    }
    public int getHairStyle () {
        return hairStyle;
    }
    public int getRadioButtonOption () {
        return radioButtonOption;
    }
}
