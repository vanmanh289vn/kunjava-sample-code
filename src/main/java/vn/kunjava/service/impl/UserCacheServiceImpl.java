package vn.kunjava.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import vn.kunjava.model.UserCache;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserCacheServiceImpl {

    private static final Map<Long, UserCache> USER_DB = new HashMap<>();

    static {
        USER_DB.put(1L, new UserCache(1L, "ManhPV2"));
        USER_DB.put(2L, new UserCache(2L, "CuongPM"));
        USER_DB.put(3L, new UserCache(3L, "ThuPTH"));
    }

    @Cacheable("users")
    public UserCache getUserById(Long id) {
        // gia lap do tre khi truy van csdl
        simulateSlowService();
        return USER_DB.get(id);
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
