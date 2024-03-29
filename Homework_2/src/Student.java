
public class Student 
{
	private int id;
	private String name;
	private double grade;
	
	public Student()
	{
		this.id = 0;
		this.name = "";
		this.grade = 0.0;
	}
	
	public Student(int id, String name, double grade)
	{
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	 
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public double getGrade()
	{
		return grade;
	}

	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	
	public boolean equals(Student stu)
	{
		//Return true if the ids match
		return this.id == stu.id;
	}
	
	public boolean equals(int id)
	{
		//Return true if the ids match
		return this.id == id;
	}
	
	public String toString()
	{
		//Return true if name and id is found
		return this.id + " " + this.name + " " + this.grade;
	}
}
