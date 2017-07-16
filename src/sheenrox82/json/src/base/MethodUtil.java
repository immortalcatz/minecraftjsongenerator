package sheenrox82.json.src.base;

import java.io.BufferedWriter;
import java.io.IOException;

public class MethodUtil
{
	public static void writeLine(BufferedWriter writer, String text)
	{
		try 
		{
			writer.write(text);
			writer.newLine();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void flush(BufferedWriter writer) 
	{
		try
		{
			writer.flush();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void closeFile(BufferedWriter writer) 
	{
		try
		{
			writer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
