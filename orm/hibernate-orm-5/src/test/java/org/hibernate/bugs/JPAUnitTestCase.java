package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.bugs.entity.Goods;
import org.hibernate.bugs.entity.Goods_;
import org.hibernate.bugs.entity.NewGoods;
import org.hibernate.bugs.entity.NewGoods_;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	@Test
	public void hhh12338ErrorTest() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Goods> goodsRoot = cq.from(Goods.class);
		cq.where(cb.isNotNull(goodsRoot.get(Goods_.tags)));
		cq = cq.select(cb.count(goodsRoot));
		long count = entityManager.createQuery(cq)
				.getSingleResult();
		Assert.assertEquals(0L,count);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Test
	public void hhh12338Test(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		Root<NewGoods> newGoodsRoot =cq.from(NewGoods.class);
		cq.where(cb.isNotNull(newGoodsRoot.get(NewGoods_.tags)));
		cq = cq.select(cb.count(newGoodsRoot));
		long count = entityManager.createQuery(cq)
				.getSingleResult();
		Assert.assertEquals(0L,count);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
