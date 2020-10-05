package corebanking.deposit.config;

import corebanking.common.systemConfig.service.SystemConfigUtility;
import org.springframework.stereotype.Service;

@Service
public class DepositPropertiesService  extends SystemConfigUtility {
    @Override
    public String getConfigParentCode() {
        return "depositProps";
    }

    final public static String MY_BANK_CODE = "myBankCode";
}
