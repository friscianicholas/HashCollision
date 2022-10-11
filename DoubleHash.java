import java.io.*;
import java.util.*;
public class DoubleHash {
	public static void main(String[] args) {
		System.out.println("Note: Arrays start with slot 0 when disucssing collision. Empty slots of hash table are filled with -1s");
		int keysample1[] = {3, 9, 43, 12, 67, 1, 32, 0};
		int keysample2[] = {5, 49, 33, 1, 7, 91, 12, 11};
		System.out.println("Array #1: ");
		System.out.println(Arrays.toString(keysample1));
		hashalgo(keysample1);
		System.out.println("Array #2: ");
		System.out.println(Arrays.toString(keysample2));
		hashalgo(keysample2);
	}
	static void hashalgo(int array[]) {
		int key;
		int h1;
		int i;
		int h2;
		int doublehash;
		int hashtable[] = new int[16];
		for (int f = 0; f < 16; f++) {
			hashtable[f] = -1;
		}
		for(int j = 0; j < 8; j++) {
			key = array[j];
			h1 = key % 16;
			h2 = 2 * (key % 4) + 1;
			i = 0;
			if(hashtable[h1] == -1) {
				hashtable[h1] = key;
				System.out.println(Arrays.toString(hashtable));
			}
			else {
				while(true) {
					doublehash = (h1 + i * h2)%16; //for printing purposes
					System.out.println("Collision! Location " + doublehash + " already filled. Find slot for " + key + "");
					i++;
					doublehash = (h1 + i * h2)%16;
					if(hashtable[doublehash] == -1) {
						hashtable[doublehash] = key;
						System.out.println("Successful double hash! --->");
						System.out.println(Arrays.toString(hashtable));
						break;
					}
				}
			}
		}
	}
}
