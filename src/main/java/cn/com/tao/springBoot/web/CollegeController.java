package cn.com.tao.springBoot.web;

import cn.com.tao.springBoot.domain.pojo.College;
import cn.com.tao.springBoot.domain.resporitory.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by taowenchen on 2016/9/5.
 */
@RequestMapping
@Controller
public class CollegeController {
  private CollegeRepository collegeRepository;


    @RequestMapping(value = "/college", method = RequestMethod.GET)
    public String getCollegeID(@RequestParam String name, Model model){
        College college= collegeRepository.findByName(name);
        model.addAttribute("college",college);
        return "/college/index";
    }

    @Autowired
    public void setCollegeRepository(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }
}
