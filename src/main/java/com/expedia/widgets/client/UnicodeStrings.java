package com.expedia.widgets.client;

import java.util.HashMap;

public class UnicodeStrings {

	private static HashMap<Character, String> mCharacterTable = null;

	// / <summary>
	// / Strips diacritics from a Latin-character
	// / Unicode string. Leaves non-Latin characters as they
	// / were.
	// / </summary>
	// / <param name="InString">A Unicode string.</param>
	// / <returns>ASCII-range characters, plus any non-Latin characters in the
	// string</returns>
	public static String LatinToAscii(String InString) {
		System.err.println("Before: " + InString);
		String returnString = "";
		Character ch = '\u0042';
		if (mCharacterTable == null)
			InitializeCharacterTable();

		for (int i = 0; i < InString.length(); i++) {
			ch = InString.charAt(i);
			if (!mCharacterTable.containsKey(ch)) {
				returnString += ch;
			} else {
				returnString += mCharacterTable.get(ch);
			}

		}
		System.err.println("After: " + returnString);
		return returnString;
	}

	// / <summary>
	// / Takes a hexadecimal string and converts it to a
	// / Unicode character
	// / </summary>
	// / <param name="HexString">A four-digit number in hex notation (eg,
	// 00E7).</param>
	// / <returns>A unicode character, as string.</returns>
	/*
	 * public static String ToUnichar(String HexString) { String returnChar;
	 * byte[] b = new byte[2]; UnicodeEncoding ue = new UnicodeEncoding();
	 * 
	 * // Take hexadecimal as text and make a Unicode char number b[0] =
	 * Convert.ToByte(HexString.Substring(2, 2), 16); b[1] =
	 * Convert.ToByte(HexString.Substring(0, 2), 16); // Get the character the
	 * number represents returnChar = ue.GetString(b); return returnChar; }
	 */

