import java.io.*;

public class SplitFile {
    private long numberOfSplits;
    private long sourceSize;
    private long bytesPerSplit;
    private long remainingBytes;
    private int maxBufferReadSize;

    public int getMaxBufferReadSize() {
        return maxBufferReadSize = 8*1024;
    }

    public long getNumberOfSplits() {
        return numberOfSplits;
    }

    public void setNumberOfSplits(long numberOfSplits) {
        this.numberOfSplits = numberOfSplits;
    }

    public long getSourceSize() {
        return sourceSize;
    }

    public void setSourceSize(long sourceSize) {
        this.sourceSize = sourceSize;
    }

    public long getBytesPerSplit() {
        return bytesPerSplit = sourceSize/numberOfSplits;
    }

    public long getRemainingBytes() {
        return remainingBytes = sourceSize%numberOfSplits;
    }


    public void readWrite (RandomAccessFile randomAccessFile, BufferedOutputStream bufferedOutputStream, int numberBytes) throws IOException {
        byte[] readingArray = new byte[numberBytes];
        int c = randomAccessFile.read(readingArray);
        if (c != -1){
            bufferedOutputStream.write(readingArray);
        }
    }
    public void splitFile(String path, long numberOfSpits) throws IOException {
        this.numberOfSplits = numberOfSpits;
        RandomAccessFile randomAccessFile= new RandomAccessFile(path, "rw");
        for (int i = 0; i < numberOfSplits; i++) {
           BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
            if (bytesPerSplit>maxBufferReadSize){
                long numberOfRead = bytesPerSplit/maxBufferReadSize;
                int numberOfRemainingBytes= (int) (bytesPerSplit%maxBufferReadSize);
                for (int j = 0; j < numberOfRead; j++) {
                    readWrite(randomAccessFile,outputStream,maxBufferReadSize);
                }
                if (numberOfRemainingBytes > 0){
                    readWrite(randomAccessFile,outputStream,numberOfRemainingBytes);
                }
            } else {
                readWrite(randomAccessFile,outputStream, (int) bytesPerSplit);
            }
            readWrite(randomAccessFile,outputStream, (int) remainingBytes);
            outputStream.close();
            randomAccessFile.close();
        }

    }
}
