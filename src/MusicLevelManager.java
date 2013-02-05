import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicLevelManager {

	private ArrayList<Integer> beats = new ArrayList<Integer>();
	private String beatString;

	public MusicLevelManager() {

	}

	public ArrayList initBeats() {
		return beats;
	}

	public void loadLevel(String x) {

		beats.clear();
		File file = new File(x + ".txt");
		String string1 = new String();
		try {
			Scanner scanner = new Scanner(file);
			int g = 1;
				String line = scanner.next();
				beatString = line;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int numBeats = Integer.parseInt(beatString.substring(0, beatString.indexOf(">")));
		int beatNumber = 0;

		for (int r = 0; r < numBeats; r++) {
			beats.add(Integer.parseInt(beatString.substring(beatString.indexOf("'",beatString.indexOf(beatNumber + "'"))+ 1 , beatString.indexOf("|" , beatString.indexOf("'" + beatNumber + "'")))));
			beatNumber++;
		}
	}
}
