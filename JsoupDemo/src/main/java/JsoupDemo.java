import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\core\\java\\demo\\JsoupDemo\\新建文本文档.txt");
        Document document = Jsoup.parse(new File(file.getAbsolutePath()), "utf-8");
        Elements elements = document.getElementsByClass("into");
//        System.out.println(elements.text());


        Book book = new Book();

        for (Element e: elements) {
//            System.out.println(e.text()+"\n");
            e.getElementsByClass("title").forEach((el)->{
                System.out.println(el.text());
                book.setTitle(el.text());
            });
        }


//        System.out.println(elements.text());
//        for (File file:fileDir.listFiles()) {
//            System.out.println("\n# "+file.getName().replaceAll(".txt","")+"\n");
//            Document document = Jsoup.parse(new File(file.getAbsolutePath()),"utf-8");
//            Elements elements = document.getElementsByClass("Image");
//            Elements content = elements.first().children();
//            StringBuffer stringBuffer = new StringBuffer("");

//            for (Element e: content) {
//
//                if (!e.text().contains(" ")){
//                    continue;
//                }
//                stringBuffer.append(e.text());
//            }
//
//            System.out.println(stringBuffer.toString().
//                    replaceAll(" 1\\)","").
//                    replaceAll(" 2\\)","").
//                    replaceAll(" 3\\)","").
//                    replaceAll(" 4\\)","").
//                    replaceAll(" 5\\)","").
//                    replaceAll(" 6\\)","").
//                    replaceAll(" 7\\)","").
//                    replaceAll(" 8\\)","").
//                    replaceAll(" 9\\)","").
//                    replaceAll(" 10\\)","").
//
//                    replaceAll("\\)","**").
//                    replaceAll(" \\("," **").
//
//                    replaceAll("1/1","")
//            );
//        }

//        Document document = Jsoup.parse(new File(file.getAbsolutePath()), "utf-8");
//        Elements elements = document.getElementsByClass("page-content font-large");
//        Elements content = elements.first().children();
//        String fiction=content.html().
//                replaceAll("<br>","").
//                replaceAll(" ","");
////        System.out.println(fiction);
////        System.out.println(fiction.replaceAll("\n",""));
////        System.out.println(fiction.replaceAll("[^。](?<=\n)",""));
//        char[] temp=fiction.toCharArray();
//        char last=0;
//        for (char b: temp) {
//            if ('\n'==b){
//                if ('。'!=last){
//                    continue;
//                }
//            }
//            last= b ;
//            System.out.print(b);
//        }
//
////        for (Element e:content) {
////            System.out.println(e.html().replaceAll("<br>","").
////                    replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;","\n"));
////        }
//
////        File temp = new File("C:\\Users\\86188\\Desktop\\sinodan");
////        File[] allHTML=temp.listFiles();
////        int i=0;
////        for (File file:allHTML){
////            try {
////                Document document = Jsoup.parse(new File(file.getAbsolutePath()), "utf-8");
////                Elements elements = document.getElementsByClass("entry-content content-reset");
////                Element content=elements.first();
////
////                for (Element e:content.children()){
////
////                    if(e.text().contains("绅士天堂地址发布页")){
////                        String regEx2 = "\\d{4,}";
////                        Pattern p2 = Pattern.compile(regEx2);
////                        Matcher m2 = p2.matcher(file.getName());
////                        m2.find();
////                        String number = m2.group();
////                        if(9760<=Integer.valueOf(number)&&Integer.valueOf(number)<=9999){
////                            System.out.println("原网页"+"http://acgheaven.cc/archives/"+number);
////                            System.out.println(document.title());
////                            System.out.println(e.previousElementSiblings().text());
////                            System.out.println();
////                        }
////
////
////                    }}
////
////
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }

//    }
//}
    }
}