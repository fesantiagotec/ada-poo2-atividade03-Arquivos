/*
1) Considere o diagrama a seguir e crie um programa JAVA que o satisfaça. O programa deverá
conter como input um conjunto de informações relacionadas a operações de salvar arquivos,
remover e listar. O programa também deverá possuir um MENU via console utilizando o
System.out.println() para informar as opções e tipos de formas de salvar arquivos,
criar diretórios e etc.
a) Obs: Para salvar arquivos do tipo imagem você poderá utilizar a classe ImageIO do pacote
javax. Segue um exemplo de como utilizar o imageIO e o que o código fez.
b) Do tipo de arquivos a serem salvos:
I) Para arquivos do tipo reminder: Deverá ser criado um diretório adicional reminders com os
arquivos do tipo txt. Ex: \reminders\
II) Para arquivos do tipo important: Deverá ser criado um diretório adicional importants com os
arquivos do tipo txt.: Ex: \importants\
III) Para arquivos do tipo simple: Não deverá criar um diretório adicional.
IV) Para os arquivos do tipo Image: Deverá ser criado um diretório adicional images com os
arquivos <png,jpg>: Ex: \images\
c) “HandlerFile” é uma classe que herda toda a implementação de FolderOrchestrator e
FileOrchestrator. Fique a vontade para adicionar novas implementações nesta classe.
obs: ------|> implementa interface; (flecha sem pontilhado) -> herança.
*/

import Orchestrator.FileOrchestrator;
import Orchestrator.FolderOrchestrator;
import model.MFile;
import model.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HandlerFile handlerFile = new HandlerFile();
        List<MFile> mFileImageList = new ArrayList();
        List<MFile> mFileList = new ArrayList();

        imprimirMenu();

        System.out.println("Obs: Para as operações (1),(2),(3),(4) é necessário criar os diretorios iniciais (5) ");
        boolean repetir = true;
        while (repetir) {
            int opcaoMenu = scanner.nextInt();
//            scanner.skip("((?<!\\R)\\s)*");
            switch (opcaoMenu) {
                case 1 -> {
                    imprimirMenuTipoArquivoTexto();
                    int opcaoMenuArquivo = scanner.nextInt();
                    switch (opcaoMenuArquivo) {
                        case 1:
                            repetir = createFile(handlerFile, MFileAnnotationTypeEnum.REMINDER);
                        case 2:
                            repetir = createFile(handlerFile, MFileAnnotationTypeEnum.IMPORTANT);
                        case 3:
                            repetir = createFile(handlerFile, MFileAnnotationTypeEnum.SIMPLE);
                    }
                }
                case 2 -> {
                    System.out.println("Opção Deletar Arquivo de Texto");
                    System.out.print("Digite o caminho do diretório: \n");
                    String path = scanner.nextLine();//
                    System.out.print("Digite o nome do arquivo: \n");
                    String nameArquivo = scanner.next();

                    System.out.println("O arquivo de texto que deseja deletar pertende a qual tipo de arquivo?");
                    System.out.println("1 - REMINDER ");
                    System.out.println("2 - IMPORTANT ");
                    System.out.println("3 - SIMPLE ");
                    System.out.println("Digite a opção: ");
                    int opcaoMenuArquivo = scanner.nextInt();

                    //listAllFiles(String directory, MFileAnnotationTypeEnum type)
                    switch (opcaoMenuArquivo) {
                        case 1:
                            String direct = "REMINDER";
                            if (direct == "REMINDER") {
                                for (MFile cadaArquivo : mFileList) {
                                    if (nameArquivo.equals(cadaArquivo.getNameFile())) {
                                        mFileList.remove(cadaArquivo);
                                    }
                                }
                            }
                            repetir = false;
                        case 2:
                            direct = "IMPORTANT";
                            if (direct == "IMPORTANT") {
                                for (MFile cadaArquivo : mFileList) {
                                    if (nameArquivo.equals(cadaArquivo.getNameFile())) {
                                        mFileList.remove(cadaArquivo);
                                    }
                                }
                            }
                            repetir = false;
                        case 3:
                            direct = "SIMPLE";
                            if (direct == "SIMPLE") {
                                for (MFile cadaArquivo : mFileList) {
                                    if (nameArquivo.equals(cadaArquivo.getNameFile())) {
                                        mFileList.remove(cadaArquivo);
                                    }
                                }
                            }
                            repetir = false;
                    }

                    System.out.println("Arquivo de Texto Deletado!");
                    repetir = false;
                }
                case 3 -> {
                    System.out.println("Opção Salvar Arquivo de Imagem");
                    System.out.println("Digite agora o caminho do diretório");
                    String path = scanner.next();
                    System.out.println("Digite agora o nome do arquivo");
                    String nameFile = scanner.next();
                    System.out.println("Digite a URL da Imagem");
                    String urlFile = scanner.next();

                    MFile mFile = new MFile();
                    mFile.setNameFile(nameFile);
                    mFile.setPath(path);
                    mFile.setContent(urlFile);

                    handlerFile.salvarImagemComDiretorio(mFile);

                    System.out.println("Programa Finalizado");
                    repetir = false;
                }
                case 4 -> {
                    System.out.println("Opção Deletar Arquivo de Imagem");
                    System.out.print("Digite o nome do arquivo que deseja deletar do diretório imagens: \n");
                    String nameArquivo = scanner.next();

                    //listAllImageFiles(String directory)
                    for (MFile cadaArquivoImagem : mFileImageList) {
                        if (nameArquivo.equals(cadaArquivoImagem.getNameFile())) {
                            mFileImageList.remove(cadaArquivoImagem);
                        }
                    }

                    System.out.println("Arquivo de Imagem Deletado!");
                    repetir = false;
                }
                case 5 -> {
                    System.out.println("Opção Criar diretórios");
                    System.out.println("O tipo de diretório deseja criar?");
                    System.out.println("1 - REMINDER ");
                    System.out.println("2 - IMPORTANT ");
                    System.out.println("3 - SIMPLE ");
                    System.out.println("Digite a opção: ");
                    int opcaoMenuArquivo = scanner.nextInt();
                    MFileAnnotationTypeEnum type = null;
                    switch (opcaoMenuArquivo) {
                        case 1:
                            type = MFileAnnotationTypeEnum.REMINDER;
                            repetir = false;
                        case 2:
                            type = MFileAnnotationTypeEnum.IMPORTANT;
                            repetir = false;
                        case 3:
                            type = MFileAnnotationTypeEnum.SIMPLE;
                            repetir = false;
                    }
                    System.out.println("Digite agora o caminho do diretório");
                    String path = scanner.next();

                    FolderOrchestrator.createAFolder(path, type);

                    repetir = false;
                }


            }
            if(opcaoMenu == 6){
                repetir = false;
            }
        }

