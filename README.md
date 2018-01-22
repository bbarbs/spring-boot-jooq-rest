# Getting Started
This a sample spring boot application that use JOOQ(Java Object Oriented Querying) which offer more type safe SQL queries. For more information about JOOQ see: http://www.jooq.org/

## Configuration
* Inorder to generate the Java code from your database we need a code generator. For gradle you can see here: https://www.jooq.org/doc/3.7/manual/code-generation/codegen-gradle/
```
Sample code generator for Gradle.

task jooqGenerator {
	def writer = new StringWriter()
	def xml = new groovy.xml.MarkupBuilder(writer)
			.configuration('xmlns': 'http://www.jooq.org/xsd/jooq-codegen-3.10.0.xsd') {
		jdbc() {
			driver('org.h2.Driver')
			url('jdbc:h2:~/test')
			user('test')
			password('test')
		}
		// See: https://www.jooq.org/doc/3.6/manual/code-generation/codegen-advanced/
		generator() {
			database() {
			}

			generate([:]) {
				pojos true
				daos true
				interfaces true
			}
			target() {
				packageName('com.jooq')
				directory('src/generated/java')
			}
		}
	}

	org.jooq.util.GenerationTool.generate(
			javax.xml.bind.JAXB.unmarshal(new StringReader(writer.toString()), org.jooq.util.jaxb.Configuration.class)
	)
}
```

## Additional Gradle Config

* You can add also other gradle task to treat the generated folder as source.
```
sourceSets {
	main {
		java {
			srcDirs "src/main/java", "src/generated/java"
		}
	}
}
```
* You can add task also to delete the generated java code.
```
apply plugin: 'base'

clean.doFirst {
	delete("src/generated/java")
}
```

## How it Works
For new checkout in order to prepopulate the schema in the database which by default is using H2. You can run the [SchemaGenerator.class](https://github.com/bbarbs/spring-boot-rest-jooq/blob/master/src/main/java/com/jooq/setup/SchemaGenerator.java) as standalone.
<br/>
Using IDE like Intellij you navigate to Settings > Build,Execution,Deployment > Compilers > Excludes and add the parts of the projects that are unrelated to be excluded from compilation. After that you can run the SchemaGenerator.

* Note: Don't forget to remove related projects on your next build when you successfully generated the schema in the database.

After you generated the schema you can now run the jooq generator as mentioned in Configuration section.

## Api Documentation
* Using Swagger2 to expose api documentation of REST service.
* To avoid issues mentioned here: https://stackoverflow.com/questions/44346443/swagger-ui-bad-request-url-generation use the right swagger-ui library.
