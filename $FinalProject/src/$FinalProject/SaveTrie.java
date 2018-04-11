package $FinalProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveTrie {
	private String fileName;

	public SaveTrie(String fileName) {
		this.fileName = fileName;
	}

	public void write(Trie node) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.fileName));
			os.writeObject(node);
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found (SaveTrie: output)");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException (SaveTrie: output)");
			e.printStackTrace();
		}
	}

	public Trie read(String fileName) {
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			Trie node = (Trie) is.readObject();
			is.close();
			return node;
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found (SaveTrie: input)");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException (SaveTrie: input)");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException (SaveTrie: input)");
			e.printStackTrace();
		}
		return null;
	}

}
