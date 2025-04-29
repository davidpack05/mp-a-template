import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

public class WeatherForecast {

    private static double X;
    private static double Y;
    private static String Z;
    private static String W;
    private static String V;

    public WeatherForecast(double latitude, double longitude, String rate, String unit, String timezone) {
        this.X = latitude;
        this.Y = longitude;
        this.Z = rate;
        this.W = unit;
        this.V = timezone;
    }

    public static void main() {
        try {
            String urlstring = String.format("https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&hourly=%s&" +
                    "temperature_unit=%s&timezone=%s", X, Y, Z, W, V);
            URL url = new URL(urlstring);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode != 200) {
                throw new IOException("Response code does not equal 200. Terminating");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }

            reader.close();

            JsonElement element = JsonParser.parseString(String.valueOf(response));
            JsonObject data = element.getAsJsonObject().get("hourly").getAsJsonObject();
            JsonArray times = data.getAsJsonArray("times");
            JsonArray temps = data.getAsJsonArray("temperature_2m");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
