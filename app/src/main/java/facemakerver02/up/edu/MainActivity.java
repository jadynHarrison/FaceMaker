package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // text views to update
    TextView redValue;
    TextView greenValue;
    TextView blueValue;

    // seek bars to update
    SeekBar redSeekBar;
    SeekBar greenSeekBar;
    SeekBar blueSeekBar;
    //values for the hairstyle spinner
    String[] hairstyles = {
            "Hair Down",
            "Braids",
            "Bun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redValue = findViewById(R.id.redValue);
        greenValue = findViewById(R.id.greenValue);
        blueValue = findViewById(R.id.blueValue);
        redSeekBar = findViewById(R.id.redBar);
        greenSeekBar = findViewById(R.id.greenBar);
        blueSeekBar = findViewById(R.id.blueBar);

        FaceView fv = findViewById(R.id.faceView);
        /** External Citation
         * Date: 17 February 2026
         * Problem: Could not insert FaceView into activity_main.xml
         * Resource: https://www.youtube.com/watch?v=EB9tIkB2SJI
         * Solution: He walked through the steps
         */
        //create the controller object
        FaceController fixYourFace = new FaceController(fv, redValue, greenValue, blueValue, redSeekBar, greenSeekBar, blueSeekBar);

        // initializes the seek bars to the correct positions
        redSeekBar.setProgress(fixYourFace.getRedProgress());
        greenSeekBar.setProgress(fixYourFace.getGreenProgress());
        blueSeekBar.setProgress(fixYourFace.getBlueProgress());

        // initializes the text to match the seek bar value
        redValue.setText("" + fixYourFace.getRedProgress());
        greenValue.setText("" + fixYourFace.getGreenProgress());
        blueValue.setText("" + fixYourFace.getBlueProgress());


        //initialize the hair spinner
        Spinner hairSpinner = findViewById(R.id.spinnerHair);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.hairstyles);
        hairSpinner.setAdapter(hairAdapter);
        hairSpinner.setOnItemSelectedListener(fixYourFace);

        //spinner listener
        //hairSpinner.setOnItemSelectedListener(hairAdapter.OnItem);

        //radio group listener
        RadioGroup videoKilledTheRadioStar = findViewById(R.id.radio_group);
        videoKilledTheRadioStar.setOnCheckedChangeListener(fixYourFace);

        //seekbar listeners
        SeekBar redBar = findViewById(R.id.redBar);
        redBar.setMax(255);
        redBar.setOnSeekBarChangeListener(fixYourFace);

        SeekBar greenBar = findViewById(R.id.greenBar);
        greenBar.setMax(255);
        greenBar.setOnSeekBarChangeListener(fixYourFace);

        SeekBar blueBar = findViewById(R.id.blueBar);
        blueBar.setMax(255);
        blueBar.setOnSeekBarChangeListener(fixYourFace);

        Button randomFace = findViewById(R.id.randomFaceButton);
        randomFace.setOnClickListener(fixYourFace);

//        fv.updateRedTV(redValue);
//        fv.updateGreenTV(greenValue);
//        fv.updateBlueTV(blueValue);
//
//        TextView redValue = findViewById(R.id.redValue);
//        redValue.setText(fixYourFace.redProgress + "");
    }

//    public void updateRGBValues (FaceView fv) {
//        fv.updateRedTV(redValue);
//        fv.updateGreenTV(greenValue);
//        fv.updateBlueTV(blueValue);
//    }
}