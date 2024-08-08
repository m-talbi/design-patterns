package creational.prototype;

import java.util.Map;

public class PostRequest extends AbstractHttpRequest {

    public PostRequest(String url, String body, Map<String, String> headers) {
        super("POST", url, body, headers);
    }

    public PostRequest(PostRequest req) {
        super(req.method, req.url, req.body, req.headers);
    }

    @Override
    public AbstractHttpRequest clone() {
        return new PostRequest(this);
    }
}
