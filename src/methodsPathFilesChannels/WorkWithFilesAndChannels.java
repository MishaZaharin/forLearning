package methodsPathFilesChannels;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.Date;

public class WorkWithFilesAndChannels {
    void makeFileInputStream() {
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream("newNameFile")) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void readFileCharacter() {
        // read data from file
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            System.out.printf("File size: %d bytes \n", fileInputStream.available());
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void writeFileCharacter() {
        // write data from file
        String text = "Hello word";
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void workWithCharacterInStream() {
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("something");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            FileReader fileReader = new FileReader(fileName);
            char[] chars = new char[200];
            fileReader.read(chars);
            for (char c : chars) {
                System.out.println(c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void workWithFilesChannels() {
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        File scr = new File(fileName);
        File dst = new File("newFile");
        // 1. Получаем FileChannel исходного файла и целевого файла
        try (FileChannel scrFileChannel = new FileInputStream(scr).getChannel();
             FileChannel dstFileChannel = new FileOutputStream(dst).getChannel()) {
            // 2. Размер текущего FileChannel
            long count = scrFileChannel.size();
            while (count > 0) {
                /*=============================================================
                 * 3. Записать байты из FileChannel исходного файла в целевой FileChannel
                 * 1. srcFileChannel.position (): начальная позиция в исходном файле не может быть отрицательной
                 * 2. count: максимальное количество переданных байтов, не может быть отрицательным
                 * 3. dstFileChannel: целевой файл
                 *==============================================================*/
                long transferred = scrFileChannel.transferTo(scrFileChannel.position(), count, dstFileChannel);
                // 4. После завершения переноса измените положение исходного файла на новое место
                scrFileChannel.position(scrFileChannel.position() + transferred);
                // 5. Рассчитаем, сколько байтов осталось перенести
                count -= transferred;
            }
            Path sourceDirectory = Paths.get(fileName);
            Path targetDirectory = Paths.get("newFileName");
            Files.copy(sourceDirectory, targetDirectory);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    static void workFileChannel() {
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        // инициализируем класс RandomAccessFile, в параметры передаем путь к файлу
        // и модификатор, который говорит, что файл откроется для чтения и записи
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
             // получаем экземпляр класса FileChannel
             FileChannel fileChannel = randomAccessFile.getChannel();) {
            // наш файл имеет небольшой размер, поэтому считывать мы его будем за один раз
            // создаем буфер необходимого размера на основании размера нашего канала
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            // прочитанные данные будем помещать в StringBuilder
            StringBuilder stringBuilder = new StringBuilder();
            // записываем данные из канала в буфер
            fileChannel.read(byteBuffer);
            // переключаем буфер с режима записи на режим чтения
            byteBuffer.flip();
            // в цикле записываем данные из буфера в StringBuilder
            while (byteBuffer.hasRemaining()) {
                stringBuilder.append((char) byteBuffer.get());
            }
            // выводим содержимое StringBuilder в консоли
            System.out.println(stringBuilder);
            // теперь продолжим нашу программу и запишем данные из строки в файл
            // создаем строку с произвольным текстом
            String someText = "something";
            // создаем для работы с записью новый буфер,
            // а канал пусть остается прежним, т.к. мы будем писать в тот же файл
            // т.е., один канал мы можем использовать как для чтения, так и для записи в файл
            // создаем буфер конкретно под нашу строку — строку переводим в массив и берем его длину
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(someText.getBytes().length);
            // записываем нашу строку в буфер
            byteBuffer2.put(someText.getBytes());
            // переключаем буфер с режима записи на режим чтения,
            // чтобы канал смог прочитать из буфера и записать нашу строку в файл
            byteBuffer2.flip();
            // канал читает информацию из буфера и записывает ее в наш файл
            fileChannel.write(byteBuffer2);
        } catch (FileNotFoundException e) {
            e.getStackTrace();

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    void path() {
        String fileName = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        Path path = Path.of(fileName);
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path tempPath : files)
                System.out.println(tempPath);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static String readWriteByteChar(String path) throws IOException {
        RandomAccessFile file;
        path = "src/methodsPathFilesChamnnels/Chukovskiy.txt";
        file = new RandomAccessFile(path, "rw");
        String s = "";
        int b = file.read();
        // побитово читаем символы и плюсуем их в строку
        while (b != -1) {
            s = s + (char) b;
            b = file.read();
            file.write(s.getBytes());
            System.out.print(s.getBytes());
        }
        file.close();
        return s;
    }

    static void workDate() {
        Date date = new Date();
        try (FileInputStream fileInputStream =
                     new FileInputStream("src/methodsPathFilesChamnnels/Shakespeare.txt");
             BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(fileInputStream)) {
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                System.out.print((char) i);
            }
            Date date1 = new Date();
            System.out.println((date1.getTime() - date.getTime()));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static void findFileByFiles() {
        //find file, recursive call
        File file = new File("something");
        if (file.isDirectory()) {
            System.out.println(file.getName() + "is the directory");
            File[] files = file.listFiles();
            for (File f : files) {
                findFileByFiles();
            }
        } else {
            System.out.println(file.getName() + "is not a directory");
        }
    }
}