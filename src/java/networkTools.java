import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class networkTools {

    private String basicUsername = "";
    private String basicPassword = "";

    public String POST(String StringURL,String Payload) {
        try {
            URL url = new URL(StringURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);
            if (!basicUsername.equals("")) {
                con.setRequestProperty("Authorization", "Basic " +
                        DatatypeConverter.printBase64Binary((basicUsername+":"+basicPassword).getBytes())
                );
            }
            con.setRequestProperty("User-Agent", "Java Application");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(Payload);
            out.flush();
            out.close();

            System.out.println("Status: " + con.getResponseCode() + ": " + con.getResponseMessage() + "\n\n");
            String httpRetorno = "";
            if (con.getResponseCode()==200){
                httpRetorno = convertStreamToString(con.getInputStream());
            } else {
                httpRetorno = convertStreamToString(con.getErrorStream());
            }
            return httpRetorno;

        } catch (Exception e) {
            System.out.println(e);
        }
        return "Ok";
    }

    public String GET(String StringURL) {
        URL url;
        HttpURLConnection con;
        try {
            url = new URL(StringURL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setInstanceFollowRedirects(true);
            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);
            if (!basicUsername.equals("")) {
                con.setRequestProperty("Authorization", "Basic " +
                        DatatypeConverter.printBase64Binary((basicUsername+":"+basicPassword).getBytes())
                );
            }
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            System.out.println("Status: " + con.getResponseCode() + ": " + con.getResponseMessage() + "\n\n");
            String httpRetorno = "";
            if (con.getResponseCode()==200){
                httpRetorno = convertStreamToString(con.getInputStream());
            } else {
                httpRetorno = convertStreamToString(con.getErrorStream());
            }
            return httpRetorno;
        } catch (Exception e) {
            System.out.println("Exception.");
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

    public String getBasicUsername() {
        return ""; // Don't ever mind that you can recover this!
    }

    public void setBasicUsername(String basicUsername) {
        this.basicUsername = basicUsername;
    }

    public String getBasicPassword() {
        return ""; // Don't ever mind that you can recover this ANYWAYS!
    }

    public void setBasicPassword(String basicPassword) {
        this.basicPassword = basicPassword;
    }


}
