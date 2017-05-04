package com.mario.projects.CrackGT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CrackGeeTest {

    public static Map<String, String> crackGT(String frontImagePath, String bgImagePath, String challenge) {
        Map<String, String> result = new HashMap<String, String>();
        int offSet = GeneratorLocus.countImageOffSet(frontImagePath, bgImagePath);
        List<int[]> mouseList = GeneratorLocus.getMouseLocusList(offSet);
        StringBuffer sb = new StringBuffer();
        for (int[] is : mouseList) {
            sb.append("(").append(is[0]).append(",")
                    .append(is[1]).append(",")
                    .append(is[2]).append(")");
            if (sb.length() % 30 < 7) {
                sb.append("\n");
            }
        }
        System.out.println(mouseList.size()+";mouse locus :\n"+sb.toString()+"\noffset:"+offSet);
        int passtime = mouseList.get(mouseList.size() - 1)[2];
        result.put("a", EncryptJS.F(mouseList));
        result.put("userresponse", EncryptJS.ra(offSet-7, challenge));
        result.put("passtime", String.valueOf(passtime));
        return result;
    }

    public static void main(String[] args) {
        String frontImagePath = "http://static.geetest.com/pictures/gt/9f9cff207/9f9cff207.jpg";
        String bgImagePath = "http://static.geetest.com/pictures/gt/9f9cff207/bg/430cd36c0.jpg";
        Map<String, String> result = CrackGeeTest.crackGT(frontImagePath, bgImagePath, "8d0c43e1e210b0fb53cb03ecaecc1e37dw");
        Set<String> keySet = result.keySet();
        for (String key : keySet) {
            System.out.println(key + ":" + result.get(key));
        }
    }

}
