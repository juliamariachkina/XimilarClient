package imageData.categorization;

import java.util.Map;

public abstract class CategorizationImageData {
    private Map<String, String> labelsToValues;
    private Map<String, String> metaData;

    public CategorizationImageData(Map<String, String> labelsToValues, Map<String, String> metaData) {
        this.labelsToValues = labelsToValues;
        this.metaData = metaData;
    }

    public Map<String, String> getLabels() {
        return Map.copyOf(labelsToValues);
    }

    public void addLabel(String label, String value) {
        labelsToValues.put(label, value);
    }

    public void deleteLabel(String label) {
        labelsToValues.remove(label);
    }

    public void updateLabel(String label, String value) {
        addLabel(label, value);
    }

    public Map<String, String> getMetaData() {
        return Map.copyOf(metaData);
    }
}
