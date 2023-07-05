package com.skryl.edu;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Skryl D.V. on 2023-05-23
 */
@Slf4j
public class DownloadTest {

    private static final String DOWNLOAD_LINK = "https://corretto.aws/downloads/latest/amazon-corretto-11-x64-linux-jdk.deb";

    @Test
    void downloadFileFromInternet() throws IOException {
        log.info("Start downloading Endpoint agent installer: " + DOWNLOAD_LINK);
        var encoding = new RequestSpecBuilder().setUrlEncodingEnabled(true).build();
        var msi = RestAssured.given()
                .spec(encoding)
                .get(DOWNLOAD_LINK)
                .asInputStream();
        var downloadPath = Paths.get(System.getProperty("user.dir") + "/target/installer3.msi");
        Files.copy(msi, downloadPath, StandardCopyOption.REPLACE_EXISTING);
        IOUtils.closeQuietly(msi);
    }

    @Test
    void downloadFileFromInternetV2() throws IOException {
        log.info("Start downloading Endpoint agent installer: " + DOWNLOAD_LINK);
        var downloadPath = Paths.get(System.getProperty("user.dir") + "/target/installer2.msi");
        writeImageIfNotExists(
                downloadPath,
                DOWNLOAD_LINK
        );
    }

    @Test
    void downloadFileFromInternetV3() throws IOException {
        log.info("Start downloading Endpoint agent installer: " + DOWNLOAD_LINK);
        var downloadPath = Paths.get(System.getProperty("user.dir") + "/target/installer.msi");
        FileUtils.copyURLToFile(new URL(DOWNLOAD_LINK), downloadPath.toFile());
    }

    private void writeImageIfNotExists(
            final Path outputImagePath,
            final String imageUrl
    ) throws IOException {

        byte[] image = RestAssured.given()
                .when()
                .get(imageUrl)
                .asByteArray();

        // output image to file
        OutputStream outStream = new FileOutputStream(outputImagePath.toString());
        outStream.write(image);
        outStream.close();
    }

}
