package fhmssql;

import java.math.BigDecimal;

import org.junit.Test;

import com.fh.util.DataTypeConversion;

public class DataTypeTest {

//	@Test
	public void bigDecimalToString() {
		
		BigDecimal bdData = new BigDecimal("75.1");
		String bigDecimalToString = DataTypeConversion.bigDecimalToString(bdData);
		System.out.println(bigDecimalToString);
		
	}
	
//	@Test
	public void bigDecimalToPercentageTest() {
		
		BigDecimal bdData = new BigDecimal("75");
		String bigDecimalToPercentage = DataTypeConversion.bigDecimalToPercentage(bdData);
		System.out.println(bigDecimalToPercentage);
		
	}
	
	@Test
	public void StringUtilTest() {
		
		String cardNo = "6225758318989901";
		String cardNo1 = cardNo.substring(0,4);
		String cardNo2 = cardNo.substring(4,cardNo.length() - 4);
		String cardNo3 = cardNo.substring(cardNo.length() - 4, cardNo.length());
		cardNo2 = "********";
		String resultStr = cardNo1 + cardNo2 + cardNo3;
		System.out.println("resultStr = " + resultStr);
		
	}
	
}
