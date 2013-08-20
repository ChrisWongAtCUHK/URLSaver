package file.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class FileProcess {

	public static final String NOTYET_STRING = "Not yet";
	private static final int BUFFER_SIZE = 4096;
	// Print one file
	public static String read(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String inputLine;
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine + "\n");
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
			System.out.println(filename + " is not ready");
			return NOTYET_STRING;
		}
	}

	// Write a file
	public static void write(String filename, String dataLine) {
		try {
			DataOutputStream dos;
			File outFile = new File(filename);

			dos = new DataOutputStream(new FileOutputStream(outFile));

			dos.writeBytes(dataLine);
			dos.close();
		} catch (IOException ex) {
			return;
		}
	}

	// Delete one file
	public static void delete(String filename) {
		try {

			File file = new File(filename);
			if (file.exists()) {
				if (file.delete()) {
					System.out.println(filename + " is deleted!");
				} else {
					System.out.println("Delete operation is failed. "
							+ filename + " cannot be deleted");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete a file with sleep time(in second), with System.gc()
	public static void forceDelete(String filename, int sleep) {
		System.gc(); // Added this part
		try {
			Thread.sleep(sleep * 1000); // This part gives the Bufferedreaders
										// and the InputStreams time to close
										// Completely
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		delete(filename);
	}
	
	// Copy image from from an InputStream to file
	public static void copyFile(InputStream srcStream, String destFile){
		 DataInputStream dis = new DataInputStream(srcStream);
		 FileOutputStream fos = null;
		 try {
			fos = new FileOutputStream(destFile);
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead;

			while ((bytesRead = dis.read(buffer)) != -1)
				fos.write(buffer, 0, bytesRead); // write
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			if(dis != null){
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
