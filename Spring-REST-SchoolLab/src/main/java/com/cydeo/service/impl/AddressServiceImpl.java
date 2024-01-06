package com.cydeo.service.impl;

import com.cydeo.dto.AddressDTO;
import com.cydeo.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> findAll() {
        return null;
    }

    @Override
    public AddressDTO findById(Long id) throws Exception {
        return null;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {
        return null;
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {
        return null;
    }
}
