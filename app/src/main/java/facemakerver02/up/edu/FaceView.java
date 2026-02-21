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

        skinColor.setColor(Color.rgb(faceModelReference.getSkinRed(), faceModelReference.getSkinGreen(),faceModelReference.getSkinBlue()));
        eyeColor.setColor(Color.rgb(faceModelReference.getEyesRed(), faceModelReference.getEyesGreen(),faceModelReference.getEyesBlue()));
        hairColor.setColor(Color.rgb(faceModelReference.getHairRed(), faceModelReference.getHairGreen(),faceModelReference.getHairBlue()));
        pupil.setColor(Color.BLACK);
    }

    /**
     * draws the face
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    public void onDraw(Canvas canvas) {
        //draws this Face object on a Canvas object
        skinColor.setColor(Color.rgb(faceModelReference.getSkinRed(), faceModelReference.getSkinGreen(),faceModelReference.getSkinBlue()));
        eyeColor.setColor(Color.rgb(faceModelReference.getEyesRed(), faceModelReference.getEyesGreen(),faceModelReference.getEyesBlue()));
        hairColor.setColor(Color.rgb(faceModelReference.getHairRed(), faceModelReference.getHairGreen(),faceModelReference.getHairBlue()));
        drawHair(canvas);
        drawSkin(canvas);
        drawEyes(canvas);
        drawOther(canvas);
    }

    /**
     * draws the avatar's skin
     */
    public void drawSkin(Canvas canvas) {
        //head
        canvas.drawCircle(800, 650, 500, skinColor);

        //ears
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
     */
    public void drawHair(Canvas canvas) {
        if (faceModelReference.getHairStyle() == 0) { // FIRST HAIRSTYLE
            // hair drawn down
            canvas.drawRect(300, 650, 1300, 1200, hairColor);
            canvas.drawOval(300, 50, 1300, 1000, hairColor);
        } else if (faceModelReference.getHairStyle() == 1) { // SECOND HAIRSTYLE
        // draws left braid
        canvas.drawCircle(325, 750, 100, hairColor);
        canvas.drawCircle(325, 900, 100, hairColor);
        canvas.drawCircle(325, 1025, 100, hairColor);
        canvas.drawCircle(325, 1150, 100, hairColor);
        canvas.drawCircle(325, 1300, 100, hairColor);
        // top hair
        canvas.drawCircle(300, 550, 100, hairColor);
        canvas.drawCircle(325, 400, 100, hairColor);
        canvas.drawCircle(450, 260, 100, hairColor);
        canvas.drawCircle(585, 170, 100, hairColor);
        canvas.drawCircle(700, 120, 100, hairColor);
        canvas.drawCircle(850, 120, 100, hairColor);
        canvas.drawCircle(1000, 170, 100, hairColor);
        canvas.drawCircle(1150, 260, 100, hairColor);
        canvas.drawCircle(1250, 400, 100, hairColor);
        canvas.drawCircle(1300, 550, 100, hairColor);
        // draws right braid
        canvas.drawCircle(1275, 750, 100, hairColor);
        canvas.drawCircle(1275, 900, 100, hairColor);
        canvas.drawCircle(1275, 1025, 100, hairColor);
        canvas.drawCircle(1275, 1150, 100, hairColor);
        canvas.drawCircle(1275, 1300, 100, hairColor);
        } else if (faceModelReference.getHairStyle() == 2) { // HAIRSTYLE THREE
            canvas.drawCircle(375, 1050, 200, hairColor);
        }
    }

    /**
     * Draws hair features that must be layered above the skin and eyes. Also includes the smile.
     * @param canvas
     */
    public void drawOther (Canvas canvas) {
        // hair features
        if (faceModelReference.getHairStyle() == 0) {
            // adds bangs to HAIRSTYLE ONE
            canvas.drawRect(500, 150, 1100, 500, hairColor);
        } else if (faceModelReference.getHairStyle() == 2) {
            // layers the hair over the face, HAIRSTYLE 3
            canvas.drawArc(200, 60, 900, 650, 135, 180, true, hairColor);
            canvas.drawArc(700, 60, 1400, 650, 225, 180, true, hairColor);
        }

        // draws smile
        canvas.drawArc(500, 650, 1110, 1100, 0, 180, true, pupil);

    }

    public FaceModel grantReferenceAccess() {
        return faceModelReference;
    }
}
