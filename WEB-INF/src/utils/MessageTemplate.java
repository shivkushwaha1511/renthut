package utils;

public class MessageTemplate {
	public static String activateAccount(String name,String email,Long authCode) {
		return "<div style=\"width:90%;border:solid 2px #186697;font-family: verdana;\">\r\n"
				+ "        <div style=\"background-color: #186697; color:white; font-size:35px; padding: 10px 20px;\">\r\n"
				+ "            Renthut\r\n"
				+ "        </div>\r\n"
				+ "        <div style=\"padding-left: 30px; padding-bottom: 40px;\">\r\n"
				+ "            <p style=\"font-weight: bold; font-size: 20px;\">Hello "+name+"!</p>\r\n"
				+ "            <p style=\"font-size: 20px;\">Welcome to Renthut</p>\r\n"
				+ "            <p>Thankyou for Registering with Us!</p>\r\n"
				+ "            <a href=\"http://localhost:8080/renthut/activateuser.do?email="+email+"&authCode="+authCode+"\">Click here to activate your account</a>\r\n"
				+ "        </div>\r\n"
				+ "    </div>";
	}
}
