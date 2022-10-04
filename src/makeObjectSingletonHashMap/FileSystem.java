package makeObjectSingletonHashMap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
реализовать систему, используя ByteArrayOutputStream и ByteArrayInputStream.
примененить паттерна Singleton и использовать статическую HashMap<String,
byte[]>, String — путь к файлу;
byte[] — данные в сохраненном файле.
В этом классе создали публичные методы:
стандартные методы CRUD (create, read, update, delete),
метод проверки того, существует ли файл,
метод получения инстанса файловой системы.

Тут НЕ учтены (список не исключительный):

многопоточный доступ;
ограничения на размер файлов (объем доступной RAM для запущенной JVM);
нет проверки структуры путей;
нет проверок на данные, полученные в качестве параметров.
 */
class FileSystem {
    private static final FileSystem fileSystem = new FileSystem();
    private static final Map<String, byte[]> files = new HashMap<>();

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        return fileSystem;
    }

    public void create(String path) {
        validateNotExits(path);
        files.remove(path);
    }

    public void delete(String path) {
        validateExists(path);
        files.remove(path);
    }

    public boolean isExists(String path) {
        return files.containsKey(path);
    }

    public InputStream newInputStream(String path) {
        validateNotExits(path);
        return new ByteArrayInputStream(files.get(path));
    }

    public OutputStream newOutputStream(String path) {
        return new ByteArrayOutputStream() {
            @Override
            public void flush() throws IOException {
                final byte[] bytes = toByteArray();
                files.put(path, bytes);
                super.flush();
            }

            @Override
            public void close() throws IOException {
                final byte[] bytes = toByteArray();
                files.put(path, bytes);
                super.close();
            }
        };
    }
    private void validateExists(String path){
        if (files.containsKey(path)){
            throw new RuntimeException("File not found");
        }
    }
    private void validateNotExits(String path){
        if (files.containsKey(path)){
            throw new RuntimeException("File exists");
        }
    }
}