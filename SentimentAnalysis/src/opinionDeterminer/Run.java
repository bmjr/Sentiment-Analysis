package opinionDeterminer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Run {

	public static void main(String[] args) {
		JTextField input = new JTextField(30);
    	int actionUser = JOptionPane.showConfirmDialog(null, input,"Enter text:",JOptionPane.OK_CANCEL_OPTION);  
		String textToAnalyse = "";
		if(actionUser < 0) {
			JOptionPane.showMessageDialog(null,"Cancel, X or escape key selected"); 
			System.exit(0); 
		}
		else{
			textToAnalyse = (String)input.getText();
		}
		Dictionary positiveDict = new Dictionary("/users/brad/documents/dictionaries/positiveDictionary.txt");
		Dictionary negativeDict = new Dictionary("/users/brad/documents/dictionaries/negativeDictionary.txt");
		Dictionary incDict = new Dictionary("/users/brad/documents/dictionaries/incrementDictionary.txt");
		Dictionary decDict = new Dictionary("/users/brad/documents/dictionaries/decrementDictionary.txt");
		Opinion sentiment = new Opinion(textToAnalyse, positiveDict.getWords(),
				negativeDict.getWords(), incDict.getWords(), decDict.getWords());
		System.out.println(sentiment.formulate());
		}
		

}
