package com.mario.projects.CrackGT.WebServiceImpl;

import javax.jws.WebService;

import com.mario.projects.CrackGT.WebService.GeeTestCrackService;

/**
 * 
 *<p>
 *description: 极验验证码破解  外部调用入口serviceImpl
 *</p>
 * @author MaXin
 * @since 2017-2-19 13:15:01
 * @see
 */

@WebService
public class GeeTestCrackServiceImpl implements GeeTestCrackService {

    public String receiveParam() {
        return "receiveParam";
    }

    public String getJS() {
        return "getJS";
    }

}
