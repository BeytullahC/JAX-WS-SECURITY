/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.beto.test.wls.authentication.user;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Belgelerim
 */
@WebService
public class TestWs {
    @WebMethod
    public String test(){
        return "YOU ARE VALID USER";
    }
}
