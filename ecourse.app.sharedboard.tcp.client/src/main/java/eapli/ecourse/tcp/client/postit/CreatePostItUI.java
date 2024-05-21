package eapli.ecourse.tcp.client.postit;

import eapli.ecourse.postit.domain.ContentType;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class CreatePostItUI extends AbstractUI {
    private final CreatePostItTCPClientController controller;

    /**
     * Instantiates a new Login ui.
     *
     * @param sock the socket
     */
    public CreatePostItUI(Socket sock) {
        this.controller = new CreatePostItTCPClientController(sock);
    }

    @Override
    protected boolean doShow() {
        try {
            String title;
            List<String> boards =  controller.listUserBoardsShared();
            do {
                if (!boards.isEmpty()) {
                    SelectWidget<String> boardSelector = new SelectWidget<>("Select one of the boards:", boards);
                    boardSelector.show();
                    if (boardSelector.selectedOption() == 0) return false;
                    title = boardSelector.selectedElement();
                } else {
                    throw  new IllegalStateException("You have no boards available");
                }
            }while (title == null);
            int row = Console.readInteger("Insert the line where you want to create the post-it");
            int column = Console.readInteger("Insert the column where you want to create the post-it");
            String contentType;
            do {
                SelectWidget<ContentType> contentTypeSelectWidget = new SelectWidget<>("Select the the type of content you want to insert", Arrays.asList(ContentType.values()));
                contentTypeSelectWidget.show();
                contentType = contentTypeSelectWidget.selectedElement().toString();
            } while (contentType == null);
            String content = Console.readLine("Insert Content");
            controller.createPostIt(contentType + "\0" + title + "\0" + row + "\0" + column, contentType, content);
            System.out.println("Post-it Created Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Create Post-it";
    }


}
