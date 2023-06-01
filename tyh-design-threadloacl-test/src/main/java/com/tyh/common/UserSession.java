package com.tyh.common;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: UserSession
 * @Author: 青衣醉
 * @Date: 2023/5/30 5:31 下午
 */
@Data
@Builder
public class UserSession {
    private String userId;
    private String name;
    private String password;
}
