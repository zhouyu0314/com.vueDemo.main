package com.zy.controller;

import com.zy.dto.Dto;
import com.zy.dto.DtoUtil;
import com.zy.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/file")
public class FileManagerController {

    @Autowired
    private FileManagerService fileManagerService;

    @PostMapping("/uploadFile")
    public Dto uploadFile(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("file") MultipartFile[] file) throws IOException {
        ServletOutputStream outputStream = null;
        try {
            //writer = response.getWriter();
            outputStream = response.getOutputStream();
            //writer.write("123");
            outputStream.write("123".getBytes());
            return DtoUtil.returnSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
        return null;
    }

    @GetMapping("/download/{fileName}")
    public Dto download(HttpServletRequest request, HttpServletResponse response,@PathVariable("fileName") String fileName) throws IOException {
        try {
            fileManagerService.download(request,response,fileName);
        } catch (Exception e) {
            return null;
        }
        return null;
    }


    @PostMapping("/axiosTest")
    public Dto axiosTest(@RequestParam Map<String,Object> param){


        return DtoUtil.returnSuccess("success",param.get("username").toString()+param.get("passwd").toString());
    }
}
