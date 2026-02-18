package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import android.app.Activity;
import android.view.View;
import android.widget.SeekBar;
import android.view.View;
import android.widget.TextView;

//this will be more useful later on. I don't want to start from scratch later. it's a work in progress
public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private FaceModel myModel;
    private FaceView myView;

    //references to modifiable GUI components
    //THIS DOESN'T WORK. Welcome to one of my many attempts at TextView.
//    private TextView redValue = findViewById(R.id.redValue);
//    private TextView greenValue;
//    private TextView blueValue;
    public int redProgress;
    public FaceController(FaceView expectFaceView) {
        myView = expectFaceView;
        myModel = myView.grantReferenceAccess();
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * Seekbar listener.
     * CAVEAT: I can determine the progress of the seekbar BUT not update the TextView
     *
     * @param seekBar The SeekBar whose progress has changed
     * @param progress The current progress level. This will be in the range min..max where min
     *                 and max were set by {@link ProgressBar#setMin(int)} and
     *                 {@link ProgressBar#setMax(int)}, respectively. (The default values for
     *                 min is 0 and max is 100.)
     * @param fromUser True if the progress change was initiated by the user.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.redBar) {
            redProgress = seekBar.getProgress();
            //redValue.setText(myModel._redValue + "");
        }
        // IT HALF WORKS.
        //this.redValue = (TextView) MainActivity.findViewById(R.id.redValue);
//        } else if (seekBar.getId() == R.id.greenBar) {
//            myModel._greenValue = seekBar.getProgress();
//            greenValue.setText(myModel._greenValue + "");
//        } else if (seekBar.getId() == R.id.blueBar) {
//            myModel._blueValue = seekBar.getProgress();
//            blueValue.setText(myModel._blueValue + "");
//        }
        myView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
