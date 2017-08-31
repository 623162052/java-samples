import org.redisson.Redisson;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Created by shiwx on 2017/6/22.
 */
public class Test {

    public static void main(String[] args) {
        Config config = new Config();
        config.setUseLinuxNativeEpoll(true);
        config.useClusterServers()
                .addNodeAddress("redis://192.168.100.38:30101")
                .addNodeAddress("redis://192.168.100.38:30102")
                .addNodeAddress("redis://192.168.100.38:30103")
                .addNodeAddress("redis://192.168.100.38:30104")
                .addNodeAddress("redis://192.168.100.38:30105")
                .addNodeAddress("redis://192.168.100.38:30106");

        RedissonClient redisson = Redisson.create(config);

//        RMapCache<String, String> map = redisson.getMapCache("anyMap");
//        String result = map.putIfAbsent("abc", "123", 60, TimeUnit.SECONDS);
//        System.out.println("result: " + result);
//        String result1 = map.putIfAbsent("abc", "123", 60, TimeUnit.SECONDS);
//        System.out.println("result1: " + result1);

        RMapCache<String, String> map = redisson.getMapCache("NGWF_CFG_CODE:100000_00030016");
        String xx = map.get("COMMON_CODE@TASK_STAFF");
        System.out.println(xx);

    }

}




