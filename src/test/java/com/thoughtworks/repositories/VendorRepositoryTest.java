package com.thoughtworks.repositories;


import com.thoughtworks.models.Product;
import com.thoughtworks.models.Vendor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class VendorRepositoryTest {
    private VendorRepository vendorRepository;
    private Vendor vendor;
    private Product product1,product2;

    @Mock
    private Session session;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Query mockQuery;


    @Before
    public void setUp() {
        initMocks(this);
        vendorRepository = new VendorRepository(sessionFactory, session);
        vendor = new Vendor(1, "vname", "m1234", "some@a.com", "address", "pan234", "dsfds32");
        product1 = new Product(1,"p1",12.50f,"kg",1);
        product2 = new Product(4,"p4",12.50f,"kg",2);

    }

    @Test
    public void shouldRetreiveAllVendors() {
        List<Vendor> vendors = new ArrayList<Vendor>();
        vendors.add(vendor);

        when(session.createQuery("from Vendor")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(vendors);

        List<Vendor> vendorList = vendorRepository.getAllVendors();

        verify(session).createQuery("from Vendor");

        assertEquals("vname", vendorList.get(0).getVendorName());
    }

    @Test
    public void shouldGetTheProductsOfAVendor() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        Query mockQuery = mock(Query.class);

        when(session.createQuery("from Product P WHERE P.vendorId = :vendorId")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(productList);

        vendorRepository.getAllProductsByVendorId(1);

        verify(session).createQuery("from Product P WHERE P.vendorId = :vendorId");
    }
}
