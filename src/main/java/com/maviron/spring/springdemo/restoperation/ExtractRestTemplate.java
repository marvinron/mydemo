package com.maviron.spring.springdemo.restoperation;

import cn.hutool.core.date.DateTime;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ExtractRestTemplate.java
 * @Description TODO
 * @createTime 2023年07月28日 16:58:00
 */
public class ExtractRestTemplate extends FilterRestTemplate {
    private RestTemplate restTemplate;

    public ExtractRestTemplate(RestTemplate restTemplate) {
        super(restTemplate);
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T getForObject(String s, Class<T> aClass, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> T getForObject(String s, Class<T> aClass, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> T getForObject(URI uri, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String s, Class<T> aClass, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String s, Class<T> aClass, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(URI uri, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public HttpHeaders headForHeaders(String s, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public HttpHeaders headForHeaders(String s, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public HttpHeaders headForHeaders(URI uri) throws RestClientException {
        return null;
    }

    @Override
    public URI postForLocation(String s, Object o, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public URI postForLocation(String s, Object o, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public URI postForLocation(URI uri, Object o) throws RestClientException {
        return null;
    }

    @Override
    public <T> T postForObject(String s, Object o, Class<T> aClass, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> T postForObject(String s, Object o, Class<T> aClass, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> T postForObject(URI uri, Object o, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String s, Object o, Class<T> aClass, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String s, Object o, Class<T> aClass, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(URI uri, Object o, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public void put(String s, Object o, Object... objects) throws RestClientException {

    }

    //final DateTime DISTRIBUTION_TIME_SPLIT_TIME = new DateTime().withTime(15, 0, 0, 0);

    //private Date calculateDistributionTimeByOrderCreateTime(Date orderCreateTime) {
    //    DateTime orderCreateDateTime = new DateTime(orderCreateTime);
    //    Date tomorrow = orderCreateDateTime.plusDays(1).toDate();
    //    Date theDayAfterTomorrow = orderCreateDateTime.plusDays(2).toDate();
    //    return orderCreateDateTime.isAfter(DISTRIBUTION_TIME_SPLIT_TIME) ? wrapDistributionTime(theDayAfterTomorrow) : wrapDistributionTime(tomorrow);
    //}
    //
    //private Date wrapDistributionTime(Date distributionTime) {
    //    DateTime currentDistributionDateTime = new DateTime(distributionTime);
    //    DateTime plusOneDay = currentDistributionDateTime.plusDays(1);
    //    boolean isSunday = (DateTimeConstants.SUNDAY == currentDistributionDateTime.getDayOfWeek());
    //    return isSunday ? plusOneDay.toDate() : currentDistributionDateTime.toDate();
    //}

    @Override
    public void put(String s, Object o, Map<String, ?> map) throws RestClientException {

    }

    @Override
    public void put(URI uri, Object o) throws RestClientException {

    }

    @Override
    public <T> T patchForObject(String s, Object o, Class<T> aClass, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> T patchForObject(String s, Object o, Class<T> aClass, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> T patchForObject(URI uri, Object o, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public void delete(String s, Object... objects) throws RestClientException {

    }

    @Override
    public void delete(String s, Map<String, ?> map) throws RestClientException {

    }

    @Override
    public void delete(URI uri) throws RestClientException {

    }

    @Override
    public Set<HttpMethod> optionsForAllow(String s, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public Set<HttpMethod> optionsForAllow(String s, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public Set<HttpMethod> optionsForAllow(URI uri) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String s, HttpMethod httpMethod, HttpEntity<?> httpEntity, Class<T> aClass, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String s, HttpMethod httpMethod, HttpEntity<?> httpEntity, Class<T> aClass, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(URI uri, HttpMethod httpMethod, HttpEntity<?> httpEntity, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String s, HttpMethod httpMethod, HttpEntity<?> httpEntity, ParameterizedTypeReference<T> parameterizedTypeReference, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String s, HttpMethod httpMethod, HttpEntity<?> httpEntity, ParameterizedTypeReference<T> parameterizedTypeReference, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(URI uri, HttpMethod httpMethod, HttpEntity<?> httpEntity, ParameterizedTypeReference<T> parameterizedTypeReference) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> aClass) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> parameterizedTypeReference) throws RestClientException {
        return null;
    }

    @Override
    public <T> T execute(String s, HttpMethod httpMethod, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Object... objects) throws RestClientException {
        return null;
    }

    @Override
    public <T> T execute(String s, HttpMethod httpMethod, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Map<String, ?> map) throws RestClientException {
        return null;
    }

    @Override
    public <T> T execute(URI uri, HttpMethod httpMethod, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        return null;
    }
}
