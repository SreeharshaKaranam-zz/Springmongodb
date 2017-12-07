package com.shivashankaripearlapt.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shivashankaripearlapt.details.*")
public class SpringBootApplicationStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootApplicationStart.class, args);
    }
}
