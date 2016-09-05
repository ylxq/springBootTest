package cn.com.tao.springBoot.domain.resporitory;


import cn.com.tao.springBoot.domain.pojo.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollegeRepository extends JpaRepository<College, String> {

    College findByName(String name);
}
