package com.wjl.loans.controller;

import com.wjl.loans.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {
    /**
     * 上传图片接口
     */
    @PostMapping("/uploadImg")
    @ResponseBody
    public String uploadFile(@RequestParam("fileName") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {

        String relativePath = FileUtil.uploadFile(file);
        //服务器路径
        String serverUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        return serverUrl + relativePath;
    }

    //处理多文件上传
    @RequestMapping(value = "/uploadImgs", method = RequestMethod.POST)
    @ResponseBody
    public String multipleFilesUpload(HttpServletRequest request) {
        //获取上传的文件数组
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        //遍历处理文件
        String serverUrl = null;
        StringBuffer pathsBuffer = new StringBuffer();
        for (MultipartFile file : files) {
            try {
                String relativePath = FileUtil.uploadFile(file);
                serverUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
                pathsBuffer.append(serverUrl + relativePath+"\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  pathsBuffer.toString();
    }
}
