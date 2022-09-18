package clients;

import imageData.similarity.SimilarityImageData;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductSimilarityClient extends SimilarityClient {
    public static final String PRODUCT_SIMILARITY_INSERT = "similarity/photos/v2/insert";
    public static final String PRODUCT_SIMILARITY_KNN = "similarity/photos/v2/insert";

    private String token;

    public ProductSimilarityClient(String authorizationToken) {
        super();
        this.token = authorizationToken;
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records, List<String> fieldsToReturn) {
        return insertImages(collectionId, records, fieldsToReturn, PRODUCT_SIMILARITY_INSERT, token);
    }

    public <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records) {
        return insertImages(collectionId, records, new ArrayList<>(), PRODUCT_SIMILARITY_INSERT, token);
    }
}
