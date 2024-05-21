package eapli.ecourse.app.manager.console.presentation.authz;

import eapli.ecourse.usermanagement.application.ActivateDeactivateSystemUserController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class ActivateSystemUserUI extends AbstractUI {
    ActivateDeactivateSystemUserController theController = new ActivateDeactivateSystemUserController();
    private final ArrayList<SystemUser> activatedSystemUsers = new ArrayList<>();

    @Override
    protected boolean doShow() {
        try {
            System.out.println("System Users List:");
            for (SystemUser s : this.theController.listSystemUsers()) {
                System.out.println(s.identity() + " - " + s.name());
            }
            System.out.println("Select the user to activate");
            String usernameEmail = Console.readLine("Email:");
            String option = Console.readLine("Activate (A/a) User?");
            if (option.equals("A")|| option.equals("a")) {
                SystemUser s = this.theController.findUserByUsername(usernameEmail);
                for(SystemUser act : this.theController.listActiveSystemUsers()){
                    activatedSystemUsers.add(act);
                }
                if(activatedSystemUsers.contains(s)){
                    System.out.println("User already activated");
                    return false;
                }
                this.theController.activateUser(s);
                System.out.println("User activated successfully");
            }else {
                System.out.println("Invalid Option");
            }
            return false;
        }catch(Exception e){
            System.out.println("It was not possible to activate the user");
            return false;
        }


    }


    @Override
    public String headline() {
        return "Activate System User";
    }
}
