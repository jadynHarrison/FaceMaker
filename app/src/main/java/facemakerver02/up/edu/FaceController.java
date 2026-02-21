package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
    private FaceModel myModel;
    private FaceView myView;
    //references to modifiable GUI components
    private TextView redValue;
    private TextView greenValue;
    private TextView blueValue;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    /**
     * The FaceController constructor is used to initialize the text views and seek bars and update them
     * accordingly. It also references an instance of FaceView and FaceModel.
     *
     * @param expectFaceView
     * @param redValue
     * @param greenValue
     * @param blueValue
     * @param redSKB
     * @param greenSKB
     * @param blueSKB
     */
    public FaceController(FaceView expectFaceView, TextView redValue, TextView greenValue, TextView blueValue, SeekBar redSKB, SeekBar greenSKB, SeekBar blueSKB) {
        this.myView = expectFaceView;
        this.myModel = myView.grantReferenceAccess();
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
        this.redSeekBar = redSKB;
        this.greenSeekBar = greenSKB;
        this.blueSeekBar = blueSKB;
    }

    /**
     * This method randomized the avatar's face when the random face button is clicked.
     *
     * CAVEAT: stayUpdated() is supposed to update the RGB text and progress. It doesn't.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        myModel.randomize();
        myModel.stayUpdated();
        myView.invalidate();
    }

    /**
     * Seekbar listener.
     * EXTERNAL CITATION: Professor Libby helped me understand updating the TextView.
     *
     * @param seekBar The SeekBar whose progress has changed
     * @param progress The current progress level. This will be in the range 0 to 255.
     * @param fromUser True if the progress change was initiated by the user.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.redBar) {
            if (myModel.getRadioButtonOption() == 0) {
                myModel.setHairRed(progress);
            } else if (myModel.getRadioButtonOption() == 1) {
                myModel.setSkinRed(progress);
            } else if (myModel.getRadioButtonOption() == 2) {
                myModel.setEyesRed(progress);
            }
            myModel.setRed(progress);
            redValue.setText("" + progress);
        }
         else if (seekBar.getId() == R.id.greenBar) {
            if (myModel.getRadioButtonOption() == 0) {
                myModel.setHairGreen(progress);
            } else if (myModel.getRadioButtonOption() == 1) {
                myModel.setSkinGreen(progress);
            } else if (myModel.getRadioButtonOption() == 2) {
                myModel.setEyesGreen(progress);
            }
            greenValue.setText("" + progress);
            myModel.setGreen(progress);
        } else if (seekBar.getId() == R.id.blueBar) {
            if (myModel.getRadioButtonOption() == 0) {
                myModel.setHairBlue(progress);
            } else if (myModel.getRadioButtonOption() == 1) {
                myModel.setSkinBlue(progress);
            } else if (myModel.getRadioButtonOption() == 2) {
                myModel.setEyesBlue(progress);
            }
            blueValue.setText("" + progress);
            myModel.setBlue(progress);
        }
        myView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * When an option is selected, the text and progress update accordingly.
     *
     * THIS COULD BE MORE EFFICIENT. Consider helper methods.
     *
     * @param group the group in which the checked radio button has changed
     * @param checkedId the unique identifier of the newly checked radio button
     */
    @Override
    public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
        if (checkedId == R.id.hairOption) {
            this.myModel.setRadioButtonOption(0);
            // updates the text
            redValue.setText("" + myModel.getHairRed());
            greenValue.setText("" + myModel.getHairGreen());
            blueValue.setText("" + myModel.getHairBlue());

            // updates the progress
            redSeekBar.setProgress(myModel.getHairRed());
            greenSeekBar.setProgress(myModel.getHairGreen());
            blueSeekBar.setProgress(myModel.getHairBlue());
        } else if (checkedId == R.id.skinOption) {
            this.myModel.setRadioButtonOption(1);
            // updates the text
            redValue.setText("" + myModel.getSkinRed());
            greenValue.setText("" + myModel.getSkinGreen());
            blueValue.setText("" + myModel.getSkinBlue());

            // updates the progress
            redSeekBar.setProgress(myModel.getSkinRed());
            greenSeekBar.setProgress(myModel.getSkinGreen());
            blueSeekBar.setProgress(myModel.getSkinBlue());
        } else if (checkedId == R.id.eyesOption) {
            this.myModel.setRadioButtonOption(2);
            // updates the text
            redValue.setText("" + myModel.getEyesRed());
            greenValue.setText("" + myModel.getEyesGreen());
            blueValue.setText("" + myModel.getEyesBlue());

            // updates the progress
            redSeekBar.setProgress(myModel.getEyesRed());
            greenSeekBar.setProgress(myModel.getEyesGreen());
            blueSeekBar.setProgress(myModel.getEyesBlue());
        }
        myView.invalidate();
    }

    /**
     * Changes the avatar's hairstyle according to the option selected.
     *
     * @param parent The AdapterView where the selection happened
     * @param view The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position) == "Hair Down") {
            myModel.setHairStyle(0);
        } else if (parent.getItemAtPosition(position) == "Braids") {
            myModel.setHairStyle(1);
        } else if (parent.getItemAtPosition(position) == "Bun") {
            myModel.setHairStyle(2);
        }

        myView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int getRedProgress() {
        return myModel.getRed();
    }
    public int getGreenProgress() {
        return myModel.getGreen();
    }
    public int getBlueProgress() {
        return myModel.getBlue();
    }
}
