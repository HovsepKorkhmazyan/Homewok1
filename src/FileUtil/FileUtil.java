package FileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("Enter File Path");
        String path = scanner.nextLine();
        System.out.println("Enter File Name");
        String fileName = scanner.nextLine();
        File folder = new File(path);
        File[] fileList = folder.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    System.out.println("True");
                }
            }
        }
        System.out.println("False");

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        System.out.println("Enter File Path");
        String path = scanner.nextLine();
        System.out.println("Enter The Keyword");
        String keyword = scanner.nextLine();
        File folder = new File(path);
        File[] folderList = folder.listFiles();
        if (folderList != null) {
            for (File file : folderList) {
                if (file.isFile() && file.toPath().endsWith(".txt")) {
                    System.out.println(file.getName());
                }
            }
        }
        System.out.println("No .txt found");

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        System.out.println("Enter File Path");
        String txtPath = scanner.nextLine();
        System.out.println("Enter The Keyword");
        String keyword = scanner.nextLine();
        try {
            BufferedReader br = new BufferedReader(new FileReader(txtPath));
            String line = br.readLine();
            while (line != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("There Was An Error While Reading The File: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("Enter Folder Path");
        String folderPath = scanner.nextLine();
        File folder = new File(folderPath);
        long totalSize = 0;
        if (folder.exists() && folder.isDirectory()) {
            File[] fileList = folder.listFiles();
            if (fileList != null) {
                for (File file : fileList) {
                    if (file.isFile()) {
                        totalSize += file.length();
                    }

                }
                System.out.println("Total Size Of The Folder Is: " + totalSize);
            } else {
                System.out.println("The Folder Is Empty");
            }
        }


    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("Enter Folder Path");
        String folderPath = scanner.nextLine();
        System.out.println("Enter The Name Of The File");
        String fileName = scanner.nextLine();
        System.out.println("Enter The Content");
        String fileContent = scanner.nextLine();
        File file = new File(folderPath, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("The File Has Been Created " + file.getName());
            } else {
                System.out.println("The File Already Exists");
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(fileContent);
            System.out.println("File Successfully Written");


        } catch (IOException e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }


    }

}
