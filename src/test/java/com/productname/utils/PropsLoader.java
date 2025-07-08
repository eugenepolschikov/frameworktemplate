package com.productname.utils;

import com.productname.models.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsLoader {
    private final static Logger log = LoggerFactory.getLogger(PropsLoader.class);
    protected String baseUrl;

    public Credentials getOrangeHrmCredentials() {
        return orangeHrmCredentials;
    }

    private Credentials orangeHrmCredentials;

    public PropsLoader() {
        try {
            prodEnvPropsLoader();
            prodCredsPropsLoader();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void prodEnvPropsLoader() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream == null) {
            throw new FileNotFoundException(String.format("Property File '%s' not found in the classpath", propFileName));
        }
        prop.load(inputStream);

        baseUrl = prop.getProperty("baseUrl");
        inputStream.close();
    }

    public void prodCredsPropsLoader() {
        String orangehrmLogin;
        String orangehrmPassword;
        Properties orangeHrmProps = new Properties();
        try (InputStream input = new FileInputStream("src/main/custom-resources/prod/orangehrm.properties")) {
            orangeHrmProps.load(input);
            orangehrmLogin = orangeHrmProps.getProperty("orangehrm.login");
            orangehrmPassword = orangeHrmProps.getProperty("orangehrm.password");
            orangeHrmCredentials  = new Credentials(orangehrmLogin, orangehrmPassword);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
