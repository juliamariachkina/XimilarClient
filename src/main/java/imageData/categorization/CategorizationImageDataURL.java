package imageData.categorization;

import java.util.HashMap;
import java.util.Map;

public class CategorizationImageDataURL extends CategorizationImageData {
    private String url;

    public CategorizationImageDataURL(Map<String, String> labelsToValues, Map<String, String> metaData, String url) {
        super(labelsToValues, metaData);
        this.url = url;
    }

    public CategorizationImageDataURL(String url) {
        super(new HashMap<>(), new HashMap<>());
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
