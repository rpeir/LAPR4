package org.sharedBoard.common;

import eapli.ecourse.app.sharedBoard.common.Message;
import eapli.ecourse.app.sharedBoard.common.MessageCodes;
import eapli.ecourse.app.sharedBoard.common.MessageFormat;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MessageFormatTest {
    private static final int VERSION = 1;
    private static final int CODE = MessageCodes.AUTH;
    private static final String TEXT = "Hello, world!";
    private static final byte[] TEXT_BYTES = TEXT.getBytes();
    private static final int TEXT_LENGTH = TEXT_BYTES.length;

    @Test
    public void testSendMessage() throws IOException {
        final Socket socket = mock(Socket.class);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
        MessageFormat messageFormat = new MessageFormat(socket);


        messageFormat.sendMessage(VERSION, CODE, TEXT);

        byte[] capturedData = byteArrayOutputStream.toByteArray();

        assertEquals(VERSION, capturedData[0]);
        assertEquals(CODE, capturedData[1]);
        assertEquals(TEXT_LENGTH % 256, capturedData[2]);
        assertEquals(TEXT_LENGTH / 256, capturedData[3]);
        assertEquals(TEXT, new String(capturedData, 4, TEXT_LENGTH));

        verify(socket, times(1)).getOutputStream();
        verify(socket, times(1)).getInputStream();
    }
}
