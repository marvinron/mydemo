package com.maviron.spring.springdemo.test;
 
import cn.hutool.crypto.digest.MD5;

import java.util.UUID;
 
/**
 * ① 将长字符串用md5算法生成32位签名串，分为4段,，每段8个字符；<br />
 * 
 * ② 对这4段循环处理，取每段的8个字符, 将他看成16进制字符串与0x3fffffff(30位1)的位与操作，超过30位的忽略处理；<br />
 * 
 * ③ 将每段得到的这30位又分成6段，每5位的数字作为字母表的索引取得特定字符，依次进行获得6位字符串；<br />
 * 
 * ④ 这样一个md5字符串可以获得4个6位串，取24位字符的前12位。<br />
 * 
 * @author zsj
 *
 */
public class ShortTextUtil {
	public static void main(String[] args) throws Exception {
		String uuid = UUID.randomUUID().toString();
		System.out.println(get12Char(uuid));
	}
 
	/**
	 * 获取短字符
	 * 
	 * @param uuid
	 * @return 大写
	 */
	public static String get12Char(String uuid) throws Exception {
		String arr[] = ShortText(uuid);
		String rst = (arr[0] + arr[1]).toUpperCase();
		return rst.substring(0, 4) + "-" + rst.substring(4, 8) + "-"
				+ rst.substring(8, 12);
	}
 
	private static String[] ShortText(String string) throws Exception {
		String key = "XuLiang"; // 自定义生成MD5加密字符串前的混合KEY
		String[] chars = new String[] { // 要使用生成URL的字符
		"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
				"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B",
				"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
				"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
 
		String hex = MD5Util.md5(key + string);
		int hexLen = hex.length();
		int subHexLen = hexLen / 8;
		String[] ShortStr = new String[4];
 
		for (int i = 0; i < subHexLen; i++) {
			String outChars = "";
			int j = i + 1;
			String subHex = hex.substring(i * 8, j * 8);
			long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);
 
			for (int k = 0; k < 6; k++) {
				int index = (int) (Long.valueOf("0000003D", 16) & idx);
				outChars += chars[index];
				idx = idx >> 5;
			}
			ShortStr[i] = outChars;
		}
 
		return ShortStr;
	}
}