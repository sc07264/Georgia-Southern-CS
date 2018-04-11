package $FinalProject;

import java.io.Serializable;
import java.util.*;

public class Trie implements Serializable {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// insert method
	public void insertion(String word) {
		TrieNode nextNode = root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			/* Checks if TrieNodeMap has specific character */
			TrieNode temp = nextNode.childrenMap.get(character);

			if (temp == null) { // node doesn't contain this letter
				temp = new TrieNode();
				nextNode.childrenMap.put(character, temp); // puts character and
															// nextNode ADDRESS
															// in Parent node
															// hashmap.
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

	private class TrieNode implements Serializable {
		Map<Character, TrieNode> childrenMap;

		public TrieNode() {
			this.childrenMap = new HashMap<>();
		}
	}
}