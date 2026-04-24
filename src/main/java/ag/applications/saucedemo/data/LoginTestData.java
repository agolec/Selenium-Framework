package ag.applications.saucedemo.data;

public class LoginTestData {

    public String username;
    public String password;
    public boolean expectedSuccess;

    public LoginTestData(String username, String password, boolean expectedSuccess){
        this.username = username;
        this.password = password;
        this.expectedSuccess = expectedSuccess;
    }
    public String toString(){
        return "Username: '" + this.username + "'\n"
                + "Password: '" + this.password + "'\n";
    }
}
