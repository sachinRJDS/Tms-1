package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class PracticeJSON {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, ParseException {
		JSONParser p = new JSONParser();
		//Object obj = p.parse(new FileReader("./src/test/resources/TMS.json"));
		Object obj = p.parse(new FileReader("C:\\Users\\MIRZA KASHIF BAIG\\Desktop\\TY\\TMS.json"));

		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("url"));

	}
	@Test
	public void json() throws FileNotFoundException, IOException, ParseException {
		JSONParser jp=new JSONParser();
		Object obj = jp.parse(new FileReader("C:\\Users\\MIRZA KASHIF BAIG\\Desktop\\TY\\TMS.json"));
		JSONObject jobj=(JSONObject) obj;
		System.out.println(jobj.get("browser"));
	}
}
