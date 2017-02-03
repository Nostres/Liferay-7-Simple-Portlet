package com.simple.controller;


import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.simple.model.UserView;
import com.simple.transfromer.impl.UserViewTransformer;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Simple Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
        },
        service = Portlet.class
)
public class SimplePortlet extends MVCPortlet {

        @Override
        public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
                UserViewTransformer userViewTransformer = new UserViewTransformer();
                List<User> userList = UserLocalServiceUtil.getUsers(0, 20);
                List<UserView> userViewsList = new ArrayList<>();
                userList.forEach(item -> userViewsList.add(userViewTransformer.convert(item)));

                renderRequest.setAttribute("userList", userViewsList);
                super.render(renderRequest, renderResponse);
        }
}