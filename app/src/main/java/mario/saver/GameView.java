package mario.saver;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Represents the main view of the game.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread mainThread;
    private CharacterImage characterImage;

    public GameView(Context context) {
        super(context);
        // Create the character for the app.
        characterImage = new CharacterImage(BitmapFactory.decodeResource(getResources(), R.drawable.pixel_mario));
        getHolder().addCallback(this);
        mainThread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * When the surface is created the animation starts.
     *
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mainThread.setRunning(true);
        mainThread.start();
    }

    /**
     * When surface is destroyed the animation stops.
     *
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                mainThread.setRunning(false);
                mainThread.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    /**
     * Repaint the canvas.
     * 
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            characterImage.draw(canvas);
        }
    }

    /**
     * Update the (view and) character's properties.
     */
    public void update() {
        characterImage.update();
    }
}
