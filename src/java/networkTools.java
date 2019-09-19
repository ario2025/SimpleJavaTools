import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class networkTools {

    public String POST(String StringURL) {
        try {
            URL url = new URL(StringURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Content-", "application/json");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes("");
            out.flush();
            out.close();
            System.out.println("Status: " + con.getResponseCode() + ": " + con.getResponseMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Ok";
    }

    public String GET(String StringURL) {
        try {
            URL url = new URL(StringURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            System.out.println("Status: " + con.getResponseCode() + ": " + con.getResponseMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Ok";
    }

}
