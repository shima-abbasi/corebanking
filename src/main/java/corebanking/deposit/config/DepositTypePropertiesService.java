package corebanking.deposit.config;

import corebanking.common.systemConfig.service.SystemConfigUtility;
import org.springframework.stereotype.Service;


@Service
public class DepositTypePropertiesService extends SystemConfigUtility {
    @Override
    public String getConfigParentCode() {
        return "depositTypeProps";
    }

    final public static String LONG_TERM_DEPOSIT = "longTermDeposit";
    final public static String SHORT_TERM_DEPOSIT = "shortTermDeposit";
}
