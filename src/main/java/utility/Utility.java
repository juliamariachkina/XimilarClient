package utility;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Utility {
    public static BufferedImage readLocalImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println(e);
        }
        return img;
    }

    public static BufferedImage readImageFromUrl(String stringUrl) {
        BufferedImage img = null;
        try {
            URL url = new URL(stringUrl);
            img = ImageIO.read(url);
        } catch (Exception e) {
            System.err.println(e);
        }
        return img;
    }

    public static String convertImageToBase64(String path) throws IOException {
        return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(path)));
    }

    public static List<JSONObject> createJsonObjectsFromLocalImages(List<String> localImagesPaths) throws IOException {
        List<JSONObject> result = new ArrayList<>();
        if (localImagesPaths == null) {
            return result;
        }
        for (String imagePath: localImagesPaths) {
            JSONObject image = new JSONObject();
            image.put("_base64", convertImageToBase64(imagePath));
            result.add(image);
        }
        return result;
    }

    public static List<JSONObject> createJsonObjectsFromImageURLs(List<String> imageURLs) {
        List<JSONObject> result = new ArrayList<>();
        if (imageURLs == null) {
            return result;
        }
        for (String imagePath: imageURLs) {
            JSONObject image = new JSONObject();
            image.put("_url", imagePath);
            result.add(image);
        }
        return result;
    }
}
