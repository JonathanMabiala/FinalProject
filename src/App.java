import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;


public class App {

    private File file;
    private File[] fileList;
    private String path = Paths.get(".").toAbsolutePath().normalize().toString()+"/src";
    private FileWriter stream = null;
    private TreeSet<String> sortedList = new TreeSet<>();
    private Scanner scanner = new Scanner(System.in);



    public String getPath(){ // Returns the path of a file
       return path;
    }

    public void  getFileList(){ // Fetches and lists all files in an ascending order.
        file = new File(this.path);
        this.fileList = this.file.listFiles();

        for(File list: this.fileList)
            sortedList.add(list.getName());
        System.out.println("----------------------------File List----------------------------------------");
        for (String value: sortedList)
            System.out.println("Sorted List: " + value);
        System.out.println("----------------------------End Of File List---------------------------------");
    }

    public void createFile(){ // Creates a file in the directory
        System.out.println("Type in the file's name to be created and hit 'enter'.");
        String name = scanner.nextLine();
        try {
            stream = new FileWriter(this.path + "/"+name+".txt");
            System.out.println("**** A file named ' " +name + " ' has been created ******\r");
            this.getFileList();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeElement(){ // Removes a specified file
        System.out.println("Type in the file's name to be deleted then hit 'enter'.");
        String name = scanner.nextLine();

        file = new File(path +"/"+ name);
        if(file.exists())
            if(file.delete()) {
                System.out.println("Deleted the file: " + file.getName());
                getFileList();
            } else {
                System.out.println("Failed to delete the file.");
            }
        else System.out.println("File does not exist / misspelled, consider case sensitivity and file extension");

    }

    public void search(){
        System.out.println("Type a file's name then hit 'enter'.");
        String name = scanner.nextLine();
        file = new File(path +"/"+ name);

        if(file.exists()){
            System.out.println("--------------------------------  Found File  -------------------------------");
            System.out.println(file.getName());
            System.out.println("---------------------------- **** Found File **** ---------------------------");
        }else{
            System.out.println("--------------------------------  File Not Found  ---------------------------");
            System.out.println("No element named " + name);
        }
    }


    public void load(){
        System.out.println(" --------------------------------------------------------------------------------------");
        System.out.println(" --------------------------------------------------------------------------------------");
        System.out.println("|                                  Welcome to LockedMe                                 |");
        System.out.println("|                                 Developed by Jonathan                                |");
        System.out.println(" --------------------------------------------------------------------------------------");
        System.out.println(" --------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        menu();

    }


    public void menu(){

        System.out.println("1) List all files in the current directory.");
        System.out.println("2) File Operations (Add , Delete and Search.)   ");
        System.out.println("3) Home.  ");
        System.out.println("4) Exit.  ");

        int option = scanner.nextInt();

        switch (option){

            case 1 :
                getFileList();
                break;
            case 2 :{
                fileOperations();
                break;}
            case 3:
                load();
            case 4 :
                System.exit(0);
            default:
                System.out.print("Option does not exist.");
        }
    }

    public void fileOperations(){
        System.out.println("1) Add file to the current Directory");
        System.out.println("2) Delete a file ");
        System.out.println("3) Search a file ");

        int options = 0;
        options = scanner.nextInt();

        switch (options){
            case 1 :
                createFile();
                break;
            case 2 :
                removeElement();
                break;
            case 3 :
                search();
            default:
                System.out.println("Option does not exist");

        }

    }
}
