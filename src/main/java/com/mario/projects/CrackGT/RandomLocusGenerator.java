package com.mario.projects.CrackGT;

import com.google.common.base.Preconditions;
import org.apache.commons.math3.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class RandomLocusGenerator<K, V extends Number> {

    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();
    private static final Logger logger = LoggerFactory.getLogger(RandomLocusGenerator.class);

    public RandomLocusGenerator(List<Pair<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();// 统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());// 权重累加
        }
    }
    
    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        String nameA = "AAAAA";
        String nameB = "BBBBB";
        String nameC = "CCCCC";
        String nameD = "DDDDD";
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put(nameA, 0);
        result.put(nameB, 0);
        result.put(nameC, 0);
        result.put(nameD, 0);
        List<Pair> list = new ArrayList<Pair>();
        list.add(Pair.create(nameA, 0.05));
        list.add(Pair.create(nameB, 0.2));
        list.add(Pair.create(nameC, 0.35));
        list.add(Pair.create(nameD, 0.4));
        RandomLocusGenerator<?, ?> locus = new RandomLocusGenerator(list);
        for (int i = 0; i < 100000000; i++) {
            String tempKey = locus.random().toString();
            result.put(tempKey, result.get(tempKey) + 1);
        }
        Iterator<String> iterator = result.keySet().iterator();
        logger.info("name:\t\ttimes");
        while (iterator.hasNext()) {
            String key = iterator.next();
            logger.info(key + "\t\t" + result.get(key));
        }
    }

}
