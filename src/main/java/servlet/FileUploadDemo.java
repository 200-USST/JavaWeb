package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
@WebServlet(value = "/fileUpload")//ROOT用户的一些操作控制层代码
public class FileUploadDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath1 = this.getServletContext().getRealPath("/WEB-INF/upload");
        String realPath2 = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File saveFilePath = new File(realPath1);
        File tempFilePath = new File(realPath2);
        boolean flag=false;
        if (!saveFilePath.exists()) {
            saveFilePath.mkdir();
        }
        if (!tempFilePath.exists()) {
            tempFilePath.mkdir();
        }
        try {
            DiskFileItemFactory diskFileItemFactory = getDiskFileItemFactory(tempFilePath);
            ServletFileUpload servletFileUpload = getServletFileUpload(diskFileItemFactory);
            flag = uploadParseRequest(servletFileUpload, req, realPath1);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        req.setAttribute("flag",flag);
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }

    private DiskFileItemFactory getDiskFileItemFactory(File file) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024 * 1024);
        diskFileItemFactory.setRepository(file);
        return diskFileItemFactory;
    }

    private ServletFileUpload getServletFileUpload(DiskFileItemFactory diskFileItemFactory) {
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.printf("总大小：%d，已上传：%d，%d\n", pContentLength, pBytesRead, pItems);
            }
        });
        servletFileUpload.setHeaderEncoding("utf-8");
        servletFileUpload.setFileSizeMax(1024 * 1024 * 10);
        return servletFileUpload;
    }
    class Rc implements RequestContext{
        HttpServletRequest request = null;
        public Rc(HttpServletRequest request) {
            this.request=request;
        }

        @Override
        public String getCharacterEncoding() {
            return request.getCharacterEncoding();
        }

        @Override
        public String getContentType() {
            return request.getContentType();
        }

        @Override
        public int getContentLength() {
            return request.getContentLength();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return request.getInputStream();
        }
    }
    private boolean uploadParseRequest(ServletFileUpload upload, HttpServletRequest req, String saveFilePath) throws FileUploadException, IOException {
        boolean flag = false;
        List<FileItem> fileItems = upload.parseRequest(new Rc(req));
        System.out.println("进入uploadParseRequest");
        for (FileItem fileItem : fileItems) {
            System.out.println("进入循环");
            if (fileItem.isFormField()) {
                System.out.println("不是文件");
                System.out.println(fileItem.getFieldName() + "---" + fileItem.getString("utf-8"));
            } else {
                System.out.println("接收文件");
                String uploadpath = fileItem.getName();
                String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
                String uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);
                System.out.println(uploadpath);
                if (uploadfilename.trim().equals("") && uploadfilename == null) {
                    continue;
                }
                System.out.println("文件名："+uploadfilename);
                if (uploadfiletype.trim().equals("jpg") && uploadfiletype == null) {
                    continue;
                }
                System.out.println("文件类型："+uploadfiletype);
                System.out.println("上传的文件名为：" + uploadfilename + "，文件类型：" + uploadfiletype);
                String uuid = UUID.randomUUID().toString();
                String realpath = saveFilePath + "/" + uuid;
                System.out.println("保存路径为："+realpath);
                File realfilepath = new File(realpath);
                if (!realfilepath.exists()) {
                    realfilepath.mkdir();
                }
                InputStream ips = fileItem.getInputStream();
                FileOutputStream fops = new FileOutputStream(realfilepath+"/"+uploadfilename);
                System.out.println(realfilepath);
                byte[] buffer = new byte[1024 * 1024];
                int len = 0;
                while ((len = ips.read(buffer)) > 0) {
                    fops.write(buffer, 0, len);
                }
                fops.close();
                ips.close();
                flag = true;
            }
        }
        return flag;
    }
}