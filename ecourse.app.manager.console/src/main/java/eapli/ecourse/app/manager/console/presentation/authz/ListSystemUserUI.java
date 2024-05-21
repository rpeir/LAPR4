package eapli.ecourse.app.manager.console.presentation.authz;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.ecourse.usermanagement.application.ListSystemUsersController;

public class ListSystemUserUI extends AbstractUI {

        private final ListSystemUsersController theController = new ListSystemUsersController();

        @Override
        protected boolean doShow() {
            System.out.println("List System Users:");
            for(SystemUser user : this.theController.listSystemUsers())
                System.out.println(user.identity()+" - "+user.name());
            return false;
        }

        @Override
        public String headline() {
            return "List System Users";
        }
    }
