package cn.com.tao.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by taowenchen on 2016/8/11.
 */
@SpringBootApplication
public class ApplicationMain {

    public static  void main(String[] args){
        SpringApplication.run(ApplicationMain.class, args);
    }

}
