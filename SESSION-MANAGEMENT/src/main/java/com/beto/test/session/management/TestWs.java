/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.test.session.management;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author Belgelerim
 */
@WebService(
        name = "Test",
        portName = "TestPort",
        serviceName = "TestService",
        targetNamespace = "http://test.org/wsdl"
)
public class TestWs {

    @Resource
    private WebServiceContext wsc;

    private Set clients;	// For storing our session ids from clients

    private String getClientID() {
        HttpServletRequest req = (HttpServletRequest) wsc.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpSession session = req.getSession();
        return session.getId();
    }

    public TestWs() {
        clients = new HashSet();
    }

    @WebMethod
    public String printSessionInfo() {
        System.out.println("endpoint invoked, checking session id of client");
        String id = getClientID();
        System.out.println(" looking up session id: " + id);
        boolean idExists = clients.contains(id);
        if (idExists) {
            System.out.println("found session id: " + id);
            return "Same session, id is " + id;
        } else {
            System.out.println("storing session id: " + id);
            clients.add(id);
            return "New session, id is " + id;
        }
    }
}
