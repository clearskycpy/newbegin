package one_question_a_day.august;


import java.util.*;

public class C8_12用户分组 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
//        使用map将对应的大小的下标存下来然后遍历map
        Map<Integer,List<Integer>> groupNum = new HashMap<>();
        for(int i = 0 ; i < groupSizes.length; i++){
            if (!groupNum.containsKey(groupSizes[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                groupNum.put(groupSizes[i],list);
            }else {
                List<Integer> list = groupNum.get(groupSizes[i]);
                list.add(i);
                groupNum.put(groupSizes[i],list);
            }

        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> keySet = groupNum.keySet();
        /*for(Integer k : keySet){
//             经过检测，前半段是没有问题的
            System.out.println("key --------->"+k);
            System.out.println("size :::"+groupNum.get(k).size());
            List<Integer> list = groupNum.get(k);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));

            }
        }*/
        for(Integer key : keySet){
//            遍历所有的key ，通过key 拿到 组大小相同的所有元素的下标 list
            List<Integer> list = groupNum.get(key);
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Integer add = list.get(i);
                System.out.println(add);
                temp.add(add);
                if (temp.size() == key){
                    result.add(temp);
                    temp = new ArrayList<>();
//                    temp.clear();
                }
            }
        }
        return result;
    }
}
