package mytree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTreeImpl implements MyTree {

    public Node root = null;


    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node temp = root;
            Node parent = null;
            while (temp != null) {
                parent = temp;
                if (temp.getKey() > key) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
            if (parent.getKey() > key) {
                parent.setLeft(new Node(key));
                parent.getLeft().setParent(parent);
            } else {
                parent.setRight(new Node(key));
                parent.getRight().setParent(parent);
            }


        }
    }


    public Node search(int key) {
        Node temp = root;
        while (temp != null && temp.getKey() != key) {
            temp = temp.getKey() > key ?
                    temp.getLeft() : temp.getRight();
        }
        return temp;
    }


    public Node min() {
        Node minNode = root;
        while (minNode.getLeft() != null) {
            minNode = minNode.getLeft();
        }
        log.info("MIN: {}", minNode.getKey());
        return minNode;
    }


    public Node max() {
        Node maxNode = root;
        while (maxNode.getRight() != null) {
            maxNode = maxNode.getRight();
        }
        log.info("MAX: {}", maxNode.getKey());
        return maxNode;
    }


    public Node remove(int key) throws Exception {
        Node nodeToRemove = this.search(key);
        Node parentOfNodeToRemove = nodeToRemove.getParent();
        Node temp;
        if (nodeToRemove.getLeft() != null &&
                nodeToRemove.getRight() != null) {
            temp = this.remove(this.sucessor(key).key);
            temp.setLeft(nodeToRemove.getLeft());
            if (temp.getLeft() != null)
                temp.getLeft().setParent(temp);
            temp.setRight(nodeToRemove.right);
            if (temp.getRight() != null)
                temp.getRight().setParent(temp);
        } else
            temp = nodeToRemove.getLeft() != null ?
                    nodeToRemove.getLeft() : nodeToRemove.getRight();
        if (temp != null) {
            nodeToRemove.setParent(parentOfNodeToRemove);
        }
        if (parentOfNodeToRemove == null) {
            root = temp;
        } else if (parentOfNodeToRemove.getLeft() == nodeToRemove) {
            parentOfNodeToRemove.setLeft(temp);
        } else {
            parentOfNodeToRemove.setRight(temp);
        }
        return nodeToRemove;
    }

    public void showInOrder() {

    }

    public void showPreOrder(Node node) {
        if(node != null) {

            System.out.print(node.getKey() + ", ");
            if(node.getLeft() != null) {
                System.out.print(node.getLeft().getKey() + ", ");
            } else  System.out.print("-"+ ", ");
            if(node.getRight() != null) {
                System.out.println(node.getRight().getKey()+ ", ");
            } else  System.out.println("-");
            showPreOrder(node.getLeft());
            showPreOrder(node.getRight());
        }
    }

    public void showPostOrder(Node node) {
        if(node != null) {
            showPostOrder(node.getLeft());//rekurencja zejdzie najdalej na dol w lewo i jak bedzie juz null to wroci na gore
            showPostOrder(node.getRight());//rekurencja zejdzie najdalej w dol po prawej i jak bedzie null to zacznie wracac

            System.out.print(node.getKey() + ", ");//wyswietlanie
            if (node.getLeft() != null) {
                System.out.print(node.getLeft().getKey() + ", ");//schodzi najdalej w dol i lewo i wyswietla
            } else System.out.print("-" + ", ");//natrafia na nulla i wyswietla -
            if (node.getRight() != null) {
                System.out.println(node.getRight().getKey() + ", ");//schodzi najdalej w dol i prawo i wyswietla
            } else System.out.println("-");//natrafia na nulla i wyswietla -


        }
    }

    private Node sucessor(int key) throws Exception {
        Node node = this.search(key);

        if (node.getRight() != null) {
            node = node.getRight();
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        } else if (node.getRight() == null && node !=
                this.root && node != this.max()) {
            Node parent = node.getParent();
            while (parent != root && parent.getKey() < node.getKey()) {
                parent = parent.getParent();
            }
            return parent;
        } else throw new Exception("NIE MA");
    }



    public void showInOrder(Node node) {

        if(node != null) {
            showInOrder(node.getLeft());
            log.info("KEY VALUE: {}",node.key);
            showInOrder(node.getRight());
        }
    }





    }
