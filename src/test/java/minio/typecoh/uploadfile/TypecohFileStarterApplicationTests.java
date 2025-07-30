package minio.typecoh.uploadfile;

import minio.typecoh.uploadfile.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class TypecohFileStarterApplicationTests {

    @Autowired
    private FileStorageService fileStorageService;

    public  String file(String filePath, String prefix, String saveFileName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        return fileStorageService.uploadCustomFile(prefix, saveFileName, "video/mp4", fileInputStream);
    }

    @Test
    public void deleteFile(){
        String url = "http://192.168.43.200:9000/leadnews/Typecoh/2025/07/30/video.mp4";
        fileStorageService.delete(url);
    }

    @Test
    public void downloadFile() throws IOException {
        String url = "http://192.168.43.200:9000/leadnews/Typecoh/2025/07/30/video.mp4";
        String file = fileStorageService.downLoadFile(url, "F:/downloaded_video.mp4");
        System.out.println(file);
    }

    @Test
    public void testUpdateImgFile() throws Exception {

        String typecoh = file("F:\\video.mp4", "Typecoh", "video.mp4");

        System.out.println(typecoh);
    }
}
