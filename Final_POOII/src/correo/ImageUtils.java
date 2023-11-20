package correo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * La clase ImageUtils proporciona utilidades para trabajar con imágenes.
 */
public class ImageUtils {
    
    /**
     * Convierte una imagen en un flujo de entrada (InputStream) en el formato especificado.
     *
     * @param image  La imagen a convertir.
     * @param format El formato de la imagen (por ejemplo, "png", "jpeg").
     * @return Un flujo de entrada que representa la imagen convertida.
     * @throws IOException Si ocurre un error de E/S durante la conversión.
     */
    public static InputStream convertImageToInputStream(Image image, String format) throws IOException {
        BufferedImage bufferedImage = toBufferedImage(image);
        return convertBufferedImageToInputStream(bufferedImage, format);
    }

    private static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // Crea una BufferedImage y dibuja la imagen en ella
        BufferedImage bufferedImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );

        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        return bufferedImage;
    }

    private static InputStream convertBufferedImageToInputStream(BufferedImage bufferedImage, String format) throws IOException {
        // Convierte BufferedImage a bytes
        byte[] imageBytes = convertBufferedImageToBytes(bufferedImage, format);

        // Convierte bytes a InputStream
        return new ByteArrayInputStream(imageBytes);
    }

    private static byte[] convertBufferedImageToBytes(BufferedImage bufferedImage, String format) throws IOException {
        // Convierte BufferedImage a bytes
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, format, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}