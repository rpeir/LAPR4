package eapli.ecourse.tcp.client.updateManagement;

import eapli.ecourse.boardUpdate.domain.CellUpdateType;
import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.framework.visitor.Visitor;

public class UpdateDTOPrinter implements Visitor<UpdateDTO> {
    @Override
    public void visit(UpdateDTO visitee) {
        System.out.printf("%s - %s - %s - %s",visitee.user,visitee.timeUpdate,visitee.updateType,visitee.subtype);
        if (visitee.updateType.equals("CellUpdate")) {
            switch (visitee.subtype) {
                case "MOVE":
                    System.out.printf(" - (%d,%d) -> (%d,%d)", visitee.initRow, visitee.initCol, visitee.endRow, visitee.endCol);
                    break;
                case "INSERT":
                case "DELETE":
                    System.out.printf(" - (%d,%d)", visitee.initRow, visitee.initCol);
                    break;
            }
        }
        System.out.println();
    }
}
