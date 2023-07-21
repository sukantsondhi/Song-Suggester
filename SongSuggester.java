import java.util.*;

class TreeNode {
    
    boolean leaf;
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value) {
        this.leaf = true;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.leaf = false;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) { this.value = value; }

    public void setLeft(TreeNode left) { this.left = left; }

    public void setRight(TreeNode right) { this.right = right; }

    public TreeNode getLeft() { return this.left; }

    public TreeNode getRight() { return this.right; }

    public boolean isLeaf() { return this.leaf; }

    

    public void print() {
        System.out.println(this.value);
        if (this.left != null) {
            this.left.print();
        }

        if (this.right != null) {
            this.right.print();
        }
    }
}

class SongSuggester {

    public static Scanner scanner = new Scanner(System.in);

    public static boolean askYesNo(String user_input) {

        
        System.out.println(user_input + " [y/n]");
        String user_input1 = scanner.nextLine();

        if (user_input1.equals("y")) {
            return true;
        }

        else {
            return false;
        }
    }

    public static void saveTree(TreeNode treeName) {

        boolean saveTree = askYesNo("Do you want to save the current tree?");
    }

    public static void playGame(TreeNode songTree) {

        
        boolean playGame = true;  


        do {                        

            TreeNode cur = songTree;

            while (!cur.isLeaf()) {

                
                boolean answer = askYesNo(cur.getValue());

                if (answer) {
                    cur = cur.getLeft();
                    
                }
                else {
                    cur = cur.getRight();
                    
                }

                

            }

            System.out.println(cur.getValue());


            
            boolean opinionOOP = askYesNo("Is this satisfactory?");


            if (!opinionOOP){

                
                System.out.println("What would you prefer instead?");
                String preference1 = scanner.nextLine();

                
                
                System.out.println("Tell me a question that distinguishes " + preference1 + " from " + cur.getValue() );
                String preference2 = scanner.nextLine();

                cur.setRight(new TreeNode(cur.getValue()));
                cur.setLeft(new TreeNode(preference1));
                cur.setValue(preference2);
                cur.leaf = false;


            }



            playGame = askYesNo("Do you want to play again?");

            
        } while (playGame);

        saveTree(songTree);


        



    }


    public static void main(String[] args) {
        System.out.println("Welcome! Let's help you find a song.");

        TreeNode songTree = new TreeNode("Do you like classical music?",

                                 new TreeNode("Are you a fan of Mozart?",  //Left TreeNode
                                 
                                     new TreeNode("Eine Kleine Nachtmusik"),    // Left-> Left TreeNode
                                        
                                     new TreeNode("\"3 Romances\" by Clara Schumann")),  //Left-> Right TreeNode
                                          
                                     
                                 new TreeNode("\"Take Five\" by Dave Brubeck")); //Right TreeNode
        

        playGame(songTree);


        

    }
}
