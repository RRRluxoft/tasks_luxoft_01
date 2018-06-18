package home.code.task.roman;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

/**
 * Date: 03.06.2018
 */
public class BinaryTreeNode implements Comparable<BinaryTreeNode> {
    final int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(final BinaryTreeNode obj) {
        if(this.val == obj.val) {
            return 0;
        }
        if (this.val > obj.val) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (Objects.isNull(obj) || getClass() != obj.getClass()) {
            return false;
        }

        BinaryTreeNode binaryTreeNode = (BinaryTreeNode) obj;

        return new EqualsBuilder()
            .append(val, binaryTreeNode.val)
            .append(left, binaryTreeNode.left)
            .append(right, binaryTreeNode.right)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(val)
            .append(left)
            .append(right)
            .toHashCode();
    }
}
