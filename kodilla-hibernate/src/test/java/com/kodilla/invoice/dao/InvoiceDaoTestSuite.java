package com.kodilla.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.invoice.dao.ItemsDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemsDao itemsDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("Laptop DELL");
        Product product2 = new Product("Laptop Lenovo");
        Product product3 = new Product("Laptop Acer");

        Item item1 = new Item(product1, new BigDecimal(1500), new BigDecimal(1500), 1);
        Item item2 = new Item(product2, new BigDecimal(2400), new BigDecimal(7200), 3);
        Item item3 = new Item(product3, new BigDecimal(1800), new BigDecimal(3600), 2);

        Invoice invoice = new Invoice("FAV/1589/2019");

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);

        int id = invoice.getId();
        String productName = invoice.getItems().get(0).getProduct().getName();

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertEquals("Laptop DELL", productName);

        //CleanUp
        invoiceDao.deleteById(id);

    }
}
