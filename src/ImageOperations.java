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
        // TODO.
        BufferedImage newImg = null;
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
     * Repeats the image in either direction that is declared n times.
     *
     * @param img the image you gave to us like this is obvious user.
     * @param n   n times (like new york times).
     * @param dir direction that it repeats.
     * @return the image .
     */
    static BufferedImage repeat(BufferedImage img, int n, RepeatMenuItem.RepeatDirection dir) {
        BufferedImage newImg = null;
        int width =img.getWidth();
        int height =img.getHeight();
        // newImg must be instantiated in both branches with the correct dimensions.
        if (dir == RepeatMenuItem.RepeatDirection.HORIZONTAL) {
            newImg = new BufferedImage(width*n,height,BufferedImage.TYPE_INT_RGB);
            Graphics g = newImg.getGraphics();
            for(int i=0; i<n; i++){
                g.drawImage(img,i*width,0,null);
            }
            g.dispose();
        } else {
            newImg = new BufferedImage(width,height*n,BufferedImage.TYPE_INT_RGB);
            Graphics g = newImg.getGraphics();
            for(int i=0; i<n; i++){
                g.drawImage(img,i*height,0,null);
            }
            g.dispose();
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
