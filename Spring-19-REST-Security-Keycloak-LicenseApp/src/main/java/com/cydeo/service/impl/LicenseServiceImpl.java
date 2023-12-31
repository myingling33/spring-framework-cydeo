package com.cydeo.service.impl;

import com.cydeo.client.OrganizationFeignClient;
import com.cydeo.model.License;
import com.cydeo.model.Organization;
import com.cydeo.repository.LicenseRepository;
import com.cydeo.service.LicenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;
    private final OrganizationFeignClient feignClient;

    public LicenseServiceImpl(LicenseRepository licenseRepository, OrganizationFeignClient feignClient) {
        this.licenseRepository = licenseRepository;
        this.feignClient = feignClient;
    }

    @Override
    public License getLicense(Long licenseId, Long organizationId) throws Exception {

        License license = licenseRepository.findById(licenseId).orElseThrow(() -> new Exception("License not found"));

        Organization organization = retrieveOrganizationInfo(organizationId);

        if (organization != null) {

            license.setOrganizationName(organization.getName());
            license.setContactName(organization.getContactName());
            license.setContactEmail(organization.getContactEmail());
            license.setContactPhone(organization.getContactPhone());

        }

        return license;

    }

    private Organization retrieveOrganizationInfo(Long organizationId) {
        return feignClient.getOrganization(organizationId);
    }

    @Override
    public License createLicense(License license) {
        licenseRepository.save(license);
        return license;
    }

    @Override
    public License updateLicense(License license) {
        licenseRepository.save(license);
        return license;
    }

    @Override
    public String deleteLicense(Long licenseId) throws Exception {
        License license = licenseRepository.findById(licenseId).orElseThrow(() -> new Exception("License not found"));
        licenseRepository.delete(license);
        return "License deleted";
    }

    @Override
    public List<License> getLicensesByOrganization(Long organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }
}
