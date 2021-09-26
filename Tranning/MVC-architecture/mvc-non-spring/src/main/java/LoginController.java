
public class LoginController {
	private UserModel user;
	
	public LoginController() {
		user = UserModel.loadUserData();
	}
	
	boolean login(String account, String password) {
		return account.equals(user.getAccount()) && password.equals(user.getPassword());
	}
}
