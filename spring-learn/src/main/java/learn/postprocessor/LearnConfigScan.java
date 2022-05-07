package learn.postprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;
import java.util.Set;

/**
 * @Author: Cyrus Chen
 * @Date: 5/7/22 3:14 PM
 * @Description:
 */
public class LearnConfigScan {
	public static void main(String[] args) throws IOException {
		CachingMetadataReaderFactory readerFactory = new CachingMetadataReaderFactory();

		MetadataReader reader = readerFactory.getMetadataReader(new ClassPathResource("/learn/postprocessor/ConfigBean.class"));

		AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
		Set<MethodMetadata> annotatedMethods = annotationMetadata.getAnnotatedMethods(Bean.class.getName());
		for (MethodMetadata annotatedMethod : annotatedMethods) {
			System.out.println(annotatedMethod.getMethodName());

			System.out.println(annotatedMethod);
		}

	}
}
