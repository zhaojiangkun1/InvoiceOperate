package com.shuzutech.cases.zpy;

import com.shuzutech.bean.BasicParameters;
import com.shuzutech.config.InterfaceNum;
import com.shuzutech.model.RequestInterface;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AIcodeBatch {
    InterfaceNum num = BasicParameters.num;

    @Test
    public void batchAicode() throws IOException, NoSuchAlgorithmException {
        String body = body();
        RequestInterface.requestInteface(body, num,"aicode");
    }

    public String body(){
        String body = "{\"serviceId\":\"aiCodingBatch\",\"content\":[{\"tradeName\":\"芹菜\",\"xh\":0,\"uid\":\"1550f13d-a3c9-4345-8cd4-02c104307d8a\"},{\"tradeName\":\"青笋\",\"xh\":1,\"uid\":\"b96b1928-abfb-4c17-8f6c-dd02ba573c6d\"},{\"tradeName\":\"蒜苗\",\"xh\":2,\"uid\":\"4edcf4cf-b863-4286-9f3e-cc96f57e4de4\"},{\"tradeName\":\"茼蒿 \",\"xh\":3,\"uid\":\"1b2c5fad-460b-40b9-9e18-c9e7b90874c2\"},{\"tradeName\":\"红椒\",\"xh\":4,\"uid\":\"152d5ce3-3ebb-4fa1-83c1-4816a033cc2a\"},{\"tradeName\":\"二金条\",\"xh\":5,\"uid\":\"6bff4894-c8e7-44a8-8e94-56f68e715fae\"},{\"tradeName\":\"大白菜\",\"xh\":6,\"uid\":\"f7735a5c-b61b-465c-bc73-c1b5f3fb7df3\"},{\"tradeName\":\"干锅虾\",\"xh\":7,\"uid\":\"b21cf4ef-6d6a-4d20-b528-0d0b0713e25b\"},{\"tradeName\":\"鸡腿\",\"xh\":8,\"uid\":\"f9333b9a-c929-4ed9-842c-298e32627d48\"},{\"tradeName\":\"油桃\",\"xh\":9,\"uid\":\"bc8a31a1-cbeb-4bc3-9232-485cd0ad3bef\"},{\"tradeName\":\"花甲\",\"xh\":10,\"uid\":\"20e19cf0-f887-4f82-820a-501cc290db61\"},{\"tradeName\":\"炸鸡腿\",\"xh\":11,\"uid\":\"9e529a1e-7815-4f45-a973-8379c78056ef\"},{\"tradeName\":\"梅菜扣肉\",\"xh\":12,\"uid\":\"c6991ed2-0b93-4102-8cb8-6a51f2c28d1e\"},{\"tradeName\":\"凉拌素菜\",\"xh\":13,\"uid\":\"1c8e2e57-2c8d-4031-bdfb-f63be38c66b3\"},{\"tradeName\":\"凉皮\",\"xh\":14,\"uid\":\"c358d314-46e0-4ea2-989a-a043c83242f8\"},{\"tradeName\":\"卤鸡爪\",\"xh\":15,\"uid\":\"f5791e47-e4f7-4fa7-b103-9cf8006ac72c\"},{\"tradeName\":\"火锅底料\",\"xh\":16,\"uid\":\"e2947827-814a-4737-95d5-c41858fd4eed\"},{\"tradeName\":\"老鸭汤料\",\"xh\":17,\"uid\":\"ed501843-7bdc-4366-b9ff-784acde7e1a0\"},{\"tradeName\":\"羊排\",\"xh\":18,\"uid\":\"288b2bf8-b691-4d00-a16c-ac55dc7361ad\"},{\"tradeName\":\"土豆\",\"xh\":19,\"uid\":\"237a41ff-7efe-4c1f-929f-e58a8fccefe3\"},{\"tradeName\":\"青笋尖\",\"xh\":20,\"uid\":\"48aaa588-1fa2-49f3-a092-b9801ebf409d\"},{\"tradeName\":\"豆芽\",\"xh\":21,\"uid\":\"bea14388-50cc-40f1-95d9-82d803c43a0a\"},{\"tradeName\":\"黄瓜\",\"xh\":22,\"uid\":\"1e2b3e70-979e-4990-9e0b-e1c5fed7320c\"},{\"tradeName\":\"香辣椒\",\"xh\":23,\"uid\":\"578554be-a093-4a0d-930a-49c2226f8e00\"},{\"tradeName\":\"菜瓜\",\"xh\":24,\"uid\":\"eb62e8a4-d64a-4f1c-ac84-9f5e7db1fef9\"},{\"tradeName\":\"小米椒\",\"xh\":25,\"uid\":\"215f695d-d8e8-4bc5-a640-398f96e43d75\"},{\"tradeName\":\"大蒜\",\"xh\":26,\"uid\":\"05ca3269-f5da-45c5-9e73-66e7cd01b454\"},{\"tradeName\":\"牛排\",\"xh\":27,\"uid\":\"a453fd96-f8de-4813-8d30-2b12fecfec68\"},{\"tradeName\":\"香肠\",\"xh\":28,\"uid\":\"7046d4c2-cd46-440a-85ff-100466e0e1c4\"},{\"tradeName\":\"腊肉\",\"xh\":29,\"uid\":\"a06c1158-b8ce-486c-bdf9-ac3cb9303115\"},{\"tradeName\":\"一次性筷子\",\"xh\":30,\"uid\":\"74dc550f-0297-45d4-b25e-b30103f298db\"},{\"tradeName\":\"一次性纸碗\",\"xh\":31,\"uid\":\"010d8e65-9ea0-46ae-bdbe-c0a1ef3b2d68\"},{\"tradeName\":\"小米\",\"xh\":32,\"uid\":\"05a5d009-cccf-4a77-8765-7cd1ffecdb1f\"},{\"tradeName\":\"小米蕉\",\"xh\":33,\"uid\":\"d34f4fbd-f09f-4485-9694-8085c4715f5c\"},{\"tradeName\":\"苹果\",\"xh\":34,\"uid\":\"d1ed826c-d73b-4f60-93d4-38b64e9c6594\"},{\"tradeName\":\"凉粉\",\"xh\":35,\"uid\":\"77791119-e24a-436f-9dfb-45404ae90384\"},{\"tradeName\":\"馒头\",\"xh\":36,\"uid\":\"3fc36ec4-32b0-47ce-ad71-2412b3941fa0\"},{\"tradeName\":\"面条\",\"xh\":37,\"uid\":\"f6f2e99f-6f61-49c7-9afc-bb4d44a8bff1\"},{\"tradeName\":\"大米\",\"xh\":38,\"uid\":\"68033823-0c29-47ec-a6bb-4c923c45e7a9\"},{\"tradeName\":\"白萝卜\",\"xh\":39,\"uid\":\"bb69999a-aa34-42ee-a6c6-00103161803a\"},{\"tradeName\":\"小笼包\",\"xh\":40,\"uid\":\"68c81743-68f9-4e39-92a3-46b4503f7480\"},{\"tradeName\":\"鸡蛋\",\"xh\":41,\"uid\":\"76a9a9ff-8cbb-4718-8ea3-5a87d5acdbc8\"},{\"tradeName\":\"玉米\",\"xh\":42,\"uid\":\"229b2a01-490a-4e31-8410-5e38cd3554b6\"},{\"tradeName\":\"猪蹄\",\"xh\":43,\"uid\":\"3411513d-fd02-4068-a79a-5fdbe845e1f9\"},{\"tradeName\":\"排骨\",\"xh\":44,\"uid\":\"159c40be-94d2-4f4a-b76c-4916317d10d4\"},{\"tradeName\":\"上海青\",\"xh\":45,\"uid\":\"e9f7f830-1993-4f65-963a-d4604e0d60e8\"},{\"tradeName\":\"砂糖桔\",\"xh\":46,\"uid\":\"b1a878ab-34cf-47ec-a937-0f948d5fd932\"},{\"tradeName\":\"枇杷\",\"xh\":47,\"uid\":\"d6707673-357f-4f60-b3c6-0c3f04f7723b\"},{\"tradeName\":\"菜心\",\"xh\":48,\"uid\":\"9eee69c1-da46-4e7f-86a2-0571adfc2fd7\"},{\"tradeName\":\"卤猪蹄\",\"xh\":49,\"uid\":\"a1fe4a0d-4a64-4a23-aec4-49068b2e0bf5\"},{\"tradeName\":\"凉拌鸡\",\"xh\":50,\"uid\":\"02184c97-ddb3-4c65-83fc-ce337e84d119\"},{\"tradeName\":\"脆炸鸡腿\",\"xh\":51,\"uid\":\"3cce4cb9-4548-404a-a87a-6a465cc6abbe\"},{\"tradeName\":\"小黄鱼\",\"xh\":52,\"uid\":\"063c7bc9-9e27-405a-b5b4-1e366a89e1f0\"},{\"tradeName\":\"黄瓜\",\"xh\":53,\"uid\":\"69e8dcdc-9e0e-4f3f-9d3d-28f12ee44f13\"},{\"tradeName\":\"韭菜\",\"xh\":54,\"uid\":\"7d5bf3da-32cf-4d66-bfa1-3a28e87f9e5f\"}]}";
        return body;
    }

    @Test(threadPoolSize = 100,invocationCount = 1000)
    public void test12()
    {
        String url = "https://paymgmt.dev.shuzutech.com/zpcloud/crestv/invoice/getInvoiceFile";
        String body  = "{\"UDiskSn\":\"661619914111\",\"InvoiceCode\":\"150000020026\",\"InvoiceNum\":\"90221458\",\"FileType\":23,\"GetImage\":0,\"SeqNumber\":\"b4AAQoFd2DFKrgoD\"}";
        testCrestv(url, body);
    }

    public void testCrestv(String url, String body)
    {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentType("application/json");
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            response = client.execute(post);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("执行结果:"+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