	// / <summary>
	// / Stores Unicode characters and their "normalized"
	// / values to a hash table. Character codes are referenced
	// / by hex numbers because that's the most common way to
	// / refer to them.
	// / </summary>
	/*
	 * Upper-case comments are identifiers from the Unicode database. Lower- and
	 * mixed-case comments are the author's
	 */
	private static void InitializeCharacterTable() {
		mCharacterTable = new HashMap<Character, String>();
		mCharacterTable.put('\u0041', "A");
		mCharacterTable.put('\u0042', "B");
		mCharacterTable.put('\u0043', "C");
		mCharacterTable.put('\u0044', "D");
		mCharacterTable.put('\u0045', "E");
		mCharacterTable.put('\u0046', "F");
		mCharacterTable.put('\u0047', "G");
		mCharacterTable.put('\u0048', "H");
		mCharacterTable.put('\u0049', "I");
		mCharacterTable.put('\u004A', "J");
		mCharacterTable.put('\u004B', "K");
		mCharacterTable.put('\u004C', "L");
		mCharacterTable.put('\u004D', "M");
		mCharacterTable.put('\u004E', "N");
		mCharacterTable.put('\u004F', "O");
		mCharacterTable.put('\u0050', "P");
		mCharacterTable.put('\u0051', "Q");
		mCharacterTable.put('\u0052', "R");
		mCharacterTable.put('\u0053', "S");
		mCharacterTable.put('\u0054', "T");
		mCharacterTable.put('\u0055', "U");
		mCharacterTable.put('\u0056', "V");
		mCharacterTable.put('\u0057', "W");
		mCharacterTable.put('\u0058', "X");
		mCharacterTable.put('\u0059', "Y");
		mCharacterTable.put('\u005A', "Z");
		mCharacterTable.put('\u0061', "a");
		mCharacterTable.put('\u0062', "b");
		mCharacterTable.put('\u0063', "c");
		mCharacterTable.put('\u0064', "d");
		mCharacterTable.put('\u0065', "e");
		mCharacterTable.put('\u0066', "f");
		mCharacterTable.put('\u0067', "g");
		mCharacterTable.put('\u0068', "h");
		mCharacterTable.put('\u0069', "i");
		mCharacterTable.put('\u006A', "j");
		mCharacterTable.put('\u006B', "k");
		mCharacterTable.put('\u006C', "l");
		mCharacterTable.put('\u006D', "m");
		mCharacterTable.put('\u006E', "n");
		mCharacterTable.put('\u006F', "o");
		mCharacterTable.put('\u0070', "p");
		mCharacterTable.put('\u0071', "q");
		mCharacterTable.put('\u0072', "r");
		mCharacterTable.put('\u0073', "s");
		mCharacterTable.put('\u0074', "t");
		mCharacterTable.put('\u0075', "u");
		mCharacterTable.put('\u0076', "v");
		mCharacterTable.put('\u0077', "w");
		mCharacterTable.put('\u0078', "x");
		mCharacterTable.put('\u0079', "y");
		mCharacterTable.put('\u007A', "z");
		mCharacterTable.put('\u00AA', "a"); // FEMININE ORDINAL INDICATOR
		mCharacterTable.put('\u00BA', "o"); // MASCULINE ORDINAL INDICATOR
		mCharacterTable.put('\u00C0', "A"); // LATIN CAPITAL LETTER A WITH GRAVE
		mCharacterTable.put('\u00C1', "A"); // LATIN CAPITAL LETTER A WITH ACUTE
		mCharacterTable.put('\u00C2', "A"); // LATIN CAPITAL LETTER A WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00C3', "A"); // LATIN CAPITAL LETTER A WITH TILDE
		mCharacterTable.put('\u00C4', "A"); // LATIN CAPITAL LETTER A WITH
											// DIAERESIS
		mCharacterTable.put('\u00C5', "A"); // LATIN CAPITAL LETTER A WITH RING
											// ABOVE
		mCharacterTable.put('\u00C6', "AE"); // LATIN CAPITAL LETTER AE -- no
												// decomposition
		mCharacterTable.put('\u00C7', "C"); // LATIN CAPITAL LETTER C WITH
											// CEDILLA
		mCharacterTable.put('\u00C8', "E"); // LATIN CAPITAL LETTER E WITH GRAVE
		mCharacterTable.put('\u00C9', "E"); // LATIN CAPITAL LETTER E WITH ACUTE
		mCharacterTable.put('\u00CA', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00CB', "E"); // LATIN CAPITAL LETTER E WITH
											// DIAERESIS
		mCharacterTable.put('\u00CC', "I"); // LATIN CAPITAL LETTER I WITH GRAVE
		mCharacterTable.put('\u00CD', "I"); // LATIN CAPITAL LETTER I WITH ACUTE
		mCharacterTable.put('\u00CE', "I"); // LATIN CAPITAL LETTER I WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00CF', "I"); // LATIN CAPITAL LETTER I WITH
											// DIAERESIS
		mCharacterTable.put('\u00D0', "D"); // LATIN CAPITAL LETTER ETH -- no
											// decomposition // Eth [D for
											// Vietnamese]
		mCharacterTable.put('\u00D1', "N"); // LATIN CAPITAL LETTER N WITH TILDE
		mCharacterTable.put('\u00D2', "O"); // LATIN CAPITAL LETTER O WITH GRAVE
		mCharacterTable.put('\u00D3', "O"); // LATIN CAPITAL LETTER O WITH ACUTE
		mCharacterTable.put('\u00D4', "O"); // LATIN CAPITAL LETTER O WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00D5', "O"); // LATIN CAPITAL LETTER O WITH TILDE
		mCharacterTable.put('\u00D6', "O"); // LATIN CAPITAL LETTER O WITH
											// DIAERESIS
		mCharacterTable.put('\u00D8', "O"); // LATIN CAPITAL LETTER O WITH
											// STROKE -- no decom
		mCharacterTable.put('\u00D9', "U"); // LATIN CAPITAL LETTER U WITH GRAVE
		mCharacterTable.put('\u00DA', "U"); // LATIN CAPITAL LETTER U WITH ACUTE
		mCharacterTable.put('\u00DB', "U"); // LATIN CAPITAL LETTER U WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00DC', "U"); // LATIN CAPITAL LETTER U WITH
											// DIAERESIS
		mCharacterTable.put('\u00DD', "Y"); // LATIN CAPITAL LETTER Y WITH ACUTE
		mCharacterTable.put('\u00DE', "Th"); // LATIN CAPITAL LETTER THORN -- no
												// decomposition; // Thorn -
												// Could be nothing other than
												// thorn
		mCharacterTable.put('\u00DF', "s"); // LATIN SMALL LETTER SHARP S -- no
											// decomposition
		mCharacterTable.put('\u00E0', "a"); // LATIN SMALL LETTER A WITH GRAVE
		mCharacterTable.put('\u00E1', "a"); // LATIN SMALL LETTER A WITH ACUTE
		mCharacterTable.put('\u00E2', "a"); // LATIN SMALL LETTER A WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00E3', "a"); // LATIN SMALL LETTER A WITH TILDE
		mCharacterTable.put('\u00E4', "a"); // LATIN SMALL LETTER A WITH
											// DIAERESIS
		mCharacterTable.put('\u00E5', "a"); // LATIN SMALL LETTER A WITH RING
											// ABOVE
		mCharacterTable.put('\u00E6', "ae"); // LATIN SMALL LETTER AE -- no
												// decomposition
		mCharacterTable.put('\u00E7', "c"); // LATIN SMALL LETTER C WITH CEDILLA
		mCharacterTable.put('\u00E8', "e"); // LATIN SMALL LETTER E WITH GRAVE
		mCharacterTable.put('\u00E9', "e"); // LATIN SMALL LETTER E WITH ACUTE
		mCharacterTable.put('\u00EA', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00EB', "e"); // LATIN SMALL LETTER E WITH
											// DIAERESIS
		mCharacterTable.put('\u00EC', "i"); // LATIN SMALL LETTER I WITH GRAVE
		mCharacterTable.put('\u00ED', "i"); // LATIN SMALL LETTER I WITH ACUTE
		mCharacterTable.put('\u00EE', "i"); // LATIN SMALL LETTER I WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00EF', "i"); // LATIN SMALL LETTER I WITH
											// DIAERESIS
		mCharacterTable.put('\u00F0', "d"); // LATIN SMALL LETTER ETH -- no
											// decomposition // small eth, "d"
											// for benefit of Vietnamese
		mCharacterTable.put('\u00F1', "n"); // LATIN SMALL LETTER N WITH TILDE
		mCharacterTable.put('\u00F2', "o"); // LATIN SMALL LETTER O WITH GRAVE
		mCharacterTable.put('\u00F3', "o"); // LATIN SMALL LETTER O WITH ACUTE
		mCharacterTable.put('\u00F4', "o"); // LATIN SMALL LETTER O WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00F5', "o"); // LATIN SMALL LETTER O WITH TILDE
		mCharacterTable.put('\u00F6', "o"); // LATIN SMALL LETTER O WITH
											// DIAERESIS
		mCharacterTable.put('\u00F8', "o"); // LATIN SMALL LETTER O WITH STROKE
											// -- no decompo
		mCharacterTable.put('\u00F9', "u"); // LATIN SMALL LETTER U WITH GRAVE
		mCharacterTable.put('\u00FA', "u"); // LATIN SMALL LETTER U WITH ACUTE
		mCharacterTable.put('\u00FB', "u"); // LATIN SMALL LETTER U WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u00FC', "u"); // LATIN SMALL LETTER U WITH
											// DIAERESIS
		mCharacterTable.put('\u00FD', "y"); // LATIN SMALL LETTER Y WITH ACUTE
		mCharacterTable.put('\u00FE', "th"); // LATIN SMALL LETTER THORN -- no
												// decomposition // Small thorn
		mCharacterTable.put('\u00FF', "y"); // LATIN SMALL LETTER Y WITH
											// DIAERESIS
		mCharacterTable.put('\u0100', "A"); // LATIN CAPITAL LETTER A WITH
											// MACRON
		mCharacterTable.put('\u0101', "a"); // LATIN SMALL LETTER A WITH MACRON
		mCharacterTable.put('\u0102', "A"); // LATIN CAPITAL LETTER A WITH BREVE
		mCharacterTable.put('\u0103', "a"); // LATIN SMALL LETTER A WITH BREVE
		mCharacterTable.put('\u0104', "A"); // LATIN CAPITAL LETTER A WITH
											// OGONEK
		mCharacterTable.put('\u0105', "a"); // LATIN SMALL LETTER A WITH OGONEK
		mCharacterTable.put('\u0106', "C"); // LATIN CAPITAL LETTER C WITH ACUTE
		mCharacterTable.put('\u0107', "c"); // LATIN SMALL LETTER C WITH ACUTE
		mCharacterTable.put('\u0108', "C"); // LATIN CAPITAL LETTER C WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0109', "c"); // LATIN SMALL LETTER C WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u010A', "C"); // LATIN CAPITAL LETTER C WITH DOT
											// ABOVE
		mCharacterTable.put('\u010B', "c"); // LATIN SMALL LETTER C WITH DOT
											// ABOVE
		mCharacterTable.put('\u010C', "C"); // LATIN CAPITAL LETTER C WITH CARON
		mCharacterTable.put('\u010D', "c"); // LATIN SMALL LETTER C WITH CARON
		mCharacterTable.put('\u010E', "D"); // LATIN CAPITAL LETTER D WITH CARON
		mCharacterTable.put('\u010F', "d"); // LATIN SMALL LETTER D WITH CARON
		mCharacterTable.put('\u0110', "D"); // LATIN CAPITAL LETTER D WITH
											// STROKE -- no decomposition //
											// Capital D with stroke
		mCharacterTable.put('\u0111', "d"); // LATIN SMALL LETTER D WITH STROKE
											// -- no decomposition // small D
											// with stroke
		mCharacterTable.put('\u0112', "E"); // LATIN CAPITAL LETTER E WITH
											// MACRON
		mCharacterTable.put('\u0113', "e"); // LATIN SMALL LETTER E WITH MACRON
		mCharacterTable.put('\u0114', "E"); // LATIN CAPITAL LETTER E WITH BREVE
		mCharacterTable.put('\u0115', "e"); // LATIN SMALL LETTER E WITH BREVE
		mCharacterTable.put('\u0116', "E"); // LATIN CAPITAL LETTER E WITH DOT
											// ABOVE
		mCharacterTable.put('\u0117', "e"); // LATIN SMALL LETTER E WITH DOT
											// ABOVE
		mCharacterTable.put('\u0118', "E"); // LATIN CAPITAL LETTER E WITH
											// OGONEK
		mCharacterTable.put('\u0119', "e"); // LATIN SMALL LETTER E WITH OGONEK
		mCharacterTable.put('\u011A', "E"); // LATIN CAPITAL LETTER E WITH CARON
		mCharacterTable.put('\u011B', "e"); // LATIN SMALL LETTER E WITH CARON
		mCharacterTable.put('\u011C', "G"); // LATIN CAPITAL LETTER G WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u011D', "g"); // LATIN SMALL LETTER G WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u011E', "G"); // LATIN CAPITAL LETTER G WITH BREVE
		mCharacterTable.put('\u011F', "g"); // LATIN SMALL LETTER G WITH BREVE
		mCharacterTable.put('\u0120', "G"); // LATIN CAPITAL LETTER G WITH DOT
											// ABOVE
		mCharacterTable.put('\u0121', "g"); // LATIN SMALL LETTER G WITH DOT
											// ABOVE
		mCharacterTable.put('\u0122', "G"); // LATIN CAPITAL LETTER G WITH
											// CEDILLA
		mCharacterTable.put('\u0123', "g"); // LATIN SMALL LETTER G WITH CEDILLA
		mCharacterTable.put('\u0124', "H"); // LATIN CAPITAL LETTER H WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0125', "h"); // LATIN SMALL LETTER H WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0126', "H"); // LATIN CAPITAL LETTER H WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u0127', "h"); // LATIN SMALL LETTER H WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u0128', "I"); // LATIN CAPITAL LETTER I WITH TILDE
		mCharacterTable.put('\u0129', "i"); // LATIN SMALL LETTER I WITH TILDE
		mCharacterTable.put('\u012A', "I"); // LATIN CAPITAL LETTER I WITH
											// MACRON
		mCharacterTable.put('\u012B', "i"); // LATIN SMALL LETTER I WITH MACRON
		mCharacterTable.put('\u012C', "I"); // LATIN CAPITAL LETTER I WITH BREVE
		mCharacterTable.put('\u012D', "i"); // LATIN SMALL LETTER I WITH BREVE
		mCharacterTable.put('\u012E', "I"); // LATIN CAPITAL LETTER I WITH
											// OGONEK
		mCharacterTable.put('\u012F', "i"); // LATIN SMALL LETTER I WITH OGONEK
		mCharacterTable.put('\u0130', "I"); // LATIN CAPITAL LETTER I WITH DOT
											// ABOVE
		mCharacterTable.put('\u0131', "i"); // LATIN SMALL LETTER DOTLESS I --
											// no decomposition
		mCharacterTable.put('\u0132', "I"); // LATIN CAPITAL LIGATURE IJ
		mCharacterTable.put('\u0133', "i"); // LATIN SMALL LIGATURE IJ
		mCharacterTable.put('\u0134', "J"); // LATIN CAPITAL LETTER J WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0135', "j"); // LATIN SMALL LETTER J WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0136', "K"); // LATIN CAPITAL LETTER K WITH
											// CEDILLA
		mCharacterTable.put('\u0137', "k"); // LATIN SMALL LETTER K WITH CEDILLA
		mCharacterTable.put('\u0138', "k"); // LATIN SMALL LETTER KRA -- no
											// decomposition
		mCharacterTable.put('\u0139', "L"); // LATIN CAPITAL LETTER L WITH ACUTE
		mCharacterTable.put('\u013A', "l"); // LATIN SMALL LETTER L WITH ACUTE
		mCharacterTable.put('\u013B', "L"); // LATIN CAPITAL LETTER L WITH
											// CEDILLA
		mCharacterTable.put('\u013C', "l"); // LATIN SMALL LETTER L WITH CEDILLA
		mCharacterTable.put('\u013D', "L"); // LATIN CAPITAL LETTER L WITH CARON
		mCharacterTable.put('\u013E', "l"); // LATIN SMALL LETTER L WITH CARON
		mCharacterTable.put('\u013F', "L"); // LATIN CAPITAL LETTER L WITH
											// MIDDLE DOT
		mCharacterTable.put('\u0140', "l"); // LATIN SMALL LETTER L WITH MIDDLE
											// DOT
		mCharacterTable.put('\u0141', "L"); // LATIN CAPITAL LETTER L WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u0142', "l"); // LATIN SMALL LETTER L WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u0143', "N"); // LATIN CAPITAL LETTER N WITH ACUTE
		mCharacterTable.put('\u0144', "n"); // LATIN SMALL LETTER N WITH ACUTE
		mCharacterTable.put('\u0145', "N"); // LATIN CAPITAL LETTER N WITH
											// CEDILLA
		mCharacterTable.put('\u0146', "n"); // LATIN SMALL LETTER N WITH CEDILLA
		mCharacterTable.put('\u0147', "N"); // LATIN CAPITAL LETTER N WITH CARON
		mCharacterTable.put('\u0148', "n"); // LATIN SMALL LETTER N WITH CARON
		mCharacterTable.put('\u0149', "'n"); // LATIN SMALL LETTER N PRECEDED BY
												// APOSTROPHE ;
		mCharacterTable.put('\u014A', "NG"); // LATIN CAPITAL LETTER ENG -- no
												// decomposition ;
		mCharacterTable.put('\u014B', "ng"); // LATIN SMALL LETTER ENG -- no
												// decomposition ;
		mCharacterTable.put('\u014C', "O"); // LATIN CAPITAL LETTER O WITH
											// MACRON
		mCharacterTable.put('\u014D', "o"); // LATIN SMALL LETTER O WITH MACRON
		mCharacterTable.put('\u014E', "O"); // LATIN CAPITAL LETTER O WITH BREVE
		mCharacterTable.put('\u014F', "o"); // LATIN SMALL LETTER O WITH BREVE
		mCharacterTable.put('\u0150', "O"); // LATIN CAPITAL LETTER O WITH
											// DOUBLE ACUTE
		mCharacterTable.put('\u0151', "o"); // LATIN SMALL LETTER O WITH DOUBLE
											// ACUTE
		mCharacterTable.put('\u0152', "OE"); // LATIN CAPITAL LIGATURE OE -- no
												// decomposition
		mCharacterTable.put('\u0153', "oe"); // LATIN SMALL LIGATURE OE -- no
												// decomposition
		mCharacterTable.put('\u0154', "R"); // LATIN CAPITAL LETTER R WITH ACUTE
		mCharacterTable.put('\u0155', "r"); // LATIN SMALL LETTER R WITH ACUTE
		mCharacterTable.put('\u0156', "R"); // LATIN CAPITAL LETTER R WITH
											// CEDILLA
		mCharacterTable.put('\u0157', "r"); // LATIN SMALL LETTER R WITH CEDILLA
		mCharacterTable.put('\u0158', "R"); // LATIN CAPITAL LETTER R WITH CARON
		mCharacterTable.put('\u0159', "r"); // LATIN SMALL LETTER R WITH CARON
		mCharacterTable.put('\u015A', "S"); // LATIN CAPITAL LETTER S WITH ACUTE
		mCharacterTable.put('\u015B', "s"); // LATIN SMALL LETTER S WITH ACUTE
		mCharacterTable.put('\u015C', "S"); // LATIN CAPITAL LETTER S WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u015D', "s"); // LATIN SMALL LETTER S WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u015E', "S"); // LATIN CAPITAL LETTER S WITH
											// CEDILLA
		mCharacterTable.put('\u015F', "s"); // LATIN SMALL LETTER S WITH CEDILLA
		mCharacterTable.put('\u0160', "S"); // LATIN CAPITAL LETTER S WITH CARON
		mCharacterTable.put('\u0161', "s"); // LATIN SMALL LETTER S WITH CARON
		mCharacterTable.put('\u0162', "T"); // LATIN CAPITAL LETTER T WITH
											// CEDILLA
		mCharacterTable.put('\u0163', "t"); // LATIN SMALL LETTER T WITH CEDILLA
		mCharacterTable.put('\u0164', "T"); // LATIN CAPITAL LETTER T WITH CARON
		mCharacterTable.put('\u0165', "t"); // LATIN SMALL LETTER T WITH CARON
		mCharacterTable.put('\u0166', "T"); // LATIN CAPITAL LETTER T WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u0167', "t"); // LATIN SMALL LETTER T WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u0168', "U"); // LATIN CAPITAL LETTER U WITH TILDE
		mCharacterTable.put('\u0169', "u"); // LATIN SMALL LETTER U WITH TILDE
		mCharacterTable.put('\u016A', "U"); // LATIN CAPITAL LETTER U WITH
											// MACRON
		mCharacterTable.put('\u016B', "u"); // LATIN SMALL LETTER U WITH MACRON
		mCharacterTable.put('\u016C', "U"); // LATIN CAPITAL LETTER U WITH BREVE
		mCharacterTable.put('\u016D', "u"); // LATIN SMALL LETTER U WITH BREVE
		mCharacterTable.put('\u016E', "U"); // LATIN CAPITAL LETTER U WITH RING
											// ABOVE
		mCharacterTable.put('\u016F', "u"); // LATIN SMALL LETTER U WITH RING
											// ABOVE
		mCharacterTable.put('\u0170', "U"); // LATIN CAPITAL LETTER U WITH
											// DOUBLE ACUTE
		mCharacterTable.put('\u0171', "u"); // LATIN SMALL LETTER U WITH DOUBLE
											// ACUTE
		mCharacterTable.put('\u0172', "U"); // LATIN CAPITAL LETTER U WITH
											// OGONEK
		mCharacterTable.put('\u0173', "u"); // LATIN SMALL LETTER U WITH OGONEK
		mCharacterTable.put('\u0174', "W"); // LATIN CAPITAL LETTER W WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0175', "w"); // LATIN SMALL LETTER W WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0176', "Y"); // LATIN CAPITAL LETTER Y WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0177', "y"); // LATIN SMALL LETTER Y WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u0178', "Y"); // LATIN CAPITAL LETTER Y WITH
											// DIAERESIS
		mCharacterTable.put('\u0179', "Z"); // LATIN CAPITAL LETTER Z WITH ACUTE
		mCharacterTable.put('\u017A', "z"); // LATIN SMALL LETTER Z WITH ACUTE
		mCharacterTable.put('\u017B', "Z"); // LATIN CAPITAL LETTER Z WITH DOT
											// ABOVE
		mCharacterTable.put('\u017C', "z"); // LATIN SMALL LETTER Z WITH DOT
											// ABOVE
		mCharacterTable.put('\u017D', "Z"); // LATIN CAPITAL LETTER Z WITH CARON
		mCharacterTable.put('\u017E', "z"); // LATIN SMALL LETTER Z WITH CARON
		mCharacterTable.put('\u017F', "s"); // LATIN SMALL LETTER LONG S
		mCharacterTable.put('\u0180', "b"); // LATIN SMALL LETTER B WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u0181', "B"); // LATIN CAPITAL LETTER B WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0182', "B"); // LATIN CAPITAL LETTER B WITH
											// TOPBAR -- no decomposition
		mCharacterTable.put('\u0183', "b"); // LATIN SMALL LETTER B WITH TOPBAR
											// -- no decomposition
		mCharacterTable.put('\u0184', "6"); // LATIN CAPITAL LETTER TONE SIX --
											// no decomposition
		mCharacterTable.put('\u0185', "6"); // LATIN SMALL LETTER TONE SIX -- no
											// decomposition
		mCharacterTable.put('\u0186', "O"); // LATIN CAPITAL LETTER OPEN O -- no
											// decomposition
		mCharacterTable.put('\u0187', "C"); // LATIN CAPITAL LETTER C WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0188', "c"); // LATIN SMALL LETTER C WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0189', "D"); // LATIN CAPITAL LETTER AFRICAN D --
											// no decomposition
		mCharacterTable.put('\u018A', "D"); // LATIN CAPITAL LETTER D WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u018B', "D"); // LATIN CAPITAL LETTER D WITH
											// TOPBAR -- no decomposition
		mCharacterTable.put('\u018C', "d"); // LATIN SMALL LETTER D WITH TOPBAR
											// -- no decomposition
		mCharacterTable.put('\u018D', "d"); // LATIN SMALL LETTER TURNED DELTA
											// -- no decomposition
		mCharacterTable.put('\u018E', "E"); // LATIN CAPITAL LETTER REVERSED E
											// -- no decomposition
		mCharacterTable.put('\u018F', "E"); // LATIN CAPITAL LETTER SCHWA -- no
											// decomposition
		mCharacterTable.put('\u0190', "E"); // LATIN CAPITAL LETTER OPEN E -- no
											// decomposition
		mCharacterTable.put('\u0191', "F"); // LATIN CAPITAL LETTER F WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0192', "f"); // LATIN SMALL LETTER F WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0193', "G"); // LATIN CAPITAL LETTER G WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0194', "G"); // LATIN CAPITAL LETTER GAMMA -- no
											// decomposition
		mCharacterTable.put('\u0195', "hv"); // LATIN SMALL LETTER HV -- no
												// decomposition
		mCharacterTable.put('\u0196', "I"); // LATIN CAPITAL LETTER IOTA -- no
											// decomposition
		mCharacterTable.put('\u0197', "I"); // LATIN CAPITAL LETTER I WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u0198', "K"); // LATIN CAPITAL LETTER K WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0199', "k"); // LATIN SMALL LETTER K WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u019A', "l"); // LATIN SMALL LETTER L WITH BAR --
											// no decomposition
		mCharacterTable.put('\u019B', "l"); // LATIN SMALL LETTER LAMBDA WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u019C', "M"); // LATIN CAPITAL LETTER TURNED M --
											// no decomposition
		mCharacterTable.put('\u019D', "N"); // LATIN CAPITAL LETTER N WITH LEFT
											// HOOK -- no decomposition
		mCharacterTable.put('\u019E', "n"); // LATIN SMALL LETTER N WITH LONG
											// RIGHT LEG -- no decomposition
		mCharacterTable.put('\u019F', "O"); // LATIN CAPITAL LETTER O WITH
											// MIDDLE TILDE -- no decomposition
		mCharacterTable.put('\u01A0', "O"); // LATIN CAPITAL LETTER O WITH HORN
		mCharacterTable.put('\u01A1', "o"); // LATIN SMALL LETTER O WITH HORN
		mCharacterTable.put('\u01A2', "OI"); // LATIN CAPITAL LETTER OI -- no
												// decomposition
		mCharacterTable.put('\u01A3', "oi"); // LATIN SMALL LETTER OI -- no
												// decomposition
		mCharacterTable.put('\u01A4', "P"); // LATIN CAPITAL LETTER P WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u01A5', "p"); // LATIN SMALL LETTER P WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u01A6', "YR"); // LATIN LETTER YR -- no
												// decomposition
		mCharacterTable.put('\u01A7', "2"); // LATIN CAPITAL LETTER TONE TWO --
											// no decomposition
		mCharacterTable.put('\u01A8', "2"); // LATIN SMALL LETTER TONE TWO -- no
											// decomposition
		mCharacterTable.put('\u01A9', "S"); // LATIN CAPITAL LETTER ESH -- no
											// decomposition
		mCharacterTable.put('\u01AA', "s"); // LATIN LETTER REVERSED ESH LOOP --
											// no decomposition
		mCharacterTable.put('\u01AB', "t"); // LATIN SMALL LETTER T WITH PALATAL
											// HOOK -- no decomposition
		mCharacterTable.put('\u01AC', "T"); // LATIN CAPITAL LETTER T WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u01AD', "t"); // LATIN SMALL LETTER T WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u01AE', "T"); // LATIN CAPITAL LETTER T WITH
											// RETROFLEX HOOK -- no
											// decomposition
		mCharacterTable.put('\u01AF', "U"); // LATIN CAPITAL LETTER U WITH HORN
		mCharacterTable.put('\u01B0', "u"); // LATIN SMALL LETTER U WITH HORN
		mCharacterTable.put('\u01B1', "u"); // LATIN CAPITAL LETTER UPSILON --
											// no decomposition
		mCharacterTable.put('\u01B2', "V"); // LATIN CAPITAL LETTER V WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u01B3', "Y"); // LATIN CAPITAL LETTER Y WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u01B4', "y"); // LATIN SMALL LETTER Y WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u01B5', "Z"); // LATIN CAPITAL LETTER Z WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u01B6', "z"); // LATIN SMALL LETTER Z WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u01B7', "Z"); // LATIN CAPITAL LETTER EZH -- no
											// decomposition
		mCharacterTable.put('\u01B8', "Z"); // LATIN CAPITAL LETTER EZH REVERSED
											// -- no decomposition
		mCharacterTable.put('\u01B9', "Z"); // LATIN SMALL LETTER EZH REVERSED
											// -- no decomposition
		mCharacterTable.put('\u01BA', "z"); // LATIN SMALL LETTER EZH WITH TAIL
											// -- no decomposition
		mCharacterTable.put('\u01BB', "2"); // LATIN LETTER TWO WITH STROKE --
											// no decomposition
		mCharacterTable.put('\u01BC', "5"); // LATIN CAPITAL LETTER TONE FIVE --
											// no decomposition
		mCharacterTable.put('\u01BD', "5"); // LATIN SMALL LETTER TONE FIVE --
											// no decomposition
		mCharacterTable.put('\u01BE', "´"); // LATIN LETTER INVERTED GLOTTAL
											// STOP WITH STROKE -- no
											// decomposition
		mCharacterTable.put('\u01BF', "w"); // LATIN LETTER WYNN -- no
											// decomposition
		mCharacterTable.put('\u01C0', "!"); // LATIN LETTER DENTAL CLICK -- no
											// decomposition
		mCharacterTable.put('\u01C1', "!"); // LATIN LETTER LATERAL CLICK -- no
											// decomposition
		mCharacterTable.put('\u01C2', "!"); // LATIN LETTER ALVEOLAR CLICK -- no
											// decomposition
		mCharacterTable.put('\u01C3', "!"); // LATIN LETTER RETROFLEX CLICK --
											// no decomposition
		mCharacterTable.put('\u01C4', "DZ"); // LATIN CAPITAL LETTER DZ WITH
												// CARON
		mCharacterTable.put('\u01C5', "DZ"); // LATIN CAPITAL LETTER D WITH
												// SMALL LETTER Z WITH CARON
		mCharacterTable.put('\u01C6', "d"); // LATIN SMALL LETTER DZ WITH CARON
		mCharacterTable.put('\u01C7', "Lj"); // LATIN CAPITAL LETTER LJ
		mCharacterTable.put('\u01C8', "Lj"); // LATIN CAPITAL LETTER L WITH
												// SMALL LETTER J
		mCharacterTable.put('\u01C9', "lj"); // LATIN SMALL LETTER LJ
		mCharacterTable.put('\u01CA', "NJ"); // LATIN CAPITAL LETTER NJ
		mCharacterTable.put('\u01CB', "NJ"); // LATIN CAPITAL LETTER N WITH
												// SMALL LETTER J
		mCharacterTable.put('\u01CC', "nj"); // LATIN SMALL LETTER NJ
		mCharacterTable.put('\u01CD', "A"); // LATIN CAPITAL LETTER A WITH CARON
		mCharacterTable.put('\u01CE', "a"); // LATIN SMALL LETTER A WITH CARON
		mCharacterTable.put('\u01CF', "I"); // LATIN CAPITAL LETTER I WITH CARON
		mCharacterTable.put('\u01D0', "i"); // LATIN SMALL LETTER I WITH CARON
		mCharacterTable.put('\u01D1', "O"); // LATIN CAPITAL LETTER O WITH CARON
		mCharacterTable.put('\u01D2', "o"); // LATIN SMALL LETTER O WITH CARON
		mCharacterTable.put('\u01D3', "U"); // LATIN CAPITAL LETTER U WITH CARON
		mCharacterTable.put('\u01D4', "u"); // LATIN SMALL LETTER U WITH CARON
		mCharacterTable.put('\u01D5', "U"); // LATIN CAPITAL LETTER U WITH
											// DIAERESIS AND MACRON
		mCharacterTable.put('\u01D6', "u"); // LATIN SMALL LETTER U WITH
											// DIAERESIS AND MACRON
		mCharacterTable.put('\u01D7', "U"); // LATIN CAPITAL LETTER U WITH
											// DIAERESIS AND ACUTE
		mCharacterTable.put('\u01D8', "u"); // LATIN SMALL LETTER U WITH
											// DIAERESIS AND ACUTE
		mCharacterTable.put('\u01D9', "U"); // LATIN CAPITAL LETTER U WITH
											// DIAERESIS AND CARON
		mCharacterTable.put('\u01DA', "u"); // LATIN SMALL LETTER U WITH
											// DIAERESIS AND CARON
		mCharacterTable.put('\u01DB', "U"); // LATIN CAPITAL LETTER U WITH
											// DIAERESIS AND GRAVE
		mCharacterTable.put('\u01DC', "u"); // LATIN SMALL LETTER U WITH
											// DIAERESIS AND GRAVE
		mCharacterTable.put('\u01DD', "e"); // LATIN SMALL LETTER TURNED E -- no
											// decomposition
		mCharacterTable.put('\u01DE', "A"); // LATIN CAPITAL LETTER A WITH
											// DIAERESIS AND MACRON
		mCharacterTable.put('\u01DF', "a"); // LATIN SMALL LETTER A WITH
											// DIAERESIS AND MACRON
		mCharacterTable.put('\u01E0', "A"); // LATIN CAPITAL LETTER A WITH DOT
											// ABOVE AND MACRON
		mCharacterTable.put('\u01E1', "a"); // LATIN SMALL LETTER A WITH DOT
											// ABOVE AND MACRON
		mCharacterTable.put('\u01E2', "AE"); // LATIN CAPITAL LETTER AE WITH
												// MACRON
		mCharacterTable.put('\u01E3', "ae"); // LATIN SMALL LETTER AE WITH
												// MACRON
		mCharacterTable.put('\u01E4', "G"); // LATIN CAPITAL LETTER G WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u01E5', "g"); // LATIN SMALL LETTER G WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u01E6', "G"); // LATIN CAPITAL LETTER G WITH CARON
		mCharacterTable.put('\u01E7', "g"); // LATIN SMALL LETTER G WITH CARON
		mCharacterTable.put('\u01E8', "K"); // LATIN CAPITAL LETTER K WITH CARON
		mCharacterTable.put('\u01E9', "k"); // LATIN SMALL LETTER K WITH CARON
		mCharacterTable.put('\u01EA', "O"); // LATIN CAPITAL LETTER O WITH
											// OGONEK
		mCharacterTable.put('\u01EB', "o"); // LATIN SMALL LETTER O WITH OGONEK
		mCharacterTable.put('\u01EC', "O"); // LATIN CAPITAL LETTER O WITH
											// OGONEK AND MACRON
		mCharacterTable.put('\u01ED', "o"); // LATIN SMALL LETTER O WITH OGONEK
											// AND MACRON
		mCharacterTable.put('\u01EE', "Z"); // LATIN CAPITAL LETTER EZH WITH
											// CARON
		mCharacterTable.put('\u01EF', "Z"); // LATIN SMALL LETTER EZH WITH CARON
		mCharacterTable.put('\u01F0', "j"); // LATIN SMALL LETTER J WITH CARON
		mCharacterTable.put('\u01F1', "DZ"); // LATIN CAPITAL LETTER DZ
		mCharacterTable.put('\u01F2', "DZ"); // LATIN CAPITAL LETTER D WITH
												// SMALL LETTER Z
		mCharacterTable.put('\u01F3', "dz"); // LATIN SMALL LETTER DZ
		mCharacterTable.put('\u01F4', "G"); // LATIN CAPITAL LETTER G WITH ACUTE
		mCharacterTable.put('\u01F5', "g"); // LATIN SMALL LETTER G WITH ACUTE
		mCharacterTable.put('\u01F6', "hv"); // LATIN CAPITAL LETTER HWAIR -- no
												// decomposition
		mCharacterTable.put('\u01F7', "w"); // LATIN CAPITAL LETTER WYNN -- no
											// decomposition
		mCharacterTable.put('\u01F8', "N"); // LATIN CAPITAL LETTER N WITH GRAVE
		mCharacterTable.put('\u01F9', "n"); // LATIN SMALL LETTER N WITH GRAVE
		mCharacterTable.put('\u01FA', "A"); // LATIN CAPITAL LETTER A WITH RING
											// ABOVE AND ACUTE
		mCharacterTable.put('\u01FB', "a"); // LATIN SMALL LETTER A WITH RING
											// ABOVE AND ACUTE
		mCharacterTable.put('\u01FC', "AE"); // LATIN CAPITAL LETTER AE WITH
												// ACUTE
		mCharacterTable.put('\u01FD', "ae"); // LATIN SMALL LETTER AE WITH ACUTE
		mCharacterTable.put('\u01FE', "O"); // LATIN CAPITAL LETTER O WITH
											// STROKE AND ACUTE
		mCharacterTable.put('\u01FF', "o"); // LATIN SMALL LETTER O WITH STROKE
											// AND ACUTE
		mCharacterTable.put('\u0200', "A"); // LATIN CAPITAL LETTER A WITH
											// DOUBLE GRAVE
		mCharacterTable.put('\u0201', "a"); // LATIN SMALL LETTER A WITH DOUBLE
											// GRAVE
		mCharacterTable.put('\u0202', "A"); // LATIN CAPITAL LETTER A WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0203', "a"); // LATIN SMALL LETTER A WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0204', "E"); // LATIN CAPITAL LETTER E WITH
											// DOUBLE GRAVE
		mCharacterTable.put('\u0205', "e"); // LATIN SMALL LETTER E WITH DOUBLE
											// GRAVE
		mCharacterTable.put('\u0206', "E"); // LATIN CAPITAL LETTER E WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0207', "e"); // LATIN SMALL LETTER E WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0208', "I"); // LATIN CAPITAL LETTER I WITH
											// DOUBLE GRAVE
		mCharacterTable.put('\u0209', "i"); // LATIN SMALL LETTER I WITH DOUBLE
											// GRAVE
		mCharacterTable.put('\u020A', "I"); // LATIN CAPITAL LETTER I WITH
											// INVERTED BREVE
		mCharacterTable.put('\u020B', "i"); // LATIN SMALL LETTER I WITH
											// INVERTED BREVE
		mCharacterTable.put('\u020C', "O"); // LATIN CAPITAL LETTER O WITH
											// DOUBLE GRAVE
		mCharacterTable.put('\u020D', "o"); // LATIN SMALL LETTER O WITH DOUBLE
											// GRAVE
		mCharacterTable.put('\u020E', "O"); // LATIN CAPITAL LETTER O WITH
											// INVERTED BREVE
		mCharacterTable.put('\u020F', "o"); // LATIN SMALL LETTER O WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0210', "R"); // LATIN CAPITAL LETTER R WITH
											// DOUBLE GRAVE
		mCharacterTable.put('\u0211', "r"); // LATIN SMALL LETTER R WITH DOUBLE
											// GRAVE
		mCharacterTable.put('\u0212', "R"); // LATIN CAPITAL LETTER R WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0213', "r"); // LATIN SMALL LETTER R WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0214', "U"); // LATIN CAPITAL LETTER U WITH
											// DOUBLE GRAVE
		mCharacterTable.put('\u0215', "u"); // LATIN SMALL LETTER U WITH DOUBLE
											// GRAVE
		mCharacterTable.put('\u0216', "U"); // LATIN CAPITAL LETTER U WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0217', "u"); // LATIN SMALL LETTER U WITH
											// INVERTED BREVE
		mCharacterTable.put('\u0218', "S"); // LATIN CAPITAL LETTER S WITH COMMA
											// BELOW
		mCharacterTable.put('\u0219', "s"); // LATIN SMALL LETTER S WITH COMMA
											// BELOW
		mCharacterTable.put('\u021A', "T"); // LATIN CAPITAL LETTER T WITH COMMA
											// BELOW
		mCharacterTable.put('\u021B', "t"); // LATIN SMALL LETTER T WITH COMMA
											// BELOW
		mCharacterTable.put('\u021C', "Z"); // LATIN CAPITAL LETTER YOGH -- no
											// decomposition
		mCharacterTable.put('\u021D', "z"); // LATIN SMALL LETTER YOGH -- no
											// decomposition
		mCharacterTable.put('\u021E', "H"); // LATIN CAPITAL LETTER H WITH CARON
		mCharacterTable.put('\u021F', "h"); // LATIN SMALL LETTER H WITH CARON
		mCharacterTable.put('\u0220', "N"); // LATIN CAPITAL LETTER N WITH LONG
											// RIGHT LEG -- no decomposition
		mCharacterTable.put('\u0221', "d"); // LATIN SMALL LETTER D WITH CURL --
											// no decomposition
		mCharacterTable.put('\u0222', "OU"); // LATIN CAPITAL LETTER OU -- no
												// decomposition
		mCharacterTable.put('\u0223', "ou"); // LATIN SMALL LETTER OU -- no
												// decomposition
		mCharacterTable.put('\u0224', "Z"); // LATIN CAPITAL LETTER Z WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0225', "z"); // LATIN SMALL LETTER Z WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0226', "A"); // LATIN CAPITAL LETTER A WITH DOT
											// ABOVE
		mCharacterTable.put('\u0227', "a"); // LATIN SMALL LETTER A WITH DOT
											// ABOVE
		mCharacterTable.put('\u0228', "E"); // LATIN CAPITAL LETTER E WITH
											// CEDILLA
		mCharacterTable.put('\u0229', "e"); // LATIN SMALL LETTER E WITH CEDILLA
		mCharacterTable.put('\u022A', "O"); // LATIN CAPITAL LETTER O WITH
											// DIAERESIS AND MACRON
		mCharacterTable.put('\u022B', "o"); // LATIN SMALL LETTER O WITH
											// DIAERESIS AND MACRON
		mCharacterTable.put('\u022C', "O"); // LATIN CAPITAL LETTER O WITH TILDE
											// AND MACRON
		mCharacterTable.put('\u022D', "o"); // LATIN SMALL LETTER O WITH TILDE
											// AND MACRON
		mCharacterTable.put('\u022E', "O"); // LATIN CAPITAL LETTER O WITH DOT
											// ABOVE
		mCharacterTable.put('\u022F', "o"); // LATIN SMALL LETTER O WITH DOT
											// ABOVE
		mCharacterTable.put('\u0230', "O"); // LATIN CAPITAL LETTER O WITH DOT
											// ABOVE AND MACRON
		mCharacterTable.put('\u0231', "o"); // LATIN SMALL LETTER O WITH DOT
											// ABOVE AND MACRON
		mCharacterTable.put('\u0232', "Y"); // LATIN CAPITAL LETTER Y WITH
											// MACRON
		mCharacterTable.put('\u0233', "y"); // LATIN SMALL LETTER Y WITH MACRON
		mCharacterTable.put('\u0234', "l"); // LATIN SMALL LETTER L WITH CURL --
											// no decomposition
		mCharacterTable.put('\u0235', "n"); // LATIN SMALL LETTER N WITH CURL --
											// no decomposition
		mCharacterTable.put('\u0236', "t"); // LATIN SMALL LETTER T WITH CURL --
											// no decomposition
		mCharacterTable.put('\u0250', "a"); // LATIN SMALL LETTER TURNED A -- no
											// decomposition
		mCharacterTable.put('\u0251', "a"); // LATIN SMALL LETTER ALPHA -- no
											// decomposition
		mCharacterTable.put('\u0252', "a"); // LATIN SMALL LETTER TURNED ALPHA
											// -- no decomposition
		mCharacterTable.put('\u0253', "b"); // LATIN SMALL LETTER B WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0254', "o"); // LATIN SMALL LETTER OPEN O -- no
											// decomposition
		mCharacterTable.put('\u0255', "c"); // LATIN SMALL LETTER C WITH CURL --
											// no decomposition
		mCharacterTable.put('\u0256', "d"); // LATIN SMALL LETTER D WITH TAIL --
											// no decomposition
		mCharacterTable.put('\u0257', "d"); // LATIN SMALL LETTER D WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0258', "e"); // LATIN SMALL LETTER REVERSED E --
											// no decomposition
		mCharacterTable.put('\u0259', "e"); // LATIN SMALL LETTER SCHWA -- no
											// decomposition
		mCharacterTable.put('\u025A', "e"); // LATIN SMALL LETTER SCHWA WITH
											// HOOK -- no decomposition
		mCharacterTable.put('\u025B', "e"); // LATIN SMALL LETTER OPEN E -- no
											// decomposition
		mCharacterTable.put('\u025C', "e"); // LATIN SMALL LETTER REVERSED OPEN
											// E -- no decomposition
		mCharacterTable.put('\u025D', "e"); // LATIN SMALL LETTER REVERSED OPEN
											// E WITH HOOK -- no decomposition
		mCharacterTable.put('\u025E', "e"); // LATIN SMALL LETTER CLOSED
											// REVERSED OPEN E -- no
											// decomposition
		mCharacterTable.put('\u025F', "j"); // LATIN SMALL LETTER DOTLESS J WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u0260', "g"); // LATIN SMALL LETTER G WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0261', "g"); // LATIN SMALL LETTER SCRIPT G -- no
											// decomposition
		mCharacterTable.put('\u0262', "G"); // LATIN LETTER SMALL CAPITAL G --
											// no decomposition
		mCharacterTable.put('\u0263', "g"); // LATIN SMALL LETTER GAMMA -- no
											// decomposition
		mCharacterTable.put('\u0264', "y"); // LATIN SMALL LETTER RAMS HORN --
											// no decomposition
		mCharacterTable.put('\u0265', "h"); // LATIN SMALL LETTER TURNED H -- no
											// decomposition
		mCharacterTable.put('\u0266', "h"); // LATIN SMALL LETTER H WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0267', "h"); // LATIN SMALL LETTER HENG WITH HOOK
											// -- no decomposition
		mCharacterTable.put('\u0268', "i"); // LATIN SMALL LETTER I WITH STROKE
											// -- no decomposition
		mCharacterTable.put('\u0269', "i"); // LATIN SMALL LETTER IOTA -- no
											// decomposition
		mCharacterTable.put('\u026A', "I"); // LATIN LETTER SMALL CAPITAL I --
											// no decomposition
		mCharacterTable.put('\u026B', "l"); // LATIN SMALL LETTER L WITH MIDDLE
											// TILDE -- no decomposition
		mCharacterTable.put('\u026C', "l"); // LATIN SMALL LETTER L WITH BELT --
											// no decomposition
		mCharacterTable.put('\u026D', "l"); // LATIN SMALL LETTER L WITH
											// RETROFLEX HOOK -- no
											// decomposition
		mCharacterTable.put('\u026E', "lz"); // LATIN SMALL LETTER LEZH -- no
												// decomposition
		mCharacterTable.put('\u026F', "m"); // LATIN SMALL LETTER TURNED M -- no
											// decomposition
		mCharacterTable.put('\u0270', "m"); // LATIN SMALL LETTER TURNED M WITH
											// LONG LEG -- no decomposition
		mCharacterTable.put('\u0271', "m"); // LATIN SMALL LETTER M WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0272', "n"); // LATIN SMALL LETTER N WITH LEFT
											// HOOK -- no decomposition
		mCharacterTable.put('\u0273', "n"); // LATIN SMALL LETTER N WITH
											// RETROFLEX HOOK -- no
											// decomposition
		mCharacterTable.put('\u0274', "N"); // LATIN LETTER SMALL CAPITAL N --
											// no decomposition
		mCharacterTable.put('\u0275', "o"); // LATIN SMALL LETTER BARRED O -- no
											// decomposition
		mCharacterTable.put('\u0276', "OE"); // LATIN LETTER SMALL CAPITAL OE --
												// no decomposition
		mCharacterTable.put('\u0277', "o"); // LATIN SMALL LETTER CLOSED OMEGA
											// -- no decomposition
		mCharacterTable.put('\u0278', "ph"); // LATIN SMALL LETTER PHI -- no
												// decomposition
		mCharacterTable.put('\u0279', "r"); // LATIN SMALL LETTER TURNED R -- no
											// decomposition
		mCharacterTable.put('\u027A', "r"); // LATIN SMALL LETTER TURNED R WITH
											// LONG LEG -- no decomposition
		mCharacterTable.put('\u027B', "r"); // LATIN SMALL LETTER TURNED R WITH
											// HOOK -- no decomposition
		mCharacterTable.put('\u027C', "r"); // LATIN SMALL LETTER R WITH LONG
											// LEG -- no decomposition
		mCharacterTable.put('\u027D', "r"); // LATIN SMALL LETTER R WITH TAIL --
											// no decomposition
		mCharacterTable.put('\u027E', "r"); // LATIN SMALL LETTER R WITH
											// FISHHOOK -- no decomposition
		mCharacterTable.put('\u027F', "r"); // LATIN SMALL LETTER REVERSED R
											// WITH FISHHOOK -- no decomposition
		mCharacterTable.put('\u0280', "R"); // LATIN LETTER SMALL CAPITAL R --
											// no decomposition
		mCharacterTable.put('\u0281', "r"); // LATIN LETTER SMALL CAPITAL
											// INVERTED R -- no decomposition
		mCharacterTable.put('\u0282', "s"); // LATIN SMALL LETTER S WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u0283', "s"); // LATIN SMALL LETTER ESH -- no
											// decomposition
		mCharacterTable.put('\u0284', "j"); // LATIN SMALL LETTER DOTLESS J WITH
											// STROKE AND HOOK -- no
											// decomposition
		mCharacterTable.put('\u0285', "s"); // LATIN SMALL LETTER SQUAT REVERSED
											// ESH -- no decomposition
		mCharacterTable.put('\u0286', "s"); // LATIN SMALL LETTER ESH WITH CURL
											// -- no decomposition
		mCharacterTable.put('\u0287', "y"); // LATIN SMALL LETTER TURNED T -- no
											// decomposition
		mCharacterTable.put('\u0288', "t"); // LATIN SMALL LETTER T WITH
											// RETROFLEX HOOK -- no
											// decomposition
		mCharacterTable.put('\u0289', "u"); // LATIN SMALL LETTER U BAR -- no
											// decomposition
		mCharacterTable.put('\u028A', "u"); // LATIN SMALL LETTER UPSILON -- no
											// decomposition
		mCharacterTable.put('\u028B', "u"); // LATIN SMALL LETTER V WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u028C', "v"); // LATIN SMALL LETTER TURNED V -- no
											// decomposition
		mCharacterTable.put('\u028D', "w"); // LATIN SMALL LETTER TURNED W -- no
											// decomposition
		mCharacterTable.put('\u028E', "y"); // LATIN SMALL LETTER TURNED Y -- no
											// decomposition
		mCharacterTable.put('\u028F', "Y"); // LATIN LETTER SMALL CAPITAL Y --
											// no decomposition
		mCharacterTable.put('\u0290', "z"); // LATIN SMALL LETTER Z WITH
											// RETROFLEX HOOK -- no
											// decomposition
		mCharacterTable.put('\u0291', "z"); // LATIN SMALL LETTER Z WITH CURL --
											// no decomposition
		mCharacterTable.put('\u0292', "z"); // LATIN SMALL LETTER EZH -- no
											// decomposition
		mCharacterTable.put('\u0293', "z"); // LATIN SMALL LETTER EZH WITH CURL
											// -- no decomposition
		mCharacterTable.put('\u0294', "'"); // LATIN LETTER GLOTTAL STOP -- no
											// decomposition
		mCharacterTable.put('\u0295', "'"); // LATIN LETTER PHARYNGEAL VOICED
											// FRICATIVE -- no decomposition
		mCharacterTable.put('\u0296', "'"); // LATIN LETTER INVERTED GLOTTAL
											// STOP -- no decomposition
		mCharacterTable.put('\u0297', "C"); // LATIN LETTER STRETCHED C -- no
											// decomposition
		mCharacterTable.put('\u0298', "O˜"); // LATIN LETTER BILABIAL CLICK --
												// no decomposition
		mCharacterTable.put('\u0299', "B"); // LATIN LETTER SMALL CAPITAL B --
											// no decomposition
		mCharacterTable.put('\u029A', "e"); // LATIN SMALL LETTER CLOSED OPEN E
											// -- no decomposition
		mCharacterTable.put('\u029B', "G"); // LATIN LETTER SMALL CAPITAL G WITH
											// HOOK -- no decomposition
		mCharacterTable.put('\u029C', "H"); // LATIN LETTER SMALL CAPITAL H --
											// no decomposition
		mCharacterTable.put('\u029D', "j"); // LATIN SMALL LETTER J WITH
											// CROSSED-TAIL -- no decomposition
		mCharacterTable.put('\u029E', "k"); // LATIN SMALL LETTER TURNED K -- no
											// decomposition
		mCharacterTable.put('\u029F', "L"); // LATIN LETTER SMALL CAPITAL L --
											// no decomposition
		mCharacterTable.put('\u02A0', "q"); // LATIN SMALL LETTER Q WITH HOOK --
											// no decomposition
		mCharacterTable.put('\u02A1', "'"); // LATIN LETTER GLOTTAL STOP WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u02A2', "'"); // LATIN LETTER REVERSED GLOTTAL
											// STOP WITH STROKE -- no
											// decomposition
		mCharacterTable.put('\u02A3', "dz"); // LATIN SMALL LETTER DZ DIGRAPH --
												// no decomposition
		mCharacterTable.put('\u02A4', "dz"); // LATIN SMALL LETTER DEZH DIGRAPH
												// -- no decomposition
		mCharacterTable.put('\u02A5', "dz"); // LATIN SMALL LETTER DZ DIGRAPH
												// WITH CURL -- no decomposition
		mCharacterTable.put('\u02A6', "ts"); // LATIN SMALL LETTER TS DIGRAPH --
												// no decomposition
		mCharacterTable.put('\u02A7', "ts"); // LATIN SMALL LETTER TESH DIGRAPH
												// -- no decomposition
		mCharacterTable.put('\u02A8', ""); // LATIN SMALL LETTER TC DIGRAPH WITH
											// CURL -- no decomposition
		mCharacterTable.put('\u02A9', "fn"); // LATIN SMALL LETTER FENG DIGRAPH
												// -- no decomposition
		mCharacterTable.put('\u02AA', "ls"); // LATIN SMALL LETTER LS DIGRAPH --
												// no decomposition
		mCharacterTable.put('\u02AB', "lz"); // LATIN SMALL LETTER LZ DIGRAPH --
												// no decomposition
		mCharacterTable.put('\u02AC', "w"); // LATIN LETTER BILABIAL PERCUSSIVE
											// -- no decomposition
		mCharacterTable.put('\u02AD', "t"); // LATIN LETTER BIDENTAL PERCUSSIVE
											// -- no decomposition
		mCharacterTable.put('\u02AE', "h"); // LATIN SMALL LETTER TURNED H WITH
											// FISHHOOK -- no decomposition
		mCharacterTable.put('\u02AF', "h"); // LATIN SMALL LETTER TURNED H WITH
											// FISHHOOK AND TAIL -- no
											// decomposition
		mCharacterTable.put('\u02B0', "h"); // MODIFIER LETTER SMALL H
		mCharacterTable.put('\u02B1', "h"); // MODIFIER LETTER SMALL H WITH HOOK
		mCharacterTable.put('\u02B2', "j"); // MODIFIER LETTER SMALL J
		mCharacterTable.put('\u02B3', "r"); // MODIFIER LETTER SMALL R
		mCharacterTable.put('\u02B4', "r"); // MODIFIER LETTER SMALL TURNED R
		mCharacterTable.put('\u02B5', "r"); // MODIFIER LETTER SMALL TURNED R
											// WITH HOOK
		mCharacterTable.put('\u02B6', "R"); // MODIFIER LETTER SMALL CAPITAL
											// INVERTED R
		mCharacterTable.put('\u02B7', "w"); // MODIFIER LETTER SMALL W
		mCharacterTable.put('\u02B8', "y"); // MODIFIER LETTER SMALL Y
		mCharacterTable.put('\u02E1', "l"); // MODIFIER LETTER SMALL L
		mCharacterTable.put('\u02E2', "s"); // MODIFIER LETTER SMALL S
		mCharacterTable.put('\u02E3', "x"); // MODIFIER LETTER SMALL X
		mCharacterTable.put('\u02E4', "'"); // MODIFIER LETTER SMALL REVERSED
											// GLOTTAL STOP
		mCharacterTable.put('\u1D00', "A"); // LATIN LETTER SMALL CAPITAL A --
											// no decomposition
		mCharacterTable.put('\u1D01', "AE"); // LATIN LETTER SMALL CAPITAL AE --
												// no decomposition
		mCharacterTable.put('\u1D02', "ae"); // LATIN SMALL LETTER TURNED AE --
												// no decomposition
		mCharacterTable.put('\u1D03', "B"); // LATIN LETTER SMALL CAPITAL BARRED
											// B -- no decomposition
		mCharacterTable.put('\u1D04', "C"); // LATIN LETTER SMALL CAPITAL C --
											// no decomposition
		mCharacterTable.put('\u1D05', "D"); // LATIN LETTER SMALL CAPITAL D --
											// no decomposition
		mCharacterTable.put('\u1D06', "TH"); // LATIN LETTER SMALL CAPITAL ETH
												// -- no decomposition
		mCharacterTable.put('\u1D07', "E"); // LATIN LETTER SMALL CAPITAL E --
											// no decomposition
		mCharacterTable.put('\u1D08', "e"); // LATIN SMALL LETTER TURNED OPEN E
											// -- no decomposition
		mCharacterTable.put('\u1D09', "i"); // LATIN SMALL LETTER TURNED I -- no
											// decomposition
		mCharacterTable.put('\u1D0A', "J"); // LATIN LETTER SMALL CAPITAL J --
											// no decomposition
		mCharacterTable.put('\u1D0B', "K"); // LATIN LETTER SMALL CAPITAL K --
											// no decomposition
		mCharacterTable.put('\u1D0C', "L"); // LATIN LETTER SMALL CAPITAL L WITH
											// STROKE -- no decomposition
		mCharacterTable.put('\u1D0D', "M"); // LATIN LETTER SMALL CAPITAL M --
											// no decomposition
		mCharacterTable.put('\u1D0E', "N"); // LATIN LETTER SMALL CAPITAL
											// REVERSED N -- no decomposition
		mCharacterTable.put('\u1D0F', "O"); // LATIN LETTER SMALL CAPITAL O --
											// no decomposition
		mCharacterTable.put('\u1D10', "O"); // LATIN LETTER SMALL CAPITAL OPEN O
											// -- no decomposition
		mCharacterTable.put('\u1D11', "o"); // LATIN SMALL LETTER SIDEWAYS O --
											// no decomposition
		mCharacterTable.put('\u1D12', "o"); // LATIN SMALL LETTER SIDEWAYS OPEN
											// O -- no decomposition
		mCharacterTable.put('\u1D13', "o"); // LATIN SMALL LETTER SIDEWAYS O
											// WITH STROKE -- no decomposition
		mCharacterTable.put('\u1D14', "oe"); // LATIN SMALL LETTER TURNED OE --
												// no decomposition
		mCharacterTable.put('\u1D15', "ou"); // LATIN LETTER SMALL CAPITAL OU --
												// no decomposition
		mCharacterTable.put('\u1D16', "o"); // LATIN SMALL LETTER TOP HALF O --
											// no decomposition
		mCharacterTable.put('\u1D17', "o"); // LATIN SMALL LETTER BOTTOM HALF O
											// -- no decomposition
		mCharacterTable.put('\u1D18', "P"); // LATIN LETTER SMALL CAPITAL P --
											// no decomposition
		mCharacterTable.put('\u1D19', "R"); // LATIN LETTER SMALL CAPITAL
											// REVERSED R -- no decomposition
		mCharacterTable.put('\u1D1A', "R"); // LATIN LETTER SMALL CAPITAL TURNED
											// R -- no decomposition
		mCharacterTable.put('\u1D1B', "T"); // LATIN LETTER SMALL CAPITAL T --
											// no decomposition
		mCharacterTable.put('\u1D1C', "U"); // LATIN LETTER SMALL CAPITAL U --
											// no decomposition
		mCharacterTable.put('\u1D1D', "u"); // LATIN SMALL LETTER SIDEWAYS U --
											// no decomposition
		mCharacterTable.put('\u1D1E', "u"); // LATIN SMALL LETTER SIDEWAYS
											// DIAERESIZED U -- no decomposition
		mCharacterTable.put('\u1D1F', "m"); // LATIN SMALL LETTER SIDEWAYS
											// TURNED M -- no decomposition
		mCharacterTable.put('\u1D20', "V"); // LATIN LETTER SMALL CAPITAL V --
											// no decomposition
		mCharacterTable.put('\u1D21', "W"); // LATIN LETTER SMALL CAPITAL W --
											// no decomposition
		mCharacterTable.put('\u1D22', "Z"); // LATIN LETTER SMALL CAPITAL Z --
											// no decomposition
		mCharacterTable.put('\u1D23', "EZH"); // LATIN LETTER SMALL CAPITAL EZH
												// -- no decomposition
		mCharacterTable.put('\u1D24', "'"); // LATIN LETTER VOICED LARYNGEAL
											// SPIRANT -- no decomposition
		mCharacterTable.put('\u1D25', "L"); // LATIN LETTER AIN -- no
											// decomposition
		mCharacterTable.put('\u1D2C', "A"); // MODIFIER LETTER CAPITAL A
		mCharacterTable.put('\u1D2D', "AE"); // MODIFIER LETTER CAPITAL AE
		mCharacterTable.put('\u1D2E', "B"); // MODIFIER LETTER CAPITAL B
		mCharacterTable.put('\u1D2F', "B"); // MODIFIER LETTER CAPITAL BARRED B
											// -- no decomposition
		mCharacterTable.put('\u1D30', "D"); // MODIFIER LETTER CAPITAL D
		mCharacterTable.put('\u1D31', "E"); // MODIFIER LETTER CAPITAL E
		mCharacterTable.put('\u1D32', "E"); // MODIFIER LETTER CAPITAL REVERSED
											// E
		mCharacterTable.put('\u1D33', "G"); // MODIFIER LETTER CAPITAL G
		mCharacterTable.put('\u1D34', "H"); // MODIFIER LETTER CAPITAL H
		mCharacterTable.put('\u1D35', "I"); // MODIFIER LETTER CAPITAL I
		mCharacterTable.put('\u1D36', "J"); // MODIFIER LETTER CAPITAL J
		mCharacterTable.put('\u1D37', "K"); // MODIFIER LETTER CAPITAL K
		mCharacterTable.put('\u1D38', "L"); // MODIFIER LETTER CAPITAL L
		mCharacterTable.put('\u1D39', "M"); // MODIFIER LETTER CAPITAL M
		mCharacterTable.put('\u1D3A', "N"); // MODIFIER LETTER CAPITAL N
		mCharacterTable.put('\u1D3B', "N"); // MODIFIER LETTER CAPITAL REVERSED
											// N -- no decomposition
		mCharacterTable.put('\u1D3C', "O"); // MODIFIER LETTER CAPITAL O
		mCharacterTable.put('\u1D3D', "OU"); // MODIFIER LETTER CAPITAL OU
		mCharacterTable.put('\u1D3E', "P"); // MODIFIER LETTER CAPITAL P
		mCharacterTable.put('\u1D3F', "R"); // MODIFIER LETTER CAPITAL R
		mCharacterTable.put('\u1D40', "T"); // MODIFIER LETTER CAPITAL T
		mCharacterTable.put('\u1D41', "U"); // MODIFIER LETTER CAPITAL U
		mCharacterTable.put('\u1D42', "W"); // MODIFIER LETTER CAPITAL W
		mCharacterTable.put('\u1D43', "a"); // MODIFIER LETTER SMALL A
		mCharacterTable.put('\u1D44', "a"); // MODIFIER LETTER SMALL TURNED A
		mCharacterTable.put('\u1D46', "ae"); // MODIFIER LETTER SMALL TURNED AE
		mCharacterTable.put('\u1D47', "b"); // MODIFIER LETTER SMALL B
		mCharacterTable.put('\u1D48', "d"); // MODIFIER LETTER SMALL D
		mCharacterTable.put('\u1D49', "e"); // MODIFIER LETTER SMALL E
		mCharacterTable.put('\u1D4A', "e"); // MODIFIER LETTER SMALL SCHWA
		mCharacterTable.put('\u1D4B', "e"); // MODIFIER LETTER SMALL OPEN E
		mCharacterTable.put('\u1D4C', "e"); // MODIFIER LETTER SMALL TURNED OPEN
											// E
		mCharacterTable.put('\u1D4D', "g"); // MODIFIER LETTER SMALL G
		mCharacterTable.put('\u1D4E', "i"); // MODIFIER LETTER SMALL TURNED I --
											// no decomposition
		mCharacterTable.put('\u1D4F', "k"); // MODIFIER LETTER SMALL K
		mCharacterTable.put('\u1D50', "m"); // MODIFIER LETTER SMALL M
		mCharacterTable.put('\u1D51', "g"); // MODIFIER LETTER SMALL ENG
		mCharacterTable.put('\u1D52', "o"); // MODIFIER LETTER SMALL O
		mCharacterTable.put('\u1D53', "o"); // MODIFIER LETTER SMALL OPEN O
		mCharacterTable.put('\u1D54', "o"); // MODIFIER LETTER SMALL TOP HALF O
		mCharacterTable.put('\u1D55', "o"); // MODIFIER LETTER SMALL BOTTOM HALF
											// O
		mCharacterTable.put('\u1D56', "p"); // MODIFIER LETTER SMALL P
		mCharacterTable.put('\u1D57', "t"); // MODIFIER LETTER SMALL T
		mCharacterTable.put('\u1D58', "u"); // MODIFIER LETTER SMALL U
		mCharacterTable.put('\u1D59', "u"); // MODIFIER LETTER SMALL SIDEWAYS U
		mCharacterTable.put('\u1D5A', "m"); // MODIFIER LETTER SMALL TURNED M
		mCharacterTable.put('\u1D5B', "v"); // MODIFIER LETTER SMALL V
		mCharacterTable.put('\u1D62', "i"); // LATIN SUBSCRIPT SMALL LETTER I
		mCharacterTable.put('\u1D63', "r"); // LATIN SUBSCRIPT SMALL LETTER R
		mCharacterTable.put('\u1D64', "u"); // LATIN SUBSCRIPT SMALL LETTER U
		mCharacterTable.put('\u1D65', "v"); // LATIN SUBSCRIPT SMALL LETTER V
		mCharacterTable.put('\u1D6B', "ue"); // LATIN SMALL LETTER UE -- no
												// decomposition
		mCharacterTable.put('\u1E00', "A"); // LATIN CAPITAL LETTER A WITH RING
											// BELOW
		mCharacterTable.put('\u1E01', "a"); // LATIN SMALL LETTER A WITH RING
											// BELOW
		mCharacterTable.put('\u1E02', "B"); // LATIN CAPITAL LETTER B WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E03', "b"); // LATIN SMALL LETTER B WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E04', "B"); // LATIN CAPITAL LETTER B WITH DOT
											// BELOW
		mCharacterTable.put('\u1E05', "b"); // LATIN SMALL LETTER B WITH DOT
											// BELOW
		mCharacterTable.put('\u1E06', "B"); // LATIN CAPITAL LETTER B WITH LINE
											// BELOW
		mCharacterTable.put('\u1E07', "b"); // LATIN SMALL LETTER B WITH LINE
											// BELOW
		mCharacterTable.put('\u1E08', "C"); // LATIN CAPITAL LETTER C WITH
											// CEDILLA AND ACUTE
		mCharacterTable.put('\u1E09', "c"); // LATIN SMALL LETTER C WITH CEDILLA
											// AND ACUTE
		mCharacterTable.put('\u1E0A', "D"); // LATIN CAPITAL LETTER D WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E0B', "d"); // LATIN SMALL LETTER D WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E0C', "D"); // LATIN CAPITAL LETTER D WITH DOT
											// BELOW
		mCharacterTable.put('\u1E0D', "d"); // LATIN SMALL LETTER D WITH DOT
											// BELOW
		mCharacterTable.put('\u1E0E', "D"); // LATIN CAPITAL LETTER D WITH LINE
											// BELOW
		mCharacterTable.put('\u1E0F', "d"); // LATIN SMALL LETTER D WITH LINE
											// BELOW
		mCharacterTable.put('\u1E10', "D"); // LATIN CAPITAL LETTER D WITH
											// CEDILLA
		mCharacterTable.put('\u1E11', "d"); // LATIN SMALL LETTER D WITH CEDILLA
		mCharacterTable.put('\u1E12', "D"); // LATIN CAPITAL LETTER D WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E13', "d"); // LATIN SMALL LETTER D WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E14', "E"); // LATIN CAPITAL LETTER E WITH
											// MACRON AND GRAVE
		mCharacterTable.put('\u1E15', "e"); // LATIN SMALL LETTER E WITH MACRON
											// AND GRAVE
		mCharacterTable.put('\u1E16', "E"); // LATIN CAPITAL LETTER E WITH
											// MACRON AND ACUTE
		mCharacterTable.put('\u1E17', "e"); // LATIN SMALL LETTER E WITH MACRON
											// AND ACUTE
		mCharacterTable.put('\u1E18', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E19', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E1A', "E"); // LATIN CAPITAL LETTER E WITH TILDE
											// BELOW
		mCharacterTable.put('\u1E1B', "e"); // LATIN SMALL LETTER E WITH TILDE
											// BELOW
		mCharacterTable.put('\u1E1C', "E"); // LATIN CAPITAL LETTER E WITH
											// CEDILLA AND BREVE
		mCharacterTable.put('\u1E1D', "e"); // LATIN SMALL LETTER E WITH CEDILLA
											// AND BREVE
		mCharacterTable.put('\u1E1E', "F"); // LATIN CAPITAL LETTER F WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E1F', "f"); // LATIN SMALL LETTER F WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E20', "G"); // LATIN CAPITAL LETTER G WITH
											// MACRON
		mCharacterTable.put('\u1E21', "g"); // LATIN SMALL LETTER G WITH MACRON
		mCharacterTable.put('\u1E22', "H"); // LATIN CAPITAL LETTER H WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E23', "h"); // LATIN SMALL LETTER H WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E24', "H"); // LATIN CAPITAL LETTER H WITH DOT
											// BELOW
		mCharacterTable.put('\u1E25', "h"); // LATIN SMALL LETTER H WITH DOT
											// BELOW
		mCharacterTable.put('\u1E26', "H"); // LATIN CAPITAL LETTER H WITH
											// DIAERESIS
		mCharacterTable.put('\u1E27', "h"); // LATIN SMALL LETTER H WITH
											// DIAERESIS
		mCharacterTable.put('\u1E28', "H"); // LATIN CAPITAL LETTER H WITH
											// CEDILLA
		mCharacterTable.put('\u1E29', "h"); // LATIN SMALL LETTER H WITH CEDILLA
		mCharacterTable.put('\u1E2A', "H"); // LATIN CAPITAL LETTER H WITH BREVE
											// BELOW
		mCharacterTable.put('\u1E2B', "h"); // LATIN SMALL LETTER H WITH BREVE
											// BELOW
		mCharacterTable.put('\u1E2C', "I"); // LATIN CAPITAL LETTER I WITH TILDE
											// BELOW
		mCharacterTable.put('\u1E2D', "i"); // LATIN SMALL LETTER I WITH TILDE
											// BELOW
		mCharacterTable.put('\u1E2E', "I"); // LATIN CAPITAL LETTER I WITH
											// DIAERESIS AND ACUTE
		mCharacterTable.put('\u1E2F', "i"); // LATIN SMALL LETTER I WITH
											// DIAERESIS AND ACUTE
		mCharacterTable.put('\u1E30', "K"); // LATIN CAPITAL LETTER K WITH ACUTE
		mCharacterTable.put('\u1E31', "k"); // LATIN SMALL LETTER K WITH ACUTE
		mCharacterTable.put('\u1E32', "K"); // LATIN CAPITAL LETTER K WITH DOT
											// BELOW
		mCharacterTable.put('\u1E33', "k"); // LATIN SMALL LETTER K WITH DOT
											// BELOW
		mCharacterTable.put('\u1E34', "K"); // LATIN CAPITAL LETTER K WITH LINE
											// BELOW
		mCharacterTable.put('\u1E35', "k"); // LATIN SMALL LETTER K WITH LINE
											// BELOW
		mCharacterTable.put('\u1E36', "L"); // LATIN CAPITAL LETTER L WITH DOT
											// BELOW
		mCharacterTable.put('\u1E37', "l"); // LATIN SMALL LETTER L WITH DOT
											// BELOW
		mCharacterTable.put('\u1E38', "L"); // LATIN CAPITAL LETTER L WITH DOT
											// BELOW AND MACRON
		mCharacterTable.put('\u1E39', "l"); // LATIN SMALL LETTER L WITH DOT
											// BELOW AND MACRON
		mCharacterTable.put('\u1E3A', "L"); // LATIN CAPITAL LETTER L WITH LINE
											// BELOW
		mCharacterTable.put('\u1E3B', "l"); // LATIN SMALL LETTER L WITH LINE
											// BELOW
		mCharacterTable.put('\u1E3C', "L"); // LATIN CAPITAL LETTER L WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E3D', "l"); // LATIN SMALL LETTER L WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E3E', "M"); // LATIN CAPITAL LETTER M WITH ACUTE
		mCharacterTable.put('\u1E3F', "m"); // LATIN SMALL LETTER M WITH ACUTE
		mCharacterTable.put('\u1E40', "M"); // LATIN CAPITAL LETTER M WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E41', "m"); // LATIN SMALL LETTER M WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E42', "M"); // LATIN CAPITAL LETTER M WITH DOT
											// BELOW
		mCharacterTable.put('\u1E43', "m"); // LATIN SMALL LETTER M WITH DOT
											// BELOW
		mCharacterTable.put('\u1E44', "N"); // LATIN CAPITAL LETTER N WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E45', "n"); // LATIN SMALL LETTER N WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E46', "N"); // LATIN CAPITAL LETTER N WITH DOT
											// BELOW
		mCharacterTable.put('\u1E47', "n"); // LATIN SMALL LETTER N WITH DOT
											// BELOW
		mCharacterTable.put('\u1E48', "N"); // LATIN CAPITAL LETTER N WITH LINE
											// BELOW
		mCharacterTable.put('\u1E49', "n"); // LATIN SMALL LETTER N WITH LINE
											// BELOW
		mCharacterTable.put('\u1E4A', "N"); // LATIN CAPITAL LETTER N WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E4B', "n"); // LATIN SMALL LETTER N WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E4C', "O"); // LATIN CAPITAL LETTER O WITH TILDE
											// AND ACUTE
		mCharacterTable.put('\u1E4D', "o"); // LATIN SMALL LETTER O WITH TILDE
											// AND ACUTE
		mCharacterTable.put('\u1E4E', "O"); // LATIN CAPITAL LETTER O WITH TILDE
											// AND DIAERESIS
		mCharacterTable.put('\u1E4F', "o"); // LATIN SMALL LETTER O WITH TILDE
											// AND DIAERESIS
		mCharacterTable.put('\u1E50', "O"); // LATIN CAPITAL LETTER O WITH
											// MACRON AND GRAVE
		mCharacterTable.put('\u1E51', "o"); // LATIN SMALL LETTER O WITH MACRON
											// AND GRAVE
		mCharacterTable.put('\u1E52', "O"); // LATIN CAPITAL LETTER O WITH
											// MACRON AND ACUTE
		mCharacterTable.put('\u1E53', "o"); // LATIN SMALL LETTER O WITH MACRON
											// AND ACUTE
		mCharacterTable.put('\u1E54', "P"); // LATIN CAPITAL LETTER P WITH ACUTE
		mCharacterTable.put('\u1E55', "p"); // LATIN SMALL LETTER P WITH ACUTE
		mCharacterTable.put('\u1E56', "P"); // LATIN CAPITAL LETTER P WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E57', "p"); // LATIN SMALL LETTER P WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E58', "R"); // LATIN CAPITAL LETTER R WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E59', "r"); // LATIN SMALL LETTER R WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E5A', "R"); // LATIN CAPITAL LETTER R WITH DOT
											// BELOW
		mCharacterTable.put('\u1E5B', "r"); // LATIN SMALL LETTER R WITH DOT
											// BELOW
		mCharacterTable.put('\u1E5C', "R"); // LATIN CAPITAL LETTER R WITH DOT
											// BELOW AND MACRON
		mCharacterTable.put('\u1E5D', "r"); // LATIN SMALL LETTER R WITH DOT
											// BELOW AND MACRON
		mCharacterTable.put('\u1E5E', "R"); // LATIN CAPITAL LETTER R WITH LINE
											// BELOW
		mCharacterTable.put('\u1E5F', "r"); // LATIN SMALL LETTER R WITH LINE
											// BELOW
		mCharacterTable.put('\u1E60', "S"); // LATIN CAPITAL LETTER S WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E61', "s"); // LATIN SMALL LETTER S WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E62', "S"); // LATIN CAPITAL LETTER S WITH DOT
											// BELOW
		mCharacterTable.put('\u1E63', "s"); // LATIN SMALL LETTER S WITH DOT
											// BELOW
		mCharacterTable.put('\u1E64', "S"); // LATIN CAPITAL LETTER S WITH ACUTE
											// AND DOT ABOVE
		mCharacterTable.put('\u1E65', "s"); // LATIN SMALL LETTER S WITH ACUTE
											// AND DOT ABOVE
		mCharacterTable.put('\u1E66', "S"); // LATIN CAPITAL LETTER S WITH CARON
											// AND DOT ABOVE
		mCharacterTable.put('\u1E67', "s"); // LATIN SMALL LETTER S WITH CARON
											// AND DOT ABOVE
		mCharacterTable.put('\u1E68', "S"); // LATIN CAPITAL LETTER S WITH DOT
											// BELOW AND DOT ABOVE
		mCharacterTable.put('\u1E69', "s"); // LATIN SMALL LETTER S WITH DOT
											// BELOW AND DOT ABOVE
		mCharacterTable.put('\u1E6A', "T"); // LATIN CAPITAL LETTER T WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E6B', "t"); // LATIN SMALL LETTER T WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E6C', "T"); // LATIN CAPITAL LETTER T WITH DOT
											// BELOW
		mCharacterTable.put('\u1E6D', "t"); // LATIN SMALL LETTER T WITH DOT
											// BELOW
		mCharacterTable.put('\u1E6E', "T"); // LATIN CAPITAL LETTER T WITH LINE
											// BELOW
		mCharacterTable.put('\u1E6F', "t"); // LATIN SMALL LETTER T WITH LINE
											// BELOW
		mCharacterTable.put('\u1E70', "T"); // LATIN CAPITAL LETTER T WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E71', "t"); // LATIN SMALL LETTER T WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E72', "U"); // LATIN CAPITAL LETTER U WITH
											// DIAERESIS BELOW
		mCharacterTable.put('\u1E73', "u"); // LATIN SMALL LETTER U WITH
											// DIAERESIS BELOW
		mCharacterTable.put('\u1E74', "U"); // LATIN CAPITAL LETTER U WITH TILDE
											// BELOW
		mCharacterTable.put('\u1E75', "u"); // LATIN SMALL LETTER U WITH TILDE
											// BELOW
		mCharacterTable.put('\u1E76', "U"); // LATIN CAPITAL LETTER U WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E77', "u"); // LATIN SMALL LETTER U WITH
											// CIRCUMFLEX BELOW
		mCharacterTable.put('\u1E78', "U"); // LATIN CAPITAL LETTER U WITH TILDE
											// AND ACUTE
		mCharacterTable.put('\u1E79', "u"); // LATIN SMALL LETTER U WITH TILDE
											// AND ACUTE
		mCharacterTable.put('\u1E7A', "U"); // LATIN CAPITAL LETTER U WITH
											// MACRON AND DIAERESIS
		mCharacterTable.put('\u1E7B', "u"); // LATIN SMALL LETTER U WITH MACRON
											// AND DIAERESIS
		mCharacterTable.put('\u1E7C', "V"); // LATIN CAPITAL LETTER V WITH TILDE
		mCharacterTable.put('\u1E7D', "v"); // LATIN SMALL LETTER V WITH TILDE
		mCharacterTable.put('\u1E7E', "V"); // LATIN CAPITAL LETTER V WITH DOT
											// BELOW
		mCharacterTable.put('\u1E7F', "v"); // LATIN SMALL LETTER V WITH DOT
											// BELOW
		mCharacterTable.put('\u1E80', "W"); // LATIN CAPITAL LETTER W WITH GRAVE
		mCharacterTable.put('\u1E81', "w"); // LATIN SMALL LETTER W WITH GRAVE
		mCharacterTable.put('\u1E82', "W"); // LATIN CAPITAL LETTER W WITH ACUTE
		mCharacterTable.put('\u1E83', "w"); // LATIN SMALL LETTER W WITH ACUTE
		mCharacterTable.put('\u1E84', "W"); // LATIN CAPITAL LETTER W WITH
											// DIAERESIS
		mCharacterTable.put('\u1E85', "w"); // LATIN SMALL LETTER W WITH
											// DIAERESIS
		mCharacterTable.put('\u1E86', "W"); // LATIN CAPITAL LETTER W WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E87', "w"); // LATIN SMALL LETTER W WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E88', "W"); // LATIN CAPITAL LETTER W WITH DOT
											// BELOW
		mCharacterTable.put('\u1E89', "w"); // LATIN SMALL LETTER W WITH DOT
											// BELOW
		mCharacterTable.put('\u1E8A', "X"); // LATIN CAPITAL LETTER X WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E8B', "x"); // LATIN SMALL LETTER X WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E8C', "X"); // LATIN CAPITAL LETTER X WITH
											// DIAERESIS
		mCharacterTable.put('\u1E8D', "x"); // LATIN SMALL LETTER X WITH
											// DIAERESIS
		mCharacterTable.put('\u1E8E', "Y"); // LATIN CAPITAL LETTER Y WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E8F', "y"); // LATIN SMALL LETTER Y WITH DOT
											// ABOVE
		mCharacterTable.put('\u1E90', "Z"); // LATIN CAPITAL LETTER Z WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u1E91', "z"); // LATIN SMALL LETTER Z WITH
											// CIRCUMFLEX
		mCharacterTable.put('\u1E92', "Z"); // LATIN CAPITAL LETTER Z WITH DOT
											// BELOW
		mCharacterTable.put('\u1E93', "z"); // LATIN SMALL LETTER Z WITH DOT
											// BELOW
		mCharacterTable.put('\u1E94', "Z"); // LATIN CAPITAL LETTER Z WITH LINE
											// BELOW
		mCharacterTable.put('\u1E95', "z"); // LATIN SMALL LETTER Z WITH LINE
											// BELOW
		mCharacterTable.put('\u1E96', "h"); // LATIN SMALL LETTER H WITH LINE
											// BELOW
		mCharacterTable.put('\u1E97', "t"); // LATIN SMALL LETTER T WITH
											// DIAERESIS
		mCharacterTable.put('\u1E98', "w"); // LATIN SMALL LETTER W WITH RING
											// ABOVE
		mCharacterTable.put('\u1E99', "y"); // LATIN SMALL LETTER Y WITH RING
											// ABOVE
		mCharacterTable.put('\u1E9A', "a"); // LATIN SMALL LETTER A WITH RIGHT
											// HALF RING
		mCharacterTable.put('\u1E9B', "s"); // LATIN SMALL LETTER LONG S WITH
											// DOT ABOVE
		mCharacterTable.put('\u1EA0', "A"); // LATIN CAPITAL LETTER A WITH DOT
											// BELOW
		mCharacterTable.put('\u1EA1', "a"); // LATIN SMALL LETTER A WITH DOT
											// BELOW
		mCharacterTable.put('\u1EA2', "A"); // LATIN CAPITAL LETTER A WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EA3', "a"); // LATIN SMALL LETTER A WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EA4', "A"); // LATIN CAPITAL LETTER A WITH
											// CIRCUMFLEX AND ACUTE
		mCharacterTable.put('\u1EA5', "a"); // LATIN SMALL LETTER A WITH
											// CIRCUMFLEX AND ACUTE
		mCharacterTable.put('\u1EA6', "A"); // LATIN CAPITAL LETTER A WITH
											// CIRCUMFLEX AND GRAVE
		mCharacterTable.put('\u1EA7', "a"); // LATIN SMALL LETTER A WITH
											// CIRCUMFLEX AND GRAVE
		mCharacterTable.put('\u1EA8', "A"); // LATIN CAPITAL LETTER A WITH
											// CIRCUMFLEX AND HOOK ABOVE
		mCharacterTable.put('\u1EA9', "a"); // LATIN SMALL LETTER A WITH
											// CIRCUMFLEX AND HOOK ABOVE
		mCharacterTable.put('\u1EAA', "A"); // LATIN CAPITAL LETTER A WITH
											// CIRCUMFLEX AND TILDE
		mCharacterTable.put('\u1EAB', "a"); // LATIN SMALL LETTER A WITH
											// CIRCUMFLEX AND TILDE
		mCharacterTable.put('\u1EAC', "A"); // LATIN CAPITAL LETTER A WITH
											// CIRCUMFLEX AND DOT BELOW
		mCharacterTable.put('\u1EAD', "a"); // LATIN SMALL LETTER A WITH
											// CIRCUMFLEX AND DOT BELOW
		mCharacterTable.put('\u1EAE', "A"); // LATIN CAPITAL LETTER A WITH BREVE
											// AND ACUTE
		mCharacterTable.put('\u1EAF', "a"); // LATIN SMALL LETTER A WITH BREVE
											// AND ACUTE
		mCharacterTable.put('\u1EB0', "A"); // LATIN CAPITAL LETTER A WITH BREVE
											// AND GRAVE
		mCharacterTable.put('\u1EB1', "a"); // LATIN SMALL LETTER A WITH BREVE
											// AND GRAVE
		mCharacterTable.put('\u1EB2', "A"); // LATIN CAPITAL LETTER A WITH BREVE
											// AND HOOK ABOVE
		mCharacterTable.put('\u1EB3', "a"); // LATIN SMALL LETTER A WITH BREVE
											// AND HOOK ABOVE
		mCharacterTable.put('\u1EB4', "A"); // LATIN CAPITAL LETTER A WITH BREVE
											// AND TILDE
		mCharacterTable.put('\u1EB5', "a"); // LATIN SMALL LETTER A WITH BREVE
											// AND TILDE
		mCharacterTable.put('\u1EB6', "A"); // LATIN CAPITAL LETTER A WITH BREVE
											// AND DOT BELOW
		mCharacterTable.put('\u1EB7', "a"); // LATIN SMALL LETTER A WITH BREVE
											// AND DOT BELOW
		mCharacterTable.put('\u1EB8', "E"); // LATIN CAPITAL LETTER E WITH DOT
											// BELOW
		mCharacterTable.put('\u1EB9', "e"); // LATIN SMALL LETTER E WITH DOT
											// BELOW
		mCharacterTable.put('\u1EBA', "E"); // LATIN CAPITAL LETTER E WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EBB', "e"); // LATIN SMALL LETTER E WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EBC', "E"); // LATIN CAPITAL LETTER E WITH TILDE
		mCharacterTable.put('\u1EBD', "e"); // LATIN SMALL LETTER E WITH TILDE
		mCharacterTable.put('\u1EBE', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX AND ACUTE
		mCharacterTable.put('\u1EBF', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX AND ACUTE
		mCharacterTable.put('\u1EC0', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX AND GRAVE
		mCharacterTable.put('\u1EC1', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX AND GRAVE
		mCharacterTable.put('\u1EC2', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX AND HOOK ABOVE
		mCharacterTable.put('\u1EC3', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX AND HOOK ABOVE
		mCharacterTable.put('\u1EC4', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX AND TILDE
		mCharacterTable.put('\u1EC5', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX AND TILDE
		mCharacterTable.put('\u1EC6', "E"); // LATIN CAPITAL LETTER E WITH
											// CIRCUMFLEX AND DOT BELOW
		mCharacterTable.put('\u1EC7', "e"); // LATIN SMALL LETTER E WITH
											// CIRCUMFLEX AND DOT BELOW
		mCharacterTable.put('\u1EC8', "I"); // LATIN CAPITAL LETTER I WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EC9', "i"); // LATIN SMALL LETTER I WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1ECA', "I"); // LATIN CAPITAL LETTER I WITH DOT
											// BELOW
		mCharacterTable.put('\u1ECB', "i"); // LATIN SMALL LETTER I WITH DOT
											// BELOW
		mCharacterTable.put('\u1ECC', "O"); // LATIN CAPITAL LETTER O WITH DOT
											// BELOW
		mCharacterTable.put('\u1ECD', "o"); // LATIN SMALL LETTER O WITH DOT
											// BELOW
		mCharacterTable.put('\u1ECE', "O"); // LATIN CAPITAL LETTER O WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1ECF', "o"); // LATIN SMALL LETTER O WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1ED0', "O"); // LATIN CAPITAL LETTER O WITH
											// CIRCUMFLEX AND ACUTE
		mCharacterTable.put('\u1ED1', "o"); // LATIN SMALL LETTER O WITH
											// CIRCUMFLEX AND ACUTE
		mCharacterTable.put('\u1ED2', "O"); // LATIN CAPITAL LETTER O WITH
											// CIRCUMFLEX AND GRAVE
		mCharacterTable.put('\u1ED3', "o"); // LATIN SMALL LETTER O WITH
											// CIRCUMFLEX AND GRAVE
		mCharacterTable.put('\u1ED4', "O"); // LATIN CAPITAL LETTER O WITH
											// CIRCUMFLEX AND HOOK ABOVE
		mCharacterTable.put('\u1ED5', "o"); // LATIN SMALL LETTER O WITH
											// CIRCUMFLEX AND HOOK ABOVE
		mCharacterTable.put('\u1ED6', "O"); // LATIN CAPITAL LETTER O WITH
											// CIRCUMFLEX AND TILDE
		mCharacterTable.put('\u1ED7', "o"); // LATIN SMALL LETTER O WITH
											// CIRCUMFLEX AND TILDE
		mCharacterTable.put('\u1ED8', "O"); // LATIN CAPITAL LETTER O WITH
											// CIRCUMFLEX AND DOT BELOW
		mCharacterTable.put('\u1ED9', "o"); // LATIN SMALL LETTER O WITH
											// CIRCUMFLEX AND DOT BELOW
		mCharacterTable.put('\u1EDA', "O"); // LATIN CAPITAL LETTER O WITH HORN
											// AND ACUTE
		mCharacterTable.put('\u1EDB', "o"); // LATIN SMALL LETTER O WITH HORN
											// AND ACUTE
		mCharacterTable.put('\u1EDC', "O"); // LATIN CAPITAL LETTER O WITH HORN
											// AND GRAVE
		mCharacterTable.put('\u1EDD', "o"); // LATIN SMALL LETTER O WITH HORN
											// AND GRAVE
		mCharacterTable.put('\u1EDE', "O"); // LATIN CAPITAL LETTER O WITH HORN
											// AND HOOK ABOVE
		mCharacterTable.put('\u1EDF', "o"); // LATIN SMALL LETTER O WITH HORN
											// AND HOOK ABOVE
		mCharacterTable.put('\u1EE0', "O"); // LATIN CAPITAL LETTER O WITH HORN
											// AND TILDE
		mCharacterTable.put('\u1EE1', "o"); // LATIN SMALL LETTER O WITH HORN
											// AND TILDE
		mCharacterTable.put('\u1EE2', "O"); // LATIN CAPITAL LETTER O WITH HORN
											// AND DOT BELOW
		mCharacterTable.put('\u1EE3', "o"); // LATIN SMALL LETTER O WITH HORN
											// AND DOT BELOW
		mCharacterTable.put('\u1EE4', "U"); // LATIN CAPITAL LETTER U WITH DOT
											// BELOW
		mCharacterTable.put('\u1EE5', "u"); // LATIN SMALL LETTER U WITH DOT
											// BELOW
		mCharacterTable.put('\u1EE6', "U"); // LATIN CAPITAL LETTER U WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EE7', "u"); // LATIN SMALL LETTER U WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EE8', "U"); // LATIN CAPITAL LETTER U WITH HORN
											// AND ACUTE
		mCharacterTable.put('\u1EE9', "u"); // LATIN SMALL LETTER U WITH HORN
											// AND ACUTE
		mCharacterTable.put('\u1EEA', "U"); // LATIN CAPITAL LETTER U WITH HORN
											// AND GRAVE
		mCharacterTable.put('\u1EEB', "u"); // LATIN SMALL LETTER U WITH HORN
											// AND GRAVE
		mCharacterTable.put('\u1EEC', "U"); // LATIN CAPITAL LETTER U WITH HORN
											// AND HOOK ABOVE
		mCharacterTable.put('\u1EED', "u"); // LATIN SMALL LETTER U WITH HORN
											// AND HOOK ABOVE
		mCharacterTable.put('\u1EEE', "U"); // LATIN CAPITAL LETTER U WITH HORN
											// AND TILDE
		mCharacterTable.put('\u1EEF', "u"); // LATIN SMALL LETTER U WITH HORN
											// AND TILDE
		mCharacterTable.put('\u1EF0', "U"); // LATIN CAPITAL LETTER U WITH HORN
											// AND DOT BELOW
		mCharacterTable.put('\u1EF1', "u"); // LATIN SMALL LETTER U WITH HORN
											// AND DOT BELOW
		mCharacterTable.put('\u1EF2', "Y"); // LATIN CAPITAL LETTER Y WITH GRAVE
		mCharacterTable.put('\u1EF3', "y"); // LATIN SMALL LETTER Y WITH GRAVE
		mCharacterTable.put('\u1EF4', "Y"); // LATIN CAPITAL LETTER Y WITH DOT
											// BELOW
		mCharacterTable.put('\u1EF5', "y"); // LATIN SMALL LETTER Y WITH DOT
											// BELOW
		mCharacterTable.put('\u1EF6', "Y"); // LATIN CAPITAL LETTER Y WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EF7', "y"); // LATIN SMALL LETTER Y WITH HOOK
											// ABOVE
		mCharacterTable.put('\u1EF8', "Y"); // LATIN CAPITAL LETTER Y WITH TILDE
		mCharacterTable.put('\u1EF9', "y"); // LATIN SMALL LETTER Y WITH TILDE
		mCharacterTable.put('\u2071', "i"); // SUPERSCRIPT LATIN SMALL LETTER I
		mCharacterTable.put('\u207F', "n"); // SUPERSCRIPT LATIN SMALL LETTER N
		mCharacterTable.put('\u212A', "K"); // KELVIN SIGN
		mCharacterTable.put('\u212B', "A"); // ANGSTROM SIGN
		mCharacterTable.put('\u212C', "B"); // SCRIPT CAPITAL B
		mCharacterTable.put('\u212D', "C"); // BLACK-LETTER CAPITAL C
		mCharacterTable.put('\u212F', "e"); // SCRIPT SMALL E
		mCharacterTable.put('\u2130', "E"); // SCRIPT CAPITAL E
		mCharacterTable.put('\u2131', "F"); // SCRIPT CAPITAL F
		mCharacterTable.put('\u2132', "F"); // TURNED CAPITAL F -- no
											// decomposition
		mCharacterTable.put('\u2133', "M"); // SCRIPT CAPITAL M
		mCharacterTable.put('\u2134', "0"); // SCRIPT SMALL O
		mCharacterTable.put('\u213A', "0"); // ROTATED CAPITAL Q -- no
											// decomposition
		mCharacterTable.put('\u2141', "G"); // TURNED SANS-SERIF CAPITAL G -- no
											// decomposition
		mCharacterTable.put('\u2142', "L"); // TURNED SANS-SERIF CAPITAL L -- no
											// decomposition
		mCharacterTable.put('\u2143', "L"); // REVERSED SANS-SERIF CAPITAL L --
											// no decomposition
		mCharacterTable.put('\u2144', "Y"); // TURNED SANS-SERIF CAPITAL Y -- no
											// decomposition
		mCharacterTable.put('\u2145', "D"); // DOUBLE-STRUCK ITALIC CAPITAL D
		mCharacterTable.put('\u2146', "d"); // DOUBLE-STRUCK ITALIC SMALL D
		mCharacterTable.put('\u2147', "e"); // DOUBLE-STRUCK ITALIC SMALL E
		mCharacterTable.put('\u2148', "i"); // DOUBLE-STRUCK ITALIC SMALL I
		mCharacterTable.put('\u2149', "j"); // DOUBLE-STRUCK ITALIC SMALL J
		mCharacterTable.put('\uFB00', "ff"); // LATIN SMALL LIGATURE FF
		mCharacterTable.put('\uFB01', "fi"); // LATIN SMALL LIGATURE FI
		mCharacterTable.put('\uFB02', "fl"); // LATIN SMALL LIGATURE FL
		mCharacterTable.put('\uFB03', "ffi"); // LATIN SMALL LIGATURE FFI
		mCharacterTable.put('\uFB04', "ffl"); // LATIN SMALL LIGATURE FFL
		mCharacterTable.put('\uFB05', "st"); // LATIN SMALL LIGATURE LONG S T
		mCharacterTable.put('\uFB06', "st"); // LATIN SMALL LIGATURE ST
		mCharacterTable.put('\uFF21', "A"); // FULLWIDTH LATIN CAPITAL LETTER B
		mCharacterTable.put('\uFF22', "B"); // FULLWIDTH LATIN CAPITAL LETTER B
		mCharacterTable.put('\uFF23', "C"); // FULLWIDTH LATIN CAPITAL LETTER C
		mCharacterTable.put('\uFF24', "D"); // FULLWIDTH LATIN CAPITAL LETTER D
		mCharacterTable.put('\uFF25', "E"); // FULLWIDTH LATIN CAPITAL LETTER E
		mCharacterTable.put('\uFF26', "F"); // FULLWIDTH LATIN CAPITAL LETTER F
		mCharacterTable.put('\uFF27', "G"); // FULLWIDTH LATIN CAPITAL LETTER G
		mCharacterTable.put('\uFF28', "H"); // FULLWIDTH LATIN CAPITAL LETTER H
		mCharacterTable.put('\uFF29', "I"); // FULLWIDTH LATIN CAPITAL LETTER I
		mCharacterTable.put('\uFF2A', "J"); // FULLWIDTH LATIN CAPITAL LETTER J
		mCharacterTable.put('\uFF2B', "K"); // FULLWIDTH LATIN CAPITAL LETTER K
		mCharacterTable.put('\uFF2C', "L"); // FULLWIDTH LATIN CAPITAL LETTER L
		mCharacterTable.put('\uFF2D', "M"); // FULLWIDTH LATIN CAPITAL LETTER M
		mCharacterTable.put('\uFF2E', "N"); // FULLWIDTH LATIN CAPITAL LETTER N
		mCharacterTable.put('\uFF2F', "O"); // FULLWIDTH LATIN CAPITAL LETTER O
		mCharacterTable.put('\uFF30', "P"); // FULLWIDTH LATIN CAPITAL LETTER P
		mCharacterTable.put('\uFF31', "Q"); // FULLWIDTH LATIN CAPITAL LETTER Q
		mCharacterTable.put('\uFF32', "R"); // FULLWIDTH LATIN CAPITAL LETTER R
		mCharacterTable.put('\uFF33', "S"); // FULLWIDTH LATIN CAPITAL LETTER S
		mCharacterTable.put('\uFF34', "T"); // FULLWIDTH LATIN CAPITAL LETTER T
		mCharacterTable.put('\uFF35', "U"); // FULLWIDTH LATIN CAPITAL LETTER U
		mCharacterTable.put('\uFF36', "V"); // FULLWIDTH LATIN CAPITAL LETTER V
		mCharacterTable.put('\uFF37', "W"); // FULLWIDTH LATIN CAPITAL LETTER W
		mCharacterTable.put('\uFF38', "X"); // FULLWIDTH LATIN CAPITAL LETTER X
		mCharacterTable.put('\uFF39', "Y"); // FULLWIDTH LATIN CAPITAL LETTER Y
		mCharacterTable.put('\uFF3A', "Z"); // FULLWIDTH LATIN CAPITAL LETTER Z
		mCharacterTable.put('\uFF41', "a"); // FULLWIDTH LATIN SMALL LETTER A
		mCharacterTable.put('\uFF42', "b"); // FULLWIDTH LATIN SMALL LETTER B
		mCharacterTable.put('\uFF43', "c"); // FULLWIDTH LATIN SMALL LETTER C
		mCharacterTable.put('\uFF44', "d"); // FULLWIDTH LATIN SMALL LETTER D
		mCharacterTable.put('\uFF45', "e"); // FULLWIDTH LATIN SMALL LETTER E
		mCharacterTable.put('\uFF46', "f"); // FULLWIDTH LATIN SMALL LETTER F
		mCharacterTable.put('\uFF47', "g"); // FULLWIDTH LATIN SMALL LETTER G
		mCharacterTable.put('\uFF48', "h"); // FULLWIDTH LATIN SMALL LETTER H
		mCharacterTable.put('\uFF49', "i"); // FULLWIDTH LATIN SMALL LETTER I
		mCharacterTable.put('\uFF4A', "j"); // FULLWIDTH LATIN SMALL LETTER J
		mCharacterTable.put('\uFF4B', "k"); // FULLWIDTH LATIN SMALL LETTER K
		mCharacterTable.put('\uFF4C', "l"); // FULLWIDTH LATIN SMALL LETTER L
		mCharacterTable.put('\uFF4D', "m"); // FULLWIDTH LATIN SMALL LETTER M
		mCharacterTable.put('\uFF4E', "n"); // FULLWIDTH LATIN SMALL LETTER N
		mCharacterTable.put('\uFF4F', "o"); // FULLWIDTH LATIN SMALL LETTER O
		mCharacterTable.put('\uFF50', "p"); // FULLWIDTH LATIN SMALL LETTER P
		mCharacterTable.put('\uFF51', "q"); // FULLWIDTH LATIN SMALL LETTER Q
		mCharacterTable.put('\uFF52', "r"); // FULLWIDTH LATIN SMALL LETTER R
		mCharacterTable.put('\uFF53', "s"); // FULLWIDTH LATIN SMALL LETTER S
		mCharacterTable.put('\uFF54', "t"); // FULLWIDTH LATIN SMALL LETTER T
		mCharacterTable.put('\uFF55', "u"); // FULLWIDTH LATIN SMALL LETTER U
		mCharacterTable.put('\uFF56', "v"); // FULLWIDTH LATIN SMALL LETTER V
		mCharacterTable.put('\uFF57', "w"); // FULLWIDTH LATIN SMALL LETTER W
		mCharacterTable.put('\uFF58', "x"); // FULLWIDTH LATIN SMALL LETTER X
		mCharacterTable.put('\uFF59', "y"); // FULLWIDTH LATIN SMALL LETTER Y
		mCharacterTable.put('\uFF5A', "z"); // FULLWIDTH LATIN SMALL LETTER Z
	} // end addValues

}