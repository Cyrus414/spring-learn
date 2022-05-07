package learn.postprocessor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;

import java.io.IOException;

public class LeanComponentScan {
	public static void main(String[] args) throws IOException {
		GenericApplicationContext context = new GenericApplicationContext();
		System.out.println("===============\n");
		ComponentScan annotation = AnnotationUtils.findAnnotation(ConfigBean.class, ComponentScan.class);
		if (annotation != null) {
			System.out.println(annotation);
			String[] packages = annotation.basePackages();
			for (String aPackage : packages) {
				System.out.println(aPackage);
				String replace = aPackage.replace('.', '/');
				String path = "classpath*:" + replace + "/**/*.class";
				System.out.println(path);

				// 用于获取类的元信息，该方法不使用反射，效率较高
				CachingMetadataReaderFactory readerFactory = new CachingMetadataReaderFactory();

				// 通过context获取类路径下的资源文件
				Resource[] resources = context.getResources(path);
				for (Resource resource : resources) {
					System.out.println("resource: " + resource);
					MetadataReader metadataReader = readerFactory.getMetadataReader(resource);
					AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
					if (annotationMetadata.hasAnnotation("org.springframework.stereotype.Component")) {
						System.out.println("==> Component");
					}

					if (annotationMetadata.hasMetaAnnotation("org.springframework.stereotype.Component")) {
						System.out.println("==> Meta Component");
					}

				}
			}
		}
	}
}
