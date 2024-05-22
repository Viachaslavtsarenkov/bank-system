package com.tsarankou.clientservice.config.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("bank.client.account")
public class BankProcessorProperties {
    private String id;
    private String endpoint;
}
