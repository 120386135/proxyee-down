package lee.study.down.mvc.form;

import java.util.ArrayList;
import java.util.List;
import lee.study.down.model.HttpDownInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class NewTaskForm {
  private String id;
  private String oldId;
  private String filePath;
  private String fileName;
  private int connections;
  private long totalSize;
  private boolean supportRange;
  private long downSize;
  private boolean isUnzip;
  private String unzipPath;

  public static NewTaskForm parse(HttpDownInfo httpDownInfo) {
    if (httpDownInfo != null) {
      NewTaskForm form = new NewTaskForm();
      BeanUtils.copyProperties(httpDownInfo.getTaskInfo(), form,
          new String[]{"startTime", "pauseTime", "status", "chunkInfoList"});
      return form;
    }
    return null;
  }

  public static List<NewTaskForm> parse(List<HttpDownInfo> list) {
    if (list != null) {
      List<NewTaskForm> formList = new ArrayList<>();
      for (HttpDownInfo httpDownInfo : list) {
        formList.add(parse(httpDownInfo));
      }
      return formList;
    }
    return null;
  }
}
