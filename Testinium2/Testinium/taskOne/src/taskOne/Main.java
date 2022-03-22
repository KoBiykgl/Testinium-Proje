package taskOne;

public class Main {

	public static void main(String[] args) {
		
	int sayi=4;
	
	for(int i=0; i<=sayi-1;i++) {
		
		for(int j=0; j<=sayi-i; j++) {
			System.out.print(" ");
		}
		
		for(int k=1; k<=(2*i+1); k++) {
			System.out.print("*");
		}
		System.out.println("");
	}

	}

}
