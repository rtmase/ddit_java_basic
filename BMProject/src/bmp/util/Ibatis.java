package bmp.util;

import java.io.IOException;
import java.io.InputStream;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Ibatis {
	private static SqlMapClient smc;
	
	private Ibatis() {
		String resource = "SqlMapConfig.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
			smc =  SqlMapClientBuilder.buildSqlMapClient(in);
			
			in.close();
		} catch (IOException e) {
			System.err.println("ibatis 설정 읽기 오류!");
			e.printStackTrace();
		}
	}
	
	public static SqlMapClient getInstance() {
		if (smc == null) {
			new Ibatis();
		}
		
		return smc;
	}
}
