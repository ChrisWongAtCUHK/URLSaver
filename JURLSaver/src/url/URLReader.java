package url;

import java.net.*;
import java.io.*;

import file.io.*;

// Class for reading url content
public class URLReader {
	private URL url;
	
	// Constructor
	public URLReader(String urlString) throws MalformedURLException{
		this.url = new URL(urlString);
	}
	
	// Connect to the url and return BufferedReader instance
	public BufferedReader bReader() throws IOException{
		return new BufferedReader(
		        new InputStreamReader(this.url.openStream()));
	}
	
	// Connect to the url and return DataInputStream instance
	public DataInputStream  dis() throws IOException{
		return new DataInputStream(this.url.openStream());
	}
		
	// Write the url content to local
	public void url2Local(String filename) throws IOException{
		DataInputStream dis = this.dis();
		FileProcess.copyFile(dis, filename);

	}

}
