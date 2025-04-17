import java.awt.*;
import java.awt.image.BufferedImage;

class ImageOperations {

    /**
     * returns the image with the red channel pixels removed.
     *
     * @param img is the image to remove the red pixels from.
     * @return a new image.
     */
    static BufferedImage zeroRed(BufferedImage img) {
        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage newImg = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color rgb = new Color(img.getRGB(x,y));

                int r = 0;
                int g = rgb.getGreen();
                int b = rgb.getBlue();

                Color newRGB = new Color(r,g,b);

                newImg.setRGB(x, y, newRGB.getRGB());

            }
        }

        return newImg;
    }

    /**
     * TODO.
     *
     * @param img TODO.
     * @return TODO.
     */
    static BufferedImage grayscale(BufferedImage img) {
        // TODO.
        BufferedImage newImg = null;
        return newImg;
    }

    /**
     * Invert the pixels of an image, by subtracting the pixel values by the max amount, IE. 255 255 255 inverse = 0 0 0.
     *
     * @param img Is the image to invert.
     * @return a new image.
     */
    static BufferedImage invert(BufferedImage img) {
        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage newImg = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color rgb = new Color(img.getRGB(x, y));

                int r = 255 - rgb.getRed();
                int g = 255 - rgb.getGreen();
                int b = 255 - rgb.getBlue();

                Color newRGB = new Color(r,g,b);

                newImg.setRGB(x, y, newRGB.getRGB());
            }
        }

        return newImg;
    }

    /**
     * mirrors the image, IE pixels on right side go to left side, and pixels on left side go to right side.
     *
     * @param img image to be mirrored.
     * @param dir the direction in which to mirror.
     * @return the mirrored image.
     */
    static BufferedImage mirror(BufferedImage img, MirrorMenuItem.MirrorDirection dir) {
        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage newImg = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

        if (dir == MirrorMenuItem.MirrorDirection.VERTICAL) {
            for (int y = 0; y < height; y++ ) {
                int x = 0;
                while (x < width / 2) {
                    Color rgb = new Color(img.getRGB(x, y));
                    newImg.setRGB(x,y,rgb.getRGB());
                    x++;
                }
                int x2 = width / 2;
                x = width / 2;
                while (x < width) {
                    Color rgb = new Color(img.getRGB(x2, y));
                    newImg.setRGB(x,y,rgb.getRGB());
                    x++;
                    x2--;
                }
            }
        } else {
            for (int x = 0; x < height; x++ ) {
                int y = 0;
                while (y < width / 2) {
                    Color rgb = new Color(img.getRGB(x, y));
                    newImg.setRGB(x,y,rgb.getRGB());
                    y++;
                }
                int y2 = width / 2;
                y = width / 2;
                while (y < width) {
                    Color rgb = new Color(img.getRGB(x, y2));
                    newImg.setRGB(x,y,rgb.getRGB());
                    y++;
                    y2--;
                }
            }
        }
        return newImg;
    }

    /**
     * TODO.
     *
     * @param img TODO.
     * @param dir TODO.
     * @return TODO.
     */
    static BufferedImage rotate(BufferedImage img, RotateMenuItem.RotateDirection dir) {
        // TODO instantiate newImg with the *correct* dimensions.
        BufferedImage newImg = null;
        if (dir == RotateMenuItem.RotateDirection.CLOCKWISE) {
            // TODO rotate the image clockwise.
        } else {
            // TODO rotate the image counter-clockwise.
        }
        return newImg;
    }

    /**
     * TODO.
     *
     * @param img TODO.
     * @param n   TODO.
     * @param dir TODO.
     * @return TODO.
     */
    static BufferedImage repeat(BufferedImage img, int n, RepeatMenuItem.RepeatDirection dir) {
        BufferedImage newImg = null;
        // newImg must be instantiated in both branches with the correct dimensions.
        if (dir == RepeatMenuItem.RepeatDirection.HORIZONTAL) {
            // TODO repeat the image horizontally.
        } else {
            // TODO repeat the image vertically.
        }
        return newImg;
    }

    /**
     * Zooms in on the image. The zoom factor increases in multiplicatives of 10% and
     * decreases in multiplicatives of 10%.
     *
     * @param img        the original image to zoom in on. The image cannot be already zoomed in
     *                   or out because then the image will be distorted.
     * @param zoomFactor The factor to zoom in by.
     * @return the zoomed in image.
     */
    static BufferedImage zoom(BufferedImage img, double zoomFactor) {
        int newImageWidth = (int) (img.getWidth() * zoomFactor);
        int newImageHeight = (int) (img.getHeight() * zoomFactor);
        BufferedImage newImg = new BufferedImage(newImageWidth, newImageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = newImg.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(img, 0, 0, newImageWidth, newImageHeight, null);
        g2d.dispose();
        return newImg;
    }
}
