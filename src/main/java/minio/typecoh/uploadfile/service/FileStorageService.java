package minio.typecoh.uploadfile.service;

import java.io.InputStream;

/**
 * @author itheima
 */
public interface FileStorageService {


    /**
     *  上传图片文件
     * @param prefix  文件前缀
     * @param filename  文件名
     * @param inputStream 文件流
     * @return  文件全路径
     */
    public String uploadImgFile(String prefix, String filename,InputStream inputStream);

    /**
     *  上传html文件
     * @param prefix  文件前缀
     * @param filename   文件名
     * @param inputStream  文件流
     * @return  文件全路径
     */
    public String uploadHtmlFile(String prefix, String filename,InputStream inputStream);

    /**
     *  上传文件
     * @param prefix  文件前缀
     * @param filename   文件名
     * @param inputStream  文件流
     * @return  文件全路径
     */
    public String uploadFile(String prefix, String filename,InputStream inputStream);

    /**
     * 上传自定义文件类型
     * @param prefix  文件前缀
     * @param filename  文件名
     * @param fileType  自定义文件，比如：text/html
     * @param inputStream  文件流
     * @return  文件全路径
     */
    public String uploadCustomFile(String prefix, String filename, String fileType, InputStream inputStream);

    /**
     * 删除文件
     * @param pathUrl  文件全路径
     */
    public void delete(String pathUrl);

    /**
     * 下载文件
     * @param pathUrl      文件全路径
     * @param fileSavePath 文件保存地址
     * @return
     *
     */
    public String downLoadFile(String pathUrl, String fileSavePath);


}