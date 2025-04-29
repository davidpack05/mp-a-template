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
        WeatherForecast.X = latitude;
        WeatherForecast.Y = longitude;
        WeatherForecast.Z = rate;
        WeatherForecast.W = unit;
        WeatherForecast.V = timezone;
    }

    public static void main(String[] args) {
        try {
            new WeatherForecast(40.7128, -74.0060, "temperature_2m", "fahrenheit", "America/New_York");

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
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }

            reader.close();

            JsonElement element = JsonParser.parseString(response.toString());
            JsonObject data = element.getAsJsonObject().get("hourly").getAsJsonObject();
            JsonArray times = data.getAsJsonArray("time");
            JsonArray temps = data.getAsJsonArray("temperature_2m");

            System.out.println("7-Day Forecast in Fahrenheit:");
            String currentDate="";
            for (int i =0; i<times.size();i++){
                String dateTime = times.getAsString();
                String date = dateTime.split("T")[0];
                String time = dateTime.split("T")[1];
                if (!date.equals(currentDate)) {
                    currentDate = date;
                    System.out.println("Forecast for " + currentDate + ":");
                }
                double temp = temps.get(i).getAsDouble();
                System.out.printf("%s: %.1f°F%n", time, temp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
