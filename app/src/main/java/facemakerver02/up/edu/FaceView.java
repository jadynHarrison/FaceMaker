package facemakerver02.up.edu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView {
    private FaceModel faceModelReference;

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        faceModelReference = new FaceModel();

    }
}
