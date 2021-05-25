package utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;

public class GoogleCaptcha {
	public static boolean validateRequest(HttpServletRequest request) throws IOException {
		String captchaResponse = request.getParameter("g-recaptcha-response");
		String secretKey = "6LdtcecaAAAAAETY2OExEK2MjjJ2OObSqbvuKRet";
		URL url = new URL("https://www.google.com/recaptcha/api/siteverify?response="+captchaResponse+"&secret="+secretKey);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		DataOutputStream dos = new DataOutputStream(con.getOutputStream());
		dos.flush();
		dos.close();
		
		InputStream is = null;
		int responseCode = con.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK) {
			is = con.getInputStream();
		}else {
			is = con.getErrorStream();
		}
		
		JsonReader jsonReader = Json.createReader(is);
		JsonObject jsonObject = jsonReader.readObject();
		
		return jsonObject.getBoolean("success");
	}
}















