import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TheCompanyProcess {

  public String cleanNames(List<String> listOfNames) {
    StringBuilder result = new StringBuilder();
    for(int i=0; i<listOfNames.size(); i++) {
      // 1글자는 Filter
      if(listOfNames.get(i).length() > 1) {
        // 첫문자는 대문자로 transform, List를 문자열로 Convert
        result.append(capitalizeString(listOfNames.get(i))).append(",");
      }
    }
    return result.substring(0, result.length() -1).toString();
  }

  public String cleanNames_f(List<String> listOfNames) {
    if (listOfNames == null) return "";
    return listOfNames
      // 병렬 처리
      .parallelStream()
      .filter(n -> n.length() > 1)
      .map(e -> capitalizeString(e))
      .collect(Collectors.joining(","));
  }

  public String capitalizeString(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
  }

  public static void main(String args[]) {
      String names[] = new String[]{"neal","s","stu","j","rich","bob","aiden","j","ethan",
                                    "liam","mason","noah","lucas","jacob","jayden","jack"};
      List<String> list = Arrays.asList(names);
      TheCompanyProcess process = new TheCompanyProcess();
      System.out.println("----- oriented java -----");
      System.out.println(process.cleanNames(list));
      System.out.println("----- functional java -----");
      System.out.println(process.cleanNames_f(list));
  }
}
