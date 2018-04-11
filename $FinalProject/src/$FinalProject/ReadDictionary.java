package $FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDictionary {
	Scanner input;
	File file;
	Trie root;

	public ReadDictionary(String file, Trie root) throws FileNotFoundException {
		this.file = new File(file);
		this.input = new Scanner(this.file);
		this.root = root;
		populate();
		System.out.println("Dictionary Done");
	}
	
	public void populate() {
		while (input.hasNext()) {
			this.root.insertion(input.nextLine());
		}
	}
}
