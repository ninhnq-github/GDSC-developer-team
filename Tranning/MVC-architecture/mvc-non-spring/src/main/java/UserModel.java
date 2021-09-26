
public class UserModel {
	
	private String account, password, name, age, major;
	
	public UserModel() {}
	
	public static UserModel loadUserData()
	{
		UserModel u = new UserModel();
		u.account = DataBaseProvider.USER_ACCOUNT;
		u.age = DataBaseProvider.USER_AGE;
		u.password = DataBaseProvider.USER_PASSWORD;
		u.major = DataBaseProvider.USER_MAJOR;
		u.name = DataBaseProvider.USER_NAME;
		return u;
	}
	
	public static void updateUserData(UserModel u)
	{
		DataBaseProvider.USER_ACCOUNT = u.account;
		DataBaseProvider.USER_AGE = u.age;
		DataBaseProvider.USER_PASSWORD = u.password;
		DataBaseProvider.USER_MAJOR = u.major;
		DataBaseProvider.USER_NAME = u.name;
	}
	
	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}
	
}
