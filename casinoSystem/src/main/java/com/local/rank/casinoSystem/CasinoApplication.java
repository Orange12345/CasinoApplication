package com.local.rank.casinoSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.local.rank"})
@EntityScan(basePackages={"com.local.rank.db.model"})
public class CasinoApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(CasinoApplication.class, args);
       System.out.println("Welcome");
    }
}
