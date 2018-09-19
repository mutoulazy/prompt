package prompt.test.json;

public class JsonUtil {

  public static void main(String[] args) {
    //json 字符串
    String s = "{\"additionalProperties\":{},\"apiVersion\":\"v1\",\"count\":1,\"firstTimestamp\":\"2018-09-12T07:18:25Z\",\"involvedObject\":{\"additionalProperties\":{},\"apiVersion\":\"v1\",\"fieldPath\":\"spec.containers{tomcat}\",\"kind\":\"Pod\",\"name\":\"uop-platform-4040156518-l3sxv\",\"namespace\":\"develop\",\"resourceVersion\":\"44098777\",\"uid\":\"0712a4ec-b65c-11e8-80be-fa163e0acde6\"},\"kind\":\"Event\",\"lastTimestamp\":\"2018-09-12T07:18:25Z\",\"message\":\"Failed to pull image \\\"registry.c2cloud.cn/c2cloud/user-organization-applications\\\": image pull failed for registry.c2cloud.cn/c2cloud/user-organization-applications:latest, this may be because there are no credentials on this request. details: (Error: image c2cloud/user-organization-applications:latest not found)\",\"metadata\":{\"additionalProperties\":{},\"creationTimestamp\":\"2018-09-12T07:18:25Z\",\"finalizers\":[],\"name\":\"uop-platform-4040156518-l3sxv.155395e429e14839\",\"namespace\":\"develop\",\"ownerReferences\":[],\"resourceVersion\":\"44114262\",\"selfLink\":\"/api/v1/namespaces/develop/events/uop-platform-4040156518-l3sxv.155395e429e14839\",\"uid\":\"09b0b011-b65c-11e8-80be-fa163e0acde6\"},\"reason\":\"Failed\",\"source\":{\"additionalProperties\":{},\"component\":\"kubelet\",\"host\":\"172-17-32-102.node\"},\"type\":\"Warning\"}";
    String out = formatJson(s);
    System.out.println(out);
  }

  /**
   * 对json字符串格式化输出
   * @param jsonStr
   * @return
   */
  public static String formatJson(String jsonStr) {
    if (null == jsonStr || "".equals(jsonStr)) return "";
    StringBuilder sb = new StringBuilder();
    char last = '\0';
    char current = '\0';
    int indent = 0;
    for (int i = 0; i < jsonStr.length(); i++) {
      last = current;
      current = jsonStr.charAt(i);
      switch (current) {
        case '{':
        case '[':
          sb.append(current);
          sb.append('\n');
          indent++;
          addIndentBlank(sb, indent);
          break;
        case '}':
        case ']':
          sb.append('\n');
          indent--;
          addIndentBlank(sb, indent);
          sb.append(current);
          break;
        case ',':
          sb.append(current);
          if (last != '\\') {
            sb.append('\n');
            addIndentBlank(sb, indent);
          }
          break;
        default:
          sb.append(current);
      }
    }

    return sb.toString();
  }

  /**
   * 添加space
   * @param sb
   * @param indent
   */
  private static void addIndentBlank(StringBuilder sb, int indent) {
    for (int i = 0; i < indent; i++) {
      sb.append('\t');
    }
  }


}

