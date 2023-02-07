package Orchestrator;

import interfaces.FileDataBase;
import interfaces.ImageFileDataBase;
import model.MFile;
import model.MFileAnnotationTypeEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDataBase, FileDataBase {

    File file;
    List <MFile> mFileImageList = new ArrayList();

    public void saveAllListOfFiles (List<MFile> mFileList) {


    }

    public void saveAllListOfImageFiles (List<MFile> mFileImageList) {
        for (MFile lista: mFileImageList) {
            file = new File("C:\\Users\\fesan\\01-Curso_Ada_PoloTech_Americanas\\modulo_03\\atividade03_poo2_Arquivos\\src\\diretorios");
            if (file.exists()){
                saveImageFile("C:\\Users\\fesan\\01-Curso_Ada_PoloTech_Americanas\\modulo_03\\atividade03_poo2_Arquivos\\src\\diretorios",
                        lista.getContent(),
                        lista.getNameFile());
            }else System.out.println("Diretório não existe");
        }
    }

    @Override
    public void saveImageFile(String directory, String content, String nameFile) {

        try {
            String direct = "imagens";
            BufferedImage imagem;
            URL url = new URL (content);

            imagem = ImageIO.read(url);
            String path = directory + "\\" + direct + "\\" + nameFile + ".png";

            ImageIO.write(imagem, ".png", new File(path));
            System.out.println("Arquivo de imagem salva com sucesso");

        } catch (IOException e) {

            System.out.println("Erro! Imagem não foi salva.");
        }
    }

    @Override
    public void saveImageFile(String directory, String content, MFileAnnotationTypeEnum fileType, String fileName) {

    }

    @Override
    public void recoveryImageFile(String directory) {

    }

    @Override
    public void removeImageFile(String directory, String nameFile) {

    }

    @Override
    public void listAllImageFiles(String directory) {

    }

    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {

        String direct;
        switch (type) {
            case REMINDER:
                direct = "\\reminders";
            case IMPORTANT:
                direct = "\\importants";
            case IMAGE:
                direct = "\\images";
            default:
                direct = "";
        }
        super.createAFolder(directory + direct, type);
        String path = directory + direct + "\\" + nameFile + ".txt";

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recoveryFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {

    }

    @Override
    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {

        if (nameFile.equals(file.getName())) {
            mFileImageList.remove(file);
        }
    }

    @Override
    public void listAllFiles(String directory, MFileAnnotationTypeEnum type) {



    }

    @Override
    public void createAFolder(String path) {

    }
}
