package paciente.android.umbrella.uniandes.edu.co.aplications;

import android.app.Application;

import paciente.android.umbrella.uniandes.edu.co.entities.User;

/**
 * Created by Gabriel on 29/06/2015.
 */
public class MigranaApplication extends Application {

    private User authenticatedUser;

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
}
