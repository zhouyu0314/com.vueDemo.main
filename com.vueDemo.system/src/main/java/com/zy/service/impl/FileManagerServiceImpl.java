package com.zy.service.impl;

import com.zy.service.FileManagerService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Service
public class FileManagerServiceImpl implements FileManagerService {
    @Override
    public void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws Exception {

        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "download";
        //判断文件夹是否存在
        File folder = new File(path);
        //不存在就创建
        if (!folder.exists()) {
            folder.mkdirs();
        }

        //判断download文件夹下的某某文件是否存在
        File downFile = new File(path,fileName);
        if (!downFile.exists()) {
            //如果不存在就要去服务器下载了
            System.out.println("fileName,不存在，即将从FTP服务器下载。。。");
        }
        ServletOutputStream outputStream = null;
            String range = null;
            int fileLength = Integer.parseInt(Long.toString(downFile.length()));
            if (fileLength == 0) {
                throw new Exception("下载失败，请重试！");
            }
        try {
            // 特殊头处理
            if (null != request.getHeader("RANGE")) {// 断点续传的头
                range = request.getHeader("RANGE");
            }
            if (null != request.getHeader("Range")) {
                range = request.getHeader("Range");
            }
            response.setContentType("application/x-msdownload");
            outputStream = response.getOutputStream();
            response.setContentLength(fileLength);
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(downFile.getName().getBytes("utf-8"), "ISO8859-1"));// 处理默认文件名的中文问题
            int startPos = 0;
            if (null != range) {// 断点续传
                startPos = Integer.parseInt(range.replaceAll("bytes=", "").replaceAll("-$|-\\d+$", ""));
            }
            if (startPos == 0) {
                FileCopyUtils.copy(new FileInputStream(downFile), response.getOutputStream());
            } else {// 断点续传
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                if (startPos != 0) {
                    /** 设置Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小] **/
                    StringBuffer sb = new StringBuffer("bytes ");
                    sb.append(Long.toString(startPos));
                    sb.append("-");
                    sb.append(Long.toString(fileLength - 1));
                    sb.append("/");
                    sb.append(Long.toString(fileLength));
                    response.setHeader("Content-Range", sb.toString());
                }
                if (startPos < fileLength) {
                    fileLength = fileLength - startPos;
                    outputStream.write(FileUtils.readFileToByteArray(downFile), (int) startPos, (int) fileLength);
                }
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
