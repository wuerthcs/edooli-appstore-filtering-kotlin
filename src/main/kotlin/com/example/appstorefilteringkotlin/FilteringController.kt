package com.example.appstorefilteringkotlin

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.DriverManager

@RestController
public class FilteringController {
    @RequestMapping("/filtering")
    fun getFiltering(): String
    {
        var userName = "root"
        var password = "123"
        var url = "jdbc:mariadb://localhost:3306"
        var driver = "org.mariadb.jdbc.Driver"
        var message = ""
        try {
            Class.forName(driver)
            var con = DriverManager.getConnection(url, userName, password)
            var st = con.createStatement()
            message =  "Connection is successful"
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return  message
    }

    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello, world!";
    }

}