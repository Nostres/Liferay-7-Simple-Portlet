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

package com.simple.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserView}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserView
 * @generated
 */
@ProviderType
public class UserViewWrapper implements UserView, ModelWrapper<UserView> {
	public UserViewWrapper(UserView userView) {
		_userView = userView;
	}

	@Override
	public Class<?> getModelClass() {
		return UserView.class;
	}

	@Override
	public String getModelClassName() {
		return UserView.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public UserView toEscapedModel() {
		return new UserViewWrapper(_userView.toEscapedModel());
	}

	@Override
	public UserView toUnescapedModel() {
		return new UserViewWrapper(_userView.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _userView.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userView.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userView.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userView.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserView> toCacheModel() {
		return _userView.toCacheModel();
	}

	@Override
	public int compareTo(UserView userView) {
		return _userView.compareTo(userView);
	}

	@Override
	public int hashCode() {
		return _userView.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userView.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserViewWrapper((UserView)_userView.clone());
	}

	/**
	* Returns the email of this user view.
	*
	* @return the email of this user view
	*/
	@Override
	public java.lang.String getEmail() {
		return _userView.getEmail();
	}

	/**
	* Returns the name of this user view.
	*
	* @return the name of this user view
	*/
	@Override
	public java.lang.String getName() {
		return _userView.getName();
	}

	@Override
	public java.lang.String toString() {
		return _userView.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userView.toXmlString();
	}

	/**
	* Returns the ID of this user view.
	*
	* @return the ID of this user view
	*/
	@Override
	public long getId() {
		return _userView.getId();
	}

	/**
	* Returns the primary key of this user view.
	*
	* @return the primary key of this user view
	*/
	@Override
	public long getPrimaryKey() {
		return _userView.getPrimaryKey();
	}

	@Override
	public void persist() {
		_userView.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userView.setCachedModel(cachedModel);
	}

	/**
	* Sets the email of this user view.
	*
	* @param email the email of this user view
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_userView.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userView.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userView.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userView.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this user view.
	*
	* @param id the ID of this user view
	*/
	@Override
	public void setId(long id) {
		_userView.setId(id);
	}

	/**
	* Sets the name of this user view.
	*
	* @param name the name of this user view
	*/
	@Override
	public void setName(java.lang.String name) {
		_userView.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_userView.setNew(n);
	}

	/**
	* Sets the primary key of this user view.
	*
	* @param primaryKey the primary key of this user view
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userView.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userView.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserViewWrapper)) {
			return false;
		}

		UserViewWrapper userViewWrapper = (UserViewWrapper)obj;

		if (Objects.equals(_userView, userViewWrapper._userView)) {
			return true;
		}

		return false;
	}

	@Override
	public UserView getWrappedModel() {
		return _userView;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userView.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userView.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userView.resetOriginalValues();
	}

	private final UserView _userView;
}