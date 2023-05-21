package work.shrink.portupdater2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

/**
 * @author Shrink
 * @version v1.0 2023-05-21 17:37
 */
@RestController
public class PortUpdaterController{
    @RequestMapping("/node-list")
    public String updatePort(@RequestParam("userId") String originalEncodedLink){
        String originalDecodedLink=new String(Base64.getDecoder()
                                                    .decode(originalEncodedLink));
        int leftIndex=originalDecodedLink.lastIndexOf(":");
        int rightIndex=originalDecodedLink.lastIndexOf("#");
        String originalPort=originalDecodedLink.substring(leftIndex+1,rightIndex);
        Random random=new Random();
        String newPort=10000+random.nextInt(40000)+"";
        String newDecodedLink=originalDecodedLink.replaceAll(originalPort,newPort);
        String newEncodedLink=new String(Base64.getEncoder()
                                               .encode(newDecodedLink.getBytes(StandardCharsets.UTF_8)));
        return newEncodedLink;
    }
}
