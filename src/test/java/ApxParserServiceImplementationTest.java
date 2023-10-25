import exception.CouldNotParseFile;
import model.response.InternalResponses;
import model.response.QuoteResponse;
import model.response.QuoteValueResponse;
import model.response.QuotesResponse;
import org.junit.jupiter.api.Test;
import service.ApxParserService;

import static org.junit.jupiter.api.Assertions.*;

class ApxParserServiceImplementationTest {

    private final ApxParserService apxParserService = new ApxParserService();

    @Test
    void test_getQuoteResponseObjectFromSourceFile_successAssertions() throws CouldNotParseFile {
        //actual
        QuotesResponse mappedQuotesResponse = apxParserService.getQuoteResponseObjectFromSourceFile("apx-data.json");
        QuoteResponse mappedQuoteResponse = mappedQuotesResponse.getQuoteResponses().get(0);
        QuoteValueResponse mappedQuoteValueResponse = mappedQuoteResponse.getQuoteValueResponses().get(0);

        //mocked
        QuotesResponse mockedQuotesResponse = TestHelper.createMockedQuotes();
        QuoteResponse mockedQuoteResponse = mockedQuotesResponse.getQuoteResponses().get(0);
        QuoteValueResponse mockedQuoteValueResponse = mockedQuoteResponse.getQuoteValueResponses().get(0);

        //assert
        assertNotNull(mappedQuotesResponse);
        assertEquals(mockedQuoteResponse.getMarket(), mappedQuoteResponse.getMarket());
        assertEquals(mockedQuoteResponse.getDateApplied(), mappedQuoteResponse.getDateApplied());
        assertEquals(mockedQuoteValueResponse.getValue(), mappedQuoteValueResponse.getValue());
        assertEquals(mockedQuoteValueResponse.getPosition(), mappedQuoteValueResponse.getPosition());
        assertEquals(mockedQuoteValueResponse.getPrecision(), mappedQuoteValueResponse.getPrecision());
        assertEquals(mockedQuoteValueResponse.getcLabel(), mappedQuoteValueResponse.getcLabel());
        assertEquals(mockedQuoteValueResponse.getColor(), mappedQuoteValueResponse.getColor());
        assertEquals(mockedQuoteValueResponse.gettLabel(), mappedQuoteValueResponse.gettLabel());
        assertEquals(mockedQuoteValueResponse.getValue(), mappedQuoteValueResponse.getValue());
        assertEquals(mockedQuoteValueResponse.getChartShow(), mappedQuoteValueResponse.getChartShow());
        assertEquals(mockedQuoteValueResponse.getChartType(), mappedQuoteValueResponse.getChartType());
        assertEquals(mockedQuoteValueResponse.getUnit(), mappedQuoteValueResponse.getUnit());
    }


    @Test
    void test_getInternalResponse_successAssertions() throws CouldNotParseFile {
        //actual
        QuotesResponse mappedQuotesResponse = apxParserService.getQuoteResponseObjectFromSourceFile("apx-data.json");
        InternalResponses internalResponse = apxParserService.getInternalResponse(mappedQuotesResponse);

        //mocked
        InternalResponses mockedInternalResponse = TestHelper.createMockedInternalResponse();

        //assert
        assertNotNull(internalResponse);
        assertNotNull(internalResponse.getResponses());
        assertEquals(mockedInternalResponse.getResponses().get(0).getDateTime(), internalResponse.getResponses().get(0).getDateTime());
        assertEquals(mockedInternalResponse.getResponses().get(0).getPrice(), internalResponse.getResponses().get(0).getPrice());
        assertEquals(mockedInternalResponse.getResponses().get(0).getNetVolume(), internalResponse.getResponses().get(0).getNetVolume());
        assertEquals(mockedInternalResponse.getResponses().get(1).getDateTime(), internalResponse.getResponses().get(1).getDateTime());
        assertEquals(mockedInternalResponse.getResponses().get(1).getPrice(), internalResponse.getResponses().get(1).getPrice());
        assertEquals(mockedInternalResponse.getResponses().get(1).getNetVolume(), internalResponse.getResponses().get(1).getNetVolume());
    }

    @Test
    void test_getQuoteResponseObjectFromSourceFile_exception() {
        assertThrows(CouldNotParseFile.class, () ->
                apxParserService.getQuoteResponseObjectFromSourceFile("apx-data-exception.json"));
    }
}
