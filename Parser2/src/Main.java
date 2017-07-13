import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Main
    {

        public static void main(String args[]) {

            LoriParser parser = new LoriParser(new LoriGrabber());
            List<String> images = parser.getImages("собаки");

            for (String image : images)
            {
                System.out.println(image);
            }
            System.out.println("Success");
        }
    }

    abstract class ImagesParser
    {
        private Grabber grabber;

        abstract public List<String> getImages(String searchParam);

        public ImagesParser(Grabber grabber)
        {
            setGrabber(grabber);
        }

        public Grabber getGrabber()
        {
            return grabber;
        }

        public void setGrabber(Grabber grabber)
        {
            this.grabber = grabber;
        }
    }

    interface Grabber
    {
        public InputStream getPage(String searchParam) throws IOException;
    }

    class LoriParser extends ImagesParser
    {

        public LoriParser(Grabber grabber)
        {
            super(grabber);
        }

        @Override
        public List<String> getImages(String searchParam)
        {
            List<String> result = new ArrayList<String>();

            try {
                BufferedReader page = new BufferedReader(new InputStreamReader(getGrabber().getPage(searchParam)));

                //Pattern image = Pattern.compile("<div class=\"thumbnail\" style=\"[^\"]+\"><a href=\"[^\"]+\" title=\"[^\"]+\" class=\"[^\"]+\"><img src=\"([^\"]+)");
                Pattern image = Pattern.compile("<h1 class=\"add-top text-basic text-muted\">\n" + "23&nbsp;вакансії: java developer у&nbsp;Львові</h1>");

                StringBuilder pageContent = new StringBuilder("");

                String line;

                while ((line = page.readLine()) != null) {
                    pageContent.append(line);
                }

                Matcher matcher = image.matcher(pageContent);

                while (matcher.find()) {
                    result.add(matcher.group(1));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }

    class LoriGrabber implements Grabber {

        private static final String searchURL = "https://www.work.ua/ua/jobs-lviv-java+developer/";

        @Override
        public InputStream getPage(String searchParam) throws IOException {
            URL url = new URL(String.format(searchURL, searchParam));

            return (InputStream) url.getContent();
        }

    }