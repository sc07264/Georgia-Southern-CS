package $FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class ProjectMain implements Serializable {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * The first time the code runs the dictionary must be read through. It
		 * must be put into the Trie. The Trie must be saved in the bin file. If
		 * the SaveTrie(bin) file exists - don't read from dictionary Convert
		 * bin back into the Trie. Call read method it returns TrieNode assign
		 * it to Trie.root.
		 */
		
		
		// What is the deal with Serialization and DeSerialization.
		// What is the serial version UID
		Trie node = new Trie();
		String fileDictionary = "/Users/SeanCrowley/Documents/workspace/$FinalProject/src/$FinalProject/Dictionary.txt";
		// could make this a scanner to input the file destination
		String fileBin = "/Users/SeanCrowley/Documents/workspace/$FinalProject/data.bin";
		File bin = new File(fileBin);
		if (!bin.exists()) {
			ReadDictionary read = new ReadDictionary(fileDictionary, node);
			SaveTrie save = new SaveTrie(fileBin); // bin == binary file
			save.write(node);
			System.out.println("Serialized");
		} else {
			SaveTrie savedTrie = new SaveTrie(fileBin);
			node = (Trie) savedTrie.read(fileBin);
			System.out.println("DeSerialized");
			node.search("actuals");
			node.search("tolerably");
			node.search("abandon");
		}
		System.out.print("Done");
	}
}