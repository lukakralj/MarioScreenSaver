package mario.saver;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Random;

/**
 * Represents the character that is moving on the screen.
 */
public class CharacterImage {
    private Bitmap image;
    private int x, y;
    private int xVelocity;
    private int yVelocity;
    private int screenWidth;
    private int screenHeight;

    /**
     * Create new character.
     *
     * @param bmp This image appears on the screen and represents the character.
     */
    public CharacterImage(Bitmap bmp) {
        image = bmp;

        xVelocity = 10;
        yVelocity = 5;
        screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        Random rand = new Random();
        x = rand.nextInt(screenWidth - image.getWidth());
        y = rand.nextInt(screenHeight - image.getHeight());
    }

    /**
     * Draw the character on the canvas.
     *
     * @param canvas Canvas to draw the character on.
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    /**
     * Update the character's properties.
     */
    public void update() {
        x += xVelocity;
        y += yVelocity;

        // If we reached the end of the screen the character needs to start moving to the other direction.
        if ((x > screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity *= -1;
        }
        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
            yVelocity *= -1;
        }
    }
}
