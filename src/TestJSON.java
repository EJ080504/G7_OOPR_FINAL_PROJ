import org.json.JSONObject;

public class TestJSON {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("message", "JSON is working!");
        System.out.println(json.toString());
    }
}