package one_question_a_day.may;

import java.util.HashSet;
import java.util.Set;

public class C5_14移除重复结点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode begin = head;
        set.add(begin.val);
        while(begin.next != null){
            if (set.contains(begin.next.val)){
                // 存在的情况
                begin.next = begin.next.next;
            }else {
                set.add(begin.next.val);
                begin = begin.next;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
