package assignment_package;

public class Main {

    public static void main(String[] args) {

        int num = 700;

        //Restrict 'num' to a specific range.
        if (num>1000000) num=1000000;
        else if (num<0) num=0;

        //Generate Lists
        SinglyLinkedList primesList = generatePrimes(num);
        SinglyLinkedList listOfThrees = generateListOfThrees(primesList);

        //Print Info
        System.out.print("List of Prime Numbers, from 0 to " + num + ": "); primesList.print();
        System.out.print("List of Primes With 3, from 0 to " + num + ": "); listOfThrees.print();

        System.out.print("Sum of Primes containing 3: " + getSumFromList(listOfThrees));
    }


    public static SinglyLinkedList generatePrimes(int n) {

        SinglyLinkedList primes = new SinglyLinkedList();//init

        if (n==2) primes.append(new Node(2));//base case

        out:for(int i=3;i<=n;i+=2) {//Generate a list of Prime Numbers.
            for (int j=2;j<=Math.sqrt(i);j++) if (i%j==0) continue out;
            primes.append(new Node(i));
        }

        return primes;
    }

    public static boolean hasThree(int num) {
        while(num > 0) {
            if(num % 10 == 3) return true;//If num is not evenly divisible by 3, divide by 10 and try again.
            num=num/10;
        }
        return false;
    }

    public static SinglyLinkedList generateListOfThrees(SinglyLinkedList unsortedList) {

        SinglyLinkedList listOfThrees = new SinglyLinkedList();//init

        Node currNode = unsortedList.getHead();//Get the first Node in the List.

        while (currNode != null) {//Iterate through each Node and each data that contains a 3 to a new List.
            if (hasThree(currNode.data)) listOfThrees.append(new Node(currNode.data));
            currNode = currNode.next;
        }

        return listOfThrees;
    }

    public static int getSumFromList(SinglyLinkedList list) {
        Node currNode = list.getHead();

        int sum = 0;

        while (currNode != null) {//Iterate through the list and add the data values.
            sum += currNode.data;
            currNode = currNode.next;
        }

        return sum;
    }
}
