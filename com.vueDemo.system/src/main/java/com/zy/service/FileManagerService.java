package com.zy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileManagerService {
    void download(HttpServletRequest request, HttpServletResponse response, String fileName) throws Exception;
}
