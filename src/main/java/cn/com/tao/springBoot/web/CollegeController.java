package cn.com.tao.springBoot.web;

import cn.com.tao.springBoot.domain.resporitory.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by taowenchen on 2016/9/5.
 */
@Controller
public class CollegeController {
  private CollegeRepository collegeRepository;

    @RequestMapping("/college")
    @ResponseBody
    public int getCollegeID(@PathVariable String name){
        return collegeRepository.findByName(name).getId();
    }

    @Autowired
    public void setCollegeRepository(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }
}
