package clients;

import imageData.similarity.SimilarityImageData;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomSimilarityClient extends SimilarityClient {
    public static final String CUSTOM_SIM_INSERT_ENDPOINT = "similarity/custom/v2/insert";
    public static final String CUSTOM_SIM_KNN_ENDPOINT = "similarity/custom/v2/visualKNN";

    private String token;

    public CustomSimilarityClient(String authorizationToken) {
        super();
        this.token = authorizationToken;
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records, List<String> fieldsToReturn) {
        return insertImages(collectionId, records, fieldsToReturn, CUSTOM_SIM_INSERT_ENDPOINT, token);
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records) {
        return insertImages(collectionId, records, new ArrayList<>(), CUSTOM_SIM_INSERT_ENDPOINT, token);
    }
}
