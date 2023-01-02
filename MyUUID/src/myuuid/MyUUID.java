package myuuid;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
/**
 *
 * @author Emir AYDIN
 */

public class MyUUID {
    
     static void asciiYaz(String mesaj) {
        int i;
        for (i = 0; i < mesaj.length(); i++) {
            System.out.print((int) mesaj.charAt(i) + "");
        }
    }

public static String macAddress(String mac) {
        UUID uuid = UUID.nameUUIDFromBytes(mac.getBytes());
        String uuidString = uuid.toString();
        return uuidString;
    }

    public static void main(String[] args) {
        String mesaj;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mesaj:");
        mesaj = scanner.nextLine();
        asciiYaz(mesaj);

        System.out.println("= Metnin ASCII Karşılığı");
        
        UUID uuid = UUID.randomUUID(); 
        String randomUUIDString = uuid.toString(); //Rastgele string değer üretir
        System.out.println(randomUUIDString);

        Random random = new Random(); // rastgele sayı üretebilecek nesne oluşturur
        int randomInt = random.nextInt(); // rastgele bir int değer üretir
        
        String uuid1 = String.valueOf(randomInt); // rastgele int değer atar.
        System.out.println(uuid1);

        String uuid2 = String.valueOf(randomInt) + mesaj.hashCode();// rastgele int değerini ve kelimenin hashCode unu birleştirir.
        System.out.println(uuid2);

        asciiYaz(mesaj);
        String uuid3 = macAddress(mesaj);
        System.out.println(uuid3); // Girdiğimiz metnin ascii karşılığını ve mac adresini birlikte yazıyor.
          

    }

}
// 2'lik       8'lik  10'luk  16'lık  HARF           2'lik     8'lik  10'luk  16'lık  HARF
//100 0001	101	65	41	A           110 0001	141	97	61	a
//100 0010	102	66	42	B           110 0010	142	98	62	b
//100 0011	103	67	43	C           110 0011	143	99	63	c
//100 0100	104	68	44	D           110 0100	144	100	64	d
//100 0101	105	69	45	E           110 0101	145	101	65	e
//100 0110	106	70	46	F           110 0110	146	102	66	f
//100 0111	107	71	47	G           110 0111	147	103	67	g
//100 1000	110	72	48	H           110 1000	150	104	68	h
//100 1001	111	73	49	I           110 1001	151	105	69	i
//100 1010	112	74	4A	J           110 1010	152	106	6A	j
//100 1011	113	75	4B	K           110 1011	153	107	6B	k
//100 1100	114	76	4C	L           110 1100	154	108	6C	l
//100 1101	115	77	4D	M           110 1101	155	109	6D	m
//100 1110	116	78	4E	N           110 1110	156	110	6E	n
//100 1111	117	79	4F	O           110 1111	157	111	6F	o
//101 0000	120	80	50	P           111 0000	160	112	70	p
//101 0001	121	81	51	Q           111 0001	161	113	71	q
//101 0010	122	82	52	R           111 0010	162	114	72	r
//101 0011	123	83	53	S           111 0011	163	115	73	s
//101 0100	124	84	54	T           111 0100	164	116	74	t
//101 0101	125	85	55	U           111 0101	165	117	75	u
//101 0110	126	86	56	V           111 0110	166	118	76	v
//101 0111	127	87	57	W           111 0111	167	119	77	w
//101 1000	130	88	58	X           111 1000	170	120	78	x
//101 1001	131	89	59	Y           111 1001	171	121	79	y
//101 1010	132	90	5A	Z           111 1010	172	122	7A	z



