package work.shrink.portupdater2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.shrink.portupdater2.entity.Domain;
import work.shrink.portupdater2.service.DomainService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Random;

/**
 * @author Shrink
 * @version v1.0 2023-05-21 17:37
 */
@RestController
public class PortUpdaterController {
  @Autowired
  private DomainService domainService;
  @RequestMapping("/node-list")
  public String updatePort(@RequestParam("userId") String originalEncodedLink) {
    String originalDecodedLink = new String(Base64.getDecoder().decode(originalEncodedLink));
    //originalDecodedLink example:
    //trojan://username@domain:port#domain%3Aport
    int lastColonIndex = originalDecodedLink.lastIndexOf(":");
    int lastHashTagIndex = originalDecodedLink.lastIndexOf("#");
    int lastPercentSignIndex = originalDecodedLink.lastIndexOf("%");
    String originalPort = originalDecodedLink.substring(lastColonIndex + 1, lastHashTagIndex);
    Random random = new Random();
    String newPort = 10000 + random.nextInt(40000) + "";
    String originalDomain = originalDecodedLink.substring(lastHashTagIndex + 1, lastPercentSignIndex);
    List<Domain> domains = domainService.list();
    int chosenIndex = new Random().nextInt(domains.size());
    String newDomain = domains.get(chosenIndex).getValue();
    String newDecodedLink = originalDecodedLink.replaceAll(originalPort, newPort).replaceAll(originalDomain, newDomain);
    String newEncodedLink = new String(Base64.getEncoder().encode(newDecodedLink.getBytes(StandardCharsets.UTF_8)));
    return newEncodedLink;
  }
}
