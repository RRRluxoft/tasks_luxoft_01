package home.code.task.roman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

/**
 * Date: 03.06.2018
 */
public class BinaryTree {
    BinaryTreeNode root;
    BinaryTreeNode left;
    BinaryTreeNode right;

    /**
     * visits all the nodes of a level before going to the next level
     * @return an array of extracted values of BTN
     */
    private Object[] traverseLevelByLevel() {
        List<Integer> extractedValues = new ArrayList<>();
        if (null == root) {
            return new Object[]{};
        }

        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            BinaryTreeNode binaryTreeNode = nodes.remove();
            extractedValues.add(binaryTreeNode.val);

            Optional.ofNullable(binaryTreeNode.left).ifPresent(nodes::add);
            Optional.ofNullable(binaryTreeNode.right).ifPresent(nodes::add);

        }
        return extractedValues.toArray();
    }

    private BinaryTreeNode add(BinaryTreeNode node, int value) {
        if (Objects.isNull(node)) {
            return new BinaryTreeNode(value);
        }

        if (value < node.val) {
            node.left = add(node.left, value);
        } else if (value > node.val) {
            node.right = add(node.right, value);
        } else {
            return node;
        }

        return node;
    }

    /**
     * I have implemented add element into Binary way ...
     * @param value
     */
    public void add(int value) {
        root = add(root, value);
    }

    /**
     *  method to compare 2 such trees (returns: true if fully equal, false - otherwise)
     * @param tree
     * @return true if fully equal, false - otherwise
     */
    public boolean compare(BinaryTree tree) {
        if (this.root.val != tree.root.val) {
            return false;
        }
        if (this.theSmallestVal(this.root) != tree.theSmallestVal(tree.root)) {
            return false;
        }
        return Arrays.deepEquals(traverseLevelByLevel(), tree.traverseLevelByLevel());
    }




    private boolean containBinaryTreeNode(BinaryTreeNode curr, int value) {
        if (curr == null) {
            return false;
        }

        if (value == curr.val) {
            return true;
        }

        return value < curr.val ? containBinaryTreeNode(curr.left, value) : containBinaryTreeNode(curr.right, value);
    }

    private int theSmallestVal(BinaryTreeNode root) {
        return root.left == null ? root.val : theSmallestVal(root.left);
    }

    private BinaryTreeNode extractChildRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.val) {
            current.left = extractChildRecursive(current.left, value);
            return current;
        }

        if (value > current.val) {
            current.right = extractChildRecursive(current.right, value);
            return current;
        }

        current = extractChildRecursive(current, value);
        return current;
    }

}
