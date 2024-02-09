import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentManager 
{
	private Student[] students;
	private int numStus;
	
	public StudentManager() {
		this.students = new Student[10];
		this.numStus = 0;
	}

	public boolean readFromFile(String fileName)
	{
		//
		File inputFile = new File(fileName);
		
		//Check if the file exists
		if (!inputFile.exists())
		{
			//Print error
			System.out.println("The file does not exist.");
			
			return false;
		}
		
		//Create a fileScanner object
		Scanner fileScanner;
		
		//File opening
		try
		{
			//Initialize scanner
			fileScanner = new Scanner(inputFile);
		} 
		catch (FileNotFoundException e)
		{
			//Print error
			System.out.println("File not found: " + e.toString());
			
			return false;
		}
		
		//Loop through lines
		while (fileScanner.hasNext())
		{
			//Scan line
			int id = fileScanner.nextInt();
			String name = fileScanner.next() + " " + fileScanner.next();
			double grade = fileScanner.nextDouble();
			
			//Create student object
			students[numStus++] = new Student(id, name, grade);
		}
		
		//Close scanner
		if (fileScanner != null)
		{
			fileScanner.close();
		}
         	
		//If it got to here, everything had to be successful
		return true;
	}

	public void displayStudents()
	{
		 StringBuilder output = new StringBuilder("Student List:\n");

		    // Append each student's info to the output string
		    for (int i = 0; i < numStus; i++) {
		        output.append(students[i].toString()).append("\n");
		    }

		    // Print the entire output string
		    System.out.print(output);
		}
	
	public boolean searchStudentById(int id)
	{
		//Check if student array is null
		if (this.students == null)
		{
			//If student is found, print string then return true
			System.out.print("This file did not contain a list of students properly formatted.");
			
			return false;
		}
		
		//Loop through student array
		for (Student s : students) {
			if (s != null && s.equals(id)) {
				System.out.println(s.toString());
				return true;
			}
		}
		
		return false;
	}
	

	public boolean updateStudentGradeById(int id, double grade)
	{
		if(this.students == null) {
			System.out.print("Invalid...");
			return false;
		}
		
		boolean stuFound = false;
		for(Student s : students) {
			if(s != null && s.equals(id)) {
				
				if(grade > 0 && 100 > grade) {
					s.setGrade(grade);
					System.out.println("Grade was updated!");
				}
				else {
					System.out.println("Grade was not updated...");
				}
				stuFound = true;
				break;
			}
			
		}
		
		if(!stuFound) {
			System.out.println("Student was not found");
			return false;
		}
		
		return true;
	}
}
