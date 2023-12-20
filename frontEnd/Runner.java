import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Runner {
	public static void main(String[] args) {
		HomePage m = new HomePage();

	}

	public void inserting_into_db(String requestType, String data, String apiRoute) {
		try {
			// Your Node.js backend URL
			String url = "http://localhost:8000/api/" + apiRoute;

			// Sample JSON data
			// String jsonInputString = "{\"username\": \"john_doe\", \"email\":
			// \"john@example.com\"}"; // String jsonInputString = "{\"username\":
			// \"john_doe\", \"email\": \"john@example.com\"}";
			String jsonInputString = data;

			// Create a URL object
			URL obj = new URL(url);

			// Open a connection
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Set the request method to POST
			con.setRequestMethod(requestType);

			// Set request headers
			con.setRequestProperty("Content-Type", "application/json");

			// Enable input/output streams
			con.setDoOutput(true);

			// Send the POST request
			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.writeBytes(jsonInputString);
				wr.flush();
			}

			// Get the HTTP response code
			int responseCode = con.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			// Read the response
			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				// Print the response
				System.out.println("Response: " + response.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
