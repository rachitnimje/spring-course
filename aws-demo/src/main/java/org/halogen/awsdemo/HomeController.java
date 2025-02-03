package org.halogen.awsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/info")
    public String aboutMachine() {
        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        String version = System.getProperty("os.version");

        return "OS: " + os + "\nArchitecture: " + arch + "\nVersion:" + version;
    }
}
