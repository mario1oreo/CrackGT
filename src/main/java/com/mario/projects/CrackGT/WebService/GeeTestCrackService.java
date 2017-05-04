package com.mario.projects.CrackGT.WebService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 *<p>
 *description: 极验验证码破解  外部调用入口service
 *</p>
 * @author MaXin
 * @since 2017-2-19 13:15:01
 * @see
 */
@WebService
public interface GeeTestCrackService {

    @WebMethod
    public String receiveParam();
    
    @WebMethod
    public String getJS();
}
