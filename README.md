# 基于minio分布式上传和下载文件管理快速开发

### 功能介绍

一共包含四个6个api，满足大部分类型文件操作，分别是：
* uploadImgFile
    * 上传图片格式文件
* uploadHtmlFile
    * 上传html格式文件
* uploadFile
    * 上传任意格式文件，上传的格式需要是满足在FileNameConstant中的类型
* uploadCustomFile
    * 上传自定义类型，如果你想上传的文件类型没有被包含在FileNameConstant类中，你可上传minio接受的自定义类型
* downLoadFile
    * 下载文件
* delete
    * 删除文件

其中FileNameConstant包含

```java
// 图片类型 (IANA 标准)
map.put("jpg", "image/jpeg");
map.put("jpeg", "image/jpeg");
map.put("png", "image/png");
map.put("gif", "image/gif");
map.put("webp", "image/webp");
map.put("svg", "image/svg+xml");
map.put("bmp", "image/bmp");
map.put("ico", "image/x-icon");
map.put("tiff", "image/tiff");

// 文档类型 (Microsoft + OpenDocument)
map.put("pdf", "application/pdf");
map.put("txt", "text/plain; charset=utf-8");
map.put("csv", "text/csv; charset=utf-8");
map.put("doc", "application/msword");
map.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
map.put("xls", "application/vnd.ms-excel");
map.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
map.put("ppt", "application/vnd.ms-powerpoint");
map.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
map.put("odt", "application/vnd.oasis.opendocument.text");
map.put("ods", "application/vnd.oasis.opendocument.spreadsheet");

// 代码/文本文件 (带字符集声明)
map.put("html", "text/html; charset=utf-8");
map.put("htm", "text/html; charset=utf-8");
map.put("css", "text/css; charset=utf-8");
map.put("js", "application/javascript");  // 推荐使用 application/javascript
map.put("mjs", "application/javascript");
map.put("json", "application/json");
map.put("xml", "application/xml");
map.put("php", "application/x-httpd-php");
map.put("java", "text/x-java-source");
map.put("sh", "application/x-sh");

// 压缩包/归档文件
map.put("zip", "application/zip");
map.put("rar", "application/vnd.rar");
map.put("7z", "application/x-7z-compressed");
map.put("tar", "application/x-tar");
map.put("gz", "application/gzip");
map.put("bz2", "application/x-bzip2");

// 音频 (RFC 标准)
map.put("mp3", "audio/mpeg");
map.put("wav", "audio/wav");
map.put("ogg", "audio/ogg");
map.put("flac", "audio/flac");
map.put("aac", "audio/aac");

// 视频 (RFC 标准)
map.put("mp4", "video/mp4");
map.put("mov", "video/quicktime");
map.put("avi", "video/x-msvideo");
map.put("mkv", "video/x-matroska");
map.put("webm", "video/webm");
map.put("flv", "video/x-flv");

// 可执行文件/安装包
map.put("exe", "application/x-msdownload");
map.put("dll", "application/x-msdownload");
map.put("apk", "application/vnd.android.package-archive");
map.put("deb", "application/x-deb");
map.put("rpm", "application/x-rpm");
map.put("msi", "application/x-msi");

// 字体文件
map.put("woff", "font/woff");
map.put("woff2", "font/woff2");
map.put("ttf", "font/ttf");
map.put("otf", "font/otf");

// 特殊类型
map.put("yaml", "application/x-yaml");
map.put("yml", "application/x-yaml");
map.put("torrent", "application/x-bittorrent");
```

api测试在TypecohFileStarterApplicationTests中已经给出，可以查看！使用之前请搭建好自己的minio环境，以及在配置文件中给出自己的minio链接信息
