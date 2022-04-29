package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static String getRandomNumber() {
		
		Random rnd = new Random();
		int number = rnd.nextInt(999);

		// this will convert any number sequence into 3 character.
		return String.format("%03d", number);
	}
	public static void CaptureScreenshot(WebDriver driver , String screenshotname)
	{



		Path dest = Paths.get("./Screenshots", screenshotname+".png" );

		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();

		} catch (IOException e) {
			System.out.println("Exception while taking screenshot!"+e.getMessage());
		}

	}

}
