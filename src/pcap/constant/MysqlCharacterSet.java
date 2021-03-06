package pcap.constant;

/**
 * mysql的字符集， 网上找的未验证。 将来会用到.
 * 
 * 我认为最好做成 enum形式
 * 
 * @see http
 *      ://dev.mysql.com/doc/internals/en/character-set.html#packet-Protocol:
 *      :CharacterSet
 */

public class MysqlCharacterSet {

    /***
     * int big5_chinese_ci =1; int latin2_czech_cs =2; int dec8_swedish_ci =3;
     * int cp850_general_ci =4; int latin1_german1_ci =5; int hp8_english_ci =6;
     * int koi8r_general_ci =7; int latin1_swedish_ci =8; int latin2_general_ci
     * =9; int swe7_swedish_ci =10; int ascii_general_ci =11; int
     * ujis_japanese_ci =12; int sjis_japanese_ci =13; int cp1251_bulgarian_ci
     * =14; int latin1_danish_ci =15; int hebrew_general_ci =16; int
     * tis620_thai_ci =18; int euckr_korean_ci =19; int latin7_estonian_cs =20;
     * int latin2_hungarian_ci =21; int koi8u_general_ci =22; int
     * cp1251_ukrainian_ci =23; int gb2312_chinese_ci =24; int greek_general_ci
     * =25; int cp1250_general_ci =26; int latin2_croatian_ci =27; int
     * gbk_chinese_ci =28; int cp1257_lithuanian_ci =29; int latin5_turkish_ci
     * =30; int latin1_german2_ci =31; int armscii8_general_ci =32; int
     * utf8_general_ci =33; int cp1250_czech_cs =34; int ucs2_general_ci =35;
     * int cp866_general_ci =36; int keybcs2_general_ci =37; int
     * macce_general_ci =38; int macroman_general_ci =39; int cp852_general_ci
     * =40; int latin7_general_ci =41; int latin7_general_cs =42; int macce_bin
     * =43; int cp1250_croatian_ci =44; int utf8mb4_general_ci =45; int
     * utf8mb4_bin =46; int latin1_bin =47; int latin1_general_ci =48; int
     * latin1_general_cs =49; int cp1251_bin =50; int cp1251_general_ci =51; int
     * cp1251_general_cs =52; int macroman_bin =53; int utf16_general_ci =54;
     * int utf16_bin =55; int cp1256_general_ci =57; int cp1257_bin =58; int
     * cp1257_general_ci =59; int utf32_general_ci =60; int utf32_bin =61; int
     * binary =63 ; int armscii8_bin =64 ; int ascii_bin =65 ; int cp1250_bin
     * =66 int cp1256_bin =67 ; int cp866_bin =68 ; int dec8_bin =69 ; int
     * greek_bin =70 ; int hebrew_bin 71 int hp8_bin 72 ; int keybcs2_bin 73 ;
     * int koi8r_bin 74 ; int koi8u_bin 75 ; int latin2_bin 77 int latin5_bin 78
     * ; int latin7_bin 79 ; int cp850_bin 80 ; int cp852_bin 81 int swe7_bin 82
     * ; int utf8_bin 83 ; int big5_bin 84 ; int euckr_bin 85 ; int gb2312_bin
     * 86 ; int gbk_bin 87 int sjis_bin 88 ; int tis620_bin 89 int ucs2_bin 90
     * int ujis_bin 91 int geostd8_general_ci 92 int geostd8_bin 93
     * latin1_spanish_ci 94 cp932_japanese_ci 95 cp932_bin 96
     * eucjpms_japanese_ci 97 eucjpms_bin 98 cp1250_polish_ci 99
     * utf16_unicode_ci 101 utf16_icelandic_ci 102 utf16_latvian_ci 103
     * utf16_romanian_ci 104 utf16_slovenian_ci 105 utf16_polish_ci 106
     * utf16_estonian_ci 107 utf16_spanish_ci 108 utf16_swedish_ci 109
     * utf16_turkish_ci 110 utf16_czech_ci 111 utf16_danish_ci 112
     * utf16_lithuanian_ci 113 utf16_slovak_ci 114 utf16_spanish2_ci 115
     * utf16_roman_ci 116 utf16_persian_ci 117 utf16_esperanto_ci 118
     * utf16_hungarian_ci 119 utf16_sinhala_ci 120 ucs2_unicode_ci 128
     * ucs2_icelandic_ci 129 ucs2_latvian_ci 130 ucs2_romanian_ci 131
     * ucs2_slovenian_ci 132 ucs2_polish_ci 133 ucs2_estonian_ci 134
     * ucs2_spanish_ci 135 ucs2_swedish_ci 136 ucs2_turkish_ci 137 ucs2_czech_ci
     * 138 ucs2_danish_ci 139 ucs2_lithuanian_ci 140 ucs2_slovak_ci 141
     * ucs2_spanish2_ci 142 ucs2_roman_ci 143 ucs2_persian_ci 144
     * ucs2_esperanto_ci 145 ucs2_hungarian_ci 146 ucs2_sinhala_ci 147
     * ucs2_general_mysql500_ci 159 utf32_unicode_ci 160 utf32_icelandic_ci 161
     * utf32_latvian_ci 162 utf32_romanian_ci 163 utf32_slovenian_ci 164
     * utf32_polish_ci 165 utf32_estonian_ci 166 utf32_spanish_ci 167
     * utf32_swedish_ci 168 utf32_turkish_ci 169 utf32_czech_ci 170
     * utf32_danish_ci 171 utf32_lithuanian_ci 172 utf32_slovak_ci 173
     * utf32_spanish2_ci 174 utf32_roman_ci 175 utf32_persian_ci 176
     * utf32_esperanto_ci 177 utf32_hungarian_ci 178 utf32_sinhala_ci 179
     * utf8_unicode_ci 192 utf8_icelandic_ci 193 utf8_latvian_ci 194
     * utf8_romanian_ci 195 utf8_slovenian_ci 196 utf8_polish_ci 197
     * utf8_estonian_ci 198 utf8_spanish_ci 199 utf8_swedish_ci 200
     * utf8_turkish_ci 201 utf8_czech_ci 202 utf8_danish_ci 203
     * utf8_lithuanian_ci 204 utf8_slovak_ci 205 utf8_spanish2_ci 206
     * utf8_roman_ci 207 utf8_persian_ci 208 utf8_esperanto_ci 209
     * utf8_hungarian_ci 210 utf8_sinhala_ci 211 utf8_general_mysql500_ci 223
     * utf8mb4_unicode_ci 224 utf8mb4_icelandic_ci 225 utf8mb4_latvian_ci 226
     * utf8mb4_romanian_ci 227 utf8mb4_slovenian_ci 228 utf8mb4_polish_ci 229
     * utf8mb4_estonian_ci 230 utf8mb4_spanish_ci 231 utf8mb4_swedish_ci 232
     * utf8mb4_turkish_ci 233 utf8mb4_czech_ci 234 utf8mb4_danish_ci 235
     * utf8mb4_lithuanian_ci 236 utf8mb4_slovak_ci 237 utf8mb4_spanish2_ci 238
     * utf8mb4_roman_ci 239 utf8mb4_persian_ci 240 utf8mb4_esperanto_ci 241
     * utf8mb4_hungarian_ci 242 utf8mb4_sinhala_ci 243
     ***/

}
