package one_question_a_day.june;

public class C6_23环形链表 {
    /**
     * 找出链表存在的一个环
     * @param head 链表的头
     * @return
     */
    public ListNode detectCycle(ListNode head) {
//        定义两个指针，一个快指针一个慢指针。快指针每次移动两个位置，慢指针每次移动一个位置。
//        如果有环的话那么他们就会在环内相遇，这样的话就能够达到一个效果，就相当于每次快指针每次比慢指针移动了一个位置
//        如果不是环的话那么慢指针到头也遇不到快指针，但是如果是一个环的话，那么他们一定能够在环内相遇，（从后面赶上）
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != null){
            fast = fast.next;
            slow = slow.next.next;
            if (fast == slow){  // 两个指针相遇了
                //说明成环了
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 == index2){
                    // 给定一个结点从头开始，一个节点在fast位置然后一起移动。他们相遇的位置就是圈的起点，数学证明
                    index2 = index2.next;
                    index1 = index1.next;
                }
                return index1;  // 返回相遇的位置
            }
        }
        return null;
    }
}
