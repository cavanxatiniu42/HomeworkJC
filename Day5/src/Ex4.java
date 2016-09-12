import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ex4 {
    public long calculateFolderCapacity (String path) throws IOException {
        Queue<File> fileQueue = new LinkedList<>();
        long lengthOfAllFiles=0;
        File file = new File(path);
        fileQueue.add(file);
        while (!fileQueue.isEmpty()) {
            File[] arrayFile = file.listFiles();
            for (File file1 : arrayFile) {
                if (file1.isFile()) {
                    lengthOfAllFiles = lengthOfAllFiles + file1.length();
                    fileQueue.remove(file1);
                } else {
                    File [] array2 = file.listFiles();
                    for (File file2 : array2) {
                        lengthOfAllFiles = lengthOfAllFiles + file2.length();
                    }
                }
            }
        }
       return lengthOfAllFiles;

    }
}
