package model;

public class MFile {

    private String content;
    private String nameFile;
    private MFileAnnotationTypeEnum type;



    private String path;

    public MFile(String content, String nameFile, MFileAnnotationTypeEnum type, String path) {
        this.content = content;
        this.nameFile = nameFile;
        this.type = type;
        this.path = path;
    }

    public MFile () {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public MFileAnnotationTypeEnum getType() {
        return type;
    }

    public void setType(MFileAnnotationTypeEnum type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
