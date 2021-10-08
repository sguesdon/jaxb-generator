package org.sguesdon.jaxbgenerator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.sguesdon.jaxbgenerator.domain.entity.Person;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class JaxbGeneratorApplicationTests {

	@Test
	void contextLoads() throws JAXBException {

		Person letter = new Person();
		Map<String,String> hm = new HashMap<String, String>();
		hm.put("toto","Amit");
		hm.put("titi","Vijay");
		hm.put("toutou","Rahul");

		letter.setSub(hm);

		JAXBContext jaxbContext     = JAXBContext.newInstance(Person.class);
		Marshaller jaxbMarshaller   = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//jaxbMarshaller.setAdapter(new TestAdapter());
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(letter, sw);
		String xmlString = sw.toString();
		log.info(xmlString);

	}

}
