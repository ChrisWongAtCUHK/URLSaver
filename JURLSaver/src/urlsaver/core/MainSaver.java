package urlsaver.core;

import java.util.Map;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import url.URLReader;

//Main program
public class MainSaver {
	
	public static void main(String[] args){
		try{
			Properties props = new Properties();
			props.load(new FileInputStream("download.properties"));
	
			for (Map.Entry<Object, Object> entry :  props.entrySet()){
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
				URLReader urlReader = new URLReader(entry.getValue().toString());
		        urlReader.url2Local(entry.getKey().toString() + ".mp4");
			}
			System.out.println("Download done.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
