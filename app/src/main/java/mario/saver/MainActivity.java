package mario.saver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Main (and only) screen of the app.
 */
public class MainActivity extends Activity {

    /**
     * Create activity with new GameView.
     * 
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GameView(this));
    }
}
