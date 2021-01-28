package p423;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.computeIfAbsent(c, (x) -> 0) + 1);
        }
        List<Character> list = new ArrayList<>();

        while (map.getOrDefault('z', 0) > 0) {
            list.add('0');
            map.put('z', map.get('z') - 1);
            map.put('e', map.get('e') - 1);
            map.put('r', map.get('r') - 1);
            map.put('o', map.get('o') - 1);
        }

        while (map.getOrDefault('w', 0) > 0) {
            list.add('2');
            map.put('t', map.get('t') - 1);
            map.put('w', map.get('w') - 1);
            map.put('o', map.get('o') - 1);
        }

        while (map.getOrDefault('u', 0) > 0) {
            list.add('4');
            map.put('f', map.get('f') - 1);
            map.put('o', map.get('o') - 1);
            map.put('u', map.get('u') - 1);
            map.put('r', map.get('r') - 1);
        }

        while (map.getOrDefault('x', 0) > 0) {
            list.add('6');
            map.put('s', map.get('s') - 1);
            map.put('i', map.get('i') - 1);
            map.put('x', map.get('x') - 1);
        }
        while (map.getOrDefault('g', 0) > 0) {
            list.add('8');
            map.put('e', map.get('e') - 1);
            map.put('i', map.get('i') - 1);
            map.put('g', map.get('g') - 1);
            map.put('h', map.get('h') - 1);
            map.put('t', map.get('t') - 1);
        }
        while (map.getOrDefault('h', 0) > 0) {
            list.add('3');
            map.put('t', map.get('t') - 1);
            map.put('h', map.get('h') - 1);
            map.put('r', map.get('r') - 1);
            map.put('e', map.get('e') - 2);
        }
        while (map.getOrDefault('f', 0) > 0) {
            list.add('5');
            map.put('f', map.get('f') - 1);
            map.put('i', map.get('i') - 1);
            map.put('v', map.get('v') - 1);
            map.put('e', map.get('e') - 1);
        }
        while (map.getOrDefault('v', 0) > 0) {
            list.add('7');
            map.put('s', map.get('s') - 1);
            map.put('e', map.get('e') - 2);
            map.put('v', map.get('v') - 1);
            map.put('n', map.get('n') - 1);
        }
        while (map.getOrDefault('i', 0) > 0) {
            list.add('9');
            map.put('n', map.get('n') - 1);
            map.put('i', map.get('i') - 1);
            map.put('n', map.get('n') - 1);
            map.put('e', map.get('e') - 1);
        }
        while (map.getOrDefault('o', 0) > 0) {
            list.add('1');
            map.put('o', map.get('o') - 1);
            map.put('n', map.get('n') - 1);
            map.put('e', map.get('e') - 1);
        }

        list.sort(Character::compareTo);
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }
}
