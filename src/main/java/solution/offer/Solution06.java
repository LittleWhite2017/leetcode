package solution.offer;

import solution.Main;
import struct.ListNode;

import java.util.Arrays;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution06 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(reversePrint(Main.getNode())));
    }

    public static int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int[] res = new int[count];
        while (head != null) {
            res[count - 1] = head.val;
            count--;
            head = head.next;
        }
        return res;
    }
}
