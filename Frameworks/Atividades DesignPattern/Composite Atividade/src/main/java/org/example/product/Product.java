package org.example.product;

import lombok.Data;
import org.example.Box;
@Data
public abstract class Product implements Box {

    protected final String title;
    protected final double price;

}
