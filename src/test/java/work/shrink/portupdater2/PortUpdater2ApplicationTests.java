package work.shrink.portupdater2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import work.shrink.portupdater2.controller.PortUpdaterController;

@SpringBootTest
class PortUpdater2ApplicationTests{
    @Autowired
    PortUpdaterController portUpdaterController;
    @Test
    void contextLoads(){
        portUpdaterController.updatePort("dHJvamFuOi8veHVzaXlhbmdAc2hyaW5rLndvcms6MjIxNzcjc2hyaW5rLndvcmslM0EyMjE3Nw==");
    }
}
