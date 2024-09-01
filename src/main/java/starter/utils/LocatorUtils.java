package starter.utils;
public class LocatorUtils{
    // Tạo XPath cho phần tử chứa văn bản cụ thể với tag name tùy chọn
    public static String getXPathForText(String text, String tagName) {
        tagName = (tagName == null || tagName.isEmpty()) ? "*" : tagName;
        return String.format("//%s[normalize-space(text())='%s']", tagName, text);
    }
    // Tạo XPath cho phần tử chứa văn bản cụ thể (partial match) với tag name tùy chọn
    public static String getXPathForPartialText(String partialText, String tagName) {
        tagName = (tagName == null || tagName.isEmpty()) ? "*" : tagName;
        return String.format("//%s[contains(normalize-space(text()), '%s')]", tagName, partialText);
    }
    // Tạo XPath cho phần tử dựa trên giá trị của thuộc tính cụ thể với tag name tùy chọn
    public static String getXPathForAttribute(String attributeName, String attributeValue, String tagName) {
        tagName = (tagName == null || tagName.isEmpty()) ? "*" : tagName;
        return String.format("//%s[@%s='%s']", tagName, attributeName, attributeValue);
    }
    // Tạo XPath cho phần tử chứa văn bản và thuộc tính cụ thể với tag name tùy chọn
    public static String getXPathForTextAndAttribute(String text, String attributeName, String attributeValue, String tagName) {
        tagName = (tagName == null || tagName.isEmpty()) ? "*" : tagName;
        return String.format("//%s[normalize-space(text())='%s' and @%s='%s']", tagName, text, attributeName, attributeValue);
    }
}