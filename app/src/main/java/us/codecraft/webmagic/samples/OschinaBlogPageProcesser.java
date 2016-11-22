package us.codecraft.webmagic.samples;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 */
public class OschinaBlogPageProcesser implements PageProcessor {

    private Site site = Site.me().setDomain("my.oschina.net").addStartUrl("http://my.oschina.net/flashsword/blog");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1/text()").toString());
        page.putField("content", page.getHtml().xpath("//div[@class='BlogContent']/tidyText()").toString());
        page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) throws Exception {
//        spider spider = spider.create(new oschinablogpageprocesser()).setscheduler(new queuescheduler().setduplicateremover(new bloomfilterduplicateremover(2000)));
//        spidermonitor.instance().register(spider);
//        spider.run();
    }
}
