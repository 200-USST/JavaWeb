package service.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import servlet.FileUploadDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileUpload {
    public void fileUpload(HttpServletRequest request,String realPath,String tmpPath,String filename) throws FileUploadException, IOException {
        File saveFilePath = new File(realPath);
        File tempFilePath = new File(tmpPath);
        boolean flag=false;
        if (!saveFilePath.exists()) {
            saveFilePath.mkdir();
        }
        if (!tempFilePath.exists()) {
            tempFilePath.mkdir();
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024 * 1024);
        diskFileItemFactory.setRepository(tempFilePath);

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");
        servletFileUpload.setFileSizeMax(1024 * 1024 * 10);

        List<FileItem> fileItems = servletFileUpload.parseRequest(new Rc(request));
        for (FileItem fileItem : fileItems) {
            if (!fileItem.isFormField()) {
                FileUploadOnly.fileup(realPath,fileItem,"PinG");
            }
        }
    }
}
