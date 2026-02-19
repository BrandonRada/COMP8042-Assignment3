import java.IO.FilerReader;
import java.IO.BufferedReader;

public class BSTChecker{
    boolean isBinarySearchTree(GenericTree<Integer> tree){



    }



    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Usage: <file_name>");
            return;
        }

        DotFileReader dotReader = new DotFileReader;

        // Requires filepath and converter function: ()String filePath, Function<String, T> converter)

        GenericTree<T> tree = dotReader.createTreeFromDotFile(file, );

        // Check the file the user entered
//         for (String file: args){
            boolean isBinarySearchTreeCorrect = isBinarySearchTree(tree);
            if (isBinarySearchTreeCorrect){
                System.out.println(file + ": The tree contained in the file is a Binary Search Tree!");
            }
//         }

    }
}