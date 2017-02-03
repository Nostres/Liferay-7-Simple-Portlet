/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.simple.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.simple.exception.NoSuchUserViewException;

import com.simple.model.UserView;

import com.simple.service.UserViewLocalServiceUtil;
import com.simple.service.persistence.UserViewPersistence;
import com.simple.service.persistence.UserViewUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class UserViewPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "com.simple.service"));

	@Before
	public void setUp() {
		_persistence = UserViewUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserView> iterator = _userViews.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserView userView = _persistence.create(pk);

		Assert.assertNotNull(userView);

		Assert.assertEquals(userView.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserView newUserView = addUserView();

		_persistence.remove(newUserView);

		UserView existingUserView = _persistence.fetchByPrimaryKey(newUserView.getPrimaryKey());

		Assert.assertNull(existingUserView);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserView();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserView newUserView = _persistence.create(pk);

		newUserView.setName(RandomTestUtil.randomString());

		newUserView.setEmail(RandomTestUtil.randomString());

		_userViews.add(_persistence.update(newUserView));

		UserView existingUserView = _persistence.findByPrimaryKey(newUserView.getPrimaryKey());

		Assert.assertEquals(existingUserView.getId(), newUserView.getId());
		Assert.assertEquals(existingUserView.getName(), newUserView.getName());
		Assert.assertEquals(existingUserView.getEmail(), newUserView.getEmail());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserView newUserView = addUserView();

		UserView existingUserView = _persistence.findByPrimaryKey(newUserView.getPrimaryKey());

		Assert.assertEquals(existingUserView, newUserView);
	}

	@Test(expected = NoSuchUserViewException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<UserView> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("UserView", "id", true,
			"name", true, "email", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserView newUserView = addUserView();

		UserView existingUserView = _persistence.fetchByPrimaryKey(newUserView.getPrimaryKey());

		Assert.assertEquals(existingUserView, newUserView);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserView missingUserView = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserView);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		UserView newUserView1 = addUserView();
		UserView newUserView2 = addUserView();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserView1.getPrimaryKey());
		primaryKeys.add(newUserView2.getPrimaryKey());

		Map<Serializable, UserView> userViews = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, userViews.size());
		Assert.assertEquals(newUserView1,
			userViews.get(newUserView1.getPrimaryKey()));
		Assert.assertEquals(newUserView2,
			userViews.get(newUserView2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UserView> userViews = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userViews.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		UserView newUserView = addUserView();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserView.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UserView> userViews = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userViews.size());
		Assert.assertEquals(newUserView,
			userViews.get(newUserView.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UserView> userViews = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userViews.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		UserView newUserView = addUserView();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserView.getPrimaryKey());

		Map<Serializable, UserView> userViews = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userViews.size());
		Assert.assertEquals(newUserView,
			userViews.get(newUserView.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = UserViewLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<UserView>() {
				@Override
				public void performAction(UserView userView) {
					Assert.assertNotNull(userView);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		UserView newUserView = addUserView();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserView.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newUserView.getId()));

		List<UserView> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserView existingUserView = result.get(0);

		Assert.assertEquals(existingUserView, newUserView);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserView.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id",
				RandomTestUtil.nextLong()));

		List<UserView> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		UserView newUserView = addUserView();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserView.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newUserView.getId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("id", new Object[] { newId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserView.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("id",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected UserView addUserView() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserView userView = _persistence.create(pk);

		userView.setName(RandomTestUtil.randomString());

		userView.setEmail(RandomTestUtil.randomString());

		_userViews.add(_persistence.update(userView));

		return userView;
	}

	private List<UserView> _userViews = new ArrayList<UserView>();
	private UserViewPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}