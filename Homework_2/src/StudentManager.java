
public class StudentManager 
{
	Student[] students;

	public boolean readFromFile(String string)
	{
		boolean readFile = false;
         try {
            Scanner sc = new Scanner(System.in);
            File inputFile = null;
            while (inputFile == null){   
                System.out.print("What is the filename? ");
                String fileName = sc.next();

                inputFile = new File(fileName);
                if (!inputFile.exists()){
                    inputFile = null;
                    }
               }
            }
		return false;
	}

	public void displayStudents()
	{
		System.out.print("\n" + "name" + "\n");
	}

	private Student findStudentById(int id)
	{
		//Check if student array even exists
		if (this.students == null)
		{
			//If the array is empty, student doesn't exist
			return null;
		}
		
		//Loop through the array
		for (Student s : students)
		{
			//If the id matches, return that student
			if (s.equals(id))
			{
				return s;
			}
		}
		
		//Return null if no student id matches
		return null;
	}
	
	public boolean searchStudentById(int id)
	{
		//Return true if a non-null result is found
		Student stu = findStudentById(id);
		
		//Check if student is found
		if (stu != null)
		{
			//If student is found, print string then return true
			System.out.println(stu.toString());
			return true;
		}
		else
		{
			//If student is not found, print error and return false
			System.out.println("Student not found.");
			return false;
		}
	}

	public boolean updateStudentGradeById(int id, double grade)
	{
		// TODO
		return false;
	}
}
