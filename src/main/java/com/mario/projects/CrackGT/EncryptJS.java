package com.mario.projects.CrackGT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

/**
 * 
 * <p>
 * description: GeeTest 加密算法
 * </p>
 * 
 * @author MaXin
 * @since 2017年2月21日
 * @see
 */
public class EncryptJS {

    // http://api.geetest.com/ajax.php?gt=1d2c042096e050f07cb35ff3df5afd92&challenge=23f54ce0c69c061f1039d87db449f517aj&userresponse=9bb4bb4475ee&passtime=2389&imgload=442&a=9!)!)!)!)!)!)!*!)!)!*!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)!)(!!Jsts~stsstssysyssstssssssssssssssssssssstssssssssssssssssssssssstsssss((((((((((((((((((((((((((((((((((!!($)3:)9,4,*3/*5,6)-*4*-4*3?D82///-5,*4--4-3/.1-5229345821-6048$)S.2/5*/3,6$)k5*5*,5,-3*.7*6*70?$)5$)K,8-7HC$,J.:n$)Z9$4-&callback=geetest_1487582806692

    private static List<int[]> mouseList = new ArrayList<int[]>();

    /**
     * 
     * c = function(a) { for (var b, c, d, e = [], f = 0, g = [], h = 0, i =
     * a.length - 1; h < i; h++) b = Math.round(a[h + 1][0] - a[h][0]), c =
     * Math.round(a[h + 1][1] - a[h][1]), d = Math.round(a[h + 1][2] - a[h][2]),
     * g.push([b, c, d]), 0 == b && 0 == c && 0 == d || (0 == b && 0 == c ? f +=
     * d : (e.push([b, c, d + f]), f = 0)); return 0 !== f && e.push([b, c, f]),
     * e }
     * 
     * {(a,b,c),(d,e,f)}
     * <p>
     * description:
     * </p>
     * 
     * @return
     * @author Administrator
     * @see
     */

    // pass!!!!
    private static List<int[]> C(List<int[]> paramA) {
        int arraySize = paramA.size() - 1;
        int b = 0;
        int c = 0;
        int d = 0;
        int f = 0;
        // int h = 0;
        List<int[]> eList = new ArrayList<int[]>();
        List<int[]> gList = new ArrayList<int[]>();

        for (int i = 0; i < arraySize; i++) {
            b = Math.round(paramA.get(i + 1)[0] - paramA.get(i)[0]);
            c = Math.round(paramA.get(i + 1)[1] - paramA.get(i)[1]);
            d = Math.round(paramA.get(i + 1)[2] - paramA.get(i)[2]);
            gList.add(new int[] { b, c, d });
            if (b == 0 && c == 0 && d == 0) {
                continue;
            } else {
                if (b == 0 && c == 0) {
                    f += d;
                } else {
                    eList.add(new int[] { b, c, d + f });
                    f = 0;
                }
            }
        }
        if (f != 0) {
            eList.add(new int[] { b, c, f });
        }
        StringBuffer result = new StringBuffer();
        result.append("{");
        for (int[] is : eList) {
            result.append("(");
            for (int i : is) {
                result.append(i).append(",");
            }
            result.append("),");
        }
        return eList;
    }

    /**
     * 
     * d = function(a) { var b =
     * "()*,-./0123456789:?@ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqr", c =
     * b.length, d = "", e = Math.abs(a), f = parseInt(e / c); f >= c && (f = c
     * - 1), f && (d = b.charAt(f)), e %= c; var g = ""; return a < 0 && (g +=
     * "!"), d && (g += "$"), g + d + b.charAt(e) },
     * 
     * 
     * <p>
     * description:
     * </p>
     * 
     * @author Administrator
     * @see
     */

    // pass!!!!
    private static String D(int paramA) {
        String b = "()*,-./0123456789:?@ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqr";
        int c = b.length();
        String d = "";
        int e = Math.abs(paramA);
        int f = e / c;
        if (f >= c) {
            f = c - 1;
        }
        if (f > 0) {
            d = String.valueOf(b.charAt(f));
        }
        e %= c;

        String g = "";
        if (paramA < 0) {
            g += "!";
        }
        if (StringUtils.isNotBlank(d)) {
            g += "$";
        }

        String result = g + d + b.charAt(e);
        return result;
    }

