package org.hibernate.bugs.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

/**
 * @author helloztt
 */
@StaticMetamodel(Goods.class)
public class Goods_ {
	public static volatile SingularAttribute<Goods, Long> id;
	public static volatile ListAttribute<Goods, Product> productList;
	public static volatile ListAttribute<Goods, String> tags;
}
