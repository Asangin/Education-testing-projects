package com.skryl.edu;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * <a href="https://www.baeldung.com/java-generate-class-from-json">Generate a Java Class From JSON</a>
 *
 * @author Skryl D.V. on 2022-05-24
 */
public class ModelGeneratorFromJson {

    public static void main(String[] args) {
        String packageName = "com.skryl.edu.model";
        String basePath = "generation-tests/src/test/resources/__files/v1";
        String outputPath = "generation-tests/src/main/java";
        File inputJson = new File(basePath + File.separator + "input.json");
        File outputPojoDirectory = new File(outputPath);
        var isCreated = outputPojoDirectory.mkdirs();
        if(!isCreated) {
            System.err.println("Cannot create folder");
        }
        try {
            new ModelGeneratorFromJson().convertJsonToJavaClass(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));
        } catch (IOException e) {
            System.out.println("Encountered issue while converting to pojo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName)
            throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(
                        config,
                        new Jackson2Annotator(config),
                        new SchemaStore()),
                new SchemaGenerator()
        );
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

        jcodeModel.build(outputJavaClassDirectory);
    }
}
