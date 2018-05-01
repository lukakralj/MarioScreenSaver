package mario.saver;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Main thread that controls the behaviour of the app.
 */
public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    private static Canvas canvas;

    /**
     * Create new main thread.
     *
     * @param surfaceHolder
     * @param gameView
     */
    public MainThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
        running = false;
    }

    /**
     * Starts the thread.
     */
    @Override
    public void run() {
        while (running) {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Set running to false to stop the thread.
     * 
     * @param isRunning
     */
    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}
