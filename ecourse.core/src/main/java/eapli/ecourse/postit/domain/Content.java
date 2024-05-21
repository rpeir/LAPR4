package eapli.ecourse.postit.domain;

import eapli.framework.domain.model.ValueObject;
import org.hibernate.annotations.Type;
import org.hibernate.type.BlobType;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class Content implements ValueObject {
    @Enumerated(EnumType.STRING)
    private ContentType type;

    @Lob
    private byte[] content;
    public static final int MAXIMUM_PACKET_SIZE = 5000000; // 5MB

    public Content() {

    }

    public Content(ContentType contentType, byte[] newContent) {
        this.type = contentType;
        this.content = newContent;
    }

    public String toString() {
        if (this.type == ContentType.TEXT) {
            return new String(this.content);
        }else
            return "image";
    }

    /**
     * Convert content to File or String object, depending of the ContentType
     * @param path if File, the new path of the file, else ignored
     * @return java.io.File or String
     */
    public Object getContent(String path) {
        if (this.type == ContentType.TEXT) {
            return Content.convertByteArrayToText(this.content);
        } else {
            return Content.convertByteArrayToImage(this.content, path);
        }
    }

    public ContentType type() {
        return type;
    }

    public static byte[] convertImageToByteArray(String path) {
        Pattern pattern = Pattern.compile("((.*(jpg|png|gif|bmp|jpeg))$)");
        byte[] imageBytes;
        if (pattern.matcher(path).matches()) {
            File image = new File(path);
            try {
                imageBytes= org.apache.commons.io.FileUtils.readFileToByteArray(image);
                if (imageBytes.length > MAXIMUM_PACKET_SIZE)
                    throw new IllegalStateException("Content too big. Please insert content with less than 50MB");
                return imageBytes;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            throw new IllegalArgumentException("Path must be a valid image path");
        return null;
    }
    public static byte[] convertTextToByteArray(String text) {
        byte[] textBytes = text.getBytes();
        if (textBytes.length > MAXIMUM_PACKET_SIZE){
            throw new IllegalStateException("Content too big. Please insert content with less than 50KB");
        }
        return textBytes;
    }
    public static File convertByteArrayToImage(byte[] image, String filename) {
        File file = new File(filename);
        try {
            org.apache.commons.io.FileUtils.writeByteArrayToFile(file, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    public static String convertByteArrayToText(byte[] text) {
        return new String(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content1 = (Content) o;
        return type == content1.type && Arrays.equals(content, content1.content);
    }
}
