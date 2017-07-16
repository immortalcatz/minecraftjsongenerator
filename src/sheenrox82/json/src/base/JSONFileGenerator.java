package sheenrox82.json.src.base;

import java.util.Scanner;

public class JSONFileGenerator
{
	public static String outputFileName;
	public static String nameOfFile;
	public static String textureName;
	public static String modID;
	public static String genType;
	public static String type;

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner output = new Scanner(System.in);
		System.out.println("Enter your output file name. Will be placed in the current program directory.");
		outputFileName = output.next();

		Scanner name = new Scanner(System.in);
		System.out.println("Enter your file name");
		nameOfFile = name.next();

		Scanner tex = new Scanner(System.in);
		System.out.println("Enter your texture name");
		textureName = tex.next();

		Scanner modid = new Scanner(System.in);
		System.out.println("Enter your MODID name. Will be made lowercase.");
		modID = modid.next();

		Scanner gen = new Scanner(System.in);
		System.out.println("Generate block or item? [block/item]");
		genType = gen.next();

		if(genType.equals(("block").toLowerCase()))
		{
			JSONWriter.makeJSON("block");
			System.out.println("Successfully completed: block registration: " + nameOfFile + ".json");
			System.out.println("Successfully completed: block model registration: /models/block/" + nameOfFile + ".json");
			System.out.println("Successfully completed: block item registration: /models/item/" + nameOfFile + ".json");
		}
		else if(genType.equals(("item").toLowerCase()))
		{
			Scanner itemType = new Scanner(System.in);
			System.out.println("Enter type of item. [regular/3d]");
			type = itemType.next();
			
			if(type.equals(("regular").toLowerCase()))
			{
				JSONWriter.makeJSON("regular");
				System.out.println("Successfully completed:" + type + " item registration: " + nameOfFile + ".json");
			}
			if(type.equals(("3d").toLowerCase()))
			{
				JSONWriter.makeJSON("3d");
				System.out.println("Successfully completed: " + type + " item registration: " + nameOfFile + ".json");
			}
		}
	}
}
