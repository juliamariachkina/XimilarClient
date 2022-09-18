package imageData.similarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarityImageDataBase64 extends SimilarityImageData {
    private String base64Data;

    public SimilarityImageDataBase64(String id, String base64Data) {
        super(id);
        this.base64Data = base64Data;
    }

    public SimilarityImageDataBase64(String id, List<String> tags, String base64Data) {
        super(id, tags);
        this.base64Data = base64Data;
    }

    public SimilarityImageDataBase64(String id, Map<String, Object> fields, String base64Data) {
        super(id, fields);
        this.base64Data = base64Data;
    }

    public SimilarityImageDataBase64(String id, List<String> tags, Map<String, Object> fields, String base64Data) {
        super(id, tags, fields);
        this.base64Data = base64Data;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }
}
