package br.com.luismunhoz.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.luismunhoz.CompareFilesApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={CompareFilesApplication.class})
public class DetectFileTypeTest {
	
	@Autowired
	JMimeMagicDetectFileType target;
	
	@Autowired
	DiskFileManager diskFileManager;
	
	@Test
	public void testFileTypeIsText() throws Exception {
		
		InputStream fileContent = getClass().getClassLoader().getResourceAsStream("shakespeare.txt");
		        
		target = new JMimeMagicDetectFileType();
		Boolean isText = target.isTextFile(fileContent);
		
		assertThat(isText, is(true));
	}
	
	@Test
	public void testFileTypeIsBinary() {
		
		InputStream fileContent = getClass().getClassLoader().getResourceAsStream("image-test-1.jpg");
		
		JMimeMagicDetectFileType target = new JMimeMagicDetectFileType();
		Boolean isText = target.isTextFile(fileContent);
		
		assertThat(isText, is(false));
		
	}

}
