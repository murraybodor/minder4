package hello;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
		log.info("Main");

//		ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        
//        Arrays.sort(beanNames);
//
//        for (String beanName : beanNames) {
//            System.out.println("Bean: " + beanName);
//        }
		

		// reversing string
		String word = "HelloWorld";
		StringBuffer wordBuf = new StringBuffer(word);
		String revWord = wordBuf.reverse().toString();
		
		System.out.println("Using reverse API:");
		System.out.println(revWord);
		System.out.println(" ");
		
		StringBuffer reverse = new StringBuffer("");
		
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse.append(word.charAt(i));
		}

		System.out.println("Using chars from for loop:");
		System.out.println(reverse.toString());
		System.out.println(" ");

		// sorted a-z
		char[] sorted = word.toLowerCase().toCharArray();
		Arrays.sort(sorted);
		System.out.println("Sorted: " + new String(sorted));
		System.out.println(" ");
		
		
		// missing number from array
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
		int arraySize = 10;

		Arrays.sort(array);

		int expectedSum = arraySize * (arraySize + 1) / 2;
		
		System.out.println("Missign number from array");
		System.out.println("expected sum: " + expectedSum);

		int actualSum = 0;
		for (int i : array) {
			actualSum += i;
		}

		System.out.println("actual sum: " + actualSum);
		System.out.println("expected - actual: " + (expectedSum - actualSum));
		System.out.println(" ");

		
		System.out.println("fibonacci using For loop");
		System.out.println("fibonacci 0: " + fibonacciFor(0));
		System.out.println("fibonacci 1: " + fibonacciFor(1));
		System.out.println("fibonacci 2: " + fibonacciFor(2));
		System.out.println("fibonacci 3: " + fibonacciFor(3));
		System.out.println("fibonacci 4: " + fibonacciFor(4));
		System.out.println("fibonacci 5: " + fibonacciFor(5));
		System.out.println("fibonacci 6: " + fibonacciFor(6));
		System.out.println("fibonacci 7: " + fibonacciFor(7));
		System.out.println("fibonacci 20: " + fibonacciFor(20));
		System.out.println(" ");

		System.out.println("fibonacci using recursion");
		System.out.println("fibonacci 0: " + fibonacciRecur(0));
		System.out.println("fibonacci 1: " + fibonacciRecur(1));
		System.out.println("fibonacci 2: " + fibonacciRecur(2));
		System.out.println("fibonacci 3: " + fibonacciRecur(3));
		System.out.println("fibonacci 4: " + fibonacciRecur(4));
		System.out.println("fibonacci 5: " + fibonacciRecur(5));
		System.out.println("fibonacci 6: " + fibonacciRecur(6));
		System.out.println("fibonacci 7: " + fibonacciRecur(7));
		System.out.println("fibonacci 20: " + fibonacciRecur(20));

		
    }
    
    private static int fibonacciFor(int input) {

    	int fib1 = 1;
    	int fib2 = 1;
    	int fibresult = 0;

    	if (input < 1) {
    		return 0;
    	} else if (input < 3) {
    		return 1;
    	} else {

    		for (int i = 3; i <= input; i++) {
        		fibresult = fib1 + fib2;
        		fib1 = fib2;
        		fib2 = fibresult;
    		}
    		
    	}
    	
    	
    	return fibresult;
    }

    private static int fibonacciRecur(int input) {
    	if (input==0) return 0;
    	if (input==1) return 1;
    	
    	return (fibonacciRecur(input - 1) + fibonacciRecur(input - 2));
    }
}