package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

	public static void main(String [] args ) throws IOException {
		
		FileReader fReader = new FileReader (System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
		
		Properties prop = new Properties();
		prop.load(fReader);
		
		
		
	}
}
