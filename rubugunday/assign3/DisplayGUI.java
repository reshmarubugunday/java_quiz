package rubugunday.assign3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


public class DisplayGUI{
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	JButton startButton;
	JButton nextQuestionButton;
	JFrame frame;
	JPanel baseQuizPanel;
	ArrayList<Question> quests = new ArrayList<Question>();
	int count = 0;
	int score = 0;
	int questNumb = 0;
	int catCount=0;
	public void FirstScreen(JFrame frame){
		
		//Frame Properties
		frame.setTitle("GOT Quiz");
		frame.setContentPane(new JLabel(new ImageIcon("F:\\JAVA\\workspace\\Assign3\\rubugunday\\assign3\\GOT3.jpg")));
		Container pane = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		//Panel for Tag
		JPanel tagPanel = new JPanel();
		tagPanel.setOpaque(false);
		final JLabel tag1 = new JLabel("Time for some Fun! Specially for GOT Fans :)");
		
		//Tag Properties
		tag1.setFont(new Font("Segoe UI", 1, 20));
		tag1.setForeground(Color.white);
		tagPanel.add(tag1, BorderLayout.WEST);
		pane.add(tagPanel, BorderLayout.NORTH);
		
		//Panel for button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		
		//Button
		startButton = new JButton("Start");
		buttonPanel.add(startButton, BorderLayout.WEST);
		pane.add(buttonPanel, BorderLayout.SOUTH);
		
		//Button ActionListener
		startButton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().removeAll(); 
                frame.revalidate();
                frame.repaint();
                ChoiceScreen(frame);
            }
        } );
		frame.pack(); 
        frame.setVisible(true);	
       
        
	}
	
	public void ChoiceScreen(JFrame frame){
		
		//OuterPanel
		JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setOpaque(false);
        //frame.getContentPane();
        frame.add(mainPanel);
        
        //SubPanel
        JPanel subPanel = new JPanel(new FlowLayout());
        subPanel.setOpaque(false);
        //subPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        
        //QuestionLabel
        JLabel questLabel = new JLabel("Let's see how obsessed you are with GoT! Choose a category ;)");
        questLabel.setFont(new Font("Segoe UI", 1, 20));
        questLabel.setForeground(Color.white);
        subPanel.add(questLabel, BorderLayout.WEST);
		mainPanel.add(subPanel, BorderLayout.CENTER);
        //mainPanel.add(subPanel);
		
		//Options
		JPanel ansPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,3,3));
		ansPanel.setOpaque(false);
        //answersPanel.setBorder(new TitledBorder("Choose one of the options below:"));
        JButton answerOption1 = new JButton("Guess who?!");
        JButton answerOption2 = new JButton("A little more in detail");
        JButton answerOption3 = new JButton("How are they related?!");
        
        //Adding the buttons to the panel.
        ansPanel.add(answerOption1);
        ansPanel.add(answerOption2);
        ansPanel.add(answerOption3);
        //ansPanel.add(answerOption4);
        
        //Add the answers panel to the main panel.
        subPanel.add(ansPanel, BorderLayout.SOUTH); 
        
        //ActionListeners on the buttons
        answerOption1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae) {
            	frame.getContentPane().removeAll(); 
            	frame.revalidate();
            	frame.repaint();
            	String category = "one";
            	QuestScreen(frame,category);
            }
        } );
        answerOption2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae) {
            	frame.getContentPane().removeAll(); 
            	frame.revalidate();
            	frame.repaint();
            	questNumb=6;
            	String category = "two";
            	QuestScreen(frame, category);
            }
        } );
        answerOption3.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae) {
            	frame.getContentPane().removeAll(); 
            	//frame.setContentPane(new JPanel(null));
            	frame.revalidate();
            	frame.repaint();
            	questNumb=9;
            	String category = "three";
            	QuestScreen(frame, category);
            }
        } );
        frame.setVisible(true);
	}
	
	public void QuestScreen(JFrame frame, String category){
		//Creating the first panel.
		
        JPanel BasePanel = new JPanel(new BorderLayout(10,10));
        TitledBorder title = BorderFactory.createTitledBorder("Top Quiz");
        title.setTitleColor(Color.black);
        title.setTitleJustification(TitledBorder.CENTER);
        BasePanel.setBorder(title);
        BasePanel.setOpaque(true);
        //System.out.print("Panel Created");
        frame.getContentPane();
        frame.add(BasePanel);
        //JToolBar tb = new JToolBar();
        
        
        
        //Creating a QuestionBank Object
        //System.out.print("Panel Created1");
        QuestionBank ListObj = new QuestionBank();
        
        
        quests = ListObj.CreateQuestionBank();
        //System.out.print("Size" + quests.size());
        
        
        Question questionObject = quests.get(questNumb);
        String question = questionObject.getQuestion(); 
        String answer1 = questionObject.getAnsOpt1();
        String answer2 = questionObject.getAnsOpt2();
        String answer3 = questionObject.getAnsOpt3();
        String answer4 = questionObject.getAnsOpt4();
        String correctAnswer = questionObject.getCorrectAns();
        String cat = questionObject.getCategory();
        String clueName = questionObject.getClueImg();
        //int catCount = 0;
        if(cat.equalsIgnoreCase(category)){
        //Creating the question box
        if(cat.equalsIgnoreCase("one")){
        	catCount=5;
        }else if (cat.equalsIgnoreCase("two")){
        	catCount=2;
        }
        else if(cat.equalsIgnoreCase("three")){
        	catCount=1;
        }
        JPanel questionPanel = new JPanel( new FlowLayout(FlowLayout.LEFT, 3,3));
        questionPanel.setBorder(new TitledBorder("Question " + (questNumb+1) ) );
        JLabel questionLabel = new JLabel(question);
        System.out.println(questionLabel);
        questionPanel.add(questionLabel);
        BasePanel.add(questionPanel, BorderLayout.NORTH);
        
        
        //Panel for the answers
        JPanel answersPanel = new JPanel(new GridLayout(4,1));
        answersPanel.setBorder(new TitledBorder("Choose one of the options below:"));
        JRadioButton answerOption1 = new JRadioButton(answer1);
        JRadioButton answerOption2 = new JRadioButton(answer2);
        JRadioButton answerOption3 = new JRadioButton(answer3);
        JRadioButton answerOption4 = new JRadioButton(answer4);
        
        //Adding buttons to a group.
        ButtonGroup answerButtonGroup = new ButtonGroup();
        answerButtonGroup.add(answerOption1);
        answerButtonGroup.add(answerOption2);
        answerButtonGroup.add(answerOption3);
        answerButtonGroup.add(answerOption4);
        
        //Adding the buttons to the panel.
        answersPanel.add(answerOption1);
        answersPanel.add(answerOption2);
        answersPanel.add(answerOption3);
        answersPanel.add(answerOption4);

        //Add the answers panel to the main panel.
        BasePanel.add(answersPanel, BorderLayout.CENTER); 
        
        //Timer panel.
        /*JPanel timerPanel = new JPanel(new FlowLayout());
        timerPanel.setBorder(new TitledBorder("Timer area:"));
        JButton test = new JButton("Test Button");
        timerPanel.add(test);
        timerPanel.add(new TimerBasedAnimation());
        BasePanel.add(timerPanel, BorderLayout.EAST);
        */
        //Getting the selected button.
        
        //answerButtonGroup.isSelected(correctAnswer);

        
        JPanel imagePanel = new JPanel(new GridBagLayout());
        imagePanel.setBorder( new TitledBorder("Question Clue") );
        Image bgImage = null;
        try {
            bgImage = ImageIO.read(DisplayGUI.class.getResource(clueName));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        ImageIcon ii = new ImageIcon(bgImage);
        JLabel imageLabel = new JLabel(ii);
        imagePanel.add( imageLabel, null );
        BasePanel.add(imagePanel, BorderLayout.WEST);
      
        
        //Buttons for navigation.
        JPanel navigationPanel = new JPanel();
        TitledBorder navigationButtons = BorderFactory.createTitledBorder("Navigation");
        navigationButtons.setTitleJustification(TitledBorder.CENTER);
        navigationPanel.setBorder(navigationButtons);
        
        //Button to go to the next question.
        JButton nextQuestionButton = new JButton("Next Question");
        
        nextQuestionButton.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent ae) {
				for (Enumeration<AbstractButton> buttons = answerButtonGroup.getElements(); buttons.hasMoreElements();)
  				{
  		            AbstractButton button = buttons.nextElement();
  		            if (button.isSelected()) {
  		                if(button.getText().equalsIgnoreCase(correctAnswer))
  		                {
  		                	score++;
  		                	
  		                	int size = quests.size()-1;
  		                	if(count >= catCount)
  		                	{
  		                		frame.setVisible(false);
  		                		frame.getContentPane().removeAll();
  								frame.revalidate();
  								frame.repaint();
  								System.out.println("\n Here 1");
  								DisplayExitScreen  ds = new DisplayExitScreen ();
  		                		ds.displayExitScreen(score-1);
  		                	}
  		                	else
  		                	{
  		                	count++;
  		                	frame.setVisible(false);
							frame.getContentPane().removeAll();
							frame.revalidate();
							frame.repaint();
							if(questNumb<10){
								questNumb++;
						QuestScreen(frame,category);
						}
  		                	}
  		                	
  		                }
  		                else
  		                {
  		                	
  		                	System.out.println("\n Quests Size" + count + " " + quests.size());
  		                	//questionObject.setScore(score);
  		                	//questionObject.setThreadCheck(true);
  		                	//System.out.println("\n The score is :" + questionObject.getScore());
  		                	if(count >= catCount)
  		                	{
  		                		frame.setVisible(false);
  		                		frame.getContentPane().removeAll();
  								frame.revalidate();
  								frame.repaint();
  								System.out.println("\n Here");
  								DisplayExitScreen  ds = new DisplayExitScreen ();
  		                		ds.displayExitScreen(score-1);
  		                	}
  		                	else
  		                	{
  		                	count++;
  		                	frame.setVisible(false);
						
  		                	frame.getContentPane().removeAll();
							frame.revalidate();
							frame.repaint();
							if(questNumb<10){
									questNumb++;
							QuestScreen(frame,category);
							}
  		                	
  		                	}
  		                }
  		                
  		            }
  		          
  		        }
  				
  				
  	    	  }	
			
			
	});
	    
        navigationPanel.add(nextQuestionButton, BorderLayout.EAST);
        
        //Button to go to the next section.
        JButton nextSectionButton = new JButton("Next Section");
        navigationPanel.add(nextSectionButton, BorderLayout.WEST);

        
        //Add the panel to the main panel.
        BasePanel.add(navigationPanel, BorderLayout.PAGE_END);
        
        //Adding the main panel to the frame.
        

        frame.setLocationRelativeTo(null);
       try {
            frame.setLocationByPlatform(true);
           // frame.setMinimumSize(frame.getSize());
        } catch(Throwable ignoreAndContinue) {
        	System.out.print("Catch error");
     }

        
        //System.out.print("AFter visible");
        
        nextQuestionButton.addActionListener(new ActionListener() {
            
            private static final long serialVersionUID = -1564412646667416696L;
            
              @SuppressWarnings("deprecation")
              public void actionPerformed(ActionEvent e)
               {
                  
                  for (Enumeration<AbstractButton> buttons = answerButtonGroup.getElements(); buttons.hasMoreElements();) {
                      AbstractButton button = buttons.nextElement();
                      if (button.isSelected()) {
                          if(button.getText().equalsIgnoreCase(correctAnswer))
                          {
                              score++;
                              System.out.print("Score"+ (score-1));
                              break;
                              
                          
                              
                          }
                      }
                  }
                }

			
			
            });
        }
        else if(questNumb<10){
			questNumb++;
	}
        frame.getContentPane();
        frame.add(BasePanel);
        frame.pack();
        frame.setVisible(true);
	}
	
/*	public void displayExitScreen(int score) {
		
		
		
		Container pane = frame.getContentPane();
		
		pane.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("End of Quiz",JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(45.0f));
		pane.add(label,BorderLayout.CENTER);
		
		JLabel scoreLabel = new JLabel("Your score is: "+ score);
		scoreLabel.setFont(scoreLabel.getFont().deriveFont(50.0f));
		scoreLabel.setForeground(Color.GREEN);
		pane.add(scoreLabel, BorderLayout.AFTER_LAST_LINE);
		JPanel panel = new JPanel(new FlowLayout());
		panel.setOpaque(false);
		JButton button1 = new JButton("Click to close.");
		button1.addActionListener(new ActionListener()
			{	

			@Override
			public void actionPerformed(ActionEvent ae) {
				//System.out.println("Button clicked");
				frame.dispose();
				System.exit(0);
				
					
			}	
		});
		
		
		panel.add(button1);
		//frame.add(panel);
		pane.add(panel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
	}*/

}


		
	

	
