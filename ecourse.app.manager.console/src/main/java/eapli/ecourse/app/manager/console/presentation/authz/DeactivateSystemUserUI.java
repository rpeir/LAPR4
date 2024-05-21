package eapli.ecourse.app.manager.console.presentation.authz;

import eapli.ecourse.usermanagement.application.ActivateDeactivateSystemUserController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class DeactivateSystemUserUI extends AbstractUI {
    ActivateDeactivateSystemUserController theController = new ActivateDeactivateSystemUserController();
    private final ArrayList<SystemUser> deactivatedSystemUsers = new ArrayList<>();

    @Override
    protected boolean doShow() {
        try {
            System.out.println("System Users List:");
            for (SystemUser s : this.theController.listSystemUsers()) {
                System.out.println(s.identity() + " - " + s.name());
            }
            System.out.println("Select the user to deactivate:");
            String usernameEmail = Console.readLine("Email:");
            String option = Console.readLine("Deactivate (D/d) user?");
            if (option.equals("D") || option.equals("d")) {
                SystemUser s = this.theController.findUserByUsername(usernameEmail);
                for (SystemUser dea : this.theController.listDeactivatedSystemUsers()) {
                    deactivatedSystemUsers.add(dea);
                }
                if (deactivatedSystemUsers.contains(s)) {
                    System.out.println("User already deactivated");
                    return false;
                }
                    this.theController.deactivateUser(s);
                    System.out.println("User deactivated successfully");

                }
                return false;
            }catch(Exception e){
                System.out.println("It was not possible to deactivate the user");
                return false;
            }


        }


    @Override
    public String headline() {
        return "Deactivate System User";
    }
}
