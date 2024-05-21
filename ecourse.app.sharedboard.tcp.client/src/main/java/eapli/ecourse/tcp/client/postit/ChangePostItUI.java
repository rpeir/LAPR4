package eapli.ecourse.tcp.client.postit;

import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.ContentType;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ChangePostItUI extends AbstractUI {
    private final ChangePostItTCPClientController controller;

    public ChangePostItUI(Socket sock) {
        this.controller = new ChangePostItTCPClientController(sock);
    }

    @Override
    protected boolean doShow() {
        try {
            String title;
            List<String> boards = controller.listBoardsWithWritePermission();
            do {
                if (!boards.isEmpty()) {
                    SelectWidget<String> boardSelector = new SelectWidget<>("Select one of the boards:", boards);
                    boardSelector.show();
                    if (boardSelector.selectedOption() == 0) return false;
                    title = boardSelector.selectedElement();
                } else {
                    throw new IllegalStateException("You have no boards available");
                }
            } while (title == null);
            //switch case for moving or editing post it
            switch (Console.readInteger("1 - Move Post-it\n2 - Edit Post-it\n3 - Delete Post-it")) {
                case 1:
                    int row1 = Console.readInteger("Insert the current line of the post-it you want to move");
                    int column1 = Console.readInteger("Insert the current column of the post-it you want to edit");
                    int row2 = Console.readInteger("Insert the new line of the post-it you want to move");
                    int column2 = Console.readInteger("Insert the new column of the post-it you want to edit");
                    if (row1 == row2 && column1 == column2) {
                        System.out.println("You can't move a post-it to the same position");
                        return false;
                    }
                    controller.movePostIt(title, row1, column1, row2, column2);
                    System.out.println("Post-it Moved Successfully");
                    return true;
                case 2:
                    int row3 = Console.readInteger("Insert the line of the post-it you want to edit");
                    int column3 = Console.readInteger("Insert the column of the post-it you want to edit");
                    String contentType;
                    do {
                        SelectWidget<ContentType> contentTypeSelectWidget = new SelectWidget<>("Select the the type of content you want to insert", Arrays.asList(ContentType.values()));
                        contentTypeSelectWidget.show();
                        contentType = contentTypeSelectWidget.selectedElement().toString();
                    } while (contentType == null);
                    String stringContent;
                    byte[] content = null;
                    do {
                        stringContent = Console.readLine("Insert new content (text or image path): ");
                        if (ContentType.TEXT.equals(ContentType.valueOf(contentType)))
                            content = Content.convertTextToByteArray(stringContent);
                        else if (ContentType.IMAGE.equals(ContentType.valueOf(contentType)))
                            content = Content.convertImageToByteArray(stringContent);
                    } while (stringContent == null || stringContent.isEmpty());
                    controller.changePostIt(title, row3, column3, contentType, content);
                    System.out.println("Post-it Edited Successfully");
                    return true;
                case 3:
                    int row4 = Console.readInteger("Insert the line of the post-it you want to delete");
                    int column4 = Console.readInteger("Insert the column of the post-it you want to delete");
                    controller.deletePostIt(title, row4, column4);
                    System.out.println("Post-it Deleted Successfully");
                    return true;
                default:
                    System.out.println("Invalid option");
                    return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String headline() {
        return "Change Post-it";
    }
}
