import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReadPractice {
    public static void main(String[] args){
        try{
            File myObj = new File("C:\\Users\\bkjr8\\Desktop\\dataset_91022.txt");
            Scanner reader = new Scanner(myObj);
            int count = 0;
            while(reader.hasNext()){
                String data = reader.next();
                if(Integer.parseInt(data) >= 9999){
                    count ++;
                }
            }
            reader.close();
            System.out.println(count);
        }catch (FileNotFoundException e){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }
}
