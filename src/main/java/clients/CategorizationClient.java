package clients;

import imageData.categorization.CategorizationImageDataBase64;
import imageData.categorization.CategorizationImageDataURL;
import org.json.JSONObject;
import utility.Utility;

import java.util.List;

public class CategorizationClient extends RestClient {
    public static final String CLASSIFY_ENDPOINT = "recognition/v2/classify";
    public static final String TASK_ENDPOINT = "recognition/v2/task";
    public static final String TRAINING_ENDPOINT = "recognition/v2/training-image";
    private String token;

    public CategorizationClient(String authorizationToken) {
        token = authorizationToken;
    }

    public JSONObject classifyImages(List<String> localImagesPaths, List<String> imageURLs,
                                            String taskID) {
        return classifyImages(localImagesPaths, imageURLs, taskID, null, false);
    }

    public JSONObject classifyImages(List<String> localImagesPaths, List<String> imageURLs,
                                            String taskID, int modelVersion) {
        return classifyImages(localImagesPaths, imageURLs, taskID, modelVersion, false);
    }

    public JSONObject classifyImages(List<String> localImagesPaths, List<String> imageURLs,
                                            String taskID, boolean storeImages) {
        return classifyImages(localImagesPaths, imageURLs, taskID, null, storeImages);
    }

    public JSONObject classifyImages(List<String> localImagesPaths, List<String> imageURLs,
                                            String taskID, Integer modelVersion, boolean storeImages) {
        JSONObject result = null;
        try {
            List<JSONObject> records = Utility.createJsonObjectsFromLocalImages(localImagesPaths);
            records.addAll(Utility.createJsonObjectsFromImageURLs(imageURLs));

            JSONObject data = new JSONObject();
            data.put("task", taskID);
            if (modelVersion != null) {
                data.put("version", modelVersion);
            }
            data.put("store_images", storeImages);
            data.put("records", records);

            result = post(data, token, CLASSIFY_ENDPOINT);

        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    public JSONObject listTasks() {
        JSONObject result = get(token, TASK_ENDPOINT);
        System.out.println(result);
        return result;
    }

    public JSONObject uploadTrainingImage(CategorizationImageDataURL imageDataURL) {
        JSONObject data = new JSONObject();
        data.put("url", imageDataURL.getUrl());
        data.put("meta_data", new JSONObject(imageDataURL.getMetaData()));

        return post(data, token, TRAINING_ENDPOINT);
    }

    public JSONObject uploadTrainingImage(CategorizationImageDataBase64 imageDataBase64) {
        JSONObject data = new JSONObject();
        data.put("base64", imageDataBase64.getBase64Data());
        data.put("meta_data", new JSONObject(imageDataBase64.getMetaData()));

        return post(data, token, TRAINING_ENDPOINT);
    }
}
