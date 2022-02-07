package localHost;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.hamcrest.Matchers.*;
public class SoapXMLRequest {
  
	@Test
	public void SoapXml() throws IOException {
		
		File file=new File("./SoapRequest/add.xml"); 
		
		if(file.exists())
		System.out.println(">>>> fileExists");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		
		
		String requestbody=IOUtils.toString(fileInputStream,"UTF-8");
		
		baseURI="http://www.dneonline.com";
		
		
		given().
		    contentType("text/xml").
		    accept(ContentType.XML).
		    body(requestbody).
		when().
		     post("//calculator.asmx").
		 then().
		     statusCode(200).log().all().and()
		     .body("//*:AddResult.text()", equalTo("30 "));
		
		
		     
	}
}
