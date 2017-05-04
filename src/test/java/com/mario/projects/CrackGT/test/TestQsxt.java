package com.mario.projects.CrackGT.test;

import com.virjar.dungproxy.client.ippool.IpPoolHolder;
import com.virjar.dungproxy.client.ippool.config.DungProxyContext;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.HeaderGroup;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.mario.projects.CrackGT.CrackGeeTest;
import com.mario.projects.CrackGT.EncryptJS;
import com.virjar.dungproxy.client.httpclient.HttpInvoker;

/**
 * 
 * <p>
 * description:企业信息公示系统打码
 * </p>
 * 
 * @author MaXin
 * @since 2017年2月23日
 * @see
 */
public class TestQsxt {
    public static void main(String[] args) {
        IpPoolHolder.init(DungProxyContext.create().setPoolEnabled(false));

        // 获取极验验证码基础信息
        String url = "http://www.gsxt.gov.cn/SearchItemCaptcha?v=" + System.currentTimeMillis();
        System.out.println(url);
        String ret = HttpInvoker.get(url);
        System.out.println("初始化响应" + ret);
        if (StringUtils.contains(ret, "false")) {
            System.out.println(ret);
            return;
        }
        JSONObject retObj = JSONObject.parseObject(ret);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gt", retObj.getString("gt"));// 必传
        jsonObject.put("challenge", retObj.getString("challenge"));// 某些场景可以不传
        jsonObject.put("product", "popup");// 产品类型,三种选择,见极验官网
        jsonObject.put("referer", "http://www.gsxt.gov.cn/corp-query-homepage.html");// 必传
        jsonObject.put("isHttps", false);// 是否是https
        jsonObject.put("offline", true);// 是否是离线打码(确认是否是离线可以观察拖动滑块的时候,是否发出网络请求)
        // callback:"geetest_1487777453804"
        jsonObject.put("callback", "geetest_" + System.currentTimeMillis());

        StringBuffer getImageUrl = new StringBuffer();
        long t = System.currentTimeMillis();
        getImageUrl.append("http://api.geetest.com/get.php?gt=").append(retObj.getString("gt"))
                .append("&challenge=").append(retObj.getString("challenge"))
                .append("&product=popup&offline=false&protocol=&path=/static/js/geetest.5.10.0.js&type=slide")
                .append("&callback=geetest_").append(t);
        String getImage = HttpInvoker.get(getImageUrl.toString());
        System.out.println("getImage响应:" + getImage);
        JSONObject getImageObj = JSONObject.parseObject(getImage.substring(getImage.indexOf("(") + 1, getImage.lastIndexOf(")")));

        String staticServer = "http://static.geetest.com/";
        long start = System.currentTimeMillis();
        
        Map<String, String> result = CrackGeeTest.crackGT(staticServer + getImageObj.getString("fullbg"), staticServer + getImageObj.getString("bg"), getImageObj.getString("challenge"));
        
        System.out.println("CrackGeeTest耗时:" + (System.currentTimeMillis() - start) + "ms");
        long start1 = System.currentTimeMillis();

        StringBuffer crackGTUrl = new StringBuffer();
        crackGTUrl.append("http://api.geetest.com/ajax.php?gt=").append(retObj.getString("gt"))
                .append("&challenge=").append(getImageObj.getString("challenge"))
                .append("&userresponse=").append(result.get("userresponse"))
                .append("&passtime=").append(result.get("passtime"))
                .append("&imgload=").append(RandomUtils.nextInt(70, 150))
                .append("&a=").append(result.get("a"))
                .append("&callback=geetest_").append(t);
        System.out.println("crackGTUrl:\t" + crackGTUrl.toString());
        List<Header> headerGroup = Lists.newArrayList();
        headerGroup.add(new BasicHeader("referer", "http://www.gsxt.gov.cn/corp-query-homepage.html"));
        headerGroup.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36"));
        String crackGT = HttpInvoker.get(crackGTUrl.toString(), headerGroup.toArray(new Header[] {}));
        System.out.println("crackGT响应:" + crackGT);

        // http://api.geetest.com/ajax.php?
        // gt=1d2c042096e050f07cb35ff3df5afd92
        // &challenge=22097defc43c2fa71eb84befd1f57de9m6
        // &userresponse=d5353d53d353553555cff
        // &passtime=3587
        // &imgload=121
        // &a=H3?@73020(!!Os)***(tts(((ysstssss(!!($**UZJTUc$)($*rZNRa$),$1HV$-U$)a$5Xa$62
        // &callback=geetest_1487779426306

    }
}
