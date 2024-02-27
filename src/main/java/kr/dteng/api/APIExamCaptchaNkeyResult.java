package kr.dteng.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIExamCaptchaNkeyResult {
	
	// JSON 파싱 하는 메소드
    public static String parsing (String jsonString) {
    	
    	String extractedValue = null;
    	
    	try {
			// JSON 파싱
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonString);

			// "result"에 대응하는 값 추출
			extractedValue = jsonNode.get("result").asText();

		} catch (Exception e) {
			e.printStackTrace();
		}
    	return extractedValue;
    }

    public static String CheckingCode(String key, String userValue) {
        String clientId = "7ktlcdansh";  // 애플리케이션 클라이언트 아이디값
        String clientSecret = "aKNvBJMqSEPtunC7q6lumcM40m6RGAJJspVeYK5f";  // 애플리케이션 클라이언트 시크릿값
        String result = "";  // 비교 결과를 저장할 변수

        try {
            String code = "1";  // 키 발급시 0, 캡차 이미지 비교시 1로 세팅

            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code + "&key=" + key
                    + "&value=" + userValue;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;

            if (responseCode == 200) {  // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }

            br.close();
            result = response.toString();
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // JSON 파싱 하는 메소드 호출하여 result값 추출
        result = parsing(result);

        return result;
    }
}