    // e = function(a) {
    // for (var b = [
    // [1, 0],
    // [2, 0],
    // [1, -1],
    // [1, 1],
    // [0, 1],
    // [0, -1],
    // [3, 0],
    // [2, -1],
    // [2, 1]
    // ], c = "stuvwxyz~", d = 0, e = b.length; d < e; d++)
    // if (a[0] == b[d][0] && a[1] == b[d][1]) return c[d];
    // return 0
    // },

    private static String E(int[] paramA) {
        int[][] b = { { 1, 0 }, { 2, 0 }, { 1, -1 }, { 1, 1 }, { 0, 1 }, { 0, -1 }, { 3, 0 }, { 2, -1 }, { 2, 1 } };
        String c = "stuvwxyz~";
        for (int i = 0; i < b.length; i++) {
            if (paramA[0] == b[i][0] && paramA[1] == b[i][1]) {
                return String.valueOf(c.charAt(i));
            }
        }
        return "0";
    }

    // f = function(a) {
    // for (var b, f = c(Q.t("arr", a)), g = [], h = [], i = [], j = 0, k =
    // f.length; j < k; j++)
    // b = e(f[j]),
    // b ? h.push(b) : (g.push(d(f[j][0])), h.push(d(f[j][1]))),
    // i.push(d(f[j][2]));
    // g.join("") + "!!" + h.join("") + "!!" + i.join("")
    // return
    // };

    public static String F(List<int[]> paramA) {
        Preconditions.checkNotNull(paramA, "mouseMoveParamList must not be null!");
        initParamA(paramA);
        StringBuffer result = new StringBuffer();
        List<int[]> f = C(mouseList);
        StringBuffer gString = new StringBuffer();
        StringBuffer hString = new StringBuffer();
        StringBuffer iString = new StringBuffer();
        String b = StringUtils.EMPTY;
        for (int i = 0; i < f.size(); i++) {
            b = E(f.get(i));
            if (!"0".equals(b)) {
                hString.append(b);
            } else {
                gString.append(D(f.get(i)[0]));
                hString.append(D(f.get(i)[1]));
            }
            iString.append(D(f.get(i)[2]));
        }
        result.append(gString.toString()).append("!!").append(hString.toString()).append("!!").append(iString.toString());
        return result.toString();
    }

    // ba.ra = function(a, b) {
    // console.log("a:"+a);
    // console.log("b:"+b);
    // console.log("b.slice:"+b.slice(32));
    // for (var c = b.slice(32), d = [], e = 0; e < c.length; e++) {
    // var f = c.charCodeAt(e);
    // d[e] = f > 57 ? f - 87 : f - 48
    // }
    // c = 36 * d[0] + d[1];
    // var g = Math.round(a) + c;
    // b = b.slice(0, 32);
    // console.log("b:"+b);
    // var h, i = [
    // [],
    // [],
    // [],
    // [],
    // []
    // ],
    // j = {},
    // k = 0;
    // e = 0;
    // for (var l = b.length; e < l; e++)
    // h = b.charAt(e),
    // j[h] || (j[h] = 1,
    // i[k].push(h),
    // k++,
    // k = 5 == k ? 0 : k);
    // for (var m, n = g, o = 4, p = "", q = [1, 2, 5, 10, 50]; n > 0;)
    // n - q[o] >= 0 ? (m = parseInt(Math.random() * i[o].length, 10), p +=
    // i[o][m], n -= q[o]) : (i.splice(o, 1), q.splice(o, 1), o -= 1);
    // return p
    // };

