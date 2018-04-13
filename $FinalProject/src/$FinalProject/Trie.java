package $FinalProject;
import java.util.*;
public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
	}
	// insert method
	public void insertion(String word) {
		TrieNode nextNode = this.root;
		for (int i = 0; i < word.length(); i++) {

			char character = word.charAt(i);
			TrieNode temp = nextNode.childrenMap.get(character);
			if (temp == null) { // node doesn't contain this letter
				temp = new TrieNode();
				nextNode.childrenMap.put(character, temp);
			}
			nextNode = temp;
		}
	}
	// search method
	public boolean search(String word) {
		TrieNode next = root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (!next.childrenMap.containsKey(character)) {
				System.out.println("Doesn't contain word");
				return false;
			} else {
				System.out.print(character + ", ");
				next = next.childrenMap.get(character);
			}
		}
		System.out.println("Contains: " + word);
		return true;
	}
	// TrieNode - holds map
	private class TrieNode {
		// put(char value and a new Node for each letter) // no duplicates
		Map<Character, TrieNode> childrenMap;

		public TrieNode() {
			// Map will contain other TrieNodes
			this.childrenMap = new HashMap<Character, TrieNode>();
		}
	}
}