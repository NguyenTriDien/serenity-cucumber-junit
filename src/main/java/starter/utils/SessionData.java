package starter.utils;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.lang.reflect.Field;
import java.util.*;

public class SessionData {
    /**
     * Load data from data table in feature file to raw data
     *
     * @param _dataTable
     * @return
     */
    private static LinkedHashMap<Integer, List<String>> loadDataTable(List<List<String>> _dataTable) {
        // Used the LinkedHashMap to maintain the order
        LinkedHashMap<Integer, List<String>> hashMap = new LinkedHashMap<Integer, List<String>>();
        // Add
        for (int i = 0; i < _dataTable.size(); i++) {
            hashMap.put(i, _dataTable.get(i));
        }
        return hashMap;
    }

    public static LinkedHashMap<Integer, List<String>> getDataTbRowsWithoutHeader(List<List<String>> dataTable) {
        LinkedHashMap<Integer, List<String>> ret = loadDataTable(dataTable);
        ret.remove(0);
        return ret;
    }

    /**
     * Get cell data value (data table description in feature file) from Session
     * Data variable by index of Row and Column Name.
     *
     * @param dataTable
     * @param _rowIndex
     * @param _colName
     * @return
     */
    public static String getDataTbVal(List<List<String>> dataTable, int _rowIndex, String _colName) {
        String ret = "";
        int colIndex = dataTable.get(0).indexOf(_colName);
        if (colIndex == -1) {
            System.out.println("***WARNING*** Column [" + _colName + "] not found in Data Table.");
            return ret;
        } else {
            try {
                ret = dataTable.get(_rowIndex).get(colIndex);
            } catch (Exception e) {
                ret = "";
                System.out.println("***WARNING*** Row [" + _rowIndex + "] not found in Data Table.");
            }
        }
        return ret;
    }

    public static String tableWithoutHeaderAndSingleRow(DataTable dataTable, String key) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String value = "";

        value = list.get(0).get(key);
        return value;
    }
    public static <T> boolean compareListObject(List<T> obj1, List<T> obj2) throws IllegalAccessException {
        if (obj1 == null && obj2 == null) {
            return true;
        }

        if (obj1 == null || obj2 == null || obj1.size() != obj2.size()) {
            return false;
        }

        for (int i = 0; i < obj1.size(); i++) {
            T item1 = obj1.get(i);
            T item2 = obj2.get(i);

            if (!compareObjects(item1, item2)) {
                return false;
            }
        }

        return true;
    }

    private static <T> boolean compareObjects(T obj1, T obj2) throws IllegalAccessException {
        if (obj1 == null && obj2 == null) {
            return true;
        }

        if (obj1 == null || obj2 == null) {
            return false;
        }

        Class<?> clazz = obj1.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            Object fieldValue1 = field.get(obj1);
            Object fieldValue2 = field.get(obj2);
            if ((fieldValue1 == null && fieldValue2 != null) || !fieldValue1.equals(fieldValue2)) {
                return false;
            }
        }

        return true;
    }

}