package service.util;

import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUploadOnly {
    public static void fileup (String realpath, FileItem item,String filename) throws IOException {
            String uploadpath = item.getName();
            String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
            String uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);

            String newfilename = filename+"."+uploadfiletype;

            File realfilepath = new File(realpath);
            if (!realfilepath.exists()) {
                realfilepath.mkdir();
            }
            InputStream ips = item.getInputStream();
            FileOutputStream fops = new FileOutputStream(realfilepath+"/"+newfilename);
            byte[] buffer = new byte[1024 * 1024];
            int len = 0;
            while ((len = ips.read(buffer)) > 0) {
                fops.write(buffer, 0, len);
            }
            fops.close();
            ips.close();
    }
}
