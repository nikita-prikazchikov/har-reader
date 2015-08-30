package de.sstoehr.harreader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a performed request.
 * @see <a href="http://www.softwareishard.com/blog/har-12-spec/#request">specification</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HarRequest {

    protected static final Long DEFAULT_SIZE = -1L;

    private HttpMethod method;
    private String url;
    private String httpVersion;
    private List<HarCookie> cookies;
    private List<HarHeader> headers;
    private List<HarQueryParam> queryString;
    private HarPostData postData;
    private Long headersSize;
    private Long bodySize;
    private String comment;

    /**
     * @return Request method, null if not present.
     */
    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    /**
     * @return Absolute URL of the request (fragments are not included), null if not present.
     */
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return Request HTTP Version, null if not present.
     */
    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    /**
     * @return List of cookie objects.
     */
    public List<HarCookie> getCookies() {
        if (cookies == null) {
            cookies = new ArrayList<>();
        }
        return cookies;
    }

    public void setCookies(List<HarCookie> cookies) {
        this.cookies = cookies;
    }

    /**
     * @return List of header objects.
     */
    public List<HarHeader> getHeaders() {
        if (headers == null) {
            headers = new ArrayList<>();
        }
        return headers;
    }

    public void setHeaders(List<HarHeader> headers) {
        this.headers = headers;
    }

    /**
     * @return List of query parameter objects.
     */
    public List<HarQueryParam> getQueryString() {
        if (queryString == null) {
            queryString = new ArrayList<>();
        }
        return queryString;
    }

    public void setQueryString(List<HarQueryParam> queryString) {
        this.queryString = queryString;
    }

    /**
     * @return Posted data info.
     */
    public HarPostData getPostData() {
        if (postData == null) {
            postData = new HarPostData();
        }
        return postData;
    }

    public void setPostData(HarPostData postData) {
        this.postData = postData;
    }

    /**
     * @return Total number of bytes from the start of the HTTP request message until (and including) the double
     * CRLF before the body. {@link #DEFAULT_SIZE} if the info is not available.
     */
    public Long getHeadersSize() {
        if (headersSize == null) {
            return DEFAULT_SIZE;
        }
        return headersSize;
    }

    public void setHeadersSize(Long headersSize) {
        this.headersSize = headersSize;
    }

    /**
     * @return Size of the request body (POST data payload) in bytes.
     * {@link #DEFAULT_SIZE} if the info is not available.
     */
    public Long getBodySize() {
        if (bodySize == null) {
            return DEFAULT_SIZE;
        }
        return bodySize;
    }

    public void setBodySize(Long bodySize) {
        this.bodySize = bodySize;
    }

    /**
     * @return Comment provided by the user or application, null if not present.
     */
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
