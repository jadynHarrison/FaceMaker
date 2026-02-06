package facemakerver02.up.edu;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private FaceModel myModel;

    //references to modifiable GUI components
    private TextView redValue;
    private TextView greenValue;
    private TextView blueValue;
    public FaceController(FaceModel barbie, TextView _red, TextView _green, TextView _blue) {
        this.myModel = barbie;
        this.redValue = _red;
        this.greenValue = _green;
        this.blueValue = _blue;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.redValue.setText("" + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
