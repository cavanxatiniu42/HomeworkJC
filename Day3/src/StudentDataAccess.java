import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StudentDataAccess {
    public StudentDataAccess() throws IOException {
    }
    public  void writeToBinaryFile(List<Student> studentList, String path) throws IOException {
        File studentData = new File(path);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(studentData));
        try {
            outputStream.writeObject(studentList);
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {

                    outputStream.close();
        }
        }

//
     public List<Student> readFromBinaryFile(String path) throws IOException, ClassNotFoundException {
         File studentData = new File(path);
         ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(studentData)));

         List<Student> studentList = (List<Student>)inputStream.readObject();
         return studentList;
     }
     public void writeToTextFile(List<Student> studentList, String path) throws IOException {
         File studentData = new File(path);
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(studentData));
         try {
             for (int i = 0; i <studentList.size() ; i++) {
                bufferedWriter.write(studentList.get(i).toString());
                 bufferedWriter.newLine();
             }
         }catch (IOException e){
             e.printStackTrace();
         }
         finally {
             bufferedWriter.close();
         }
     }
     public List<Student> readFromTextFile (String path) throws FileNotFoundException {
         List<Student> listStudent = new ArrayList<>();
         File studentData = new File(path);
         BufferedReader bufferedReader = new BufferedReader(new FileReader(studentData));
         while (true){
             try {
                 String student = bufferedReader.readLine();
                 String[] oneStudent = student.split(",");
                 Student student1 = new Student(Integer.parseInt(oneStudent[0].replaceAll("[^0-9]","")), oneStudent[1].replaceAll("[^a-z]",""));
                 listStudent.add(student1);
                 return listStudent;
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

     }

    }

