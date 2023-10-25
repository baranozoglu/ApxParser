package model.response;

import java.util.List;

public class InternalResponses {
    List<InternalResponse> responses;

    public InternalResponses() {
    }

    public InternalResponses(List<InternalResponse> responses) {
        this.responses = responses;
    }

    public static InternalResponses of(List<InternalResponse> responses) {
        return new InternalResponses(responses);
    }

    public List<InternalResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<InternalResponse> responses) {
        this.responses = responses;
    }
}
