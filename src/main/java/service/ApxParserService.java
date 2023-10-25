package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.CouldNotParseFile;
import model.Quotes;
import model.response.*;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static model.enums.TLabelEnum.*;

@Service
public class ApxParserService {
    private static final Logger logger = Logger.getLogger(ApxParserService.class.getName());

    private static void setInternalResponse(QuotesResponse quotesResponse,
                                            List<InternalResponse> internalResponses) {
        quotesResponse.getQuoteResponses().forEach(quoteResponse -> {
            InternalResponse internalResponse = new InternalResponse();
            LocalDateTime localDateTime = getLocalDateTime(quoteResponse);
            quoteResponse.getQuoteValueResponses().forEach(quoteValueResponse ->
                    setValuesByTLabel(internalResponse, localDateTime, quoteValueResponse));
            internalResponses.add(internalResponse);
        });
    }

    private static void setValuesByTLabel(InternalResponse internalResponse,
                                          LocalDateTime localDateTime,
                                          QuoteValueResponse quoteValueResponse) {
        if (HOUR.getLabel().equals(quoteValueResponse.gettLabel())) {
            internalResponse.setDateTime(combineLocaleDateAndTime(localDateTime, quoteValueResponse));
        } else if (NET_VOLUME.getLabel().equals(quoteValueResponse.gettLabel())) {
            internalResponse.setNetVolume(quoteValueResponse.getValue());
        } else if (PRICE.getLabel().equals(quoteValueResponse.gettLabel())) {
            internalResponse.setPrice(quoteValueResponse.getValue());
        }
    }

    private static LocalDateTime combineLocaleDateAndTime(LocalDateTime localDateTime,
                                                          QuoteValueResponse quoteValueResponse) {
        return LocalDateTime.of(
                localDateTime.getYear(),
                localDateTime.getMonthValue(),
                localDateTime.getDayOfMonth(),
                getHour(quoteValueResponse),
                0);
    }

    private static LocalDateTime getLocalDateTime(QuoteResponse quoteResponse) {
        return quoteResponse.getDateApplied().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private static int getHour(QuoteValueResponse quoteValueResponse) {
        if (Objects.equals(quoteValueResponse.getValue(), "24")) {
            return 0;
        }
        return Integer.parseInt(quoteValueResponse.getValue());
    }

    private static Quotes mapObjectFromUrl(String filePath) throws CouldNotParseFile {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(readFileAsString(filePath), Quotes.class);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error parsing file from file path: {}", filePath);
            throw new CouldNotParseFile("Error parsing file from file path");
        }
    }

    private static String readFileAsString(String filePath) throws CouldNotParseFile {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error reading file from file path: {}", filePath);
            throw new CouldNotParseFile("Error reading file from file path");
        }
    }

    private static String determineFullFilePath(String filePath) {
        return "src/test/resources/".concat(filePath);
    }

    public InternalResponses getInternalResponse(QuotesResponse quotesResponse) {
        List<InternalResponse> internalResponses = new ArrayList<>();
        setInternalResponse(quotesResponse, internalResponses);

        return InternalResponses.of(internalResponses);
    }

    public QuotesResponse getQuoteResponseObjectFromSourceFile(String filePath) throws CouldNotParseFile {
        try {
            Quotes quotes = mapObjectFromUrl(determineFullFilePath(filePath));
            return QuotesResponse.of(quotes);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Something went wrong during parsing! Exception: {}", e.getMessage());
            throw new CouldNotParseFile();
        }
    }

}
