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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the UserView service. Represents a row in the &quot;UserView&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.simple.model.impl.UserViewModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.simple.model.impl.UserViewImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserView
 * @see com.simple.model.impl.UserViewImpl
 * @see com.simple.model.impl.UserViewModelImpl
 * @generated
 */
@ProviderType
public interface UserViewModel extends BaseModel<UserView> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user view model instance should use the {@link UserView} interface instead.
	 */

	/**
	 * Returns the primary key of this user view.
	 *
	 * @return the primary key of this user view
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user view.
	 *
	 * @param primaryKey the primary key of this user view
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this user view.
	 *
	 * @return the ID of this user view
	 */
	public long getId();

	/**
	 * Sets the ID of this user view.
	 *
	 * @param id the ID of this user view
	 */
	public void setId(long id);

	/**
	 * Returns the name of this user view.
	 *
	 * @return the name of this user view
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this user view.
	 *
	 * @param name the name of this user view
	 */
	public void setName(String name);

	/**
	 * Returns the email of this user view.
	 *
	 * @return the email of this user view
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this user view.
	 *
	 * @param email the email of this user view
	 */
	public void setEmail(String email);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(UserView userView);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserView> toCacheModel();

	@Override
	public UserView toEscapedModel();

	@Override
	public UserView toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}