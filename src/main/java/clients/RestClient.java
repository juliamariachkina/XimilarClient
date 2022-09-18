package clients;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RestClient {
    public static final String BASE_URL = "https://api.ximilar.com/";

    public static JSONObject get(String authorizationToken, String endpoint) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(BASE_URL + endpoint);
            httpGet.addHeader("authorization", authorizationToken);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return new JSONObject(new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            System.err.println(e);
        }
        return new JSONObject();
    }

    public static JSONObject post(JSONObject data, String authorizationToken, String endpoint) {
        return post(data, authorizationToken, endpoint, new HashMap<>());
    }

    public static JSONObject post(JSONObject data, String authorizationToken, String endpoint, Map<String, String> headers) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            StringEntity requestEntity = new StringEntity(data.toString(4), ContentType.APPLICATION_JSON);

            HttpPost httpPost = new HttpPost(BASE_URL + endpoint);
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpPost.addHeader(header.getKey(), header.getValue());
            }
            httpPost.addHeader("authorization", authorizationToken);
            httpPost.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(httpPost);
            return new JSONObject(new BufferedReader(new InputStreamReader(response.getEntity().getContent())).lines().collect(Collectors.joining("\n")));
        } catch (Exception e) {
            System.err.println(e);
        }
        return new JSONObject();
    }
}
