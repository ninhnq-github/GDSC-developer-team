package mvc_demo;

public class UserModel {
	
	public static String _name = "ninh";
	public static String _password = "123";
	
	private String name, password;
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserModel() // assume that name and password was loaded from DB 
    {
    	this.name = _name;
    	this.password = _password;
    }
}
