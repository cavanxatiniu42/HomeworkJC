import java.util.ArrayList;

public class StudentManage {
    public ArrayList<Student> students = new ArrayList<>();
    public StudentManage (ArrayList<Student> students){
        this.students = students;
    }
    public boolean addStudent(Student student){
        if (student.getID() >= 0){
            students.add(student);
            return true;
        }
        return false;
    }
    public boolean deleteStudent (Student student){
        for (int i = 0; i <students.size() ; i++) {
            if (student.getName().equals(students.get(i).getName())){
                students.remove(student);
                return true;
            }
        }
        return false;
    }
    public boolean modifyName ( String oldName, String newName){
        for (int i = 0; i <students.size() ; i++) {
            if (oldName.equals(students.get(i).getName())){
                students.get(i).setName(newName);
                return true;
            }
        }
        return false;
    }
    public Student findStudent(String name){
        for (int i = 0; i <students.size() ; i++) {
            if (name.equals(students.get(i).getName())){
                return students.get(i);
            }
        }
        return null;
    }
    public String toString(){
        String result = "";
        for (int i = 0; i <students.size() ; i++) {
            if (!students.get(i).equals(null)){
                result = result + "ID: " +students.get(i).getID()+ "name: " + students.get(i).getName();
            }
        }
        return result;
    }


}
