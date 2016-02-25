import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.stanford.nlp.simple.*;

public class Begin {

	private static BufferedReader _Source;
	public final static String LINE_SEPERATOR = "\\\\n";
	
	public static void main(String[] args) throws Exception {
		
		initialize();
		String text = null;
		
		while ((text = _Source.readLine())!=null) {
			text = preprocess(text);
			Document doc = new Document(text);
			
			for (Sentence sent : doc.sentences()) {
				
				
				System.out.println(sent.text());
			}
			System.out.println("***");
		}
		

		
		cleanUp();
		
/*		
		// Create a document. No computation is done yet.
        Document doc = new Document("add your text here! It can contain multiple sentences.");
        for (Sentence sent : doc.sentences()) {  // Will iterate over two sentences
            // We're only asking for words -- no need to load any models yet
            System.out.println("The second word of the sentence '" + sent + "' is " + sent.word(1));
            // When we ask for the lemma, it will load and run the part of speech tagger
            System.out.println("The third lemma of the sentence '" + sent + "' is " + sent.lemma(2));
            // When we ask for the parse, it will load and run the parser
            System.out.println("The parse of the sentence '" + sent + "' is " + sent.parse());
        }
        
        
*/        
	}

	private static void initialize() {
		
		InputStream sourceIO = Begin.class.getResourceAsStream("sample.txt");
		_Source = new BufferedReader(new InputStreamReader(sourceIO));
		
	}
	
	private static void cleanUp() throws Exception {
		
		_Source.close();
		
	}
	private static String preprocess(String text) {
		
		text = text.replaceAll("\\\\n", " ");
		text = text.replaceAll("\\(.*?\\)","");
		
		return text;
	}
}
