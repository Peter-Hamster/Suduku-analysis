import java.util.*;
import java.io.*;


class Shudu{
	private int[][] A;

	
	public Shudu(int[][] newA) {
		A = newA;
	}
	
	// Solving those who only has one choice
	public boolean working1() {
		boolean again = false;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(A[i][j] ==0) {
					ArrayList<Integer> AL = new ArrayList<Integer>();
					for(int a=1;a<10;a++) {
						AL.add(a);
					}
					
					for(int k=1;k<10;k++) {
						//For row
						for(int x=0;x<9;x++) {
							if(A[x][j] == k) {
								Integer I = new Integer(k);
								AL.remove(I);
							}	
						}
					
						//For column
						for(int x=0;x<9;x++) {
							if(A[i][x] == k) {
								Integer I = new Integer(k);
								AL.remove(I);		
							}	
						}
					
						//For Square, up-left
						int g = -(i%3);
						int h = -(j%3);
				
						for(int x=0+g;x<3+g;x++) {
							for(int y=0+h;y<3+h;y++) {
								if(A[i+x][j+y] == k) {
									Integer I = new Integer(k);
									AL.remove(I);
								}	
							}
						}
							
				}
				if (AL.size() == 1			) {
					A[i][j] = AL.get(0);
					
					again = true;
					System.out.println("!");
				}
				}
			}
		}
		return again;
	}
	
	//solving those who can only be them in their row
	
	public boolean working2() {
		boolean again = false;
		
		
		for(int i=0;i<9;i++) {
			int[] B = {0,0,0,0,0,0,0,0,0,0};
			for(int j=0;j<9;j++) {
				if (A[i][j] == 0 ) {
					ArrayList<Integer> AL = new ArrayList<Integer>();
					for(int a=1;a<10;a++) {
						AL.add(a);
					}
					
					for(int k=1;k<10;k++) {
						//For row
						for(int x=0;x<9;x++) {
							if(A[x][j] == k) {
								Integer I = new Integer(k);
								AL.remove(I);
							}	
						}
					
						//For column
						for(int x=0;x<9;x++) {
							if(A[i][x] == k) {
								Integer I = new Integer(k);
								AL.remove(I);		
							}	
						}
					
						//For Square
						int g = -(i%3);
						int h = -(j%3);
				
						for(int x=0+g;x<3+g;x++) {
							for(int y=0+h;y<3+h;y++) {
								if(A[i+x][j+y] == k) {
									Integer I = new Integer(k);
									AL.remove(I);
								}	
							}
						}
							
					}//k
					for(int p=0; p<AL.size();p++) {
						B[AL.get(p)]++;
					}
				}
				
				}
			
			for(int q=0;q<10;q++) {
				if(B[q]==1) {
					System.out.println("!!!");
					for(int z = 0; z<9;z++) {
						if(A[i][z]==0) {
							// For position, row is i, column is z, the number to find is q 
							boolean RP = true;
							for(int x=0; x<9;x++) {
								if(A[x][z] == q) {
									RP = false;
								}
								if(A[i][x] == q) {
									RP = false;
								}									
							}
							
							int g = -(i%3);
							int h = -(z%3);
					
							for(int x=0+g;x<3+g;x++) {
								for(int y=0+h;y<3+h;y++) {
									if(A[i+x][z+y] == q) {
										RP = false;
									}	
								}
							}
							
							if (RP) {
								A[i][z] = q;
								again = true;
								System.out.println("???");
							}
						}
					}
					
				}
			}
			
			}
		
		
		return again;
	}
	
	
	public boolean check() {
		boolean finish = true;
		for(int i=0; i<9;i++) {
			for(int j=0;j<9; j++) {
				if(A[i][j] == 0)
					finish = false;
			}
		}
		return finish;
	}
	
	public int[] guess() {
		int[] Guess = new int[4];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(A[i][j] ==0) {
					ArrayList<Integer> AL = new ArrayList<Integer>();
					for(int a=1;a<10;a++) {
						AL.add(a);
					}
					
					for(int k=1;k<10;k++) {
						//For row
						for(int x=0;x<9;x++) {
							if(A[x][j] == k) {
								Integer I = new Integer(k);
								AL.remove(I);
							}	
						}
					
						//For column
						for(int x=0;x<9;x++) {
							if(A[i][x] == k) {
								Integer I = new Integer(k);
								AL.remove(I);		
							}	
						}
					
						//For Square, up-left
						int g = -(i%3);
						int h = -(j%3);
				
						for(int x=0+g;x<3+g;x++) {
							for(int y=0+h;y<3+h;y++) {
								if(A[i+x][j+y] == k) {
									Integer I = new Integer(k);
									AL.remove(I);
								}	
							}
						}
							
				}
				if(AL.size()==2) {
					Guess[0] = i;
					Guess[1] = j;
					
					Guess[2] = AL.get(0);
					Guess[3] = AL.get(1);
				
					System.out.println("!");
					
					for(int d=0;d<4;d++) {
						System.out.print(Guess[d]+" ");
					}
					System.out.println();
					return Guess;
					}
				}
				
				
			}
		}
		return Guess;
	}
	
	public int[][] getArray(){
		return A;
	}
	
}

public class Sudoku {
	public static void main(String[] args) {
		
		int[][] A = new int[9][9];
		try {
			File F = new File("Shudu.txt");
			Scanner stdin = new Scanner(F);
			for(int i = 0; i < 9 ; i++) {
				String S = stdin.nextLine();
				for(int j = 0; j < 9; j++) {
					A[i][j] = S.charAt(j) - '0';
				}		
			}
			for(int i = 0; i < 9 ; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(A[i][j]);
				}
				System.out.println();
				
			}
			
			Shudu S = new Shudu(A);
			while(S.working1());
			S.working1();
			while(S.working2());

			
			
			System.out.println();System.out.println();
			
			for(int i = 0; i < 9 ; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(A[i][j]);
				}
				System.out.println();
				
			}
			
			System.out.println();
			System.out.println();
			System.out.println(S.check());
			System.out.println();
			System.out.println();
			
			A = S.getArray();
			int[] guess = new int[4];
			guess = S.guess();
			int[][] A1= new int[9][9];
			int[][] A2= new int[9][9];			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					A1[i][j] = A[i][j];
					A2[i][j] = A[i][j];
				}
			}
			
			
			A1[guess[0]][guess[1]] = guess[2];
			
			A2[guess[0]][guess[1]] = guess[3];
			
			Shudu S1 = new Shudu(A1);
			Shudu S2 = new Shudu(A2);
			
			while(S1.working1());
			S1.working1();
			while(S1.working2());
			int[][] newA1 = S1.getArray();
			
			while(S2.working1());
			S2.working1();
			while(S2.working2());
			int[][] newA2 = S2.getArray();
			
			System.out.println();System.out.println();
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(newA1[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();System.out.println();
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(newA2[i][j]);
				}
				System.out.println();
			}
			
			
			System.out.println();System.out.println();
			
			PrintWriter pw = new PrintWriter(F);
			for(int i = 0; i < 9 ; i++) {
				for(int j = 0; j < 9; j++) {
					pw.print(A1[i][j]);
				}
				pw.println();
			}
			pw.close();
			
			
			for(int i = 0; i < 9 ; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(A1[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println();
			
			for(int i = 0; i < 9 ; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(A2[i][j]);
				}
				System.out.println();
				
			}
			
			
		
		
		}
		catch(IOException ioe) {
			System.out.println("IOException occur!!!");
		}
		
			
	}
	
}
