package kr.dteng.api;

//네이버 캡차 API 예제 - 캡차 이미지 수신
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIExamCaptchaImage {
	
	// 클래스 객체 생성하여 추출한 Key 값 가져오기
	static APIExamCaptchaVO captchaVO = new APIExamCaptchaVO();
    public String getKeyFromVO() {
//    	System.out.println("잘 가져와 지는지 확인 : " + captchaVO.getKey());
    	return captchaVO.getKey();
    }
    
    // JSON 파싱 하는 메소드
    public static String parsing (String jsonString) {
    	
    	String extractedValue = null;
    	
    	try {
			// JSON 파싱
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonString);

			// "key"에 대응하는 값 추출
			extractedValue = jsonNode.get("key").asText();

		} catch (Exception e) {
			e.printStackTrace();
		}
    	return extractedValue;
    }
    
    // 이미지 파일을 Base64로 인코딩하는 메소드
    public static String encodeImageToBase64(InputStream inputStream) {
        String base64EncodedImage = null;

        try {
            byte[] imageData = readInputStream(inputStream);

            base64EncodedImage = Base64.getEncoder().encodeToString(imageData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return base64EncodedImage;
    }
    
    // InputStream을 바이트 배열로 읽어오는 메소드
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[1024];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        return buffer.toByteArray();
    }
	
	public static String downloadCaptchaImage(String jsonString) {
		String clientId = "7ktlcdansh";// 애플리케이션 클라이언트 아이디값";
		String key;
		String base64EncodedImage = null;
		
		// JSON 파싱 하는 메소드 호출하여 key값 추출
		key = parsing(jsonString);
		
		captchaVO.setKey(key);
	    
//	    System.out.println("Img key : " + key);
//	    System.out.println("Img getKey() : " + captchaVO.getKey());
	    	
		try {
			String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha-bin/v1/ncaptcha?key=" + key
					+ "&X-NCP-APIGW-API-KEY-ID" + clientId;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				InputStream is = con.getInputStream();
				System.out.println("is" + is);

				// 이미지 파일을 Base64로 인코딩
				base64EncodedImage = encodeImageToBase64(is);

				// 여기에서 base64EncodedImage를 사용하거나 반환하는 작업을 수행할 수 있습니다.

				is.close();
			} else { // 오류 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
//		System.out.println("key값 : " + key);
//		System.out.println("extractedValue값 : " + extractedValue);
//		System.out.println("filename값 : " + filename);
		return base64EncodedImage;
	}
}