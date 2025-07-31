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

    /**
     * 测试上传图片文件
     * @throws FileNotFoundException
     */
    @Test
    void uploadFile_JPG() throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(new File("F:\\image.jpg"));

        String typecoh = fileStorageService.uploadFile("Typecoh", "image.jpg", fileInputStream);

        System.out.println(typecoh);
    }

    /**
     * 测试上传视频文件
     * @throws FileNotFoundException
     */
    @Test
    void uploadFile_Video() throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(new File("F:\\video.mp4"));

        String typecoh = fileStorageService.uploadFile("Typecoh", "video.mp4", fileInputStream);

        System.out.println(typecoh);
    }

    /**
     * 测试下载图片文件
     * @throws FileNotFoundException
     */
    @Test
    void downLoadFile_JPG() throws FileNotFoundException {

        String typecoh = fileStorageService.downLoadFile("http://192.168.43.200:9000/leadnews/Typecoh/2025/07/31/image.jpg",  "F:\\image.jpg");

        System.out.println(typecoh);
    }

    /**
     * 测试下载视频文件
     * @throws FileNotFoundException
     */
    @Test
    void downLoadFile_Video() throws FileNotFoundException {

        String typecoh = fileStorageService.downLoadFile("http://192.168.43.200:9000/leadnews/Typecoh/2025/07/31/video.mp4",  "F:\\video.mp4");

        System.out.println(typecoh);
    }
}
