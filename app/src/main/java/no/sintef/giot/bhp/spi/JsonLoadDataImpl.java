package no.sintef.giot.bhp.spi;

import android.util.Log;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import no.sintef.giot.bhp.sqlite.DBHelper;

public class JsonLoadDataImpl extends LoadDataService {

  private static final String TAG = "CsvLoadDataImpl";

  /**
   * Get data from SQLite as JSON
   *
   * @return data from SQLite as a JSON string
   */
  @Override
  public String getData() {
    String jsonData = DBHelper.getInstance(null).getAllEntriesAsJson();
    return jsonData;
  }
}

