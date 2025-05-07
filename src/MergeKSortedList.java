public class MergeKSortedList {

    /**
     * https://leetcode.com/problems/merge-k-sorted-lists/description/
     * */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }
    ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        else if (start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = mergeKLists(lists, start, mid);
            ListNode l2 = mergeKLists(lists, mid + 1, end);
            return mergeLists(l1, l2);
        }else{
            return null;
        }
    }

    ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }
}
