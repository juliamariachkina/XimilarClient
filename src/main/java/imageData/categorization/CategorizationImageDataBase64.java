package imageData.categorization;

import java.util.HashMap;
import java.util.Map;

public class CategorizationImageDataBase64 extends CategorizationImageData {
    private String base64Data;

    public CategorizationImageDataBase64(Map<String, String> labelsToValues, Map<String, String> metaData, String base64Data) {
        super(labelsToValues, metaData);
        this.base64Data = base64Data;
    }

    public CategorizationImageDataBase64(String base64Data) {
        super(new HashMap<>(), new HashMap<>());
        this.base64Data = base64Data;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }
}
