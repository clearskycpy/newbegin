package one_question_a_day.june;

public class C6_19合并有序链表 {
    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode res = head;
        while(list1 != null || list2 != null){
// 记得处理一下空指针
            if (list1 == null ){
                head.next = list2;
                list2 = list2.next;  // 遍历下一个结点
                head = head.next;
                continue;
            }
            if (list2 == null){
                head.next = list1;
                list1 = list1.next;  // 遍历下一个结点
                head = head.next;
                continue;
            }
            if (list1.val > list2.val){
//                此时二小于一 ，挪动二
                head.next = list2;
                list2 = list2.next;  // 遍历下一个结点
                head = head.next;
            }else {
                head.next = list1;
                list1 = list1.next;  // 遍历下一个结点
                head = head.next;
            }
        }
        return  res.next;
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = head.next;
        head.next = swapPairs(newNode.next);
        newNode.next = head;
        return newNode;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
