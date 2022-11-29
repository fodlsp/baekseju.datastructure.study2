package tree;

public class BinaryTree {
    Node rootNode = null;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (rootNode == null) {
            this.rootNode = newNode;
        } else {
            Node head = rootNode;
            Node currentNode;
            while (true) {
                currentNode = head;

                if (head.getData() > data) {
                    head = head.getLeft();

                    if (head == null) {
                        currentNode.setLeft(newNode);
                        break;
                    }
                } else if (head.getData() < data) {
                    head = head.getRight();

                    if (head == null) {
                        currentNode.setRight(newNode);
                        break;
                    }
                }
            }
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getData());
        inOrder(node.getRight());

    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getData());

    }

    public void delete(int data) {
        if (rootNode == null) {
            System.out.println("생성되어 있는 노드가 없습니다.");
            return;
        }
        Node findNode = rootNode;
        boolean search = false;
        Node parent = null;

        while (findNode != null) {
            if (findNode.getData() == data) {
                search = true;
                break;
            } else if (findNode.getData() > data) {
                parent = findNode;
                findNode = findNode.getLeft();

            } else if (findNode.getData() < data) {
                parent = findNode;
                findNode = findNode.getRight();
            }
        }
        if (!search) {
            System.out.println("찾으려는 노드가 없습니다.");
            return;
        }
        //1번째 경우
        if(findNode.getLeft() == null && findNode.getRight() == null){
            if(findNode == rootNode){
                rootNode = null;
                return;
            }
           if(parent.getLeft() == findNode){
               parent.setLeft(null);
           }else {
               parent.setRight(null);
           }
        }
        //2번째 경우
        else if(findNode.getLeft() == null || findNode.getRight() == null ){
            Node childNode = null;
            if(findNode.getLeft() == null){
                childNode = findNode.getRight();

            }else{
                childNode = findNode.getLeft();
            }

            if(findNode == rootNode){
                rootNode = childNode;
                return;
            }

            if(parent.getLeft() == findNode){
                parent.setLeft(childNode);
            }else{
                parent.setRight(childNode);
            }
        }
        //3번째 경우
         else {
            Node childNode = findNode.getRight();
            Node saveNode = findNode;
            if(childNode.getLeft() == null){
                findNode.setData(childNode.getData());
                findNode.setRight(childNode.getRight());
            }else {
                while (childNode.getLeft() != null) {
                    saveNode = childNode;
                    childNode = childNode.getLeft();
                }
                findNode.setData(childNode.getData());
                saveNode.setLeft(childNode.getRight());
            }
        }
    }


    public Node search(int data) {

        if (rootNode == null) {
            System.out.println("노드가 없습니다.");
        } else {
            Node head = rootNode;
            while (head != null) {

                if (head.getData() == data) {
                    return head;
                } else if (head.getData() > data) {
                    head = head.getLeft();

                } else if (head.getData() < data) {
                    head = head.getRight();
                }
            }
        }
        return null;
    }
}
