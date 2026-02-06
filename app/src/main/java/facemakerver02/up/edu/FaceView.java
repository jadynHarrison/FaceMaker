package facemakerver02.up.edu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/*eventually, according to the project description, we'll
 *a view class that's a subclass of SurfaceView. This class
 * doesn't correspond to the SurfaceView in the xml, however,
 * it might be useful later so I'm keeping it.
 */
public class FaceView extends SurfaceView {
    private FaceModel faceModelReference;

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        faceModelReference = new FaceModel();

    }
}
