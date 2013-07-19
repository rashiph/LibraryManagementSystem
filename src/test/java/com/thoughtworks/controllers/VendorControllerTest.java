package com.thoughtworks.controllers;


import com.thoughtworks.services.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class VendorControllerTest {

    private PurchaseManagementController purchaseManagementController;
    @Mock
    private VendorService mockedVendorService;
    @Mock
    private org.springframework.web.servlet.ModelAndView modelAndView;

    @Before
    public void setUp() {
        initMocks(this);
        purchaseManagementController = new PurchaseManagementController(mockedVendorService);
    }

    @Test
    public void shouldReturnVendorList() {
        purchaseManagementController.getAllVendors();

        verify(mockedVendorService).getAllVendors();
    }

    @Test
    public void shouldReturnProductListOfParticularVendor() {
        purchaseManagementController.getAllProductsByVendorId(1);

        verify(mockedVendorService).getAllProductsByVendorId(1);
    }
}
