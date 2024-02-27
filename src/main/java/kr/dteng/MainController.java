package kr.dteng;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kr.dteng.api.APIExamCaptchaImage;
import kr.dteng.api.APIExamCaptchaNkey;
import kr.dteng.api.APIExamCaptchaNkeyResult;



@RestController
public class MainController {
	
//	@RequestMapping("/")
//	public String hello() {
//		return "SpringBoot Hello World!";
//	}
	
//	@RequestMapping("/index")
//	public String showIndexPage() {
//		String viewName = "index";
//		return viewName;
//	}
	
	// /경로 연결
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView linkIndexPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index-kor");
        return mav;
    }
	
	// 메인페이지-KOR
	@RequestMapping(value = "/index-kor.do", method = RequestMethod.GET)
    public ModelAndView viewIndexPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index-kor");
        return mav;
    }
	
	// 메인페이지-ENG
	@RequestMapping(value = "/index-eng.do", method = RequestMethod.GET)
    public ModelAndView viewIndexPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index-eng");
        return mav;
    }
	
	// 회사소개페이지-KOR
	@RequestMapping(value = "/company-kor.do", method = RequestMethod.GET)
    public ModelAndView viewCompanyPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company-kor");
        mav.addObject("title", "Company");
        return mav;
    }
		
	// 회사소개페이지-ENG
	@RequestMapping(value = "/company-eng.do", method = RequestMethod.GET)
    public ModelAndView viewCompanyPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company-eng");
        mav.addObject("title", "Company");
        return mav;
    }
	
	// 인사말페이지-KOR
	@RequestMapping(value = "/greetings-kor.do", method = RequestMethod.GET)
    public ModelAndView viewGreetingsPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greetings-kor");
        mav.addObject("title", "Greetings");
        return mav;
    }
		
	// 인사말페이지-ENG
	@RequestMapping(value = "/greetings-eng.do", method = RequestMethod.GET)
    public ModelAndView viewGreetingsPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greetings-eng");
        mav.addObject("title", "Greetings");
        return mav;
    }
	
	// 연혁페이지-KOR
	@RequestMapping(value = "/history-kor.do", method = RequestMethod.GET)
    public ModelAndView viewHistoryPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("history-kor");
        mav.addObject("title", "History");
        return mav;
    }
		
	// 연혁페이지-ENG
	@RequestMapping(value = "/history-eng.do", method = RequestMethod.GET)
    public ModelAndView viewHistoryPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("history-eng");
        mav.addObject("title", "History");
        return mav;
    }
	
	// 오시는 길 페이지-KOR
	@RequestMapping(value = "/location-kor.do", method = RequestMethod.GET)
    public ModelAndView viewLocationPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("location-kor");
        mav.addObject("title", "Location");
        return mav;
    }
		
	// 오시는 길 페이지-ENG
	@RequestMapping(value = "/location-eng.do", method = RequestMethod.GET)
    public ModelAndView viewLocationPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("location-eng");
        mav.addObject("title", "Location");
        return mav;
    }
	
	// 사업소개페이지-KOR
	@RequestMapping(value = "/business-kor.do", method = RequestMethod.GET)
    public ModelAndView viewBusinessPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("business-kor");
        mav.addObject("title", "Business");
        return mav;
    }
			
	// 사업소개페이지-ENG
	@RequestMapping(value = "/business-eng.do", method = RequestMethod.GET)
    public ModelAndView viewBusinessPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("business-eng");
        mav.addObject("title", "Business");
        return mav;
    }
	
	// ESC란페이지-KOR
	@RequestMapping(value = "/what_is_esc-kor.do", method = RequestMethod.GET)
    public ModelAndView viewWhatIsESCPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("what_is_esc-kor");
        mav.addObject("title", "WhatIsESC");
        return mav;
    }
				
	// ESC란페이지-ENG
	@RequestMapping(value = "/what_is_esc-eng.do", method = RequestMethod.GET)
    public ModelAndView viewWhatIsESCsPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("what_is_esc-eng");
        mav.addObject("title", "WhatIsESC");
        return mav;
    }
	
	// 공중관계페이지-KOR
	@RequestMapping(value = "/pr-kor.do", method = RequestMethod.GET)
    public ModelAndView viewPRPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pr-kor");
        mav.addObject("title", "PR");
        return mav;
    }
				
	// 공중관계페이지-ENG
	@RequestMapping(value = "/pr-eng.do", method = RequestMethod.GET)
    public ModelAndView viewPRPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pr-eng");
        mav.addObject("title", "PR");
        return mav;
    }
	
	// 고객지원페이지-KOR
	@RequestMapping(value = "/contact-kor.do", method = RequestMethod.GET)
    public ModelAndView viewContactPageKOR() throws InterruptedException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("contact-kor");
        mav.addObject("title", "Contact");
        return mav;
    }
	
				
	// 고객지원페이지-ENG
	@RequestMapping(value = "/contact-eng.do", method = RequestMethod.GET)
    public ModelAndView viewContactPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("contact-eng");
        mav.addObject("title", "Contact");
        return mav;
    }
	
	
	
	
	// get방식으로 파라미터 전달 예제
