import java.io.*;
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
            con.setRequestProperty("User-Agent", "Java Application");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Content-", "application/json");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes("");
            out.flush();
            out.close();
            String httpRetorno = convertStreamToString( con.getInputStream() );
            System.out.println("Status: " + con.getResponseCode() + ": " + con.getResponseMessage() + "\n\n");
            return httpRetorno;
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
            String httpRetorno = convertStreamToString( con.getInputStream() );
            System.out.println("Status: " + con.getResponseCode() + ": " + con.getResponseMessage() + "\n\n");
            return httpRetorno;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Ok";
    }


    public static String convertStreamToString(InputStream is) throws IOException {

        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } else {
            return "";
        }
    }

}
