package interfaces;

import model.MFileAnnotationTypeEnum;

public interface FileDataBase {

    void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile);
    void recoveryFile(String directory, String nameFile, MFileAnnotationTypeEnum type);
    void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type);
    void listAllFiles(String directory, MFileAnnotationTypeEnum type);

}
