package clients;

import imageData.similarity.SimilarityImageData;
import imageData.similarity.SimilarityImageDataBase64;
import imageData.similarity.SimilarityImageDataURL;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SimilarityClient extends RestClient {
     protected <T extends SimilarityImageData> JSONObject insertImages(String collectionId, List<T> records,
                                                                       List<String> fieldsToReturn,
                                                                       String endpoint, String authorizationToken) {
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("Input records are null or empty");
        }
        Map<String, String> headers = Map.of("collection-id", collectionId);
        JSONObject data = new JSONObject();
        if (fieldsToReturn != null && !fieldsToReturn.isEmpty()) {
            data.put("fields_to_return", fieldsToReturn);
        }
        data.put("records", createJsonObjectsFromImages(records));

        return post(data, authorizationToken, endpoint, headers);
    }

    private <T extends SimilarityImageData> List<JSONObject> createJsonObjectsFromImages(List<T> records) {
         List<JSONObject> result = new ArrayList<>();
         for (T record: records) {
             JSONObject jsonObject = new JSONObject();
             jsonObject.put("_id", record.getId());
             if (record instanceof SimilarityImageDataBase64) {
                 jsonObject.put("_base64", ((SimilarityImageDataBase64) record).getBase64Data());
             }
             if (record instanceof SimilarityImageDataURL) {
                 jsonObject.put("_url",((SimilarityImageDataURL) record).getUrl());
             }
             if (!record.getTags().isEmpty()) {
                 jsonObject.put("tags", record.getTags());
             }
             for (Map.Entry<String, Object> field: record.getFields().entrySet()) {
                 jsonObject.put(field.getKey(), field.getValue());
             }
             result.add(jsonObject);
         }
         return result;
    }
}
