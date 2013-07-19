package com.thoughtworks.services;


import com.thoughtworks.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class VendorServiceTest {
    @Mock
    VendorRepository vendorRepository;

    VendorService vendorService;

    @Before
    public void setUp(){
        initMocks(this);
        vendorService = new VendorService(vendorRepository);
    }

    @Test
    public void shouldGetAllTheVendors(){
        vendorService.getAllVendors();
        verify(vendorRepository).getAllVendors();
    }

    @Test
    public void shouldRetreiveAllTheProductsOfAVendor() {
        vendorService.getAllProductsByVendorId(1);
        verify(vendorRepository).getAllProductsByVendorId(1);
    }
}
