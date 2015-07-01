package paciente.android.umbrella.uniandes.edu.co.entities;

/**
 * Created by Gabriel on 27/06/2015.
 */
public class User {
    private String Identification;

    public String getIdentification() {
        return Identification;
    }

    public void setIdentification(String identification) {
        Identification = identification;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
