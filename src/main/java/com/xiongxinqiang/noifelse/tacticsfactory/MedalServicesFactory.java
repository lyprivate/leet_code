package com.xiongxinqiang.noifelse.tacticsfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/22 6:14 下午
 */
public class MedalServicesFactory {

    private static final Map<String, IMedalService> map = new HashMap<>();
    static {
        map.put("guard", new GuardMedalServiceImpl());
        map.put("vip", new VipMedalServiceImpl());
        map.put("guest", new GuestMedalServiceImpl());
    }
    public static IMedalService getMedalService(String medalType) {
        return map.get(medalType);
    }

}
