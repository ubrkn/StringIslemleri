package com.ub.odevler.string;

public class StringParse {

	public static void main(String[] args) {

		final String metin = "#PatNo:1234@Pat: Taner TEMEL@Age:45@HBG:65@AG:45@#"
				+ "#PatNo:1235@Pat: Kemal TEMEL@Age:34@HBG:65@AG:45@#"
				+ "#PatNo:1236@Pat: Cemal TEMEL@Age:23@HBG:65@AG:45@#"
				+ "#PatNo:1237@Pat: Ayþe TEMEL@Age:5@HBG:65@AG:45@#"
				+ "#PatNo:1238@Pat: Fatma TEMEL@Age:75@HBG:65@AG:45@#";

		String[] satir = metin.split("#", 0);

		for (String string : satir) {
			System.out.println(string);
		}

		for (int i = 1; i < satir.length; i++) {

			String sayac = satir[i];
			int bolumSayisi = sayac.length() - sayac.replace("@", "").length();
			int bas = 0;
			int son = 0;
			String yazdir;

			for (int j = 0; j < bolumSayisi; j++) {

				son = satir[i].toString().indexOf("@", son+1);
				
				switch (j) {
				case 0:
					yazdir = (satir[i].substring(bas, son));
					yazdir = yazdir.replaceAll("PatNo:", "Hasta No: ");
					System.out.print(yazdir);
					bas = son;
					
					break;

				case 1:
					yazdir = (satir[i].substring(bas, son));
					yazdir = yazdir.replaceAll("@Pat: ", " / Hasta Adi: ");
					System.out.print(yazdir);
					bas = son;
					
					break;
					
				case 2:
					yazdir = (satir[i].substring(bas, son));
					yazdir = yazdir.replaceAll("@Age:", " / Yas: ");
					System.out.print(yazdir);
					bas = son;
					
					break;
				
				case 3:
					yazdir = (satir[i].substring(bas, son));
					yazdir = yazdir.replaceAll("@", " / ");
					System.out.print(yazdir);
					bas = son;
					
					break;
				
				case 4:
					yazdir = (satir[i].substring(bas, son));
					yazdir = yazdir.replaceAll("@", " / ");
					System.out.println(yazdir);
					bas = son;
					
					break;
				
				default:
					break;
				}
				

			}

		}

	}

}
