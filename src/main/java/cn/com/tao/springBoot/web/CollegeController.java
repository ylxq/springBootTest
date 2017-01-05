package cn.com.tao.springBoot.web;

import cn.com.tao.springBoot.domain.pojo.College;
import cn.com.tao.springBoot.domain.resporitory.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by taowenchen on 2016/9/5.
 */
@RequestMapping
@Controller
public class CollegeController {
    private CollegeRepository collegeRepository;


    @RequestMapping(value = "/college", method = RequestMethod.GET)
    public String getCollegeID(@RequestParam String name, Model model) {
        College college = collegeRepository.findByName(name);
        List<College> lists = collegeRepository.findAll();
        model.addAttribute("college", college);
        model.addAttribute("boolTRUE", true);
        model.addAttribute("boolFALSE", false);
        model.addAttribute("date", LocalDateTime.now());
        model.addAttribute("list", lists);


        return "/college/index";
    }


    //文件上传
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @PostMapping("/form")
    @ResponseBody
    public void handleFormUpload(@RequestParam("name") String name,
                                 @RequestParam("file") MultipartFile file) {
        byte[] bytes = {};
        FileOutputStream  out =null;
        if (!file.isEmpty()) {
            try {
                bytes = file.getBytes();
                File f = new File("D:/upload/" + file.getOriginalFilename());
                out = new FileOutputStream(f);
                out.write(bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return ;
    }

    @Autowired
    public void setCollegeRepository(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }
}
