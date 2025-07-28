package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	public static String getTestData(String key) throws Exception {
		String testDataValue;
		return testDataValue = (String) getJsonData().get(key);//input is the key

	}

	public static JSONObject getJsonData() throws IOException, ParseException, Exception  {

		//pass the path of the testdata.json file
		File filename = new File("resources//TestData//testdata.json");
		//convert json file into string
		String json = FileUtils.readFileToString(filename, "UTF-8");
		//parse the string into object
		Object obj = new JSONParser().parse(json);
		//give jsonobject so that I can return it to the function everytime it get called
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;

	}

	public static JSONArray getJsonArray(String key) throws IOException, ParseException, Exception {
		JSONObject jsonObject = getJsonData();
		JSONArray jsonArray = (JSONArray) jsonObject.get(key);
		return jsonArray;
		
	}
	
	public static Object getJsonArrayData(String key, int index) throws IOException, ParseException, Exception {
		JSONArray languages = getJsonArray("languages");
		return languages.get(index);
		
	
		
	}

}
