package vn.edu.spx.haolvph26545_mob201_asm.RSS;

import android.util.Log;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import vn.edu.spx.haolvph26545_mob201_asm.DTO.TinTucDTO;


public class TinTucLoader {
    List<TinTucDTO> tinTucList = new ArrayList<TinTucDTO>();
    TinTucDTO tinTucDTO;
    String textContent;

    public List<TinTucDTO> getTinTucList(InputStream inputStream) {
        // nội dung tự viết , tham khảo ví dụ product
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            // truyền nguồn dữ liệu
            parser.setInput(inputStream, null);
            // xác định event type
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // viết code xử lý ở đây
                String tagName = parser.getName();
                Log.d("zzzzz", "Tag name =  " + tagName +
                        ", Độ sâu của thẻ = " + parser.getDepth() + ", event = " + eventType);


                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        // bắt đầu vào 1 thẻ
                        if (tagName.equalsIgnoreCase("item")) {
                            tinTucDTO = new TinTucDTO();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if(tinTucDTO != null){
                            //
                            if(tagName.equalsIgnoreCase("item")){
                                tinTucList.add(tinTucDTO);
                            }

                            if (tagName.equalsIgnoreCase("title")){
                                tinTucDTO.setTitle( textContent );
                            }

                            if (tagName.equalsIgnoreCase("description"))
                            {
                                tinTucDTO.setDescription( textContent );
                            }
                            if(tagName.equalsIgnoreCase("Link")){
                                tinTucDTO.setLink( textContent );
                            }

                        }


                        break;
                    default:
                        Log.d("zzzz", "eventType khác: " + eventType + ", tag = " + tagName);
                        break;
                }


                // viết lệnh chuyển event type để vòng lặp không bị treo
                // để ở cuối cùng của lệnh while
                eventType = parser.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tinTucList;
    }



/* Tham chiếu các EventType
    int START_DOCUMENT = 0;
    int END_DOCUMENT = 1;
    int START_TAG = 2;
    int END_TAG = 3;
    int TEXT = 4;
    int CDSECT = 5;
    int COMMENT = 9;
    int DOCDECL = 10;
    int ENTITY_REF = 6;
    int IGNORABLE_WHITESPACE = 7;
    String NO_NAMESPACE = "";
    int PROCESSING_INSTRUCTION = 8;
     */
}
