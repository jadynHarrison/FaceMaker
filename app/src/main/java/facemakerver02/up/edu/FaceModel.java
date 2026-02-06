package facemakerver02.up.edu;
import java.util.Random;
public class FaceModel {
    //declare variables
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    public FaceModel() {
        //initialize variables
        Random random = new Random();
        skinColor = random.nextInt(256);
        eyeColor = random.nextInt(256);
        hairColor = random.nextInt(256);
        hairStyle = random.nextInt(4);
    }
}
