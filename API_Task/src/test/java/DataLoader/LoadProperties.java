package DataLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	//Load Data From Properties file
			public static Properties data=LoadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\Data.properties");
			public static Properties LoadProperties(String path) {
				
				Properties data=new Properties();
				
				try {
					FileInputStream stream=new FileInputStream(path);
					data.load(stream);
				}
					 catch (FileNotFoundException e) {
					System.out.println("error occured" + e.getMessage());
				}
					 catch (IOException e) {
						 
						 System.out.println("error occured" + e.getMessage());
					 }
				
				return data;
			}
}
