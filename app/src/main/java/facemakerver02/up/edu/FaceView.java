package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.TextView;

public class FaceView extends SurfaceView {
    private FaceModel faceModelReference;

    Paint skinColor = new Paint();
    Paint hairColor = new Paint();
    Paint eyeColor = new Paint();

    Paint pupil = new Paint();


    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        faceModelReference = new FaceModel();

        setWillNotDraw(false);

        skinColor.setColor(Color.rgb(faceModelReference._skinRedValue, faceModelReference._skinGreenValue,faceModelReference._skinBlueValue));
        eyeColor.setColor(Color.rgb(faceModelReference._eyesRedValue, faceModelReference._eyesGreenValue,faceModelReference._eyesBlueValue));
        hairColor.setColor(Color.rgb(faceModelReference._hairRedValue, faceModelReference._hairGreenValue,faceModelReference._hairBlueValue));
        pupil.setColor(Color.BLACK);
    }

    /**
     * draws the face
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    public void onDraw(Canvas canvas) {
        //draws this Face object on a Canvas object
        drawSkin(canvas);
        drawEyes(canvas);
        drawHair(canvas);

        // THIS DOESN'T WORK. I'm still figuring it out. We did it in class.
        // set the text views to match the RGB value
//        TextView redTextView = findViewById(R.id.redValue);
//        redTextView.setText(faceModelReference._redValue + "");
//        TextView greenTextView = findViewById(R.id.greenValue);
//        greenTextView.setText(faceModelReference._greenValue + "");

//        TextView blueTextView = (TextView) findViewById(R.id.blueValue);
//        if (blueTextView != null) {
//            blueTextView.setText(faceModelReference._blueValue + "");
//        }
        //blueTextView.setText(faceModelReference._blueValue + "");
    }

    /**
     * draws the avatar's skin
     * @param canvas
     */
    public void drawSkin(Canvas canvas) {
        //use skinColor int
        canvas.drawCircle(800, 650, 500, skinColor);
        canvas.drawCircle(250, 650, 100, skinColor);
        canvas.drawCircle(1350, 650, 100, skinColor);
    }

    /**
     * draws the avatar's eyes
     * @param canvas
     */
    public void drawEyes(Canvas canvas) {
        //use eyeColor int
        canvas.drawCircle(600, 650, 100, eyeColor);
        canvas.drawCircle(1000, 650, 100, eyeColor);
        canvas.drawCircle(600, 650, 50, pupil);
        canvas.drawCircle(1000, 650, 50, pupil);
    }

    /**
     * draws the avatar's skin
     *
     * CAVEAT: I haven't designed the hairstyles yet.
     *
     * @param canvas
     */
    public void drawHair(Canvas canvas) {
        if (faceModelReference.hairStyle == 0) {
            // hairstyle 1
        } else if (faceModelReference.hairStyle == 1) {
            // hairstyle 2
        } else if (faceModelReference.hairStyle == 2) {
            // hairstyle 3
        } else {
            // hairstyle 4
        }
    }

    public FaceModel grantReferenceAccess() {
        return faceModelReference;
    }
}
