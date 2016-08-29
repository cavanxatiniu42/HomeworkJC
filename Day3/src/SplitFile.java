import java.io.*;

public class SplitFile{
    public boolean splitFile (String path, long numberOfSplits) throws IOException {
        File file = new File(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        long size = file.length();
        long numberOfBytesPerFile = size/numberOfSplits;
        byte[] buffer = new byte[(int)numberOfBytesPerFile];
        for (int i = 0; i <numberOfBytesPerFile ; i++) {
            while (bufferedInputStream.read(buffer) != -1 && i<numberOfSplits){
                File newFile = new File(file.getName()+ i++);
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
                outputStream.write(buffer);
                outputStream.close();
            }
        }
        return true;
    }

}