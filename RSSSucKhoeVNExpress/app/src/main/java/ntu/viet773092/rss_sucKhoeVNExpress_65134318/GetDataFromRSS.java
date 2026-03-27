package ntu.viet773092.rss_sucKhoeVNExpress_65134318;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GetDataFromRSS {
    public static ArrayList<LandScape> parseRSS(String rssUrl) {
        ArrayList<LandScape> listData = new ArrayList<>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            InputStream inputStream = new URL(rssUrl).openStream();
            parser.setInput(inputStream, null);

            boolean isInsideItem = false;
            String title = "", description = "";
            String currentText = "";

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("item".equalsIgnoreCase(tagName)) {
                            isInsideItem = true;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        currentText = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (isInsideItem) {
                            if ("title".equalsIgnoreCase(tagName)) {
                                title = currentText;
                            } else if ("description".equalsIgnoreCase(tagName)) {
                                description = currentText;
                            } else if ("item".equalsIgnoreCase(tagName)) {
                                // 1. Trich xuat URL anh
                                String imgUrl = "";
                                if (description.contains("src=\"")) {
                                    int start = description.indexOf("src=\"") + 5;
                                    int end = description.indexOf("\"", start);
                                    if (start > 4 && end > start) {
                                        imgUrl = description.substring(start, end);
                                    }
                                }

                                // 2. Trich xuat Tom tat
                                String summary = "";
                                if (description.contains("</br>")) {
                                    summary = description.substring(description.lastIndexOf("</br>") + 5).trim();
                                }

                                // 3. Them doi tuong vao danh sach (parsedList cua MainAct.)
                                listData.add(new LandScape(imgUrl, title, summary));

                                // Reset
                                title = "";
                                description = "";
                                isInsideItem = false;
                            }
                        }
                        break;
                }
                eventType = parser.next();
            }
            inputStream.close();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        return listData;
    }
}