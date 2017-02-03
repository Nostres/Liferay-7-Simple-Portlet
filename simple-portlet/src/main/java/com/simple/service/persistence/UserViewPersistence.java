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

package com.simple.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.simple.exception.NoSuchUserViewException;

import com.simple.model.UserView;

/**
 * The persistence interface for the user view service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.simple.service.persistence.impl.UserViewPersistenceImpl
 * @see UserViewUtil
 * @generated
 */
@ProviderType
public interface UserViewPersistence extends BasePersistence<UserView> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserViewUtil} to access the user view persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user view in the entity cache if it is enabled.
	*
	* @param userView the user view
	*/
	public void cacheResult(UserView userView);

	/**
	* Caches the user views in the entity cache if it is enabled.
	*
	* @param userViews the user views
	*/
	public void cacheResult(java.util.List<UserView> userViews);

	/**
	* Creates a new user view with the primary key. Does not add the user view to the database.
	*
	* @param id the primary key for the new user view
	* @return the new user view
	*/
	public UserView create(long id);

	/**
	* Removes the user view with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user view
	* @return the user view that was removed
	* @throws NoSuchUserViewException if a user view with the primary key could not be found
	*/
	public UserView remove(long id) throws NoSuchUserViewException;

	public UserView updateImpl(UserView userView);

	/**
	* Returns the user view with the primary key or throws a {@link NoSuchUserViewException} if it could not be found.
	*
	* @param id the primary key of the user view
	* @return the user view
	* @throws NoSuchUserViewException if a user view with the primary key could not be found
	*/
	public UserView findByPrimaryKey(long id) throws NoSuchUserViewException;

	/**
	* Returns the user view with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the user view
	* @return the user view, or <code>null</code> if a user view with the primary key could not be found
	*/
	public UserView fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, UserView> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user views.
	*
	* @return the user views
	*/
	public java.util.List<UserView> findAll();

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
	public java.util.List<UserView> findAll(int start, int end);

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
	public java.util.List<UserView> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserView> orderByComparator);

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
	public java.util.List<UserView> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserView> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user views from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user views.
	*
	* @return the number of user views
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}