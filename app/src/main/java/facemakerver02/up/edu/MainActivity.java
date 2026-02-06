package facemakerver02.up.edu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private FaceModel myModel;
    String[] hairstyles = {
            "Ponytail",
            "Braid",
            "Curls"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the hair spinner
        Spinner hairSpinner = findViewById(R.id.spinnerHair);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.hairstyles);
        hairSpinner.setAdapter(hairAdapter);

        //create the model object
        myModel = new FaceModel();

        //create the controller object
        TextView redValue = findViewById(R.id.redValue);
        TextView greenValue = findViewById(R.id.greenValue);
        TextView blueValue = findViewById(R.id.blueValue);
        FaceController fixYourFace = new FaceController(myModel, redValue, greenValue, blueValue);
    }
}