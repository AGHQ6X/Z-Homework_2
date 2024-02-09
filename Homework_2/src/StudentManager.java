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
	
	

	public boolean readFromFile(String string)
	{
		boolean readFile = false;
        Scanner sc = new Scanner(System.in); 
        File inputFile = null;
		try {
            while (inputFile == null){   
                System.out.print("What is the filename? ");
                String fileName = sc.next();

                inputFile = new File(fileName);
                if (!inputFile.exists()){
                    inputFile = null;
                    }
               }
    		try (Scanner fileScanner = new Scanner(inputFile)){
    			while (fileScanner.hasNext()) {
    				int id = fileScanner.nextInt();
    				String name = fileScanner.next() + " " +fileScanner.next();
    				double grade = fileScanner.nextDouble();
    				students[numStus++] = new Student(id, name, grade);
    			}
    		readFile = true;
    		}
            } catch (Exception a) {
            	//catch goes here
            	//TODO
            }/*finally {
         		if (sc != null) {
         			sc.close();
         		}
         		
         		
         	}*/
         	
			
         	
		return false;
	}

	public void displayStudents()
	{
		//display all students in the list
		
		System.out.print("Student List: ");
		for(int i = 0; i < numStus; i++) {
			System.out.println(students[i].toString());
			
		}
		
	}


	
	public boolean searchStudentById(int id)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Student's ID Which you would like to change");
		int idToSearch = sc.nextInt();
		
		//Check if student is found
		if (this.students == null)
		{
			//If student is found, print string then return true
			System.out.print("This file did not contain a list of students properly formatted.");
			return false;
		}
		
		boolean studentFound = false;
		
		for (Student s : students) {
			if(s.equals(idToSearch)) {
				System.out.println(s.toString());
				studentFound = true;
				break;
			}
		}
			//If student is not found, print error and return false
			if(!studentFound) {
				System.out.println("Student not found.");
				return false;
			}
			return false;
		
	}
	

	public boolean updateStudentGradeById(int id, double grade)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the ID of the student you would like to change the grade of please..");
		int idUpd = sc.nextInt();
		
		if(this.students == null) {
			System.out.print("Invalid...");
			return false;
		}
		
		boolean stuFound = false;
		for(Student s : students) {
			if(s.equals(idUpd)) {
				System.out.print("Student Found:" + s.toString());
				System.out.print("Enter the new grade (From 0 to 100, please).");
				double newGrade = sc.nextDouble();
				
				if(newGrade > 0 && 100 > newGrade) {
					s.setGrade(newGrade);
					System.out.print("Grade was updated!");
					
				}
				else {
					System.out.print("Grade was not updated...");
				}
				stuFound = true;
				break;
			}
			
		}
		
		
		if(!stuFound) {
			System.out.print("Student was not found");
		}
		
		return false;
	}
}