//        System.out.println("LISTANDO ARQUIVOS");
//        System.out.println("DIRETÓRIO");
//        String directory = scanner.nextLine();
//        handlerFile.listarArquivos(directory);

    }

    public static Boolean createFile(HandlerFile handlerFile, MFileAnnotationTypeEnum type) {
        System.out.println("Opção:" + type.name());
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho do diretório: \n");
        String path = sc.nextLine();
        System.out.print("Digite o conteúdo do arquivo: \n");
        String contentArquivo = sc.next();
        System.out.print("Digite o nome do arquivo: \n");
        String nameArquivo = sc.next();

        MFile mFile = new MFile();
        mFile.setType(type);
        mFile.setPath(path);
        mFile.setContent(contentArquivo);
        mFile.setNameFile(nameArquivo);

        handlerFile.salvarComDiretorio(mFile);

        System.out.println("Programa Finalizado!");
        return false;
    }

    public static void imprimirMenu (){
        System.out.println("----- Seja bem-vindo ao organizador de arquivos ----- ");
        System.out.println();
        System.out.println("-----> MENU <-----");
        System.out.println("O que deseja fazer? ");
        System.out.println("1 - Salvar Arquivo de Texto");
        System.out.println("2 - Deletar Arquivo de Texto");
        System.out.println("3 - Salvar Arquivo de Imagem");
        System.out.println("4 - Deletar Arquivo de Imagem");
        System.out.println("5 - Criar diretório");
        System.out.println("6 - Sair");
        System.out.println("Digite a opção: ");
    }

    public static void imprimirMenuTipoArquivoTexto (){
        System.out.println("Opção Salvar Arquivo de Texto TXT");
        System.out.println("Você pode criar 3 tipos de arquivos TXT");
        System.out.println("1 - REMINDER ");
        System.out.println("2 - IMPORTANT ");
        System.out.println("3 - SIMPLE ");
        System.out.println("Digite a opção: ");
    }
}