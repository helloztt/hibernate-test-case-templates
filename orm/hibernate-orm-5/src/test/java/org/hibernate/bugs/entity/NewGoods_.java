package org.hibernate.bugs.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

/**
 * @author helloztt
 */
@StaticMetamodel(Goods.class)
public class NewGoods_ {
	public static volatile SingularAttribute<Goods, Long> id;
	public static volatile ListAttribute<Goods, Product> productList;
	public static volatile SingularAttribute<Goods, List<java.lang.String>> tags;
}
