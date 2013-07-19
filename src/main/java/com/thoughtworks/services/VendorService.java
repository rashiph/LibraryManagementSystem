package com.thoughtworks.services;

import com.thoughtworks.models.Product;
import com.thoughtworks.models.Vendor;
import com.thoughtworks.repositories.VendorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class VendorService {
    @Autowired
   VendorRepository vendorRepository;

    public List<Vendor> getAllVendors(){

        return vendorRepository.getAllVendors();
    }

    public List<Product> getAllProductsByVendorId(int vendorId) {
        return vendorRepository.getAllProductsByVendorId(vendorId);
    }

}
