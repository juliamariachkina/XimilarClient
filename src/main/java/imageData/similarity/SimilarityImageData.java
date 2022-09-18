package imageData.similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SimilarityImageData {
    private String id;
    private List<String> tags = new ArrayList<>();
    private Map<String, Object> fields = new HashMap<>();

    public SimilarityImageData(String id) {
        this.id = id;
    }

    public SimilarityImageData(String id, List<String> tags) {
        this.id = id;
        this.tags = tags;
    }

    public SimilarityImageData(String id, Map<String, Object> fields) {
        this.id = id;
        this.fields = fields;
    }

    public SimilarityImageData(String id, List<String> tags, Map<String, Object> fields) {
        this.id = id;
        this.tags = tags;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public List<String> getTags() {
        return List.copyOf(tags);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public Map<String, Object> getFields() {
        return Map.copyOf(fields);
    }

    public void addField(String name, String value) {
        fields.put(name, value);
    }
}
