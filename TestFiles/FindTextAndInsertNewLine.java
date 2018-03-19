package artOfTesting.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Log{
	protected LogDetails log;
}

class LogDetails{
	protected String version;
	protected List<ResponseEntryList>entries;
}

class ResponseEntryList{
	protected RequestObj request;
	protected ResponseObj response;
}

class RequestObj{
	protected String method;
	protected String url;
	protected List<QueryStringAttr> queryString;
}

class QueryStringAttr{
	protected String name;
	protected String value;
}
class ResponseObj{
	protected String status;
	protected String statusText;
	protected String httpVersion;
	protected ContentObj content;
}
class ContentObj{

	protected String size;
	protected String mimeType;
	protected String comment;
}

public class FindTextAndInsertNewLine {

	/**
	 * @param args
	 */

	@Test
	public static void main() throws Exception {
		BufferedReader br =  new BufferedReader(new FileReader("C:\\Downloads\\_har\\Test12_14_2016_12_29_59_PM.har"));
		String contents ;
		StringBuffer entireFile = new StringBuffer("");
		while((contents=br.readLine())!=null){
			entireFile.append(contents);
		}
		br.close();
		Gson parser = new GsonBuilder().create();
		Log data = parser.fromJson(entireFile.toString(), Log.class); 
		if(data!=null){
			for(int i=0;i<data.log.entries.size();i++){
				ResponseObj response = data.log.entries.get(i).response;
				RequestObj request = data.log.entries.get(i).request;

				if(request.url.toString().startsWith("http://targetpsp.px.247inc.net/psp") || request.url.toString().startsWith("http://d1af033869koo7.cloudfront.net") ){
					System.out.println("URL = ="+request.url);
					System.out.println(response.status+" _ "+response.statusText);
					//System.out.println(response.statusText);
				}




				//System.out.println("QUERY STRING \n _________________________________________________");
				List<QueryStringAttr> queryString = request.queryString;
				for(QueryStringAttr temp : queryString){
					if(temp.name.equalsIgnoreCase("d")&& temp.value.startsWith("{\"e\"")){
						System.out.println(temp.name+" = = "+temp.value);
						Reporter.log(temp.value);

						FileWriter f = new FileWriter("C:\\Downloads\\_har\\Json_Hello.txt", true);
						BufferedWriter out = new BufferedWriter(f);
						out.write(temp.value + "\n");
						
						out.close();
						f.close();


					}

				}
				
				

			}

		}
	}

}
