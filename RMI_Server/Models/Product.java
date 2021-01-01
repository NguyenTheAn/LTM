/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author ann52
 */
public class Product implements Serializable {
    public int id;
    public String code;
    public String name;
    public float importPrice;
    public float exportPrice;
    public String createdUser;
    private static final long serialVersionUID = 20151107;

    public Product() {
    }

    public Product(int id, String code, String name, float importPrice, float exportPrice, String createdUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.createdUser = createdUser;
    }
    
}