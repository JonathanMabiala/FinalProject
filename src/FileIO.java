import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class FileIO {

    private File file;
    private File[] fileList;
    private String path = Paths.get(".").toAbsolutePath().normalize().toString()+"/src";
    private FileWriter stream = null;
    private TreeSet<String> sortedList = new TreeSet<>();


    public String getPath(){
       return path;
    }


    public void  getFileList(){

        file = new File(this.path);
        this.fileList = this.file.listFiles();

        for(File list: this.fileList) {
            sortedList.add(list.getName());
        }
        System.out.println("----------------------------File List----------------------------------------");
        for (String value: sortedList) {

            System.out.println("Sorted List: " + value);

        }
        System.out.println("----------------------------End Of File List---------------------------------");
    }

    public void createFile(String name){
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

    public void removeElement(String name){
        file = new File(path +"/"+ name);

        if(file.exists()){
            if(file.delete()) {
                System.out.println("Deleted the file: " + file.getName());
                getFileList();
            } else {
                System.out.println("Failed to delete the file.");
            }
            } else {
            System.out.println("File does not exist / misspelled, consider case sensitivity and file extension");
        }
    }

    public void search(String name){

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

}
