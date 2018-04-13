package $FinalProject;
import java.io.FileNotFoundException;

public class ProjectMain {
	public static void main(String[] args) throws FileNotFoundException {
		Trie dic = new Trie();
		new ReadDictionary("/Users/SeanCrowley/git/Georgia-Southern-CS/$FinalProject/src/$FinalProject/Dictionary.txt", dic);
		dic.search("actuals");
		dic.search("tolerably");
		dic.search("abandon");
		dic.search("duodecimal");
	}
}