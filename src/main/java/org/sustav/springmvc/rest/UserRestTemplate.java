package org.sustav.springmvc.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Anton Sustavov
 * @since 2020/02/29
 */
public class UserRestTemplate {
    public static void main(String[] args) {
        final String uri = "http://localhost:8383/phonebooks/users-rest/users/1";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_PDF));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);
        try {
            Files.write(Paths.get("user.pdf"), response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
