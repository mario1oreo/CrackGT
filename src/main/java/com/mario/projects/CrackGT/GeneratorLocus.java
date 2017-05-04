package com.mario.projects.CrackGT;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 * description: 极验验证码轨迹生成
 * </p>
 * 
 * @author MaXin
 * @since 2017年2月21日
 * @see
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class GeneratorLocus {

    private final static Logger logger = LoggerFactory.getLogger(GeneratorLocus.class);

    private static RandomLocusGenerator RANDOM;
    private static RandomLocusGenerator X_YN_RANDOM;
    private static RandomLocusGenerator X_INC_RANDOM;
    private static RandomLocusGenerator X_T_O_RANDOM;
    private static RandomLocusGenerator Y_YN_RANDOM;
    private static RandomLocusGenerator Y_INC_RANDOM;
    private static RandomLocusGenerator Y_M_RANDOM;
    private static RandomLocusGenerator T_S_RANDOM;
    private static RandomLocusGenerator T_M_RANDOM;
    private static RandomLocusGenerator T_E_RANDOM;

    static {

        List<Pair<Integer, Double>> RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        RANDOM_PAIR_LIST.add(Pair.create(1, 0.01));
        RANDOM_PAIR_LIST.add(Pair.create(2, 0.01));
        RANDOM_PAIR_LIST.add(Pair.create(3, 0.02));
        RANDOM_PAIR_LIST.add(Pair.create(4, 0.02));
        RANDOM_PAIR_LIST.add(Pair.create(5, 0.03));
        RANDOM_PAIR_LIST.add(Pair.create(6, 0.03));
        RANDOM_PAIR_LIST.add(Pair.create(7, 0.04));
        RANDOM_PAIR_LIST.add(Pair.create(8, 0.04));
        RANDOM_PAIR_LIST.add(Pair.create(9, 0.08));
        RANDOM_PAIR_LIST.add(Pair.create(10, 0.22));
        RANDOM_PAIR_LIST.add(Pair.create(11, 0.21));
        RANDOM_PAIR_LIST.add(Pair.create(12, 0.9));
        RANDOM_PAIR_LIST.add(Pair.create(13, 0.04));
        RANDOM_PAIR_LIST.add(Pair.create(14, 0.04));
        RANDOM_PAIR_LIST.add(Pair.create(15, 0.03));
        RANDOM_PAIR_LIST.add(Pair.create(16, 0.03));
        RANDOM_PAIR_LIST.add(Pair.create(17, 0.02));
        RANDOM_PAIR_LIST.add(Pair.create(18, 0.02));
        RANDOM_PAIR_LIST.add(Pair.create(19, 0.01));
        RANDOM_PAIR_LIST.add(Pair.create(20, 0.01));
        RANDOM = new RandomLocusGenerator(RANDOM_PAIR_LIST);

        List<Pair<Boolean, Double>> X_YN_RANDOM_PAIR_LIST = new ArrayList<Pair<Boolean, Double>>();
        X_YN_RANDOM_PAIR_LIST.add(Pair.create(true, 0.98));
        X_YN_RANDOM_PAIR_LIST.add(Pair.create(false, 0.02));
        X_YN_RANDOM = new RandomLocusGenerator(X_YN_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> X_INC_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        X_INC_RANDOM_PAIR_LIST.add(Pair.create(0, 0.03));
        X_INC_RANDOM_PAIR_LIST.add(Pair.create(1, 0.46));
        X_INC_RANDOM_PAIR_LIST.add(Pair.create(2, 0.27));
        X_INC_RANDOM_PAIR_LIST.add(Pair.create(3, 0.24));
        X_INC_RANDOM = new RandomLocusGenerator(X_INC_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> X_T_O_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        X_T_O_RANDOM_PAIR_LIST.add(Pair.create(6, 0.00));
        X_T_O_RANDOM_PAIR_LIST.add(Pair.create(7, 1.00));
        X_T_O_RANDOM = new RandomLocusGenerator(X_T_O_RANDOM_PAIR_LIST);

        List<Pair<Boolean, Double>> Y_YN_RANDOM_PAIR_LIST = new ArrayList<Pair<Boolean, Double>>();
        Y_YN_RANDOM_PAIR_LIST.add(Pair.create(false, 0.68));
        Y_YN_RANDOM_PAIR_LIST.add(Pair.create(true, 0.32));
        Y_YN_RANDOM = new RandomLocusGenerator(Y_YN_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> Y_INC_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        Y_INC_RANDOM_PAIR_LIST.add(Pair.create(0, 0.72));
        Y_INC_RANDOM_PAIR_LIST.add(Pair.create(1, 0.255));
        Y_INC_RANDOM_PAIR_LIST.add(Pair.create(2, 0.01));
        Y_INC_RANDOM_PAIR_LIST.add(Pair.create(3, 0.005));
        Y_INC_RANDOM = new RandomLocusGenerator(Y_INC_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> Y_M_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(1, 0.01));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(2, 0.05));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(3, 0.1));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(4, 0.15));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(5, 0.20));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(6, 0.20));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(7, 0.15));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(8, 0.05));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(9, 0.04));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(10, 0.03));
        Y_M_RANDOM_PAIR_LIST.add(Pair.create(11, 0.02));
        Y_M_RANDOM = new RandomLocusGenerator(Y_M_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> T_S_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        T_S_RANDOM_PAIR_LIST.add(Pair.create(40, 0.1));
        T_S_RANDOM_PAIR_LIST.add(Pair.create(50, 0.13));
        T_S_RANDOM_PAIR_LIST.add(Pair.create(60, 0.17));
        T_S_RANDOM_PAIR_LIST.add(Pair.create(70, 0.20));
        T_S_RANDOM_PAIR_LIST.add(Pair.create(80, 0.24));
        T_S_RANDOM_PAIR_LIST.add(Pair.create(90, 0.16));
        T_S_RANDOM = new RandomLocusGenerator(T_S_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> T_M_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        T_M_RANDOM_PAIR_LIST.add(Pair.create(1, 0.01));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(2, 0.05));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(3, 0.1));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(4, 0.15));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(5, 0.20));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(6, 0.20));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(7, 0.15));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(8, 0.05));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(9, 0.04));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(10, 0.03));
        T_M_RANDOM_PAIR_LIST.add(Pair.create(11, 0.02));
        T_M_RANDOM = new RandomLocusGenerator(T_M_RANDOM_PAIR_LIST);

        List<Pair<Integer, Double>> T_E_RANDOM_PAIR_LIST = new ArrayList<Pair<Integer, Double>>();
        T_E_RANDOM_PAIR_LIST.add(Pair.create(40, 0.35));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(70, 0.08));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(130, 0.12));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(190, 0.10));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(250, 0.10));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(310, 0.04));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(370, 0.02));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(430, 0.08));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(490, 0.05));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(550, 0.05));
        T_E_RANDOM_PAIR_LIST.add(Pair.create(610, 0.01));
        T_E_RANDOM = new RandomLocusGenerator(T_E_RANDOM_PAIR_LIST);
    }

    /**
     * 1.得到原图，背景图，并计算去扣除偏移量
     * 
     * 2.计算随机响应时间
     * 
     * 3.画出模拟轨迹
     * 
     * 4.加密返回响应时间和加密码
     * 
     */

    /**
     * 
     * <p>
     * description: 计算偏移量
     * </p>
     * 
     * @param imageFrontPath
     *            原图 可以是file/url
     * @param imageBGpath
     *            背景图 可以是file/url
     * @return offSet 偏移量
     * @author MaXin
     * @since 2017-2-21 16:56:32
     * @see
     */
    public static int countImageOffSet(String imageFrontPath, String imageBGpath) {
        int offSet = 0;
        if (StringUtils.isBlank(imageFrontPath) || StringUtils.isBlank(imageBGpath)) {
            logger.error("图片链接不能为空！");
            return offSet;
        }
        try {
            String frontImage = GeeTestImageHandle.getGeetestImg(imageFrontPath, GeeTestImageHandle.topLeftPointList);
            String BGImage = GeeTestImageHandle.getGeetestImg(imageBGpath, GeeTestImageHandle.topLeftPointList);
            offSet = GeeTestImageHandle.findXDiffRectangeOfTwoImage(frontImage, BGImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (offSet < 7) {
            return 0;
        }
        return offSet;
    }

    private static List<int[]> initList() {
        List<int[]> initList = new ArrayList<int[]>();
        initList.add(new int[] { -(Integer.valueOf(RANDOM.random().toString()) + 15), -(Integer.valueOf(RANDOM.random().toString()) + 13), 0 });
        initList.add(new int[] { 0, 0, 0 });
        return initList;
    }

    private static List<Integer> fillX(int imageOffSetPx) {
        List<Integer> list = new ArrayList<Integer>();
        int xmRandom = imageOffSetPx - Integer.valueOf(X_T_O_RANDOM.random().toString());
        if (xmRandom < 1) {
            xmRandom = imageOffSetPx;
        }
        for (int i = 0, x = i; true; i++) {
            if (Boolean.parseBoolean(X_YN_RANDOM.random().toString())) {
                x += Integer.valueOf(X_INC_RANDOM.random().toString());
                list.add(x);
                if (x == xmRandom || x == xmRandom - 1 || x == xmRandom + 1) {
                    break;
                }
            }
        }
        return list;
    }

    private static List<Integer> fillY(int length) {
        List<Integer> list = new ArrayList<Integer>();
        int ymRandom = Integer.valueOf(Y_M_RANDOM.random().toString());
        boolean upOrDown = Boolean.valueOf(Y_YN_RANDOM.random().toString());
        for (int i = 0, y = i; i < length; i++) {
            if (Boolean.valueOf(Y_YN_RANDOM.random().toString()) && (upOrDown && y < ymRandom || !upOrDown && -y < ymRandom)) {
                if (upOrDown) {
                    y += Integer.valueOf(Y_INC_RANDOM.random().toString());
                } else {
                    y -= Integer.valueOf(Y_INC_RANDOM.random().toString());
                }
            } else if (Boolean.valueOf(Y_YN_RANDOM.random().toString()) && !(upOrDown && y < ymRandom || !upOrDown && -y < ymRandom)) {
                upOrDown = !upOrDown;
            }
            list.add(y);
        }
        return list;
    }

    private static int countMaxTime(int length) {
        if (length < 90) {
            return 2000;
        } else if (length < 140) {
            return 2700;
        } else if (length < 190) {
            return 3500;
        } else {
            return 4000;
        }
    }

    private static List<Integer> fillT(int length) {
        List<Integer> list = new ArrayList<Integer>();
        int totalTime = 0;
        int maxTime = countMaxTime(length);
        for (int i = 0, k = i, m = length * 3 / 5, n = length * 3 / 4; k < length + 1; k++) {
             if (k < 3 || k < m || k > n - 1) {
                i = Integer.valueOf(T_M_RANDOM.random().toString());
            }else if (k < n) {
                i = Integer.valueOf(T_E_RANDOM.random().toString()) + Integer.valueOf(T_M_RANDOM.random().toString());
            }
            totalTime += i;
            list.add(totalTime);
            if (list.size() == length && totalTime > maxTime) {
                System.out.println("get TList retry one more time!");
                list.clear();
                totalTime = 0;
                k = 0;
            }
        }
        return list;
    }

    public static List<int[]> getMouseLocusList(String imageFrontPath, String imageBGpath) {
        int offSet = countImageOffSet(imageFrontPath, imageBGpath);
        return getMouseLocusList(offSet);
    }

    public static List<int[]> getMouseLocusList(int offSet) {
        List<int[]> initList = initList();
        List<Integer> listX = fillX(offSet);
        List<Integer> listY = fillY(listX.size());
        List<Integer> listT = fillT(listX.size());
        for (int i = 0; i < listX.size(); i++) {
            initList.add(new int[] { listX.get(i), listY.get(i), listT.get(i) });
        }
        return initList;
    }

    public static List<int[]> getMouseLocusListVersionA(int offSet) {
        List<int[]> initList = initList();
        initList.addAll(fillXYT(offSet));
        return initList;
    }

    private static List<int[]> fillXYT(int offSet) {
        List<int[]> list = new ArrayList<int[]>();
        int xmRandom = offSet - Integer.valueOf(X_T_O_RANDOM.random().toString());
        if (xmRandom < 1) {
            xmRandom = offSet;
        }
        boolean upOrDown = Boolean.valueOf(Y_YN_RANDOM.random().toString());
        for (int i = 0, x = i; true; i++) {
            if (Boolean.parseBoolean(X_YN_RANDOM.random().toString())) {
                int insX = Integer.valueOf(X_INC_RANDOM.random().toString());
                int insY = 0;
                int insT = 0;
                x += insX;
                if (insX == 0) {
                    insY = 1;
                    insT = Integer.valueOf(T_S_RANDOM.random().toString())+Integer.valueOf(T_M_RANDOM.random().toString());
                } else {
                    insY = Integer.valueOf(Y_INC_RANDOM.random().toString());
                    while (1 < (BigDecimal.valueOf(insY).divide(BigDecimal.valueOf(insX),2,BigDecimal.ROUND_HALF_UP).doubleValue())) {
                        insY = Integer.valueOf(Y_INC_RANDOM.random().toString());
                    }
                }
                if (x == xmRandom || x == xmRandom - 1 || x == xmRandom + 1) {
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<int[]> initList = initList();
        List<Integer> listX = fillX(69);
        List<Integer> listY = fillY(listX.size());
        List<Integer> listT = fillT(listX.size());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < initList.size(); i++) {
            sb.append("(");
            sb.append(initList.get(i)[0]).append(",")
                    .append(initList.get(i)[1]).append(",")
                    .append(initList.get(i)[2]).append(")\n");
        }
        for (int j = 0; j < listX.size(); j++) {
            sb.append("(").append(listX.get(j)).append(",")
                    .append(listY.get(j)).append(",")
                    .append(listT.get(j)).append(")\n");
        }
        System.out.println("t:" + sb.toString());
        System.out.println("list.size:" + listT.size());
    }

}
