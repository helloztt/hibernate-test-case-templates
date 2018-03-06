package org.hibernate.bugs.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by helloztt on 2017-08-19.
 */
@Entity
public class NewGoods {
    private Long id;
    private List<Product> productList;
    private List<String> tags;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Lob
    @Convert(converter = StringToListConverter.class)
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
