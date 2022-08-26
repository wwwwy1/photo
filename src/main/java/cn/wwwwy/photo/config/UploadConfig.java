package cn.wwwwy.photo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {

    /**
     * 图片文件上传地址
     */
    @Value("${img.uploadUrl}")
    public String imgUploadUrl;

    /**
     * 图片文件下载地址
     */
    @Value("${img.downloadUrl}")
    public String imgDownloadUrl;

    /**
     * 图片文件预览地址
     */
    @Value("${img.previewUrl}")
    public String imgPreviewUrl;


    public String getImgDownloadUrl(String filename){
        return imgDownloadUrl + filename;
    }

    public String getImgPreviewUrl(String filename){
        return imgPreviewUrl + filename;
    }

    public String getImgUploadUrl(String filename){
        return imgUploadUrl + filename;
    }
}
