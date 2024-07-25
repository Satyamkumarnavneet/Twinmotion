package org.twinmotion.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

    public static void blendImages(String imagePath1, String imagePath2, String outputImagePath) throws IOException {
        BufferedImage image1 = ImageIO.read(new File(imagePath1));
        BufferedImage image2 = ImageIO.read(new File(imagePath2));

        int width = Math.min(image1.getWidth(), image2.getWidth());
        int height = Math.min(image1.getHeight(), image2.getHeight());

        BufferedImage blendedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = blendedImage.createGraphics();
        g2d.drawImage(image1, 0, 0, width, height, null);
        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2d.setComposite(alpha);
        g2d.drawImage(image2, 0, 0, width, height, null);
        g2d.dispose();

        ImageIO.write(blendedImage, "jpg", new File(outputImagePath));
    }
}
