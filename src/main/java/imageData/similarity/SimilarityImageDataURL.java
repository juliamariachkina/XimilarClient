package imageData.similarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarityImageDataURL extends SimilarityImageData {
    private String url;

    public SimilarityImageDataURL(String id, String url) {
        super(id);
        this.url = url;
    }

    public SimilarityImageDataURL(String id, List<String> tags, String url) {
        super(id, tags);
        this.url = url;
    }

    public SimilarityImageDataURL(String id, Map<String, Object> fields, String url) {
        super(id, fields);
        this.url = url;
    }

    public SimilarityImageDataURL(String id, List<String> tags, Map<String, Object> fields, String url) {
        super(id, tags, fields);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
