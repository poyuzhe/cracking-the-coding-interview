package com.stmartin;

import com.stmartin.utility.LinkedListNode;

/**
 * Created by martinshen on 2017/9/30.
 * Delete middle node: remove a node from the middle (not first or last node), given only access to that node.
 */
class DeleteMiddleNode {
    static void deleteMiddleNode(LinkedListNode node) {
        assert (node.next != null);
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
