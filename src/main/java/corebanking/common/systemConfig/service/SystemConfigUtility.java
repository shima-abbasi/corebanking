package corebanking.common.systemConfig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public abstract class SystemConfigUtility {

    @Autowired
    private SystemConfigService systemConfigService;

    public abstract String getConfigParentCode();

    public String getValue(String code) {
        return systemConfigService.getConfigByCode(code).getValue();
    }

}
