/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserviceclient;

import java.util.Scanner;
import org.me.product.Product;

/**
 *
 * @author ann52
 */
public class WebServiceClient {

    public static void main(String[] args) {
        // TODO code application logic here
        Product product = getProduct("B17DCCN002");
        System.out.println(product.getId());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        float importPrice = scanner.nextFloat();
        float exportPrice = scanner.nextFloat();
        product.setName(name);
        product.setExportPrice(exportPrice);
        product.setImportPrice(importPrice);
        boolean state = insertProduct(product);
        System.out.println(state);
    }

    private static Product getProduct(java.lang.String code) {
        org.me.product.ProductService_Service service = new org.me.product.ProductService_Service();
        org.me.product.ProductService port = service.getProductServicePort();
        return port.getProduct(code);
    }

    private static boolean insertProduct(org.me.product.Product product) {
        org.me.product.ProductService_Service service = new org.me.product.ProductService_Service();
        org.me.product.ProductService port = service.getProductServicePort();
        return port.insertProduct(product);
    }
    
}
