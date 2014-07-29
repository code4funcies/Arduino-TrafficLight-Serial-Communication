package neumont.enterprise;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame  extends JFrame{

	SerialTest st;
	int healthyProjects = 0, averageProjects = 0, unhealthyProjects = 0;
	double displayAverage = 0.0;
	
	public MainFrame(String title, SerialTest st){
		super(title);
		setSerialTest(st);
		setLayout(new GridBagLayout());
		addCompnonents();
		
		
	}
	
	public void setSerialTest(SerialTest st){
		this.st = st;
        this.st.initialize();
		
	}
	
	
	public void addCompnonents(){
		
		GridBagConstraints gc = new GridBagConstraints();

		JLabel label = new JLabel("Project Monitor");
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 0;
		add(label, gc);
		
		
		//FIRST COLUMN
		JLabel projectTasks = new JLabel("Total Tasks: ");
		projectTasks.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 2;
		add(projectTasks, gc);
		
		JLabel projectCompletedTasks = new JLabel("Completed Tasks: ");
		projectCompletedTasks.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 3;
		add(projectCompletedTasks, gc);
		
		JLabel projectBugs = new JLabel("Total Bugs: ");
		projectBugs.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 4;
		add(projectBugs, gc);
		
		JLabel projectCompletedBugs = new JLabel("Completed Bugs: ");
		projectCompletedBugs.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 5;
		add(projectCompletedBugs, gc);
		
		JLabel projectReviews = new JLabel("Total Reviews: ");
		projectReviews.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 6;
		add(projectReviews, gc);
		
		JLabel projectCompletedReviews = new JLabel("Completed Reviews: ");
		projectCompletedReviews.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 7;
		add(projectCompletedReviews, gc);
		
		JLabel projectCodeComplexity = new JLabel("Code Complexity: ");
		projectCodeComplexity.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 8;
		add(projectCodeComplexity, gc);
		
		JLabel projectCodeCoverage = new JLabel("Code Coverage: ");
		projectCodeCoverage.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 9;
		add(projectCodeCoverage, gc);
		

		final JButton updateButton = new JButton("Update");
		updateButton.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 10;
		add(updateButton, gc);
		
		JLabel tasksWeight = new JLabel("45%");
		tasksWeight.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 2;
		add(tasksWeight, gc);
		
		JLabel bugsWeight = new JLabel("25%");
		bugsWeight.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 4;
		add(bugsWeight, gc);
		
		JLabel reviewsWeight = new JLabel("10%");
		reviewsWeight.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 6;
		add(reviewsWeight, gc);
		
		JLabel complexityWeight = new JLabel("5%");
		complexityWeight.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 8;
		add(complexityWeight, gc);
		
		
		JLabel coverageWeight = new JLabel("15%");
		coverageWeight.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.SOUTHWEST;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 9;
		add(coverageWeight, gc);
		
		
		//SECOND COLUMN
		
		final JTextField projectTasksField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 0;
		add(projectTasksField, gc);
		
		
		final JTextField projectCompletedTasksField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 3;
		add(projectCompletedTasksField, gc);
		
		final JTextField projectBugsField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 4;
		add(projectBugsField, gc);
		
		final JTextField projectCompletedBugsField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 5;
		add(projectCompletedBugsField, gc);
		
		final JTextField projectReviewsField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 6;
		add(projectReviewsField, gc);
		
		final JTextField projectCompletedReviewsField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 7;
		add(projectCompletedReviewsField, gc);
		
		final JTextField projectCodeComplexityField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 8;
		add(projectCodeComplexityField, gc);
		
		final JTextField projectCodeCoverageField = new JTextField(7);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 9;
		add(projectCodeCoverageField, gc);
		
		
		
		
		//THIRD COLUMN
		
		JButton healthyButton = new JButton("Healthy");
		healthyButton.setFont(new Font("Serif", Font.PLAIN, 18));
		healthyButton.setBackground(Color.decode("#009933"));
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 2;
		add(healthyButton, gc);
		
		JButton averageButton = new JButton("Average");
		averageButton.setFont(new Font("Serif", Font.PLAIN, 18));
		averageButton.setBackground(Color.YELLOW);
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 3;
		add(averageButton, gc);
		
		JButton unhealthyButton = new JButton("Unhealthy");
		unhealthyButton.setFont(new Font("Serif", Font.PLAIN, 18));
		unhealthyButton.setBackground(Color.decode("#DA4747"));
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 5;
		add(unhealthyButton, gc);
		
		JButton buildingButton = new JButton("Building");
		buildingButton.setFont(new Font("Serif", Font.PLAIN, 18));
		buildingButton.setBackground(Color.ORANGE);
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 4;
		add(buildingButton, gc);
		
		JButton AwesomeButton = new JButton("Awesome");
		AwesomeButton.setFont(new Font("Serif", Font.PLAIN, 18));
		AwesomeButton.setBackground(Color.DARK_GRAY);
		AwesomeButton.setForeground(Color.YELLOW);
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 6;
		add(AwesomeButton, gc);
		
		final JLabel projectAggregateGreen = new JLabel("Healthy: " + healthyProjects);
		projectAggregateGreen.setForeground(Color.decode("#009933"));
		projectAggregateGreen.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 7;
		add(projectAggregateGreen, gc);
		
		final JLabel projectAggregateYellow = new JLabel("Average: " + averageProjects);
		projectAggregateYellow.setFont(new Font("Serif", Font.PLAIN, 18));
		projectAggregateYellow.setForeground(Color.decode("#B88A00"));
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 8;
		add(projectAggregateYellow, gc);
		
		final JLabel projectAggregateRed = new JLabel("Unhealthy: " + unhealthyProjects);
		projectAggregateRed.setFont(new Font("Serif", Font.PLAIN, 18));
		projectAggregateRed.setForeground(Color.decode("#DA4747"));
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 9;
		add(projectAggregateRed, gc);
		
		JButton offButton = new JButton("OFF");
		offButton.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 1;
		gc.gridy = 10;
		add(offButton, gc);

		final JButton aggregateButton = new JButton("Aggregate: " + displayAverage +"%");
		aggregateButton.setFont(new Font("Serif", Font.PLAIN, 18));
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 10;
		add(aggregateButton, gc);
		
//		final JLabel aggregateWeight = new JLabel(displayAverage + "%");
//		coverageWeight.setFont(new Font("Serif", Font.PLAIN, 18));
//		gc.anchor = GridBagConstraints.EAST;
//		gc.weightx = 0.5;
//		gc.weighty = 0.5;
//		gc.gridx = 2;
//		gc.gridy = 10;
//		add(coverageWeight, gc);
		
		
		
		
		
		//ACTION LISTENERS
		healthyButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				
				Thread t=new Thread() {
					public void run() {
						System.out.println("green light!");
						st.WriteToArduino('1');
					}
				};
				t.start();
				
				
				
				
			}
			
			
		});

		
		averageButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						System.out.println("yellow light!");
						st.WriteToArduino('2');
					}
				};
				t.start();
				
			}
			
			
		});
		
		
		unhealthyButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						System.out.println("red light!");
						st.WriteToArduino('3');
					}
				};
				t.start();
				
			}
			
			
		});
		
		
		offButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						System.out.println("off!");
						st.WriteToArduino('4');
					}
				};
				t.start();
				
			}
			
			
		});
		
		
		buildingButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						System.out.println("off!");
						st.WriteToArduino('5');
					}
				};
				t.start();
				
			}
			
			
		});
		
		AwesomeButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						System.out.println("off!");
						st.WriteToArduino('6');
					}
				};
				t.start();
				
			}
			
			
		});
		
		
		updateButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						
						st.WriteToArduino('5');
						try{
							
						System.out.println("update!");
						ProjectStats ps = new ProjectStats();
						int totalTasks = Integer.parseInt(projectTasksField.getText());
						int completedTasks = Integer.parseInt(projectCompletedTasksField.getText());
						int totalBugs = Integer.parseInt(projectBugsField.getText());
						int completedBugs = Integer.parseInt(projectCompletedBugsField.getText());
						int totalReviews = Integer.parseInt(projectReviewsField.getText());
						int completedReviews = Integer.parseInt(projectCompletedReviewsField.getText());
						int complexity = Integer.parseInt(projectCodeComplexityField.getText());
						int coverage = Integer.parseInt(projectCodeCoverageField.getText());
						ps.setTasksTotal(totalTasks);
						ps.setTasksComplete(completedTasks);
						ps.setBugsTotal(totalBugs);
						ps.setBugsComplete(completedBugs);
						ps.setCodeReviewTotal(totalReviews);
						ps.setCodeReviewComplete(completedReviews);
						ps.setCodeComplexity(complexity);
						ps.setCodeCoverage(coverage);
						ps.setTimeModifier(1.0);
						HealthCalculator hc = new HealthCalculator();
						HealthItem hi = hc.calculate(ps);
						
						if(hi.getHealth().getName().equals("Green")){
							healthyProjects ++;
							st.WriteToArduino('1');
						}
						else if(hi.getHealth().getName().equals("Yellow")){
							averageProjects ++;
							st.WriteToArduino('2');
						}
						else if(hi.getHealth().getName().equals("Red")){
							unhealthyProjects ++;
							st.WriteToArduino('3');
						}
						 
						double round = (double)Math.round(hi.getValue() * 1000) / 1000;
						updateButton.setText("Update: " + round*100 + "%");
						projectAggregateGreen.setText("Healthy: " + healthyProjects);
						projectAggregateYellow.setText("Average: " + averageProjects);
						projectAggregateRed.setText("Unhealthy: " + unhealthyProjects);
						
						}catch(Exception e){
							System.out.println("incorrect input format");
							
						}
						repaint();
						
					}
				};
				t.start();
				
			}
			
			
		});
		
		aggregateButton.addActionListener(new ActionListener(){

			@Override
			public synchronized void actionPerformed(ActionEvent arg0) {
				Thread t=new Thread() {
					public void run() {
						System.out.println("off!");
						st.WriteToArduino('5');
						
						double healthPoints = healthyProjects + (averageProjects * 0.5);
						double healthAverage = healthPoints/(healthyProjects + averageProjects + unhealthyProjects);
						if(healthAverage >= 0.75){
							st.WriteToArduino('1');
						}
						else if(healthAverage < 0.75 & healthAverage > 0.25){
							st.WriteToArduino('2');
						}
						else{
							st.WriteToArduino('3');
						}
						
						double displayAverage = healthAverage * 100;
						double round = (double)Math.round(displayAverage * 100) / 100;
						aggregateButton.setText("Aggregate: " + round +"%");
						System.out.println("Overall Score: " +healthAverage);
						
						
						
					}
				};
				t.start();
				
			}
			
			
		});
		
		
	}
	
	
}
