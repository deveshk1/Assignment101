package com.rev.Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
        checkRes();
    }

    public static void checkRes() {
        try {
            File f=new File("./res");
            if(!f.exists())
                f.mkdir();
            File f2=new File("./res/files");
            if(!f2.exists())
                f2.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
