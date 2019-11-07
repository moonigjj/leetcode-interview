/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package structure;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: Node.java, v 0.1 2019-10-25 10:14 tangyue Exp $$
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node() {

    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
