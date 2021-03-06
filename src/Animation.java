import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animation {

    BufferedImage[] image;

    int current = 0;

    final int STILL = 0;

    int delay = 10;

    public Animation(String name, int count, String fileType) {
        image = new BufferedImage[count];

        for(int i = 0; i < count; i++) {
            try {
                image[i] = ImageIO.read(new File("./images/" + name + i + "." + fileType));
            } catch (IOException e) {
            }
        }
    }

    public void draw(Graphics gfx) {
        gfx.drawImage(getCurrentImage(), 200, 200,null);
    }

    public Image getCurrentImage() {
        if(MySimpleGame.speed > 1) {
            if(delay == 0) {
                current++;
                if(current == image.length) {
                    current = 0;
                }
                delay = 6;
            }

            delay--;

            return image[current];
        }
        else {
            if(delay == 0) {
                current++;
                if(current == image.length) {
                    current = 0;
                }
                delay = 10;
            }

            delay--;

            return image[current];
        }
    }

    public Image shootAnimation() {
        if(delay == 0) {
            current++;

            if(current == image.length) {
                current = 9;
            }
            delay = 10;
        }
        delay--;

        return image[current];
    }

    public Image deathAnimation() {
        if(delay == 0) {
            current++;

            if(current == image.length) {
                current = 9;
            }
            delay = 10;
        }
        delay--;

        return image[current];
    }

    public Image getStillImage() {
        return image[STILL];
    }
}
