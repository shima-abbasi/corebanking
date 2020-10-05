package corebanking.common.systemConfig.service;

import corebanking.common.systemConfig.dto.SystemConfigDTO;
import corebanking.common.systemConfig.exception.SystemConfigException;
import corebanking.common.systemConfig.model.SystemConfig;
import corebanking.common.systemConfig.repository.SystemConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    private SystemConfigRepo systemConfigRepo;

    @Override
    public SystemConfig getConfigByCode(String code) {
        try {
            return systemConfigRepo.findByCode(code);
        } catch (Exception ex) {
            throw new SystemConfigException(ex);
        }
    }

    @Override
    public List<SystemConfig> getConfigByParentCode(String code) {
        return systemConfigRepo.getByParentCode(code);
    }

    @Override
    public HashMap<String, String> toMapSystemConfigs(Set<SystemConfig> systemConfigs) {
        return new HashMap<>(systemConfigs.stream().collect(Collectors.toMap(SystemConfig::getCode, SystemConfig::getValue)));
    }

    @Override
    public SystemConfigDTO convertToDTO(SystemConfig systemConfig) {
        SystemConfigDTO configDTO = new SystemConfigDTO();
        configDTO.setCode(systemConfig.getCode());
        configDTO.setName(systemConfig.getName());
        configDTO.setValue(systemConfig.getValue());
        return configDTO;
    }
}
