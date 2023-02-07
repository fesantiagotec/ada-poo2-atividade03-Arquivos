package Orchestrator;

import interfaces.FolderManagement;
import model.MFileAnnotationTypeEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;

import static model.MFileAnnotationTypeEnum.*;

public class FolderOrchestrator implements FolderManagement {

    public void createFolders(List<String> mListPaths) {

    }

    public void removeFolders(List<String> mListPaths) {

    }

    @Override
    public void createAFolder(String path, MFileAnnotationTypeEnum type) {

        String direct = "";
        switch (type) {
            case REMINDER -> direct = "reminders";
            case IMPORTANT -> direct = "importants";
            case IMAGE -> direct = "images";
            default -> direct = "";
        }
        try {
            boolean file = new File(path + "\\"+direct).exists();
            if (file) {
                System.out.println("diretorio ja existe");
            } else {
                boolean result = new File(path).mkdir();
                if (result) {
                    System.out.println(" DIRETORIO CRIADO COM SUCESSO ");
                }

            }

        } catch (Exception e) {
            System.out.println(" ERROR AO CRIAR DIRETORIO ");
        }
    }

    public void saveImageFile(String directory, String content, String nameFile){
        try {
            String dir = "imagens";
            BufferedImage image;
            URL url = new URL(content);
            image = ImageIO.read(url);
            String path = directory + "\\" + dir + "\\" + nameFile + ".jpg";
            ImageIO.write(image, "jpg", new File(path));
            System.out.println("Imagem salva com sucesso");
        } catch (Exception e) {
            System.out.println("error generico. imagem não foi salva");
        }
    }

    public abstract void saveImageFile(String directory, String content, MFileAnnotationTypeEnum fileType, String fileName);

    @Override
    public void createAFolder(String path) {

    }

    @Override
    public void removeAFolder(String path) {

    }

    @Override
    public void listAllFoldersCreated() {

    }
}
