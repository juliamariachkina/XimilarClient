package clients;

import imageData.similarity.SimilarityImageData;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ImageMatchingClient extends SimilarityClient {
    public static final String IMAGE_MATCHING_INSERT_ENDPOINT = "image_matching/v2/insert";
    public static final String IMAGE_MATCHING_KNN_ENDPOINT = "image_matching/v2/visualKNN";

    private String token;

    public ImageMatchingClient(String authorizationToken) {
        super();
        this.token = authorizationToken;
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records) {
        return insertImages(collectionId, records, new ArrayList<>(), IMAGE_MATCHING_INSERT_ENDPOINT, token);
    }
}
