import java.awt.*;
import java.awt.image.BufferedImage;

class ImageOperations {

    /**
     * TODO.
     *
     * @param img TODO.
     * @return TODO.
     */
    static BufferedImage zeroRed(BufferedImage img) {
        // TODO.
        BufferedImage newImg = null;
        return newImg;
    }

    /**
     * TODO.
     *
     * @param img TODO.
     * @return TODO.
     */
    static BufferedImage grayscale(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(width, height, img.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color rgb = new Color(img.getRGB(x,y));

                int r = rgb.getRed();
                int g = rgb.getGreen();
                int b = rgb.getBlue();

                int gray = (int)(0.299 * r + 0.587 * g + 0.114 * b);

                Color grayColor = new Color(gray, gray, gray);

                newImg.setRGB(x,y, grayColor.getRGB());
            }
        }




        //BufferedImage newImg = null;
        return newImg;
    }

    /**
     * TODO.
     * @param img TODO.
     * @return TODO.
     */
    static BufferedImage invert(BufferedImage img) {
        // TODO.
        BufferedImage newImg = null;
        return newImg;
    }

    /**
     * TODO.
     *
     * @param img TODO.
     * @param dir TODO.
     * @return TODO.
     */
    static BufferedImage mirror(BufferedImage img, MirrorMenuItem.MirrorDirection dir) {
        // TODO instantiate newImg with the *correct* dimensions.
        BufferedImage newImg = null;
        if (dir == MirrorMenuItem.MirrorDirection.VERTICAL) {
            // TODO mirror the image vertically.
        } else {
            // TODO mirror the image horizontally.
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
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(height, width, img.getType());

        if (dir == RotateMenuItem.RotateDirection.CLOCKWISE) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = img.getRGB(x,y);
                    newImg.setRGB(height - 1 - y, x, rgb);
                }
            }
        } else {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = img.getRGB(x, y);
                    newImg.setRGB(y, width - 1 - x, rgb);
                }
            }
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
