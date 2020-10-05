package corebanking.common.systemConfig.service;

import corebanking.common.systemConfig.dto.SystemConfigDTO;
import corebanking.common.systemConfig.model.SystemConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface SystemConfigService {

    SystemConfig getConfigByCode(String code);

    List<SystemConfig> getConfigByParentCode(String code);

    HashMap<String, String> toMapSystemConfigs(Set<SystemConfig> systemConfigs);

    SystemConfigDTO convertToDTO(SystemConfig systemConfig);
}
