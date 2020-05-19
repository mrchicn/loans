package com.wjl.loans.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

public class FileUtil {
    /**
     * 第一步：判断文件是否为空   true：返回提示为空信息   false：执行第二步
     * 第二步：判断目录是否存在   不存在：创建目录
     * 第三部：通过输出流将文件写入硬盘文件夹并关闭流
     *
     * @param file
     * @return
     */
    public static String uploadFile(MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }
        // 获取文件名
        String fileName = new Date().getTime() + "_" + file.getOriginalFilename();

        //放到类路径下的imgs文件夹中
        String classpath = null;
        try {
            classpath = ResourceUtils.getFile("classpath:").getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //限制文件上传的类型
        String contentType = file.getContentType();
        if ("image/jpeg".equals(contentType) || "image/jpg".equals(contentType)) {

            String relativePath = "/imgs/" + fileName;
            String path = classpath + relativePath;
            //创建文件路径
            File dest = new File(path);
            //判断文件是否已经存在
            if (dest.exists()) {
                return "文件已经存在";
            }
            //判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                //上传文件//保存文件
                file.transferTo(dest);
                return relativePath;

            } catch (Exception e) {
                return "上传失败";
            }
        }
        return "上传失败";
    }
}
