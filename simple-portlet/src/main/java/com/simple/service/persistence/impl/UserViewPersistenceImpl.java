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

package com.simple.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.simple.exception.NoSuchUserViewException;

import com.simple.model.UserView;
import com.simple.model.impl.UserViewImpl;
import com.simple.model.impl.UserViewModelImpl;

import com.simple.service.persistence.UserViewPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the user view service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserViewPersistence
 * @see com.simple.service.persistence.UserViewUtil
 * @generated
 */
@ProviderType
public class UserViewPersistenceImpl extends BasePersistenceImpl<UserView>
	implements UserViewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserViewUtil} to access the user view persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserViewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserViewModelImpl.ENTITY_CACHE_ENABLED,
			UserViewModelImpl.FINDER_CACHE_ENABLED, UserViewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserViewModelImpl.ENTITY_CACHE_ENABLED,
			UserViewModelImpl.FINDER_CACHE_ENABLED, UserViewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserViewModelImpl.ENTITY_CACHE_ENABLED,
			UserViewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UserViewPersistenceImpl() {
		setModelClass(UserView.class);
	}

	/**
	 * Caches the user view in the entity cache if it is enabled.
	 *
	 * @param userView the user view
	 */
	@Override
	public void cacheResult(UserView userView) {
		entityCache.putResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
			UserViewImpl.class, userView.getPrimaryKey(), userView);

		userView.resetOriginalValues();
	}

	/**
	 * Caches the user views in the entity cache if it is enabled.
	 *
	 * @param userViews the user views
	 */
	@Override
	public void cacheResult(List<UserView> userViews) {
		for (UserView userView : userViews) {
			if (entityCache.getResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
						UserViewImpl.class, userView.getPrimaryKey()) == null) {
				cacheResult(userView);
			}
			else {
				userView.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user views.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserViewImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user view.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserView userView) {
		entityCache.removeResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
			UserViewImpl.class, userView.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserView> userViews) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserView userView : userViews) {
			entityCache.removeResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
				UserViewImpl.class, userView.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user view with the primary key. Does not add the user view to the database.
	 *
	 * @param id the primary key for the new user view
	 * @return the new user view
	 */
	@Override
	public UserView create(long id) {
		UserView userView = new UserViewImpl();

		userView.setNew(true);
		userView.setPrimaryKey(id);

		return userView;
	}

	/**
	 * Removes the user view with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the user view
	 * @return the user view that was removed
	 * @throws NoSuchUserViewException if a user view with the primary key could not be found
	 */
	@Override
	public UserView remove(long id) throws NoSuchUserViewException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the user view with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user view
	 * @return the user view that was removed
	 * @throws NoSuchUserViewException if a user view with the primary key could not be found
	 */
	@Override
	public UserView remove(Serializable primaryKey)
		throws NoSuchUserViewException {
		Session session = null;

		try {
			session = openSession();

			UserView userView = (UserView)session.get(UserViewImpl.class,
					primaryKey);

			if (userView == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserViewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userView);
		}
		catch (NoSuchUserViewException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserView removeImpl(UserView userView) {
		userView = toUnwrappedModel(userView);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userView)) {
				userView = (UserView)session.get(UserViewImpl.class,
						userView.getPrimaryKeyObj());
			}

			if (userView != null) {
				session.delete(userView);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userView != null) {
			clearCache(userView);
		}

		return userView;
	}

	@Override
	public UserView updateImpl(UserView userView) {
		userView = toUnwrappedModel(userView);

		boolean isNew = userView.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userView.isNew()) {
				session.save(userView);

				userView.setNew(false);
			}
			else {
				userView = (UserView)session.merge(userView);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
			UserViewImpl.class, userView.getPrimaryKey(), userView, false);

		userView.resetOriginalValues();

		return userView;
	}

	protected UserView toUnwrappedModel(UserView userView) {
		if (userView instanceof UserViewImpl) {
			return userView;
		}

		UserViewImpl userViewImpl = new UserViewImpl();

		userViewImpl.setNew(userView.isNew());
		userViewImpl.setPrimaryKey(userView.getPrimaryKey());

		userViewImpl.setId(userView.getId());
		userViewImpl.setName(userView.getName());
		userViewImpl.setEmail(userView.getEmail());

		return userViewImpl;
	}

	/**
	 * Returns the user view with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user view
	 * @return the user view
	 * @throws NoSuchUserViewException if a user view with the primary key could not be found
	 */
	@Override
	public UserView findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserViewException {
		UserView userView = fetchByPrimaryKey(primaryKey);

		if (userView == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserViewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userView;
	}

	/**
	 * Returns the user view with the primary key or throws a {@link NoSuchUserViewException} if it could not be found.
	 *
	 * @param id the primary key of the user view
	 * @return the user view
	 * @throws NoSuchUserViewException if a user view with the primary key could not be found
	 */
	@Override
	public UserView findByPrimaryKey(long id) throws NoSuchUserViewException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the user view with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user view
	 * @return the user view, or <code>null</code> if a user view with the primary key could not be found
	 */
	@Override
	public UserView fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
				UserViewImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserView userView = (UserView)serializable;

		if (userView == null) {
			Session session = null;

			try {
				session = openSession();

				userView = (UserView)session.get(UserViewImpl.class, primaryKey);

				if (userView != null) {
					cacheResult(userView);
				}
				else {
					entityCache.putResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
						UserViewImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
					UserViewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userView;
	}

	/**
	 * Returns the user view with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the user view
	 * @return the user view, or <code>null</code> if a user view with the primary key could not be found
	 */
	@Override
	public UserView fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, UserView> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserView> map = new HashMap<Serializable, UserView>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserView userView = fetchByPrimaryKey(primaryKey);

			if (userView != null) {
				map.put(primaryKey, userView);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
					UserViewImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserView)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERVIEW_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (UserView userView : (List<UserView>)q.list()) {
				map.put(userView.getPrimaryKeyObj(), userView);

				cacheResult(userView);

				uncachedPrimaryKeys.remove(userView.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserViewModelImpl.ENTITY_CACHE_ENABLED,
					UserViewImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the user views.
	 *
	 * @return the user views
	 */
	@Override
	public List<UserView> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user views.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user views
	 * @param end the upper bound of the range of user views (not inclusive)
	 * @return the range of user views
	 */
	@Override
	public List<UserView> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user views.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user views
	 * @param end the upper bound of the range of user views (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user views
	 */
	@Override
	public List<UserView> findAll(int start, int end,
		OrderByComparator<UserView> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user views.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserViewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user views
	 * @param end the upper bound of the range of user views (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user views
	 */
	@Override
	public List<UserView> findAll(int start, int end,
		OrderByComparator<UserView> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<UserView> list = null;

		if (retrieveFromCache) {
			list = (List<UserView>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERVIEW;

				if (pagination) {
					sql = sql.concat(UserViewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserView>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserView>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user views from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserView userView : findAll()) {
			remove(userView);
		}
	}

	/**
	 * Returns the number of user views.
	 *
	 * @return the number of user views
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERVIEW);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserViewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user view persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserViewImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERVIEW = "SELECT userView FROM UserView userView";
	private static final String _SQL_SELECT_USERVIEW_WHERE_PKS_IN = "SELECT userView FROM UserView userView WHERE id_ IN (";
	private static final String _SQL_COUNT_USERVIEW = "SELECT COUNT(userView) FROM UserView userView";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userView.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserView exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(UserViewPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}