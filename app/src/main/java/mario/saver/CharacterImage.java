package mario.saver;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

public class CharacterImage {
    private Bitmap image;
    private int x, y;
    private int xVelocity;
    private int yVelocity;
    private int screenWidth;
    private int screenHeight;

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

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update() {
        x += xVelocity;
        y += yVelocity;

        if ((x > screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity *= -1;
        }
        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
            yVelocity *= -1;
        }
    }
}
