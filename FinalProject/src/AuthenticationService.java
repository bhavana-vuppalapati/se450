import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthenticationService {
    private List<User> users ;

    public boolean register(String username, String password) {

        if(!username.isEmpty())
        {
            if(!password.isEmpty())
            {
                User newUser=new User(username,password);
                UserService.addUser(newUser);
                return true;
            }
        }
        return false;

    }

    public boolean login(String username, String password) {
        users=UserService.getAllUsers();
        int index=0;
        for(User user :users)
        {   index++;
            if(user.getUsername().equals(username))
            {
                if(user.getPassword().equals(password))
                {
                    return true;
                }
                else{
                    System.out.println("Invalid password");
                }
            }
            else{
                System.out.println("Username does not exist");
            }
        }
        return false;
    }
}