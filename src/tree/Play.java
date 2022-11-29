package tree;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        while (true) {
            System.out.println("1.Insert 2.전위순회 3.중위순회 4.후위순회 5.검색 6.삭제 7.종료");
            int n = sc.nextInt();
            if (n == 7) {
                break;
            }
            switch (n) {

                case 1:
                    System.out.println("넣을 값을 입력해주세요.");
                    int data = sc.nextInt();
                    bt.insert(data);
                    break;
                case 2:
                    bt.preOrder(bt.rootNode);
                    break;
                case 3:
                    bt.inOrder(bt.rootNode);
                    break;
                case 4:
                    bt.postOrder(bt.rootNode);
                    break;
                case 5:
                    System.out.println("검색할 값을 입력해주세요.");
                    int searchData = sc.nextInt();
                    bt.search(searchData);
                    break;
                case 6:
                    int deleteData = sc.nextInt();
                    bt.delete(deleteData);
                    break;
                default:
                    System.out.println("선택을 다시해주세요.");
            }
        }
    }
}
