package artOfTesting.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class ReadJsonAndRetrieveValues {

	WebDriver driver;

	public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException{
		Iterator<String> keys = json.keys();
		while(keys.hasNext()){
			String key = keys.next();
			String val = null;
			try{
				JSONObject value = json.getJSONObject(key);
				parse(value,out);
			}catch(Exception e){
				val = json.getString(key);
			}

			if(val != null){
				out.put(key,val);
			}
		}
		return out;
	}

	@Test
	public static void main() throws JSONException{

		Read("", "123");

	}

	public static  void Read(String Event1, String Time) throws JSONException {

		String ec = null;
		try {
			//File file = new File("C:\\Downloads\\_har\\Json_"+Time+".txt");
			File file = new File("C:\\Downloads\\_har\\Cucumber_BrowserMob_BG\\Test06_15_2017_3_22_54_PM.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				try{
					String line1 = line.replace("\"", "\'");
					String json = line1;
					JSONObject object = new JSONObject(json);
					JSONObject info = object.getJSONObject("e");
					Map<String,String> out = new HashMap<String, String>();
					parse(info,out);
					ec = out.get("ec");
					String ec1 = out.get(Event1);
					/* String vi = out.get("vi");
		    String bd = out.get("bd");
		    String bsid = out.get("bsid");
		    String tseq = out.get("tseq");
		    String st = out.get("st");
					 */
					System.out.println("**********************************************************************");
					System.out.println("Compare"+ec);
					System.out.println("**********************************************************************");
					compare(ec, out);
				}catch(Exception e){
					System.out.println("**********************************************************************");
					System.out.println("Compare in Catch"+ec);
					System.out.println("**********************************************************************");
					System.out.println("Inside while try catch for unterminated string");


					String line2 = line.concat("efault\",\"bsid\":\"Not Valid ID_Added by code-1\",\"up\":1456233399109,\"it\":0,\"tseq\":7}}");
					String json = line2;
					JSONObject object = new JSONObject(json);
					JSONObject info = object.getJSONObject("e");
					Map<String,String> out = new HashMap<String, String>();
					parse(info,out);
					ec = out.get("ec");
					String ec1 = out.get(Event1);
					compare(ec, out);
					/* String vi = out.get("vi");
		    String bd = out.get("bd");
		    String bsid = out.get("bsid");
		    String tseq = out.get("tseq");
		    String st = out.get("st");*/





				}}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		//return ec;
	}
	private static void compare(String ec, Map<String, String> out) throws IOException, JSONException {
		String A = null;
		// TODO Auto-generated method stub
		String aaa = ec.toString();
		//	System.out.println(aaa);
		File file = new File("D:\\Keshav_My Files\\Selenium_Files\\EventsVariablesSource\\"+aaa+".txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\n");
			A = line.toString();
			ReadJsonAndRetrieveValues.readbla(A,aaa, out);
		}
		fileReader.close();
	}

	private static void readbla(String a, String aaa, Map<String, String> out2) throws JSONException, IOException {
		String ec2 = out2.get("ec")	;
		String ec1 = out2.get(a);
		System.out.println("Variable value of "+a +" is :: "+ ec1 );//+ " vi : " + vi + " bd : "+bd + " bsid : "+ bsid + " tseq : "+tseq+" st "+st);
		Reporter.log("Variable value of "+a +" is :: "+ ec1 );
	}
}