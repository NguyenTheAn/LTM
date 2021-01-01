/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Models.Product;
import Models.IProduct;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ann52
 */
public class ProductImpl extends UnicastRemoteObject implements IProduct{

    public ProductImpl() throws RemoteException {
    }

    @Override
    public Product getProduct(String code) throws RemoteException {
        return new Product(123, code, "PC", (float) 50.5, (float) 70.0, "true");
    }

    @Override
    public boolean insertProduct(Product product) throws RemoteException {
        if (product.name.length() <= 8 || product.name.length() >= 20 || product.exportPrice < product.importPrice){
            return false;
        }
        return true;
    }
    
    
}
