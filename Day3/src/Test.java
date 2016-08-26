import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        File file = new File("text.dat");
        file.createNewFile();
     //   file.delete();
        Student student = new Student(1, "thuy");
       StudentManage studentManage = new StudentManage(studentList);
        studentManage.addStudent(student);
        StudentDataAccess studentDataAccess = new StudentDataAccess();
        studentDataAccess.writeToBinaryFile(studentList,"text.dat" );
        System.out.println(studentDataAccess.readFromBinaryFile("text.dat").toString());
    }
}
