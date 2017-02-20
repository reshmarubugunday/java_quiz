package rubugunday.assign3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionBank {

	
	public ArrayList<Question> getQuestionsList() {
		return questionsList;
	}


	public void setQuestionsList(ArrayList<Question> questionsList) {
		this.questionsList = questionsList;
	}


	private ArrayList<Question> questionsList = new ArrayList<Question>(10);
	
   
    public ArrayList<Question> CreateQuestionBank(){
    	
    	String fileName = "F:\\JAVA\\workspace\\Assign3\\rubugunday\\assign3\\questions.csv";
    	Scanner fileReader = null;
    	try {
        
    		fileReader = new Scanner(new File(fileName));
    
    	}catch (FileNotFoundException e) {
    
    		System.out.println("\n Check the location of the file passed.");
    		e.printStackTrace();
    
    	}
    	while(fileReader.hasNextLine())
    	{
    		//System.out.println("\n Line:" + fileScan.nextLine());
    		String line = fileReader.nextLine();
    		String[] Parts = line.split(",");
    		/*if(Parts[7].equalsIgnoreCase(" "))
    		{
    			Parts[7] = "noClue.jpg";
    		}*/
        
    		//System.out.println("\n Parameter values" + Parts[7]);
    		Question object = new Question(Parts[0], Parts[1], Parts[2], Parts[3], Parts[4],Parts[5],Parts[6],Parts[7]);
    		//System.out.print("Objecct"+object.getQuestion());
    		
    		/*for(String value:Parts)
        	{
            	System.out.println("\n Value: " + value);
            
        	}*/
        	//System.out.println("\nEnd of first line.");
    		questionsList.add(object);
    	}
    	fileReader.close();
    	//System.out.print("questions" + questionsList);
    	return questionsList;
    	
    }	
}