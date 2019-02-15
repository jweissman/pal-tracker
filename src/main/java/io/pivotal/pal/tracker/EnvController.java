package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final String port;
    private final String memLimit;
    private final String instanceIndex;
    private final String instanceAddress;

    public EnvController(
            @Value("${port:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIdx,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr
    ) {
        this.port = port;
        this.memLimit = memLimit;
        this.instanceIndex = cfInstanceIdx;
        this.instanceAddress = cfInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> theEnv = new HashMap<>();

        theEnv.put("PORT", this.port);
        theEnv.put("MEMORY_LIMIT", this.memLimit);
        theEnv.put("CF_INSTANCE_INDEX", this.instanceIndex);
        theEnv.put("CF_INSTANCE_ADDR", this.instanceAddress);

        return theEnv;
    }
}
