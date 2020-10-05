package corebanking.customer.api;

import corebanking.common.dto.ApiDTO;
import corebanking.customer.dto.RegisterCustomerRequestDTO;
import corebanking.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@PropertySource(value = "classpath:api.properties")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("${CUSTOMER__REGISTER_CUSTOMER}")
    public ApiDTO registerCustomer(@RequestBody @NotNull @Valid RegisterCustomerRequestDTO requestDTO){
        return new ApiDTO(Boolean.FALSE, "customer_registered_successfully", customerService.registerCustomer(requestDTO));
    }

    @RequestMapping("${CUSTOMER___FIND_CUSTOMER_BY_NATIONAL_CODE}")
    public ApiDTO findCustomerByNationalCode(@RequestParam String nationalCode){
        return new ApiDTO(Boolean.FALSE, "customer_found_successfully", customerService.findCustomerByNationalCode(nationalCode));
    }

}
