package kr.dteng.api;

// 네이버 캡차 API 예제 - 키발급
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class APIExamCaptchaNkey {

	public static String getCaptchaKey() {
		String clientId = "7ktlcdansh";
		String clientSecret = "aKNvBJMqSEPtunC7q6lumcM40m6RGAJJspVeYK5f";
		try {
			String code = "0";
			String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
//			System.out.println(response.toString());

			return response.toString();
		} catch (Exception e) {
			System.out.println(e);
			return "Error: " + e.getMessage();
		}
	}
}
