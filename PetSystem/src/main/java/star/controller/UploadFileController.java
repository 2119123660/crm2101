package star.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import star.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/upload")
@CrossOrigin
@Api(tags = "上传文件相关API接口")
public class UploadFileController {

     /**
       *功能描述：uploadFile
       *方法参数：不跳转，只完成文件上传，返回上传成功后的路径
       *返回值：
       *作者：zz
       *时间：2024/9/29 13:55
       */
    @RequestMapping("uploadFile")
    public void uploadFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断上传
        if(file != null && file.getSize() >0){
            String path = FileUtil.transferToMVC(request, file);
            //设置编码格式
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(path);
            out.flush();
            out.close();
        }
    }
}
