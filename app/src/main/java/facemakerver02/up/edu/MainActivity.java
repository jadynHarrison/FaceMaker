package facemakerver02.up.edu;

/**
 * @author Jadyn Harrison
 */

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //values for the hairstyle spinner
    String[] hairstyles = {
            "Ponytail",
            "Braid",
            "Curls"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FaceView fv = findViewById(R.id.faceView);
        /** External Citation
         * Date: 17 February 2026
         * Problem: Could not insert FaceView into activity_main.xml
         * Resource: https://www.youtube.com/watch?v=EB9tIkB2SJI
         * Solution: He walked through the steps
         */
        //create the controller object
        FaceController fixYourFace = new FaceController(fv);


        //initialize the hair spinner
        Spinner hairSpinner = findViewById(R.id.spinnerHair);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.hairstyles);
        hairSpinner.setAdapter(hairAdapter);

// I couldn't figure this out. I know we did it in class. I'll fix my work.
//        TextView greenValue = findViewById(R.id.greenValue);
//        TextView blueValue = findViewById(R.id.blueValue);

        //seekbar listeners
        SeekBar redBar = findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(fixYourFace);

        SeekBar greenBar = findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(fixYourFace);

        SeekBar blueBar = findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(fixYourFace);

        TextView redValue = findViewById(R.id.redValue);
        redValue.setText(fixYourFace.redProgress + "");
    }
}