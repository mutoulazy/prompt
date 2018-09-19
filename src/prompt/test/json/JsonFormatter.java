package prompt.test.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonFormatter {

  /**
   * @param args
   */
  public static void main(String[] args) {
    String uglyJSONString = "{\"additionalProperties\":{},\"apiVersion\":\"v1\",\"count\":1,\"firstTimestamp\":\"2018-09-12T07:18:25Z\",\"involvedObject\":{\"additionalProperties\":{},\"apiVersion\":\"v1\",\"fieldPath\":\"spec.containers{tomcat}\",\"kind\":\"Pod\",\"name\":\"uop-platform-4040156518-l3sxv\",\"namespace\":\"develop\",\"resourceVersion\":\"44098777\",\"uid\":\"0712a4ec-b65c-11e8-80be-fa163e0acde6\"},\"kind\":\"Event\",\"lastTimestamp\":\"2018-09-12T07:18:25Z\",\"message\":\"Failed to pull image \\\"registry.c2cloud.cn/c2cloud/user-organization-applications\\\": image pull failed for registry.c2cloud.cn/c2cloud/user-organization-applications:latest, this may be because there are no credentials on this request. details: (Error: image c2cloud/user-organization-applications:latest not found)\",\"metadata\":{\"additionalProperties\":{},\"creationTimestamp\":\"2018-09-12T07:18:25Z\",\"finalizers\":[],\"name\":\"uop-platform-4040156518-l3sxv.155395e429e14839\",\"namespace\":\"develop\",\"ownerReferences\":[],\"resourceVersion\":\"44114262\",\"selfLink\":\"/api/v1/namespaces/develop/events/uop-platform-4040156518-l3sxv.155395e429e14839\",\"uid\":\"09b0b011-b65c-11e8-80be-fa163e0acde6\"},\"reason\":\"Failed\",\"source\":{\"additionalProperties\":{},\"component\":\"kubelet\",\"host\":\"172-17-32-102.node\"},\"type\":\"Warning\"}";
    String prettyJsonString = jsonFormatter(uglyJSONString);
    System.out.println("JSON格式化前：");
    System.out.println(uglyJSONString);
    System.out.println("JSON格式化后：");
    System.out.println(prettyJsonString);

  }

  public static String jsonFormatter(String uglyJSONString) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jp = new JsonParser();
    JsonElement je = jp.parse(uglyJSONString);
    String prettyJsonString = gson.toJson(je);
    return prettyJsonString;
  }
}
