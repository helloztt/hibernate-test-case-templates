package org.hibernate.bugs.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

/**
 * @author helloztt
 */
@StaticMetamodel(NewGoods.class)
public class NewGoods_ {
	public static volatile SingularAttribute<NewGoods, Long> id;
	public static volatile ListAttribute<NewGoods, Product> productList;
	public static volatile SingularAttribute<NewGoods, List<String>> tags;
}
