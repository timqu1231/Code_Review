import java.util.Scanner;
class Counting_Inversion_algorithm {
    public static void main(String []args) {
        //user' input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a number list( eg. 1,2,3 ):");
        String input_string = scan.nextLine();
        String[] input_list = input_string.split(",");
        int[] input_number = new int[input_list.length];
        int total = 0;
        int current;//pointer start at last digit
        int compare;//pointer start at last digit-1
        //convert to int
        for (int i = 0;i<input_list.length;i++){
            input_number[i] = Integer.parseInt(input_list[i]);
        }
        //compare two digit and if inversion, then total add 1 and printout
        for (int j = input_list.length-1; j >= 0; j--){
            current = input_number[j];
            for (int k = j - 1; k >= 0; k--){
                compare = input_number[k];
                if (current < compare){
                    total = total + 1;
                    System.out.println("("+compare +","+ current+")");
                }
            }
        }
        System.out.println("Total of counting inversion is " + total);
    }
}

