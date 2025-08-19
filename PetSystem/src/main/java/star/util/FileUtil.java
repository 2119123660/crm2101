package star.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/*
 *功能描述：文件上传工具类
 *作者：zz
 *时间：2024/1/23 15:48
 */
public class FileUtil {

    /*
     *功能描述：获取系统时间生成路径 20240123
     *方法参数：
     *返回值：
     *作者：zz
     *时间：2024/1/23 15:49
     */
    public static String getDatePath() {
        //获取系统当前时间
        return LocalDate.now().toString().replace("-", "");
    }

    /*
     *功能描述：文件重命名
     *方法参数：
     *返回值：
     *作者：zz
     *时间：2024/1/23 15:53
     */
    public static String getNewFileName(String filename) {
        //获取文件的扩展名
        String[] split = filename.split("\\.");
        String suf = split[split.length - 1];
        //创建文件名系统当前时间 + UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return getDatePath() + uuid + "." + suf;
    }

    /*
     *功能描述：上传文件
     *方法参数：
     *返回值：上传成功后的文件路径
     *作者：zz
     *时间：2024/1/23 16:07
     */
    public static String transferTo(HttpServletRequest request, String name) throws IOException, ServletException {
        Part part = request.getPart(name);
        String realPath = request.getServletContext().getRealPath("");
        System.out.println("realPath = " + realPath);
        String filePath = realPath + "/upload";
        File fileDer = new File(filePath);
        if (!fileDer.exists()) {
            //不存在需要创建文件目录
            fileDer.mkdirs();
        }
        //2、文件名
        String originalFilename = part.getSubmittedFileName();
        //重命名
        String newFileName = getNewFileName(originalFilename);
        //上传文件 File
        part.write(filePath + "/" + newFileName);
        System.out.println("文件上传成功后的磁盘路径 = " + filePath + "/" + newFileName);
        //Files.copy(Paths.get(filePath + "/" + newFileName),Paths.get("D:\\xja\\bk\\hospitalManager\\src\\main\\webapp\\upload\\"+newFileName));
        return newFileName;
    }

    /*
     *功能描述：上传文件SpringMVC
     *方法参数：
     *返回值：上传成功后的文件路径
     *作者：zz
     *时间：2024/1/23 16:07
     */
    public static String transferToMVC(HttpServletRequest request, MultipartFile file) throws IOException, ServletException {
        String realPath = request.getServletContext().getRealPath("");
        System.out.println("realPath = " + realPath);
        String filePath = realPath + "/upload";
        File fileDer = new File(filePath);
        if (!fileDer.exists()) {
            //不存在需要创建文件目录
            fileDer.mkdirs();
        }
        //2、文件名
        String originalFilename = file.getOriginalFilename();
        //重命名
        String newFileName = getNewFileName(originalFilename);
        //上传文件 File
        file.transferTo(new File(filePath + "/" + newFileName));
        System.out.println("文件上传成功后的磁盘路径 = " + filePath + "/" + newFileName);
        //Files.copy(Paths.get(filePath + "/" + newFileName),Paths.get("D:\\xja\\bk\\hospitalManager\\src\\main\\webapp\\upload\\"+newFileName));
        return newFileName;
    }


    /*
     *功能描述：上传文件带日期目录
     *方法参数：
     *返回值：上传成功后的文件路径
     *作者：zz
     *时间：2024/1/23 16:07
     */
    public static String transferToByDate(HttpServletRequest request, String name) throws IOException, ServletException {
        Part part = request.getPart(name);
        String realPath = request.getServletContext().getRealPath("");
        System.out.println("realPath = " + realPath);
        String datepath = getDatePath();
        String filePath = realPath + "/upload/" + datepath;
        File fileDer = new File(filePath);
        if (!fileDer.exists()) {
            //不存在需要创建文件目录
            fileDer.mkdirs();
        }
        //2、文件名
        String originalFilename = part.getSubmittedFileName();
        String newFileName = getNewFileName(originalFilename);
        //上传文件 File
        part.write(filePath + "/" + newFileName);
        return datepath + "/" + newFileName;
    }

    public static void main(String[] args) {
        String datePath = getDatePath();
        System.out.println("datePath = " + datePath);
        String newFileName = getNewFileName("6.png");
        System.out.println("newFileName = " + newFileName);

    }

}
