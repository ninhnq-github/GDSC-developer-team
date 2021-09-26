
public class ProfileController {
	private UserModel user;
	
	public ProfileController(){
		user = UserModel.loadUserData();
	}
	
	public void updateProfile(String name, String age, String major) {
		this.user.setName(name);
		this.user.setAge(age);
		this.user.setMajor(major);
		UserModel.updateUserData(user);
	}
}
