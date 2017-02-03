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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserViewSoap implements Serializable {
	public static UserViewSoap toSoapModel(UserView model) {
		UserViewSoap soapModel = new UserViewSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static UserViewSoap[] toSoapModels(UserView[] models) {
		UserViewSoap[] soapModels = new UserViewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserViewSoap[][] toSoapModels(UserView[][] models) {
		UserViewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserViewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserViewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserViewSoap[] toSoapModels(List<UserView> models) {
		List<UserViewSoap> soapModels = new ArrayList<UserViewSoap>(models.size());

		for (UserView model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserViewSoap[soapModels.size()]);
	}

	public UserViewSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _id;
	private String _name;
	private String _email;
}