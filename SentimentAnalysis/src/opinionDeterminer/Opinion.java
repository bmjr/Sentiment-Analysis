package opinionDeterminer;

import java.util.ArrayList;

public class Opinion {

	private String text;
	private ArrayList<String> incWords;
	private ArrayList<String> decWords;
	private ArrayList<String> positiveWords;
	private ArrayList<String> negativeWords;

	public Opinion(String text, ArrayList<String> positiveWords, ArrayList<String> negativeWords,
			ArrayList<String> incWords, ArrayList<String> decWords){
		this.positiveWords=positiveWords;
		this.negativeWords=negativeWords;
		this.incWords=incWords;
		this.decWords=decWords;
		this.text=text;
	}
	
	public String formulate(){
		String[] words = this.text.split(" ");
		int positiveCount = 0;
		int negativeCount = 0;
		for(int i=0; i<words.length;i++){
			try{
				if (this.incWords.contains(words[i-1])&&this.positiveWords.contains(words[i])){
					positiveCount+= 3;
				}
				else if(this.decWords.contains(words[i-1])&&this.positiveWords.contains(words[i])){
					positiveCount += 1;
				}
				else if(this.positiveWords.contains(words[i])){
					positiveCount+= 2;
				}
				else if(this.incWords.contains(words[i-1])&&this.negativeWords.contains(words[i])){
					negativeCount+=3;
				}
				else if(this.decWords.contains(words[i-1])&&this.negativeWords.contains(words[i])){
					negativeCount+=1;
				}
				else if(this.negativeWords.contains(words[i])){
					negativeCount+=2;
				}
			}catch(ArrayIndexOutOfBoundsException e){
				if(this.positiveWords.contains(words[i])){
					positiveCount+= 2;
				}
				else if(this.negativeWords.contains(words[i])){
					negativeCount+=2;
				}
			}
		}
		int score = positiveCount - negativeCount;
		String opinionFormed = "";
		if (score>=0){
			opinionFormed="Positive";
		}
		else{
			opinionFormed="Negative";
		}
		return opinionFormed;
	}
}
