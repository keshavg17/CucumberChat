package artOfTesting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ReplaceText {
	//@Test
	public static void main(String FileName1, String FileName2)
	{
		try
		{	  
			String line = null;
			BufferedReader br = new BufferedReader ( new FileReader ( FileName1 )  );
			PrintWriter pr = new PrintWriter ( new BufferedWriter ( new FileWriter ( FileName2, false )  )  );	  

			while  (  ( line = br.readLine (  )  )  != null )   {  
				if (line.startsWith("[24]7.ai"))
				{
					line=line.replace("[24]7.ai", "[24]7.ai");
					//line=line.replace(System.getProperty("line.separator"), "");
					pr.append("\n");
					pr.write(line);
				}
				else if (line.startsWith(".")){
					line=line.replace(".", "Visitor Text: ");
					//line=line.replace(System.getProperty("line.separator"), "");
					pr.append("\n");
					pr.write(line);
					
				}
				else if (line.startsWith(",")){
					line=line.replace(",", "");
					//line=line.replace(System.getProperty("line.separator"), "");
					pr.append("\n");
					pr.write(line);
				}
				/*else{
					line = line.replace(line, "Visitor: "+line);
					pr.write(line);
				}*/
				else pr.println ( line );
			}  
			br.close (  );			
			br = null;
			pr.close (  );
			pr = null;		
		}  catch  ( java.io.FileNotFoundException ex )   {  
			System.out.println ( "File '" + "Text"  + "' does not exist. " );	  
		}  catch  ( java.io.IOException ex )   {  
			ex.printStackTrace (  );
		}
	}}