import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tenwa.report.XMLEntity;
import com.tenwa.report.entity.ReportDataSource;
import com.tenwa.report.enums.DataSourceType;

public class MainTest {
	private static final Logger log = LoggerFactory.getLogger(MainTest.class);

	public static void main(String[] args) throws Exception {

		// System.out.println(String.format("yyyy-MM-dd", new Date()));
		String s = "";
		marshaller2();
	}

	private static void replaceDirty(String s) throws IOException {
		File f = new File("/Users/Simon/Downloads/1.xml");
		Reader reader = new InputStreamReader(new FileInputStream(f));
		char[] tempchars = new char[30];
		int charread = 0;
		StringBuffer sb = new StringBuffer();
		// 读入多个字符到字符数组中，charread为一次读取字符数
		while ((charread = reader.read(tempchars)) != -1) {
			// 同样屏蔽掉\r不显示
			if ((charread == tempchars.length)
					&& (tempchars[tempchars.length - 1] != '\r')) {
				sb.append(tempchars);
			} else {
				for (int i = 0; i < charread; i++) {
					if (tempchars[i] == '\r') {
						continue;
					} else {
						sb.append(tempchars);
					}
				}
			}
		}
		reader.close();

		String c = sb.toString();

		System.out.println(sb.toString());

	}
	
	private static ReportDataSource createDatasource(){
		ReportDataSource ds = new ReportDataSource();
		ds.setDataSourceName("datasourceName");
		ds.setDataSourceType(DataSourceType.JDBC);
		ds.setDialect("oracle");
		ds.setDialectName("oracle");
		ds.setId("id");
		ds.setDriverName("drivername");
		ds.setJndi("jndi");
		ds.setPassword("password");
		ds.setUrl("url");
		ds.setUsername("username");
		return ds;
	}
	
	
	
	private static void marshaller2() throws JAXBException{
		
		XMLEntity entity = new XMLEntity();
		entity.setParentEntity(null);
		entity.setId("root");
		
		Set<XMLEntity> children = new HashSet<XMLEntity>();
		for(int i = 0; i < 3; i++){
			XMLEntity child = new XMLEntity();
			child.setId("child" + i);
			child.setParentEntity(entity);
			child.setChildren(null);
			children.add(child);
		}
		entity.setChildren(children);
		
		JAXBContext ctx = JAXBContext.newInstance(XMLEntity.class);
		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(entity, System.out);
	}
}
