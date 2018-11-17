package csv;

import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.Map;

public class PathGraphCsvProcessor {

    public static void main(String[] args) throws Exception {
        readWithCsvMapReader();
    }

    private static CellProcessor[] getProcessors() {


        final CellProcessor[] processors = new CellProcessor[]{
                new Optional(), // married
                new Optional()
        };

        return processors;
    }

    private static void readWithCsvMapReader() throws Exception {

        ICsvMapReader mapReader = null;
        try {
            mapReader = new CsvMapReader(new FileReader("C:\\Users\\wsgpz\\IdeaProjects\\canvas\\src\\run\\resources\\pathMap\\7c0f5230-6b1e-4af2-bcad-5a70c24c6ee8\\path\\6b11bbd9-60a8-433c-bafe-a0bd5085087d.csv"), CsvPreference.STANDARD_PREFERENCE);

            // the header columns are used as the keys to the Map
            final String[] header = mapReader.getHeader(false);
            final CellProcessor[] processors = getProcessors();

            Map<String, Object> customerMap;
            while ((customerMap = mapReader.read(header, processors)) != null) {
                System.out.println(String.format("lineNo=%s, rowNo=%s", mapReader.getLineNumber(),
                        mapReader.getRowNumber(), customerMap));
            }

        } finally {
            if (mapReader != null) {
                mapReader.close();
            }
        }
    }
}
