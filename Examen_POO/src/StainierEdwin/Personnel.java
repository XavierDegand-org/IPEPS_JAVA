package StainierEdwin;

import java.util.regex.*;

public class Personnel {
	
	private int idPersonnel;
	private int id;
	private String email;
	private String emailPattern = "^(.+)@(.+)$";
	private Departement dept;
	
	public Personnel(String email, Departement dept)
	{
		this.idPersonnel = idPersonnel;
		this.id = id;
		SetEmail(email);
		this.dept = dept;
	}
	
	public int GetIdPersonnel()
	{
		return idPersonnel;
	}
	
	public String GetEmail()
	{
		return email;
	}
	
	public void SetEmail(String email)
	{
		/*String regex = "^(.+)@(.+)$";
		
		try {
			Pattern pattern = Pattern.compile(emailPattern);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches())
			{
				this.email = email;
			}
			else
			{
				System.out.println("Email Incorrect");
			}
		}
		catch (PatternSyntaxException ex)
		{
			System.out.println(ex.toString());
		}*/
					
		this.email = email;
	}
	
	public String GetDepartement()
	{
		return dept.GetDeptNom();
	}
	
	
	
}
