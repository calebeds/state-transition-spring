package com.calebe.statetransition;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

@Service
public class ProductService {
    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product find(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public void decrementStock(Product p) {
        p.setStock(p.getStock() - 1);
        entityManager.merge(p);//It will update only because this p has the same id
    }

    @Transactional
    public void create(int id, int stock) {
        Product newProduct = new Product(id, stock);
        entityManager.merge(newProduct);//Here will create a new row because hibernate will not find a 3 id
    }
}
