package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class LicenseService {

    private final MessageSource messages;

    public License getLicense(String licenseId, String organizationId){
        return License.builder()
                .id(new Random().nextInt(1000))
                .licenseId(licenseId)
                .organizationId(organizationId)
                .description("Software product")
                .productName("Great company")
                .licenseType("full")
                .build();
    }

    public String createLicense(License license, String organizationId, Locale locale){
        String response = null;

        if(nonNull(license)){
            license.setOrganizationId(organizationId);
            response = String.format(messages.getMessage("license.create.message", null, locale), license.toString());
        }

        return response;
    }

    public String updateLicense(License license, String organizationId){
        String response = null;

        if(nonNull(license)){
            license.setOrganizationId(organizationId);
            response = String.format(messages.getMessage("license.update.message", null, null), license.toString());
        }

        return response;

    }

    public String deleteLicense(String licenseId, String organizationId){
        String response = null;

        response = String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);

        return response;

    }


}
