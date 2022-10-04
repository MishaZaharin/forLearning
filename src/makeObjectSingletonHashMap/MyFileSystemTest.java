package makeObjectSingletonHashMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MyFileSystemTest {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystem.getFileSystem();
        final String path = "/user/bin/data.txt";
        fileSystem.create(path);
        System.out.println("file created successfully");
        try (InputStream inputStream = fileSystem.newInputStream(path)) {
            System.out.print("File contents:\t");
            System.out.println(read(inputStream));
        }
        try (final OutputStream outputStream = fileSystem.newOutputStream(path)) {
            outputStream.write("JavaRush".getBytes(UTF_8));
            System.out.println("Data written to file");
        }
        try (InputStream inputStream = fileSystem.newInputStream(path)) {
            System.out.println("File contents:\t");
            System.out.println(read(inputStream));
        }
        fileSystem.delete(path);
        System.out.println("File exists:\t");
        System.out.println(fileSystem.isExists(path));
    }
    private static String read(InputStream inputStream) throws IOException{
        return new String(inputStream.readAllBytes(), UTF_8);
    }
}
