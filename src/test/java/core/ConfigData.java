package core;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.SneakyThrows;

import java.io.File;

public class ConfigData {

    public String browser;
    public Boolean headless;
    public Boolean startMaximized;
    public String browserSize;
    public String host;
    public String reportFolder;

    @SneakyThrows
    public static ConfigData readFileDataConfig() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        return objectMapper.readValue(new File("src/test/resources/config.yaml"), ConfigData.class);
    }
}
