package opinionDeterminer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {

	private String dictName;
	private ArrayList<String> dictionaryWords;

	public Dictionary(String dictName){
		this.dictName=dictName;
		this.dictionaryWords = new ArrayList<String>();
		readDictionary();
	}
	
	private void readDictionary(){
		//File dict = new File(this.dictName);
		try (BufferedReader br = new BufferedReader(new FileReader(dictName))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	this.dictionaryWords.add((String)line);

		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getWords(){
		return this.dictionaryWords;
	}
}