//	 @GetMapping("/send-email.do") 
//	 public void sendEmail(@RequestParam(name = "test", defaultValue = "null") String name) { 
//		 System.out.println("Hello, " + name +"!"); 
//	 }
	 
	// post방식으로 파라미터 전달 예제
//	@PostMapping("/send-email.do")
//	public void sendEmail(@RequestParam(name = "test", defaultValue = "null") String test) {
//	    System.out.println("Hello, " + test + "!");
//	}
	
	@RequestMapping(value = "/captcha-image-load-kor.do", method = RequestMethod.GET)
	public ModelAndView captchaImageLoadKOR() throws InterruptedException {
	    String key = null;
	    String imageResult = null;

	    // 클래스 객체 생성하여 Key 생성
	    APIExamCaptchaNkey captchaNkey = new APIExamCaptchaNkey();
	    key = captchaNkey.getCaptchaKey();
//	    System.out.println(key);
	    
	    // 클래스 객체 생성하여 Image 다운로드
	    APIExamCaptchaImage captchaImage = new APIExamCaptchaImage();
	    imageResult = APIExamCaptchaImage.downloadCaptchaImage(key);	    
	    System.out.println(imageResult);
	    

	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("captcha-image-load-kor");
	    mav.addObject("title", "CaptchaImageLoadKOR");
	    mav.addObject("imageResult", imageResult);
	    return mav;
	}
	
	@RequestMapping(value = "/captcha-image-load-eng.do", method = RequestMethod.GET)
	public ModelAndView captchaImageLoadENG() throws InterruptedException {
	    String key = null;
	    String imageResult = null;

	    // 클래스 객체 생성하여 Key 생성
	    APIExamCaptchaNkey captchaNkey = new APIExamCaptchaNkey();
	    key = captchaNkey.getCaptchaKey();
//	    System.out.println(key);
	    
	    // 클래스 객체 생성하여 Image 다운로드
	    APIExamCaptchaImage captchaImage = new APIExamCaptchaImage();
	    imageResult = APIExamCaptchaImage.downloadCaptchaImage(key);	    
	    System.out.println(imageResult);
	    

	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("captcha-image-load-eng");
	    mav.addObject("title", "CaptchaImageLoadENG");
	    mav.addObject("imageResult", imageResult);
	    return mav;
	}


	// 메일 발송
	private final JavaMailSender mailSender;

    public MainController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/send-email.do")
    public ModelAndView sendMail(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "account") String account,
                                 @RequestParam(name = "domain") String domain,
                                 @RequestParam(name = "contact1") String contact1,
                                 @RequestParam(name = "contact2") String contact2,
                                 @RequestParam(name = "contact3") String contact3,
                                 @RequestParam(name = "message") String message,
                                 @RequestParam(name = "subscribe") String subscribe,
                                 @RequestParam(name = "user_value") String user_value,
                                 @RequestParam(name = "lang") String lang) {

        // System.out.println("최초 파라미터 전달 값 : " + lang);
		// 클래스 객체 생성하여 Key 값 불러오기
    	APIExamCaptchaImage captchaImage = new APIExamCaptchaImage();
    	String key = captchaImage.getKeyFromVO();
//    	System.out.println("메인클래스까지 잘 왔나 확인 : " + key);
		
		// 클래스 객체 생성하여 Code 비교
		APIExamCaptchaNkeyResult checkCode = new APIExamCaptchaNkeyResult();
		String result = checkCode.CheckingCode(key, user_value);
		System.out.println(result);
		
		if (result == "true") {
			// 구성된 이메일 주소 생성
	        String emailAddress = account + "@" + domain;
	        
	        // 구성된 연락처 생성
	        String contact = contact1 + "-" + contact2 + "-" + contact3;
	        
	        // 개행 문자(\n 또는 \r\n)를 <br>로 변환
	        String formattedMessage = message.replace("\r\n", "<br>").replace("\n", "<br>");

	        // 메일 내용 구성
	        String mailContent = "<b>이름 : </b>" + name + "<br><br>"
	                + "<b>이메일 주소: </b>" + emailAddress + "<br><br>"
	                + "<b>연락처 : </b>" + contact + "<br><br>"
	                + "<b>문의 내용 : </b><br>" + formattedMessage + "<br><br>";

	        // MimeMessage 생성
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

	        try {
	            helper.setText(mailContent, true); // HTML 형식으로 메일 내용 설정
	            helper.setTo("sales@dteng.kr"); // 수신자 이메일 주소 설정
	            helper.setSubject("[홈페이지] 문의사항이 도착했습니다."); // 메일 제목 설정

	            // 실제 메일 발송
	            mailSender.send(mimeMessage);

	            // 성공적으로 메일을 보냈다면, 성공 페이지로 이동
	            ModelAndView mav = new ModelAndView();
	            if ("kor".equals(lang)) {
		            // System.out.println("메일발송 성공시 : " + lang);
	                mav.setViewName("contact-kor");
	            } else if ("eng".equals(lang)) {
		            // System.out.println("메일발송 성공시 : " + lang);
	                mav.setViewName("contact-eng");
	            }
	            mav.addObject("result", "Success");
	            mav.addObject("title", "Contact");
	            return mav;

	        } catch (MessagingException e) {
	            // 메일 전송 중 오류가 발생하면, 에러 페이지로 이동
	        	 ModelAndView mav = new ModelAndView();
	        	 if ("kor".equals(lang)) {
	 	            // System.out.println("메일발송 오류 발생시 : " + lang);
	                 mav.setViewName("contact-kor");
	             } else if ("eng".equals(lang)) {
	 	            // System.out.println("메일발송 오류 발생시 : " + lang);
	                 mav.setViewName("contact-eng");
	             }
	             mav.addObject("result", "Error");
	             mav.addObject("title", "Contact");
	             return mav;
	        }
		} else {
			// key 값 미일치(false) 시, Fail 페이지로 이동
	       	 ModelAndView mav = new ModelAndView();
		       	if ("kor".equals(lang)) {
		            // System.out.println("메일발송 실패(미일치)시 : " + lang);
		            mav.setViewName("contact-kor");
		        } else if ("eng".equals(lang)) {
		            // System.out.println("메일발송 실패(미일치)시 : " + lang);
		            mav.setViewName("contact-eng");
		        }
	            mav.addObject("result", "Fail");
	            mav.addObject("title", "Contact");
	            return mav;
		}

    }

	
	// 채용안내페이지-KOR
	@RequestMapping(value = "/recruit-kor.do", method = RequestMethod.GET)
    public ModelAndView viewRecruitPageKOR() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recruit-kor");
        mav.addObject("title", "Recruit");
        return mav;
    }
				
	// 채용안내페이지-ENG
	@RequestMapping(value = "/recruit-eng.do", method = RequestMethod.GET)
    public ModelAndView viewRecruitPageENG() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recruit-eng");
        mav.addObject("title", "Recruit");
        return mav;
    }
}