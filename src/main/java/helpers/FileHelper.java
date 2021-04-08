package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Files.write;

public class FileHelper {

    private static final Logger log = LogManager.getLogger("Обработчик файлов");

    public static List<String> readFile(String path){
        try {
            log.debug("Читаю файл " + path);
            return readAllLines(Paths.get(path));
        } catch (IOException e) {
            log.error(e);
            return new ArrayList<>();
        }
    }
    public static List<String> readFile(File file){
        try {
            log.debug("Читаю файл " + file.getPath());
            return readAllLines(file.toPath());
        } catch (IOException e) {
            log.error(e);
            return new ArrayList<>();
        }
    }

    public static File writeFileAndGet(List<String> data, String name){
        log.debug("Пишем файл " + name);
        File parent = new File("/home/bohdan/opensource/G48Automation/target/outputFiles");
        if (!parent.exists()){
            log.debug("Создаю недостающие директории");
            parent.mkdirs();
        }
        File result = new File(parent, name);
        try {
            log.debug("Произвожу запись в файл: " + result.getPath());
            write(result.toPath(), data);
        } catch (IOException e) {
            log.error(e);
        }
        return result;
    }


}
