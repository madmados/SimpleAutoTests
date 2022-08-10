import PageObj.MainPage;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
    @Test
    /* Тест не проходит из-за ошибки "unable to find valid certification path to requested target"
    ошибка возникает при скачке конкретно 3 картинки.
    Не уверен, входило ли это в ТЗ, но решил пока сдать так, т.к. как решить эту проблему не совсем знаю.
    Если конкретно, то я не знаю и не понимаю, где должен лежать сертификат сайта
     */
    public void simpleTest() {
        MainPage ObjPage =
                open("https://www.google.ru/", MainPage.class);
        ObjPage.takePic("Марьинский Александр");
        String url = $(byXpath("//*[@id=\"Sva75c\"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div[3]/div/a/img"))
                .getAttribute("src");
        String fileName = "src/test/java/PageObj/pic.jpg";

        FileOutputStream fout = null;
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new URL(url).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
                fout.flush();
            }
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
