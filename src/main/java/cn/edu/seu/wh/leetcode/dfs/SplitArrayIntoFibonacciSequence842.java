package cn.edu.seu.wh.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

// leetcode 842
// 将数组拆分成斐波那契序列
public class SplitArrayIntoFibonacciSequence842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if(null == S || 0 == S.length()){
            return res;
        }
        backTrack(res, S, 0, 0, 0);
        return res;
    }

    private boolean backTrack(List<Integer> list, String S, int start,int prev, int sum){
        if(start == S.length()){
            return list.size() >= 3;
        }

        long curLong = 0;
        for(int i = start; i < S.length(); i++){
            if(i > start && S.charAt(start) == '0'){
                break;
            }
            curLong = curLong * 10 + S.charAt(i) - '0';
            if(curLong > Integer.MAX_VALUE){
                break;
            }
            int cur = (int)curLong;
            if(list.size() >= 2){
                if(cur > sum){
                    break;
                }
                if(cur < sum){
                    continue;
                }
            }
            list.add(cur);
            if(backTrack(list, S, i+1, cur, cur + prev)){
                return true;
            }else{
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence842 splitArrayIntoFibonacciSequence842 = new SplitArrayIntoFibonacciSequence842();
        splitArrayIntoFibonacciSequence842.splitIntoFibonacci("123456579");
    }
}