    public static String ra(int a, String b) {
        System.out.println("challenge.length:"+b.length());
        String c = b.substring(32);
        int[] d = new int[b.length() - 32];
        for (int i = 0; i < c.length(); i++) {
            int f = c.codePointAt(i);
            d[i] = f > 57 ? f - 87 : f - 48;
        }
        int tempC = 36 * d[0] + d[1];
        int g = Math.round(a) + tempC;
        b = b.substring(0, 32);
        Object h;
        int k = 0, e = 0;
        List<List<Object>> i = new ArrayList<List<Object>>();
        Map<Object, String> j = new HashMap<Object, String>();
        for (int l = b.length(); e < l; e++) {
            h = b.charAt(e);
            if (StringUtils.isBlank(j.get(h))) {
                j.put(h, "1");
                if (i.size() == k) {
                    List<Object> temp = new ArrayList<Object>();
                    temp.add(h);
                    i.add(temp);
                } else {
                    i.get(k).add(h);
                }
                k++;
                if (k == 5) {
                    k = 0;
                }
            }
        }
        String p = StringUtils.EMPTY;
        List<Integer> q = new ArrayList<Integer>();
        q.add(1);
        q.add(2);
        q.add(5);
        q.add(10);
        q.add(50);
        for (int n = g, m = 0, o = 4; n > 0;) {
            if (n - q.get(o) >= 0) {
                m = (int) (Math.random() * i.get(o).size());
                p += i.get(o).get(m);
                n -= q.get(o);
            } else {
                i.remove(o);
                q.remove(o);
                o -= 1;
            }
        }
        return p;
    }

    
    public static String t(){
//        for (var c = b.slice(32), d = [], e = 0; e < c.length; e++) {
//            var f = c.charCodeAt(e);
//            d[e] = f > 57 ? f - 87 : f - 48
//        } c = 36 * d[0] + d[1];
//        var g = Math.round(a) + c; b = b.slice(0, 32);
//        var h, i = [[], [], [], [], []], j = {}, k = 0;
//        e = 0;
//        for (var l = b.length; l > e; e++)
//            h = b.charAt(e), j[h] || (j[h] = 1, i[k].push(h), k++ , k = 5 == k ? 0 : k);
//        for (var m, n = g, o = 4, p = "", q = [1, 2, 5, 10, 50]; n > 0;)
//            n - q[o] >= 0 ? (m = parseInt(Math.random() * i[o].length, 10),
//                p += i[o][m], n -= q[o]) : (i.splice(o, 1), q.splice(o, 1), o -= 1);
//        return p
        
        return "";
    }
    
    private static void initParamA(List<int[]> initList) {
        mouseList.addAll(initList);

    }

    private static void initParamA() {
        // 测试数据
        mouseList.add(new int[] { -24, -27, 0 });
        mouseList.add(new int[] { 0, 0, 0 });
        mouseList.add(new int[] { 1, 0, 140 });
        mouseList.add(new int[] { 7, -1, 190 });
        mouseList.add(new int[] { 18, -4, 222 });
        mouseList.add(new int[] { 29, -6, 262 });
        mouseList.add(new int[] { 42, -6, 320 });
        mouseList.add(new int[] { 48, -7, 363 });
        mouseList.add(new int[] { 50, -7, 393 });
        mouseList.add(new int[] { 51, -7, 434 });
        mouseList.add(new int[] { 52, -7, 474 });
        mouseList.add(new int[] { 53, -7, 560 });
        mouseList.add(new int[] { 54, -7, 718 });
        mouseList.add(new int[] { 55, -7, 767 });
        mouseList.add(new int[] { 56, -7, 866 });
        mouseList.add(new int[] { 57, -7, 920 });
        mouseList.add(new int[] { 58, -7, 966 });
        mouseList.add(new int[] { 60, -7, 1032 });
        mouseList.add(new int[] { 61, -7, 1069 });
        mouseList.add(new int[] { 62, -7, 1142 });
        mouseList.add(new int[] { 63, -7, 1228 });
        mouseList.add(new int[] { 65, -7, 1264 });
        mouseList.add(new int[] { 66, -7, 1308 });
        mouseList.add(new int[] { 67, -7, 1352 });
        mouseList.add(new int[] { 68, -7, 1440 });
        mouseList.add(new int[] { 68, -7, 1970 });
    }

    public static void main(String[] args) {

//        initParamA();
//        System.out.println(F(mouseList));
        System.out.println(ra(92, "2d1cb7c3893022b24a306238a03460f8"));
//        699313b2b367531bf699427a50bbd76e
        
//        1cdeca6cc818968e87638436647184e45f
        System.out.println("aaa3a777d8");
    }
}
