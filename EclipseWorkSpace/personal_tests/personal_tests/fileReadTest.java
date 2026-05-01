/**
 * 
 */
package personal_tests;

/**
 * 
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileReadTest
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		// http://textfiles.com/100/captmidn.txt
		File file = new File("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\captmidn.txt");
		Scanner scan = new Scanner(file);
		String fileContent = "second test for read line";
		while (scan.hasNextLine())
		{
			fileContent = fileContent.concat(scan.nextLine() + "\n");
		}
		FileWriter writer = new FileWriter("C:\\GitHub Repos\\JavaRepo\\EclipseWorkSpace\\personal_tests\\newfile.txt");

		writer.write(fileContent);
		writer.close();
	}

}
