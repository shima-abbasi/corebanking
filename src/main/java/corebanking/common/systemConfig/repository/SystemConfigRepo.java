package corebanking.common.systemConfig.repository;

import corebanking.common.repository.BasicRepo;
import corebanking.common.systemConfig.model.SystemConfig;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SystemConfigRepo extends BasicRepo<SystemConfig> {

    SystemConfig findByCode (String code);

    List<SystemConfig> getByParentCode(@Param("parentCode") String parentCode);

}
