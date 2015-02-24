/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.wlsauthenticationtest;

import java.util.Map;
import javax.xml.ws.BindingProvider;
import webService.TestWs;
import webService.TestWsService;

/**
 *
 * @author Belgelerim
 */
public class tester {
    public static void main(String[] args) {
        TestWsService port = new TestWsService();
        TestWs soap = port.getTestWsPort();
        Map<String,Object> requestContext = ((BindingProvider)soap).getRequestContext();
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "wls");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "12341234");
        System.out.println(soap.test());
        
    }
}
