package sheenrox82.json.src.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter 
{
	private static BufferedWriter writer;
	private static BufferedWriter blockModelWriter;
	private static BufferedWriter blockItemModelWriter;

	static
	{
		File dir = new File("./" + JSONFileGenerator.outputFileName);
		File modelDir = new File(dir.getPath() + "/models");
		File blockModelDir = new File(modelDir.getPath() + "/block");
		File blockItemDir = new File(modelDir.getPath() + "/item");

		dir.mkdir();
		dir = new File("./" + JSONFileGenerator.outputFileName + "/" + JSONFileGenerator.nameOfFile + ".json");

		try 
		{
			writer = new BufferedWriter(new FileWriter(dir));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		if(JSONFileGenerator.genType.equals(("block").toLowerCase()))
		{
			modelDir.mkdir();
			blockModelDir.mkdir();
			blockItemDir.mkdir();
			blockModelDir = new File("./" + JSONFileGenerator.outputFileName + "/models/block/" + JSONFileGenerator.nameOfFile + ".json");
			blockItemDir = new File("./" + JSONFileGenerator.outputFileName + "/models/item/" + JSONFileGenerator.nameOfFile + ".json");

			try 
			{
				blockModelWriter = new BufferedWriter(new FileWriter(blockModelDir));
				blockItemModelWriter = new BufferedWriter(new FileWriter(blockItemDir));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static void makeJSON(String type)
	{
		if(type == "regular")
			logRegular();
		if(type == "3d")
			log3D();
		if(type == "block")
			logBlock();
	}

	public static void logRegular() 
	{
		writeRegular();
		MethodUtil.flush(writer);
		MethodUtil.closeFile(writer);
	}

	public static void log3D() 
	{
		write3D();
		MethodUtil.flush(writer);
		MethodUtil.closeFile(writer);
	}

	public static void logBlock() 
	{
		writeBlock();
		MethodUtil.flush(writer);
		MethodUtil.closeFile(writer);
		writeBlockModel();
		MethodUtil.flush(blockModelWriter);
		MethodUtil.closeFile(blockModelWriter);
		writeBlockItemModel();
		MethodUtil.flush(blockItemModelWriter);
		MethodUtil.closeFile(blockItemModelWriter);
	}

	public static void writeRegular()
	{
		MethodUtil.writeLine(writer, "# THIS IS THE ITEM FILE. IT GOES IN THE assets/" + JSONFileGenerator.modID.toLowerCase() + "/models/item/ folder.");
		MethodUtil.writeLine(writer, "# Generated using sheenrox82's JSON File Generator for Minecraft 1.8.");
		MethodUtil.writeLine(writer, "");
		MethodUtil.writeLine(writer, "{");
		MethodUtil.writeLine(writer, "    \"parent\": \"builtin/generated\",");
		MethodUtil.writeLine(writer, "    \"textures\": {");
		MethodUtil.writeLine(writer, "        \"layer0\": \"" + JSONFileGenerator.modID.toLowerCase() + ":items/" + JSONFileGenerator.textureName + "\"");
		MethodUtil.writeLine(writer, "    },");
		MethodUtil.writeLine(writer, "    \"display\": {");
		MethodUtil.writeLine(writer, "        \"thirdperson\": {");
		MethodUtil.writeLine(writer, "            \"rotation\": [ -90, 0, 0 ],");
		MethodUtil.writeLine(writer, "            \"translation\": [ 0, 1, -3 ],");
		MethodUtil.writeLine(writer, "            \"scale\": [ 0.55, 0.55, 0.55 ]");
		MethodUtil.writeLine(writer, "        },");
		MethodUtil.writeLine(writer, "        \"firstperson\": {");
		MethodUtil.writeLine(writer, "            \"rotation\": [ 0, -135, 25 ],");
		MethodUtil.writeLine(writer, "            \"translation\": [ 0, 4, 2 ],");
		MethodUtil.writeLine(writer, "            \"scale\": [ 1.7, 1.7, 1.7 ]");
		MethodUtil.writeLine(writer, "        }");
		MethodUtil.writeLine(writer, "    }");
		MethodUtil.writeLine(writer, "}");
	}

	public static void write3D()
	{
		MethodUtil.writeLine(writer, "# THIS IS THE ITEM FILE. IT GOES IN THE assets/" + JSONFileGenerator.modID.toLowerCase() + "/models/item/ folder.");
		MethodUtil.writeLine(writer, "# Generated using sheenrox82's JSON File Generator for Minecraft 1.8.");
		MethodUtil.writeLine(writer, "");
		MethodUtil.writeLine(writer, "{");
		MethodUtil.writeLine(writer, "    \"parent\": \"builtin/generated\",");
		MethodUtil.writeLine(writer, "    \"textures\": {");
		MethodUtil.writeLine(writer, "        \"layer0\": \"" + JSONFileGenerator.modID.toLowerCase() + ":items/" + JSONFileGenerator.textureName + "\"");
		MethodUtil.writeLine(writer, "    },");
		MethodUtil.writeLine(writer, "    \"display\": {");
		MethodUtil.writeLine(writer, "        \"thirdperson\": {");
		MethodUtil.writeLine(writer, "            \"rotation\": [ 0, 90, -35 ],");
		MethodUtil.writeLine(writer, "            \"translation\": [ 0, 1.25, -3.5 ],");
		MethodUtil.writeLine(writer, "            \"scale\": [ 0.85, 0.85, 0.85 ]");
		MethodUtil.writeLine(writer, "        },");
		MethodUtil.writeLine(writer, "        \"firstperson\": {");
		MethodUtil.writeLine(writer, "            \"rotation\": [ 0, -135, 25 ],");
		MethodUtil.writeLine(writer, "            \"translation\": [ 0, 4, 2 ],");
		MethodUtil.writeLine(writer, "            \"scale\": [ 1.7, 1.7, 1.7 ]");
		MethodUtil.writeLine(writer, "        }");
		MethodUtil.writeLine(writer, "    }");
		MethodUtil.writeLine(writer, "}");
	}

	public static void writeBlock()
	{
		MethodUtil.writeLine(writer, "# THIS IS THE BLOCKSTATE FILE. IT GOES IN THE assets/" + JSONFileGenerator.modID.toLowerCase() + "/blockstates/ folder.");
		MethodUtil.writeLine(writer, "# Generated using sheenrox82's JSON File Generator for Minecraft 1.8.");
		MethodUtil.writeLine(writer, "");
		MethodUtil.writeLine(writer, "{");
		MethodUtil.writeLine(writer, "    \"variants\": {");
		MethodUtil.writeLine(writer, "        \"normal\": { \"model\": \"" + JSONFileGenerator.modID.toLowerCase() + ":" + JSONFileGenerator.nameOfFile + "\" }");
		MethodUtil.writeLine(writer, "    }");
		MethodUtil.writeLine(writer, "}");
	}

	public static void writeBlockModel()
	{
		MethodUtil.writeLine(blockModelWriter, "# THIS IS THE BLOCK MDOEL FILE. IT GOES IN THE assets/" + JSONFileGenerator.modID.toLowerCase() + "/models/block/ folder.");
		MethodUtil.writeLine(blockModelWriter, "# Generated using sheenrox82's JSON File Generator for Minecraft 1.8.");
		MethodUtil.writeLine(blockModelWriter, "");
		MethodUtil.writeLine(blockModelWriter, "{");
		MethodUtil.writeLine(blockModelWriter, "    \"parent\": \"block/cube_all\",");
		MethodUtil.writeLine(blockModelWriter, "    \"textures\": {");
		MethodUtil.writeLine(blockModelWriter, "        \"all\": \"" + JSONFileGenerator.modID.toLowerCase() + ":blocks/" + JSONFileGenerator.textureName + "\"");
		MethodUtil.writeLine(blockModelWriter, "    }");
		MethodUtil.writeLine(blockModelWriter, "}");
	}
	
	public static void writeBlockItemModel()
	{
		MethodUtil.writeLine(blockItemModelWriter, "# THIS IS THE BLOCK ITEM MDOEL FILE. IT GOES IN THE assets/" + JSONFileGenerator.modID.toLowerCase() + "/models/item/ folder.");
		MethodUtil.writeLine(blockItemModelWriter, "# Generated using sheenrox82's JSON File Generator for Minecraft 1.8.");
		MethodUtil.writeLine(blockItemModelWriter, "");
		MethodUtil.writeLine(blockItemModelWriter, "{");
		MethodUtil.writeLine(blockItemModelWriter, "    \"parent\": \"" + JSONFileGenerator.modID.toLowerCase() + ":block/" + JSONFileGenerator.textureName + "\",");
		MethodUtil.writeLine(blockItemModelWriter, "    \"display\": {");
		MethodUtil.writeLine(blockItemModelWriter, "        \"thirdperson\": {");
		MethodUtil.writeLine(blockItemModelWriter, "            \"rotation\": [ 10, -45, 170 ],");
		MethodUtil.writeLine(blockItemModelWriter, "            \"translation\": [ 0, 1.5, -2.75 ],");
		MethodUtil.writeLine(blockItemModelWriter, "            \"scale\": [ 0.375, 0.375, 0.375 ]");
		MethodUtil.writeLine(blockItemModelWriter, "        }");
		MethodUtil.writeLine(blockItemModelWriter, "    }");
		MethodUtil.writeLine(blockItemModelWriter, "}");
	}
}