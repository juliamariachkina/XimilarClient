package clients;

import imageData.similarity.SimilarityImageData;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FashionSimilarityClient extends SimilarityClient {
    public static final String FASHION_SIM_INSERT_ENDPOINT = "similarity/fashion/v2/insert";
    public static final String FASHION_SIM_KNN_ENDPOINT = "similarity/fashion/v2/visualKNN";

    private String token;

    public FashionSimilarityClient(String authorizationToken) {
        super();
        this.token = authorizationToken;
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records, List<String> fieldsToReturn) {
        return insertImages(collectionId, records, fieldsToReturn, FASHION_SIM_INSERT_ENDPOINT, token);
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records) {
        return insertImages(collectionId, records, new ArrayList<>(), FASHION_SIM_INSERT_ENDPOINT, token);
    }
}
