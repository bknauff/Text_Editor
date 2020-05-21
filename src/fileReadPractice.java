import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReadPractice {
    public static void main(String[] args){
        //Practice1
        /*try{
            File myObj = new File("C:\\Users\\bkjr8\\IdeaProjects\\Text_Editor\\dataset_91022.txt");
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
        }*/
        //Problem 2
        try{
            File myObj = new File("C:\\Users\\bkjr8\\IdeaProjects\\Text_Editor\\dataset_91069.txt");
            Scanner reader = new Scanner(myObj);
            int year = reader.nextInt();
            long popInc = 0;
            System.out.println("Year:     Population:");
            long lastYearPop = reader.nextLong();
            System.out.println(year+"     "+lastYearPop);
            while(reader.hasNextInt()){
                int dataYear = reader.nextInt();
                long data = reader.nextLong();
                if(data - lastYearPop > popInc){
                    popInc = data - popInc;
                    year = dataYear;
                    lastYearPop = data;
                }
                System.out.println(dataYear+"     "+data);

            }
            reader.close();
            System.out.println(year);
        }
        catch (FileNotFoundException e){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }
}
